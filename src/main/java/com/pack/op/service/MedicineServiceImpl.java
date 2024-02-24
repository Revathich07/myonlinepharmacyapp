package com.pack.op.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.op.model.MedicineModel;
import com.pack.op.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	MedicineRepository medicineRepo;
	
	@Override
	public void saveMedicine(MedicineModel medDetails) {
		medicineRepo.save(medDetails);
	}

	@Override
	public List<MedicineModel> getAllMedicines() {
		return medicineRepo.findAll();
	}

	@Override
	public MedicineModel getMedicineById(int id) {
		return medicineRepo.findByMedId(id);
	}

	@Override
	public void deleteMedicine(int id) {
		medicineRepo.deleteById(id);
		
	}

}
