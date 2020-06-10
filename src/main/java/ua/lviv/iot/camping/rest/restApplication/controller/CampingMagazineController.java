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

@RequestMapping("/camping_magazine")
@RestController
public class CampingMagazineController {
    
    private Map<Integer, CampingMagazine> campingmagazines = new HashMap<>();
    private AtomicInteger IdCounter = new AtomicInteger();
    @Autowired
    private CampingMagazineService campingMagazineService;

    @GetMapping
    public List<CampingMagazine> getAllMagazines() {
        return campingMagazineService.getAllMagazines();
    }

    @GetMapping(path = "/{id}")
    public CampingMagazine getMagazineById(Integer magazineId) {
        return campingMagazineService.getMagazineById(magazineId);
    }
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public CampingMagazine createMagazine(final @RequestBody CampingMagazine magazine) {
        magazine.setId(IdCounter.incrementAndGet());
        campingmagazines.put(magazine.getId(), magazine);
        campingMagazineService.createMagazine(magazine);
        return magazine;
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<CampingMagazine> deleteMagazine(final @PathVariable("id") Integer magazineId) {
        if (campingMagazineService.magazineExists(magazineId)) {
            campingMagazineService.deleteMagazine(magazineId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<CampingMagazine> updateMagazine(final @PathVariable("id") Integer magazineId,
            final @RequestBody CampingMagazine magazine) {
        magazine.setId(magazineId);
        if (campingmagazines.containsKey(magazineId)) {
            campingmagazines.put(magazineId, magazine);
            campingMagazineService.updateMagazine(magazineId, magazine);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}