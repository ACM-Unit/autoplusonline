package ua.com.autoplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.autoplus.entity.Category;
import ua.com.autoplus.services.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService service;

    private List<Category> categoryList = new ArrayList<>();
        @RequestMapping("/api/category/all")
        public List<Category> findAll() {
            return categoryList;
        }

        @RequestMapping(value = "/api/category", method = RequestMethod.POST)
        public Category addCategory(Category category) {
            categoryList.add(category);
            return category;
        }

    @RequestMapping(value = "/api/category/root", method = RequestMethod.GET)
    public List<Category> getSortedCategory() {
        List<Category> categories = service.getRootCategories();
        return categories;
    }


    @RequestMapping("/api/category/findby/{reference}")
    public Category findByReference(@PathVariable String reference) {
        return service.getCategoryByReference("/"+reference+"/");
    }
}
