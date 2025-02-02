package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.models.ItenaryMaster;
import com.example.repository.ItenaryMasterRepository;

@Service
public class ItenaryMasterServiceImpl {

    @Autowired
    private ItenaryMasterRepository itenaryMasterRepository;
    

    // Get ItenaryMaster by ID
    public List<ItenaryMaster> getItenaryMasterById(int tourId) {
        return itenaryMasterRepository.findByTourId(tourId);
    }

}
