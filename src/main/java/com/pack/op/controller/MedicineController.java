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

import com.pack.op.model.MedicineModel;
import com.pack.op.modeldto.MedicineModelDTO;
import com.pack.op.service.MedicineService;

@RestController
@RequestMapping("/admin/medicine")
public class MedicineController {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
    private MedicineService medService;
	
	@PostMapping("/addMedicine")
    public ResponseEntity<String> saveMedicine(@RequestBody MedicineModelDTO medDto) {
    	MedicineModel medDetails=modelMapper.map(medDto,MedicineModel.class);
    	medService.saveMedicine(medDetails); 
    	return new ResponseEntity<String>("Medicine got added successfully", HttpStatus.CREATED);
    }
	
	 @GetMapping("/admin/list")
		public List<MedicineModel> getAllMedicines()
		{
			return medService.getAllMedicines();
		}
		
		@GetMapping("/admin/list/{id}")
		public MedicineModel getMedicineById(@PathVariable int id){
			return medService.getMedicineById(id);
		}
	
		@PutMapping("/admin/updateMed/{id}")
	    public ResponseEntity<String> updateMedicine(@PathVariable int id,@RequestBody MedicineModelDTO medcine) {
			MedicineModel medDet=modelMapper.map(medcine, MedicineModel.class);
			MedicineModel medDet1 = medService.getMedicineById(id); 
			medDet1.setBrand(medDet.getBrand());
			medDet1.setDescription(medDet.getDescription());
			medDet1.setExpDate(medDet.getExpDate());
	        medService.saveMedicine(medDet1);
	        return new ResponseEntity<String>("Medicine got updated successfully", HttpStatus.CREATED);
	    }
	    

		@DeleteMapping("/admin/delete/{id}")
		public void deleteMedicine(@PathVariable int id)
		{
			medService.deleteMedicine(id);
		}
	
}
