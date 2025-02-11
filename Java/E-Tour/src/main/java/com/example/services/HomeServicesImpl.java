package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.CategoryMaster;
import com.example.repository.HomeRepository;

@Service
public class HomeServicesImpl implements HomeServices{
	@Autowired
	private HomeRepository homerepository;

	@Override
	public List<CategoryMaster> getAllCategories() {
		// TODO Auto-generated method stub
		return homerepository.findAll();
	}
	
}
