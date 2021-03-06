package ua.lviv.iot.camping.rest.restApplication.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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

import ua.lviv.iot.camping.rest.restApplication.bussiness.CampingService;
import ua.lviv.iot.camping.rest.restApplication.model.AbstractCamping;

@RequestMapping("/campings")
@RestController
public class CampingController {

    static private Map<Integer, AbstractCamping> abstractCampings = new HashMap<>();

    static private AtomicInteger idCounter = new AtomicInteger();
    @Autowired
    private CampingService campingService;

    @GetMapping
    public List<AbstractCamping> getAbstractCampings() {

        return new LinkedList<AbstractCamping>(abstractCampings.values());
    }

    @GetMapping(path = "/{id}")
    public AbstractCamping getAbstractCamping(final @PathVariable("id") Integer abstractCampingId) {
        return abstractCampings.get(abstractCampingId);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public AbstractCamping createAbstractCamping(final @RequestBody AbstractCamping abstractCamping) {
        abstractCamping.setId(idCounter.incrementAndGet());
        abstractCampings.put(abstractCamping.getId(), abstractCamping);
        campingService.createCamping(abstractCamping);
        return abstractCamping;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AbstractCamping> deleteAbstractCamping(@PathVariable("id") Integer abstractCampingId) {
        HttpStatus status = abstractCampings.remove(abstractCampingId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        campingService.deleteCamping(abstractCampingId);
        return ResponseEntity.status(status).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AbstractCamping> updateAbstractCamping(final @PathVariable("id") Integer abstractCampingId,
            final @RequestBody AbstractCamping abstractCamping) {
        HttpStatus status;
        abstractCamping.setId(abstractCampingId);
        if (abstractCampings.containsKey(abstractCampingId)) {
            abstractCampings.put(abstractCampingId, abstractCamping);
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        campingService.updateCamping(abstractCampingId, abstractCamping);
        return ResponseEntity.status(status).build();
    }
}