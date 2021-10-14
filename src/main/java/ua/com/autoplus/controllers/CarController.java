package ua.com.autoplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.autoplus.entity.Car;
import ua.com.autoplus.entity.Modification;
import ua.com.autoplus.services.CarService;
import ua.com.autoplus.services.impl.VinCodeRestService;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
public class CarController {

    @Autowired
    private CarService service;

    @Autowired
    private VinCodeRestService vinSerice;
    @RequestMapping("/api/cars/allMarks")
    public Set<String> findAllMarks(@RequestParam(value = "year") String year) {
        return service.getMarks(year);
    }

    @RequestMapping("/api/cars/allMarks/byBrand")
    public Set<String> findAllMarksByBrand(@RequestParam(value = "brand") String brand,
                                           @RequestParam(value = "year") String year) {
        Set<String> set = service.getMarksByBrand(brand, year);
        return set;
    }
    @RequestMapping("/api/cars/allMarks/byModel")
    public Set<Car> findAllMarksByBrand(@RequestParam(value = "brand") String brand,
                                        @RequestParam(value = "model") String model,
                                        @RequestParam(value = "year") String year) {
        Set<Car> set = service.getMarksByBrandAndModel(brand, model, year);
        return set;
    }
    @RequestMapping("/api/cars/modifications")
    public List<Modification> findModificationById(@RequestParam(value = "carId") Integer id) {
        return service.getModificaionByCarId(id);
    }

    @RequestMapping("/api/cars/modification")
    public Modification findModificationByVin(@RequestParam(value = "vin") String vin) {
        Modification modification = null;
        try {
            modification = vinSerice.getCarByVin(vin);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modification;
    }
}
