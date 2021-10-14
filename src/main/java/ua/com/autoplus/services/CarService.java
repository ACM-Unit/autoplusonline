package ua.com.autoplus.services;

import ua.com.autoplus.entity.Car;
import ua.com.autoplus.entity.Modification;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public interface CarService {

    TreeSet<String> getMarks(String year);

    TreeSet<String> getMarksByBrand(String brand, String year);

    Set<Car> getMarksByBrandAndModel(String brand, String model, String year);

    List<Modification> getModificaionByCarId(Integer carId);

}
