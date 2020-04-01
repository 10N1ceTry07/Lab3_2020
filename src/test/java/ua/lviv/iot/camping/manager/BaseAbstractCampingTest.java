package ua.lviv.iot.camping.manager;

import org.junit.jupiter.api.BeforeEach;

import ua.lviv.iot.camping.model.AbstractCamping;
import ua.lviv.iot.camping.model.ThingsType;

import java.util.LinkedList;
import java.util.List;

public class BaseAbstractCampingTest {
    protected List<AbstractCamping> things;

    @BeforeEach
    void setUp() {

        this.things = new LinkedList<AbstractCamping>();
        this.things.add(new AbstractCamping("backpack", "CityStyle", 550, 2.5, ThingsType.HIKING));
        this.things.add(new AbstractCamping("flashlight", "Dynamo", 80, 1.5, ThingsType.HIKING));
        this.things.add(new AbstractCamping("tent", "Caravan", 1500, 5.3, ThingsType.SECONDARY_NECESSITY));
        this.things.add(new AbstractCamping("aidkit", "UHL-MASH", 250, 3.1, ThingsType.FIRSTLY_NECESSITY));

    }

}
