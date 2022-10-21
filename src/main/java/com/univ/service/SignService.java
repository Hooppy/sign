package com.univ.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.univ.dao.SignDao;
import com.univ.model.SignModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignService {
	
	private final SignDao signDao;
	
	public Long getSignPeople() {
		
		Long signPeople = signDao.count();
		
		return signPeople;
	}
	
	@Transactional
	public void sign(Map<String, Object> params) {
		
		String sname = (String) params.get("sname");
		String semail = (String) params.get("semail");
		
		SignModel insertSign = SignModel.builder()
								.sname(sname)
								.semail(semail)
								.build();
		
		signDao.save(insertSign);
	}
}
