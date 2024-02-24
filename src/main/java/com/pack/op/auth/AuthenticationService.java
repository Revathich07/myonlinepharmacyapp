package com.pack.op.auth;

import com.pack.op.configuration.JwtService;

import com.pack.op.model.UserModel.Role;
import com.pack.op.model.UserModel;
import com.pack.op.repository.UserRepository;
import com.pack.op.token.Token;
import com.pack.op.token.TokenRepository;
import com.pack.op.token.TokenType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.var;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  public AuthenticationService(UserRepository repository, TokenRepository tokenRepository,
			PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
		super();
		this.repository = repository;
		this.tokenRepository = tokenRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

private final UserRepository repository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
	  UserModel userObj = new UserModel();
	  userObj.setUserName(request.getUserName());
	  userObj.setUserEmail(request.getUserEmail());
	  userObj.setPassword(passwordEncoder.encode(request.getPassword()));
	  userObj.setUserRole(Role.CUSTOMER);
	  UserModel savedUser=repository.save(userObj);
    String jwtToken = jwtService.generateToken(userObj);
    String refreshToken = jwtService.generateRefreshToken(userObj);
    saveUserToken(savedUser, jwtToken);
    AuthenticationResponse authResp = new AuthenticationResponse();
    authResp.setAccessToken(jwtToken);
    authResp.setRefreshToken(refreshToken);
    return authResp;
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUserEmail(),
            request.getPassword()
        )
    );
    UserModel user=repository.findByUserEmail(request.getUserEmail())
        .orElseThrow();
    String jwtToken = jwtService.generateToken(user);
    String refreshToken = jwtService.generateRefreshToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    AuthenticationResponse authResp1 = new AuthenticationResponse();
    authResp1.setAccessToken(jwtToken);
    authResp1.setRefreshToken(refreshToken);
    return authResp1;
  }

  private void saveUserToken(UserModel user, String jwtToken) {
	  Token token = new Token();
	  token.setUser(user);
	  token.setToken(jwtToken);
	  token.setTokenType(TokenType.BEARER);
       token.setExpired(false);
       token.setRevoked(false);
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(UserModel user) {
	  List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getUserId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }

  public void refreshToken(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String userEmail;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    refreshToken = authHeader.substring(7);
    userEmail = jwtService.extractUsername(refreshToken);
    if (userEmail != null) {
    	UserModel user = this.repository.findByUserEmail(userEmail)
              .orElseThrow();
      if (jwtService.isTokenValid(refreshToken, user)) {
        String accessToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, accessToken);
        AuthenticationResponse authResp2 = new AuthenticationResponse();
        authResp2.setAccessToken(accessToken);
        authResp2.setRefreshToken(refreshToken);
        new ObjectMapper().writeValue(response.getOutputStream(), authResp2);
      }
    }
  }
}
