package ua.com.autoplus.services.impl;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import ua.com.autoplus.entity.Warehouse;
import ua.com.autoplus.repositories.WarehouseRepository;
import ua.com.autoplus.services.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    public WarehouseRepository repository;

    public Warehouse getWarehouseById(Integer id) {
        return repository.getOne(id);
    }
}
