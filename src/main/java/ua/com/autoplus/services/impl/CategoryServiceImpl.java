package ua.com.autoplus.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.autoplus.entity.Category;
import ua.com.autoplus.repositories.CategoryRepository;
import ua.com.autoplus.services.CategoryService;


import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    public CategoryRepository repository;

    public List<Category> getRootCategories() {
        List<Category> list = repository.findByParentIdIsNull();
        return list;
    }
    public Category getCategoryByReference(String reference) {
        Category list = repository.findByReference(reference);
        return list;
    }
}
