package ua.com.autoplus.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.autoplus.entity.Car;
import ua.com.autoplus.entity.Modification;
import ua.com.autoplus.repositories.CarRepository;
import ua.com.autoplus.repositories.ModificationRepository;
import ua.com.autoplus.services.CarService;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository repository;
    @Autowired
    private ModificationRepository modificationRepository;

    public TreeSet<String> getMarks(String year){
        return repository.getAllByYear(year).stream().map(mark -> mark.getBrand()).collect(Collectors.toCollection(TreeSet::new));
    }

    public TreeSet<String> getMarksByBrand(String brand, String year){
        return repository.getByBrandAndYear(brand, year).stream().map(mark -> mark.getModel())
                .collect(Collectors.toCollection(TreeSet::new));
    }
    public Set<Car> getMarksByBrandAndModel(String brand, String model, String year){
        return repository.getByBrandAndModelAndYear(brand, model, year).stream().collect(Collectors.toSet());
    }

    public List<Modification> getModificaionByCarId(Integer carId){
        Car car = repository.findById(carId).get();
        return modificationRepository.getByCar(car);
    }
}
