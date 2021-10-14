package ua.com.autoplus.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ua.com.autoplus.entity.Category;
import ua.com.autoplus.entity.Part;
import ua.com.autoplus.repositories.CategoryRepository;
import ua.com.autoplus.repositories.PartRepository;
import ua.com.autoplus.services.PartService;

import java.math.BigInteger;


@Service
public class PartServiceImpl implements PartService {
    @Autowired
    public PartRepository repository;
    @Autowired
    public CategoryRepository categoryRepository;

    public Page<Part> getPartsByFilterName(String reference, String place, Pageable pageable) {
        if (StringUtils.isEmpty(place)) {
            return repository.findByCategoryIn(categoryRepository.findByLastLevelChildren(reference), pageable);
        } else {
            return repository.findByFullTextSearchAp(categoryRepository.findByLastLevelChildren(reference), place + "*", pageable);
        }
    }
}
