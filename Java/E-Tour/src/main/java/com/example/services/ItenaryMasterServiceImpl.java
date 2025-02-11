package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.example.models.ItenaryMaster;
import com.example.repository.ItenaryMasterRepository;

@Service
public class ItenaryMasterServiceImpl implements IternaryMasterServices {

    @Autowired
    private ItenaryMasterRepository itenaryMasterRepository;

    // Get all itineraries by tour ID
    @Override
    public List<ItenaryMaster> getItenaryMasterById(int tourId) {
        return itenaryMasterRepository.findByTourId(tourId);
    }

    // Get itinerary details in the requested language
    @Override
    public List<String> getItenaryDetailsByLanguage(int tourId, String lang) {
        List<ItenaryMaster> itenaryMasters = getItenaryMasterById(tourId);
        if (itenaryMasters.isEmpty()) {
            return null; // No itineraries found for the given tour ID
        }

        List<String> details = new ArrayList<>();
        String language = (lang != null) ? lang.toLowerCase() : "en";

        for (ItenaryMaster itenary : itenaryMasters) {
            switch (language) {
                case "fr":
                    details.add(itenary.getDetailsFr());
                    break;
                case "es":
                    details.add(itenary.getDetailsEs());
                    break;
                case "mr":
                    details.add(itenary.getDetailsMr());
                    break;
                case "hi":
                    details.add(itenary.getDetailsHi());
                    break;
                default:
                    details.add(itenary.getDescription()); // Default to English
                    break;
            }
        }

        return details; // Return the list of details
    }
}
