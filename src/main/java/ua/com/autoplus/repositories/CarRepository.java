package ua.com.autoplus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.autoplus.entity.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Optional<Car> findById(Integer id);
    @Query(value = "SELECT * \n" +
            "FROM CAR C \n" +
            "WHERE :year >= TRIM(SUBSTRING_INDEX(SUBSTRING_INDEX(C.YEAR, '-', 1), '-', -1)) AND \n" +
            ":year <= TRIM(SUBSTRING_INDEX(SUBSTRING_INDEX(REPLACE(C.YEAR, 'наст. время', YEAR(sysdate())), '-', 2), '-', -1))", nativeQuery = true)
    List<Car> getAllByYear(String year);
    @Query(value = "SELECT * \n" +
            "FROM CAR C \n" +
            "WHERE C.BRAND = :brand \n" +
            "AND :year >= TRIM(SUBSTRING_INDEX(SUBSTRING_INDEX(C.YEAR, '-', 1), '-', -1)) AND \n" +
            ":year <= TRIM(SUBSTRING_INDEX(SUBSTRING_INDEX(REPLACE(C.YEAR, 'наст. время', YEAR(sysdate())), '-', 2), '-', -1))", nativeQuery = true)
    List<Car> getByBrandAndYear(String brand, String year);
    @Query(value = "SELECT * \n" +
            "FROM CAR C \n" +
            "WHERE C.BRAND = :brand \n" +
            "AND C.MODEL = :model \n" +
            "AND :year >= TRIM(SUBSTRING_INDEX(SUBSTRING_INDEX(C.YEAR, '-', 1), '-', -1)) AND \n" +
            ":year <= TRIM(SUBSTRING_INDEX(SUBSTRING_INDEX(REPLACE(C.YEAR, 'наст. время', YEAR(sysdate())), '-', 2), '-', -1))", nativeQuery = true)
    List<Car> getByBrandAndModelAndYear(String brand, String model, String year);
}
