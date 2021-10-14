package ua.com.autoplus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.autoplus.entity.Warehouse;

public interface WarehouseRepository  extends JpaRepository<Warehouse, Integer> {
}
