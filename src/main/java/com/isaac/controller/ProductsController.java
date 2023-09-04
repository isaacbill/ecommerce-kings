package com.isaac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isaac.model.Products;
import com.isaac.service.ProductsService;

@Controller
public class ProductsController {
	@Autowired
	ProductsService productsService;
	@GetMapping("/products")
	 @ResponseBody 
	 public ResponseEntity<?> getAllProducts() {
	        try {
	            List<Products> products = productsService.getAllProducts();

	            if (products != null && !products.isEmpty()) {
	                return ResponseEntity.ok(products);
	            } else {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                        .body("No products found");
	            }
	        } catch (Exception e) {
	            // Handle any exceptions that may occur, e.g., database errors
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Error fetching products: " + e.getMessage());
	        }
	    }

}
