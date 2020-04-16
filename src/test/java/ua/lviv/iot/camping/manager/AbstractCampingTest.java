package ua.lviv.iot.camping.manager;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ua.lviv.iot.camping.manager.BaseAbstractCampingTest;
import ua.lviv.iot.camping.rest.restApplication.model.AbstractCamping;
import ua.lviv.iot.camping.rest.restApplication.model.ThingsType;

public class AbstractCampingTest extends BaseAbstractCampingTest {

    public List<AbstractCamping> result;

    @Test
    public void testFindGoodsCheaperThan() {
        CampingManager manager = new CampingManager(things);
        ThingsType thingsType = ThingsType.HIKING;
        result = manager.findThingsForHiking(thingsType, things);

        assertEquals(ThingsType.HIKING, things.get(0).getThingsType());
        assertEquals(ThingsType.HIKING, things.get(1).getThingsType());
        assertEquals(ThingsType.SECONDARY_NECESSITY, things.get(2).getThingsType());
        assertEquals(ThingsType.FIRSTLY_NECESSITY, things.get(3).getThingsType());

    }

}