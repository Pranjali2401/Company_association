package com.companyAssociation.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyAssociation.demo.dao.ManagerHrDao;
import com.companyAssociation.demo.dto.ManagerHrDtoIn;
import com.companyAssociation.demo.dto.ManagerHrDtoOut;
import com.companyAssociation.demo.model.ManagerHr;

@Service
public class ManagerHrService {

	@Autowired
	private ManagerHrDao managerDao;

//convert into dto
	public ManagerHrDtoOut buildManagerHrDto(ManagerHr mHr) {
		ManagerHrDtoOut managerherHrDtoOut = new ManagerHrDtoOut();
		managerherHrDtoOut.id = mHr.getId();
		managerherHrDtoOut.name = mHr.getName();
		return managerherHrDtoOut;

	}

	public List<ManagerHrDtoOut> buildManagerHrDto(List<ManagerHr> mHr) {
		List<ManagerHrDtoOut> list = new ArrayList<>();

		mHr.forEach(eachManager -> {
			ManagerHrDtoOut managerherHrDtoOut = new ManagerHrDtoOut();
			managerherHrDtoOut.id = eachManager.getId();
			managerherHrDtoOut.name = eachManager.getName();
			list.add(managerherHrDtoOut);
		});

		return list;

	}

//convert into entity	
	public ManagerHr buildManagerHr(ManagerHrDtoIn mDtoIn) {
		ManagerHr m = new ManagerHr();
		m.setName(mDtoIn.name);
		return m;
	}

	public ManagerHrDtoOut addManagerHr(ManagerHrDtoIn mh) {
		ManagerHr managerHr = buildManagerHr(mh);
		managerHr = managerDao.save(managerHr);
		return buildManagerHrDto(managerHr);
	}

	public ManagerHrDtoOut getManagerHr(long id) {
		ManagerHr m = managerDao.findById(id).get();
		return buildManagerHrDto(m);
	}

	public List<ManagerHrDtoOut> getAllManagerHr() {
		List<ManagerHr> allManager = managerDao.findAll();
		return buildManagerHrDto(allManager);
	}

	public void updateManagerHr(ManagerHrDtoIn mh, long id) {
		ManagerHr managerHr = buildManagerHr(mh);
		managerHr = managerDao.findById(id).get();
		managerHr.setName(mh.name);
		managerDao.save(managerHr);

	}

	public void deleteManagerHr(long id) {
		managerDao.deleteById(id);
	}

}
