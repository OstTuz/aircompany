import Planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;

    //Constructor
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane p : planes)
        {
            if (p instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) p);
            }
        }
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        for (int i = 0; i < getMilitaryPlanes().size(); i++)
        {
            if (getMilitaryPlanes().get(i).getType() == MilitaryType.TRANSPORT)
            {
                transportMilitaryPlanes.add(getMilitaryPlanes().get(i));
            }
        }
        return transportMilitaryPlanes;
    }

    ///3  same methods getPassengerPlanes getMilitaryPlanes and getExperimentalPlanes
    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void printPlanes(Collection<? extends Plane> planes) {
        for (Plane plane:planes) {
            System.out.println(plane);
        }
    }

    public List<MilitaryPlane> getBomberPlanesFromMilitary()
    {
        List<MilitaryPlane> bomberPlanes = new ArrayList<>();
        for (MilitaryPlane militaryPlane: getMilitaryPlanes()) {
            if (militaryPlane.getType() == MilitaryType.BOMBER)
            {
                bomberPlanes.add(militaryPlane);
            }
        }
        return bomberPlanes;
    }

    public List<ExperimentalPlane> getUnclassifiedPlanes()
    {
        List<ExperimentalPlane> unclassifiedPlanes = new ArrayList<>();
        for (ExperimentalPlane experimentalPlane: getExperimentalPlanes()) {
            if (experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED)
            {
                unclassifiedPlanes.add(experimentalPlane);
            }
        }
        return unclassifiedPlanes;
    }

    public boolean isSortedByMaxLoadCapacity() {
        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < sortByMaxLoadCapacity().planes.size() - 1; i++) {
            if (sortByMaxLoadCapacity().planes.get(i).getMaxLoadCapacity() > sortByMaxLoadCapacity().planes.get(i + 1).getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        return nextPlaneMaxLoadCapacityIsHigherThanCurrent;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

}
