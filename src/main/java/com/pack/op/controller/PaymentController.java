package com.pack.op.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.op.model.PaymentModel;
import com.pack.op.modeldto.PaymentModelDTO;
import com.pack.op.service.PaymentService;

@RestController
@RequestMapping("/customer/payment")
public class PaymentController {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	PaymentService paymentSer;
	
	@PostMapping("/addpayment")
    public ResponseEntity<String> addPayment(@RequestBody PaymentModelDTO payDto) {
    	PaymentModel payDetails=modelMapper.map(payDto,PaymentModel.class);
    	paymentSer.savePayment(payDetails); 
    	return new ResponseEntity<String>("Payment got added Successfully", HttpStatus.CREATED);
    }
	
	@GetMapping("/admin/list")
	public List<PaymentModel> getAllPayments()
	{
		return paymentSer.getAllPayments();
	}
	
	@GetMapping("/admin/list/{id}")
	public PaymentModel getPaymentById(@PathVariable int id){
		return paymentSer.getPaymentById(id);
	}

	@PutMapping("/admin/updatePayment/{id}")
    public ResponseEntity<String> updatePayment(@PathVariable int id,@RequestBody PaymentModelDTO pay) {
		PaymentModel payDet=modelMapper.map(pay, PaymentModel.class);
		PaymentModel payDet1 = paymentSer.getPaymentById(id); 
		payDet1.setPaymentDate(payDet.getPaymentDate());
		payDet1.setModeOfPayment(payDet.getModeOfPayment());
		payDet1.setStatus(payDet.getStatus());
		paymentSer.savePayment(payDet1);
        return new ResponseEntity<String>("Payment got updated successfully", HttpStatus.CREATED);
	}
	
	@DeleteMapping("/admin/delete/{id}")
	public void deletePayment(@PathVariable int id)
	{
		paymentSer.deletePayment(id);
	}
}
