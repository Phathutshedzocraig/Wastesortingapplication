package com.enviro.assessment.grad001.phathutshedzomakala.controller;

import com.enviro.assessment.grad001.phathutshedzomakala.model.WasteCategory;
import com.enviro.assessment.grad001.phathutshedzomakala.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//The @PathVariable annotation is used to extract the ID from the URL path for the GET, PUT, and DELETE methods.
@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;

    @Autowired
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        List<WasteCategory> wasteCategories = wasteCategoryService.getAllWasteCategories();
        return ResponseEntity.ok(wasteCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        WasteCategory wasteCategory = wasteCategoryService.getWasteCategoryById(id);
        return wasteCategory != null ? ResponseEntity.ok(wasteCategory) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@RequestBody WasteCategory wasteCategory) {
        WasteCategory createdWasteCategory = wasteCategoryService.createWasteCategory(wasteCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWasteCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @RequestBody WasteCategory wasteCategory) {
        WasteCategory updatedWasteCategory = wasteCategoryService.updateWasteCategory(id, wasteCategory);
        return updatedWasteCategory != null ? ResponseEntity.ok(updatedWasteCategory) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
