package ua.lviv.iot.camping.rest.restApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.camping.rest.restApplication.bussiness.*;
import ua.lviv.iot.camping.rest.restApplication.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/camping_customers")
@RestController
public class CampingCustomerController {
    
    private Map<Integer, CampingCustomer> campingCustomers = new HashMap<>();
    private AtomicInteger IdCounter = new AtomicInteger();
    @Autowired
    private CampingCustomerService campingCustomerService;

    @GetMapping
    public List<CampingCustomer> getAllCampingCustomers() {
        return campingCustomerService.getAllCampingCustomers();
    }
    
    @GetMapping(path = "/{id}")
    public CampingCustomer getCampingCustomerById(final @PathVariable("id") Integer campingcustomerId) {
        return campingCustomerService.getCampingCustomerById(campingcustomerId);
    }
    
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public CampingCustomer createCampingCustomer(final @RequestBody CampingCustomer campingCustomer) {
        campingCustomer.setId(IdCounter.incrementAndGet());
        campingCustomers.put(campingCustomer.getId(), campingCustomer);
        campingCustomerService.createCampingCustomer(campingCustomer);
        return campingCustomer;
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AbstractCamping> deleteCampingCustomer(@PathVariable("id") Integer campingcustomerId) {
        if(campingCustomerService.campingCustomerExists(campingcustomerId)) {
            campingCustomerService.deleteCampingCustomer(campingcustomerId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<AbstractCamping> updateCampingCustomer(final @PathVariable("id") Integer campingcustomerId,
            final @RequestBody CampingCustomer campingCustomer) {
        HttpStatus status;
        campingCustomer.setId(campingcustomerId);
        if (campingCustomers.containsKey(campingcustomerId)) {
            campingCustomers.put(campingcustomerId, campingCustomer);
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        campingCustomerService.updateCampingCustomer(campingcustomerId, campingCustomer);
        return ResponseEntity.status(status).build();
    }
}