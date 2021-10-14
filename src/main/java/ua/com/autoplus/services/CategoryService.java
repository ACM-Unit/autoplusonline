package ua.com.autoplus.services;

import ua.com.autoplus.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getRootCategories();

    Category getCategoryByReference(String reference);

}
