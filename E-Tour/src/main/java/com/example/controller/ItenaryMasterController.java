package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.services.ItenaryMasterServiceImpl;

@RestController
@RequestMapping("/api/subcategory")
public class ItenaryMasterController {

    @Autowired
    private ItenaryMasterServiceImpl itenaryMasterService;

    // Get ItenaryMaster by ID
    @GetMapping("/{categoryId}/tours/{tourid}/itenary")
    public ResponseEntity<List<String>> getItenaryMasterById(
            @PathVariable("tourid") int tourId,
            @RequestParam(name = "lang", required = false) String lang) 
    {
        try {
            // Fetch itinerary details from the service
            List<String> details = itenaryMasterService.getItenaryDetailsByLanguage(tourId, lang);

            // Return details or appropriate error response
            if (details != null && !details.isEmpty()) 
                return ResponseEntity.ok(details);
            else
                return ResponseEntity.status(404).build();
            
        } 
        catch (Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }
}