package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.models.CategoryMaster;

public interface CategoryMasterService {
	List<CategoryMaster> getAllCategories();
	Optional<CategoryMaster> getCategoryById(int id);
}
