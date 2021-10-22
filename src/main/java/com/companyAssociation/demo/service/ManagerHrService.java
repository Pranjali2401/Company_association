package com.companyAssociation.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyAssociation.demo.dao.ManagerHrDao;
import com.companyAssociation.demo.model.ManagerHr;

@Service
public class ManagerHrService {

	@Autowired
	ManagerHrDao managerDao;
	
	public ManagerHr addManagerHr(ManagerHr mh) {
		ManagerHr  managerHr = managerDao.save(mh);
		return managerHr;
	}
	
	public ManagerHr getManagerHr(long id) {
		return managerDao.findById(id).get();
	}
	
	public List<ManagerHr> getAllManagerHr(){
		List<ManagerHr> allManager = managerDao.findAll();
		return allManager;
	}
	
	public void updateManagerHr(ManagerHr mh, long id) {
		ManagerHr hrId = managerDao.findById(id).get();
		hrId.setName(mh.getName());
		managerDao.save(hrId);
		
	}
	
	public void deleteManagerHr(long id) {
		managerDao.deleteById(id);
	}
	
}
