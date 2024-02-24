package com.pack.op.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pack.op.model.MedicineModel;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineModel, Integer>{

	
	 @Query("SELECT m.price FROM MedicineModel m where m.medId = :medId")
	 public List<Float> getPriceById(@Param("medId") int medId);
	 
	 public MedicineModel findByMedId(int id);
}
