package ua.com.autoplus.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.autoplus.entity.Category;
import ua.com.autoplus.entity.Part;
import ua.com.autoplus.entity.Warehouse;
import ua.com.autoplus.services.CategoryService;
import ua.com.autoplus.services.PartService;
import ua.com.autoplus.services.WarehouseService;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class PartController {
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private PartService partService;
    private List<Category> categoryList = new ArrayList<>();

    @RequestMapping("/api/part/findby/{reference}")
    public ResponseEntity<Map<String, Object>> findByReferenceOrdered(@PathVariable String reference,
                                                               @RequestParam(value = "sortcol[]", required=false) String[] sortCol,
                                                               @RequestParam(value = "sortdir[]", required=false) String[] sortDir,
                                                               @RequestParam(value = "filter", required=false) String filter,
                                                               @RequestParam(value = "echo", required=false) int echo,
                                                               @RequestParam(value = "page", required=false) int page,
                                                               @RequestParam(value = "pagesize", required=false) int pageSize) {
        Sort sort;
        List<Sort.Order> list = new ArrayList();
        list.add(Sort.Order.by("name").with(Sort.DEFAULT_DIRECTION));
        if(!StringUtils.isEmpty(sortCol)) {
            List<Sort.Order> sortList = IntStream.range(0, sortCol.length).mapToObj(i ->
                    Sort.Order.by(sortCol[i]).with(Sort.Direction.fromString(sortDir[i]))
            ).collect(Collectors.toList());
             sort = Sort.by(sortList);
        } else {
            sort = Sort.by(list);
        }
        System.out.println(filter);
        System.out.println(PageRequest.of(page - 1, pageSize, sort));
        Page<Part> data = partService.getPartsByFilterName("/" + reference + "/", filter,
                    PageRequest.of(page - 1, pageSize, sort));
        Map resp = new HashMap();
        System.out.println(data.getContent().size());
        resp.put("filtered", data.getTotalPages());
        resp.put("echo", echo);
        resp.put("sortcol[]", sortCol);
        resp.put("sortdir[]", sortDir);
        resp.put("page", page);
        resp.put("pageSize", pageSize);
        resp.put("data", data.getContent());
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/part/findbyId/{id}")
    public  @ResponseBody Warehouse findById(@PathVariable Integer id, Model model) {
        Warehouse part = warehouseService.getWarehouseById(id);
        model.addAttribute("warehouse", part);
        return part;
    }
    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public ModelAndView userDetails() {
        ModelAndView modelAndView = new ModelAndView();
        Warehouse warehouse = warehouseService.getWarehouseById(1);
        modelAndView.addObject("warehouse", warehouse);
        modelAndView.setViewName("users");
        return modelAndView;
    }
}
