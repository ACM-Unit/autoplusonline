package ua.com.autoplus.services.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.autoplus.entity.Modification;
import ua.com.autoplus.repositories.ModificationRepository;

import java.io.IOException;
import java.net.URL;
import java.util.AbstractMap;

import java.util.Map;
import java.util.stream.Collectors;


@Service
public class VinCodeRestService {
    @Autowired
    private ModificationRepository repository;

    public Modification getCarByVin(String vin) throws IOException {
        Document doc = Jsoup.parse(new URL("https://carsvin.ru/auto/vin?vincode=" + vin).openStream(),
                "UTF-8", "");
        Element table = doc.getElementById("placeholder");
        Elements rows = table.getElementsByTag("tr");
        Map<String, String> map = rows.stream().filter(tr -> tr.getElementsByTag("td").size() == 2)
                .map(tr -> new AbstractMap.SimpleEntry(tr.getElementsByTag("td").get(0).html(),
                        tr.getElementsByTag("td").get(1).getElementsByTag("a").size()!=0?
                                tr.getElementsByTag("td").get(1).getElementsByTag("a").html():
                                tr.getElementsByTag("td").get(1).html()))
                .collect(Collectors.toMap(e -> e.getKey().toString(), e1 -> e1.getValue().toString(),(e1, e2) -> {
                    System.out.println("duplicate key found!");
                    return e2;
                }));        Modification modification = repository.getByVinCode(
                map.get("Наименование идентификатора марки автомобиля:"),
                map.get("Наименование идентификатора модели автомобиля:"),
                map.get("Двигатель работает по принципу:"),
                map.get("Объем движка:"),
                map.get("Количество цилиндров:"),
                map.get("У автомобиля тип кузова:"),
                map.get("Сколько клапанов:"),
                map.get("Привод у автомобиля:"),
                map.get("Используемый тип толива:"),
                map.get("Тип движка в авто:"));
        return modification;
    }
}
