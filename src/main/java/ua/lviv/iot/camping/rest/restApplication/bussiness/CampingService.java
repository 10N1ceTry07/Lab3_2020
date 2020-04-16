package ua.lviv.iot.camping.rest.restApplication.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void deleteCamping(Integer id) {
        campingRepository.deleteById(id);
    }
    public AbstractCamping updateCamping(Integer id, AbstractCamping newAbstractCamping) {
        AbstractCamping abstractcamping = campingRepository.getOne(id);
        abstractcamping = newAbstractCamping;
        return campingRepository.save(abstractcamping);
    }
}
