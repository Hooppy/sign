package com.univ.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.univ.model.SignModel;

public interface SignDao extends JpaRepository<SignModel, Long>{
	
}
