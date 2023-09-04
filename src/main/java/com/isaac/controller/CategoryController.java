package com.isaac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isaac.model.Category;
import com.isaac.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	 CategoryService categoryService;
	
	@GetMapping("/categories/{categoryname}")
	@ResponseBody
	public ResponseEntity<?> getCategoryByName(@PathVariable String categoryname) {
        try {
            Category category = categoryService.getCategoryByName(categoryname);

            if (category != null) {
                return ResponseEntity.ok(category);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Category not found");
            }
        } catch (Exception e) {
            // Handle any exceptions that may occur, e.g., database errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching category: " + e.getMessage());
        }
    }
	    @GetMapping("/categories")
		 @ResponseBody 
		 public ResponseEntity<?> getAllCategories() {
		        try {
		            List<Category> categories = categoryService.getAllCategories();

		            if (categories != null && !categories.isEmpty()) {
		                return ResponseEntity.ok(categories);
		            } else {
		                return ResponseEntity.status(HttpStatus.NOT_FOUND)
		                        .body("No categories found");
		            }
		        } catch (Exception e) {
		            // Handle any exceptions that may occur, e.g., database errors
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		                    .body("Error fetching categories: " + e.getMessage());
		        }
		    }
}
