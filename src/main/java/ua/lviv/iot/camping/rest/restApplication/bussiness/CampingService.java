package ua.lviv.iot.camping.rest.restApplication.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ua.lviv.iot.camping.rest.restApplication.dataaccess.CampingRepository;
import ua.lviv.iot.camping.rest.restApplication.model.*;





@Service
public class CampingService {
    @Autowired
    private CampingRepository campingRepository;

    public AbstractCamping createCamping(AbstractCamping abstractCamping) {
        return campingRepository.save(abstractCamping);
    }
    
    public List<AbstractCamping> findAll() {
        return campingRepository.findAll();
    }
    
    public ResponseEntity<AbstractCamping> findById(Integer abstractCampingId) {
        if (campingRepository.findById(abstractCampingId).isPresent()) {
            return new ResponseEntity<>(campingRepository.getOne(abstractCampingId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    public HttpStatus deleteById(Integer abstractCampingId) {
        if (campingRepository.existsById(abstractCampingId)) {
            campingRepository.deleteById(abstractCampingId);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }
    public ResponseEntity<AbstractCamping> updateById(Integer abstractCampingId, AbstractCamping updateAbstractCamping) {
        if (campingRepository.findById(abstractCampingId).isPresent()) {
            AbstractCamping abstractCamping = campingRepository.getOne(abstractCampingId);
            abstractCamping = updateAbstractCamping;
            campingRepository.save(abstractCamping);

            return new ResponseEntity<>(abstractCamping, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
