package ua.lviv.iot.camping.manager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.camping.model.*;

public class AbstractCampingUtilsTest extends BaseAbstractCampingTest {

    @Test
    public void testSortThingsByProducer() {
        CampingManagerUtils.sortGoodsByProducer(things, SortType.ASCENDING);

        assertEquals("Caravan", things.get(0).getProducer());
        assertEquals("CityStyle", things.get(1).getProducer());
        assertEquals("Dynamo", things.get(2).getProducer());
        assertEquals("UHL-MASH", things.get(3).getProducer());
    }

    @Test
    public void testSortGoodsByPriceInUAH() {
        CampingManagerUtils.sortByPriceInUAH(things, SortType.ASCENDING);
        assertEquals(80, things.get(0).getPriceInUAH());
        assertEquals(250, things.get(1).getPriceInUAH());
        assertEquals(550, things.get(2).getPriceInUAH());
        assertEquals(1500, things.get(3).getPriceInUAH());
    }

    @Test
    public void testSortThingsByWeightInKilo() {
        CampingManagerUtils.sortByWeightInKilo(things, SortType.ASCENDING);
        assertEquals(1.5, things.get(0).getWeightInKilo());
        assertEquals(2.5, things.get(1).getWeightInKilo());
        assertEquals(3.1, things.get(2).getWeightInKilo());
        assertEquals(5.3, things.get(3).getWeightInKilo());

    }

}
