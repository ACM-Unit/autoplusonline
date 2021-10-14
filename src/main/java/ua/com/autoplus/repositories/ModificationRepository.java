package ua.com.autoplus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.autoplus.entity.Car;
import ua.com.autoplus.entity.Modification;

import java.util.List;
@Repository
public interface ModificationRepository extends JpaRepository<Modification, Integer> {
    List<Modification> getByCar(Car car);
    @Query(value="select m.id, m.parent, m.name, m.enginetype, m.enginemodel, m.enginecapacity, m.power, m.drive, m.date, m.reference, m.description, m.startYear, m.endYear, m.bodyType, m.driveType, m.capacity, m.capacityTax, m.capacityTech, m.fuelMixture, m.fuelType, m.numberOfCylinders, m.numberOfValves, m.constructionInterval, m.engineCode, m.startYearMonth, m.endYearMonth, m.end_year, " +
            "c.id, c.brand, c.model, c.type, c.reference, c.year, c.title " +
            "from  modification m, car c where m.parent =  c.id and\n" +
            "lower(c.brand) = lower(:brand)\n" +
            "and lower(c.type) = lower(:type)\n" +
            "and fuelMixture = :fuelMixture\n" +
            "and replace(enginecapacity,' ccm', '') = :enginecapacity\n" +
            "and numberOfCylinders = :numberOfCylinders\n" +
            "and bodyType = :bodyType\n" +
            "and numberOfValves = :numberOfValves\n" +
            "and drive = :drive\n" +
            "and fuelType = :fuelType\n" +
            "and enginetype = :enginetype", nativeQuery = true)
    Modification getByVinCode(String brand, String type, String fuelMixture, String enginecapacity,
                              String numberOfCylinders, String bodyType, String numberOfValves, String drive,
                              String fuelType, String enginetype);
}
