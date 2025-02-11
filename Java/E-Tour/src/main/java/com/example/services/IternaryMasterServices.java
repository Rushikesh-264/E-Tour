package com.example.services;


import java.util.List;
import com.example.models.ItenaryMaster;
public interface IternaryMasterServices {
	List<ItenaryMaster> getItenaryMasterById(int id);
	List<String> getItenaryDetailsByLanguage(int tourId, String language);
}
