package com.pack.op.service;

import java.util.List;

import com.pack.op.model.MedicineModel;

public interface MedicineService {

	public void saveMedicine(MedicineModel medDetails);

	public List<MedicineModel> getAllMedicines();

	public MedicineModel getMedicineById(int id);

	public void deleteMedicine(int id);

}
