package ua.lviv.iot.camping.manager;

import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.camping.model.AbstractCamping;
import ua.lviv.iot.camping.model.ThingsType;

public class CampingManager {

    private List<AbstractCamping> things;

    public CampingManager(List<AbstractCamping> things) {
        this.setThings(things);
    }

    public List<AbstractCamping> findThingsForHiking(ThingsType thingsType, List<AbstractCamping> things) {
        
        List<AbstractCamping> result = new LinkedList<>();
        for (int thingFromTheList = 0; thingFromTheList < things.size(); thingFromTheList++) {
            if (things.get(thingFromTheList).getThingsType() == thingsType) {
                result.add(things.get(thingFromTheList));
                System.out.println("#" + (thingFromTheList + 1) + " matching the criteria" + " with price "
                        + things.get(thingFromTheList).getThingsType());
            } else {
                System.out.println(" #" + (thingFromTheList + 1) + " does not match the criteria");
            }
        }
        return result;
    }

    public List<AbstractCamping> getThings() {
        return things;
    }

    public void setThings(List<AbstractCamping> things) {
        this.things = things;
    }
}
