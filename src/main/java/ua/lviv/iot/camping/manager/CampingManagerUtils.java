package ua.lviv.iot.camping.manager;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import ua.lviv.iot.camping.model.AbstractCamping;
import ua.lviv.iot.camping.model.SortType;

public class CampingManagerUtils {

    // Sort with anonym
    // class//////////////////////////////////////////////////////////////////////

    public static void sortGoodsByProducer(List<AbstractCamping> things, SortType sortType) {
        Comparator<AbstractCamping> comparator = new Comparator<AbstractCamping>() {
            @Override
            public int compare(AbstractCamping firstItem, AbstractCamping secondItem) {
                return firstItem.getProducer().compareTo(secondItem.getProducer());
            }
        };
        things.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    // Static inner class
    static class ThingsByWeightInKilo implements Comparator<AbstractCamping>, Serializable {

        private static final long serialVersionUID = 1L;

        @Override
        public int compare(AbstractCamping firstThing, AbstractCamping secondThing) {
            return (int) (firstThing.getWeightInKilo() - secondThing.getWeightInKilo());
        }
    }

    private static final ThingsByWeightInKilo THINGS_SORTER_BY_WEIGHT_IN_KILO = new ThingsByWeightInKilo();

    // sort using static inner class
    public static void sortByWeightInKilo(List<AbstractCamping> things, SortType sortType) {
        things.sort(sortType == SortType.ASCENDING ? THINGS_SORTER_BY_WEIGHT_IN_KILO
                : THINGS_SORTER_BY_WEIGHT_IN_KILO.reversed());
    }

    // inner class
     static class SortThingsByPriceInUAH implements Comparator<AbstractCamping>,Serializable {
        
        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        @Override
        public int compare(AbstractCamping firstThing, AbstractCamping secondThing) {
            if (Double.compare(firstThing.getPriceInUAH(), secondThing.getPriceInUAH()) < 0) {
                return -1;
            }
            if (Double.compare(firstThing.getPriceInUAH(), secondThing.getPriceInUAH()) > 0) {
                return 1;
            }
            return 0;
        }
    }

    // sort using inner class
    public static void sortByPriceInUAH(List<AbstractCamping> things, SortType sortType) {
        SortThingsByPriceInUAH sortThingsByPriceInUAH = new SortThingsByPriceInUAH();
        things.sort(sortType == SortType.ASCENDING ? sortThingsByPriceInUAH : sortThingsByPriceInUAH.reversed());
    }

}
