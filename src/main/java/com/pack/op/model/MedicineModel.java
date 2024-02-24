package com.pack.op.model;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;





@Entity
@Table(name = "medicine")
public class MedicineModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medId;
	
	public int getMedId() {
		return medId;
	}
	public void setMedId(int medId) {
		this.medId = medId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<CartItems> getItems() {
		return items;
	}
	public void setItems(Set<CartItems> items) {
		this.items = items;
	}
	public int getId() {
		return medId;
	}
	public void setId(int id) {
		this.medId = id;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}

	public Date getManuDate() {
		return manuDate;
	}
	public void setManuDate(Date manuDate) {
		this.manuDate = manuDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDesc() {
		return description;
	}
	public void setDesc(String description) {
		this.description = description;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	private String medName;
	private String brand;
	

	private String composition;
	private Status status;
	
	public static enum Status {
		INSTOCK,
		OUTOFSTOCK
	}
	
	@Temporal(TemporalType.DATE)
	private Date manuDate;
	
	@Temporal(TemporalType.DATE)
	private Date expDate;
	private float price;
	private String description;
	
	@JsonIgnore
	@JsonManagedReference(value = "medEntity")
	@OneToMany(mappedBy = "med")
	private Set<CartItems> items;
}
