package com.fred.event_service.controller;

import com.fred.event_service.model.ApiResponse;
import com.fred.event_service.model.Category;
import com.fred.event_service.service.CategoryService;
import com.fred.event_service.util.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    final CategoryService categoryService;

    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Integer id){
        Category category = categoryService.getCategory(id).orElse(null);
        if (category != null){
            return ResponseEntity.ok(category);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category categoryRequest){
        ApiResponse apiResponse = new ApiResponse();
        Category category = categoryService.createCategory(categoryRequest);
        apiResponse.setResultCode(Constants.CODE_200);
        apiResponse.setData(category);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id){
        Category category = categoryService.getCategory(id).orElse(null);
        if (category != null){
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
