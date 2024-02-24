package com.pack.op.modeldto;

import java.util.Date;
import com.pack.op.model.MedicineModel.Status;

public class MedicineModelDTO {

	private String medId;
	public String getMedId() {
		return medId;
	}
	public void setMedId(String medId) {
		this.medId = medId;
	}

	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getManuDate() {
		return manuDate;
	}
	public void setManuDate(Date manuDate) {
		this.manuDate = manuDate;
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

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	private Status status;

	
	private Date expDate;
	private float price;
	private String description;
	private Date manuDate;
	private String medName;
	private String brand;
	private String composition;
	
}
