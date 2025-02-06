package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.models.ItenaryMaster;
import com.example.services.ItenaryMasterServiceImpl;

@RestController
@RequestMapping("/api/subcategory")
public class ItenaryMasterController {

    @Autowired
    private ItenaryMasterServiceImpl itenaryMasterService;

    // Get ItenaryMaster by ID
    @GetMapping("/{categoryId}/tours/{tourid}/itenary")
    public ResponseEntity<List<ItenaryMaster>> getItenaryMasterById(@PathVariable("tourid") int tourId) {
        return ResponseEntity.ok(itenaryMasterService.getItenaryMasterById(tourId));
    }
}