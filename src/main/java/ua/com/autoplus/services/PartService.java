package ua.com.autoplus.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.com.autoplus.entity.Part;

public interface PartService {

    Page<Part> getPartsByFilterName(String reference, String place, Pageable pageable);

}
