package com.pack.op.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "user")
public class UserModel implements UserDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

	
	
	
	public UserModel(int userId, String userName, String userEmail, String password, Role userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.userRole = userRole;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserModel(String userName, String userEmail, String password, Role userRole) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.userRole = userRole;
	}
	private String userName;
	private String userEmail;
	private long phoneNum;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role userRole;
	
	

	@Temporal(TemporalType.DATE)
	private Date userDob;
	
	public static enum Gender {
		MALE,
		FEMALE
	}
	public static enum Role {
		ADMIN,
		CUSTOMER,
		SUPPLIER
	}
	@JsonIgnore
	@JsonManagedReference(value = "userMod")
	@OneToMany(mappedBy = "userModel")
	private Set<CartModel> cart;
	
	@JsonIgnore
	@JsonManagedReference(value = "userTab")
	@OneToMany(mappedBy = "userModel")
	private Set<PaymentModel> payment;

	@JsonIgnore
	@JsonManagedReference(value = "userBean")
	@OneToOne(mappedBy= "userModel")
	private UserSubscription userSub;
	
	@JsonIgnore
	@JsonManagedReference(value = "userEntity")
	@OneToOne(mappedBy= "userModel")
	private AccountModel account;



	
	@Override
	public String getUsername() {
		return userEmail;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	public Date getUserDob() {
		return userDob;
	}
	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}
	public Set<CartModel> getCart() {
		return cart;
	}
	public void setCart(Set<CartModel> cart) {
		this.cart = cart;
	}
	public Set<PaymentModel> getPayment() {
		return payment;
	}
	public void setPayment(Set<PaymentModel> payment) {
		this.payment = payment;
	}
	public UserSubscription getUserSub() {
		return userSub;
	}
	public void setUserSub(UserSubscription userSub) {
		this.userSub = userSub;
	}
	public AccountModel getAccount() {
		return account;
	}
	public void setAccount(AccountModel account) {
		this.account = account;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(userRole.name()));
	}
	@Override
	public String getPassword() {
		return password;
	}
}

