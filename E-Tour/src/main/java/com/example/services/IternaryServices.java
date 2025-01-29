package com.example.services;


import java.util.List;
import java.util.Optional;

import com.example.models.ItenaryMaster;
public interface IternaryServices {
	List<ItenaryMaster> getAllItenaryMasters();
	ItenaryMaster getItenaryMasterById(int id);
 
}
