package example1;

import java.util.*;

/**
 * @author Andrey Ledovskikh
 */
public class UndergroundSystem {

    class Route {;
        final public String startStationName;
        final public String endStationName;

        private int count;
        private List<Integer> durations = new ArrayList<>();

        Route(String startStationName, String endStationName) {
            this.startStationName = startStationName;
            this.endStationName = endStationName;
        }

        void addTrip(int duration) {
            this.durations.add(duration);
            this.count++;
        }

        double getAverage() {
            if (this.count == 0) {
                return 0;
            }
            return ((double) durations.stream().mapToInt(item -> item).sum()) / this.count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Route)) return false;
            Route route = (Route) o;
            return startStationName.equals(route.startStationName) && endStationName.equals(route.endStationName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startStationName, endStationName);
        }
    }

    class PassengerCheckIn {
        final private int id;
        final private String startStationName;
        final int currentTime;

        public PassengerCheckIn(int id, String startStationName, int currentTime) {
            this.id = id;
            this.startStationName = startStationName;
            this.currentTime = currentTime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PassengerCheckIn)) return false;
            PassengerCheckIn that = (PassengerCheckIn) o;
            return id == that.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    Map<Route, Route> routes = new HashMap<>();
    Map<Integer, PassengerCheckIn> checkIn = new HashMap<>();

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        if (checkIn.get(id) != null) {
            return;
        }

        checkIn.put(id, new PassengerCheckIn(id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        if (checkIn.get(id) == null) {
            return;
        }

        final var checkInInfo = this.checkIn.get(id);
        this.checkIn.remove(id);

        if (!routes.containsKey(new Route(checkInInfo.startStationName, stationName))) {
            routes.put(new Route(checkInInfo.startStationName, stationName), new Route(checkInInfo.startStationName, stationName));
        }

        final var currentRoute = routes.get(new Route(checkInInfo.startStationName, stationName));

        currentRoute.addTrip(t - checkInInfo.currentTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        if (routes.get(new Route(startStation, endStation)) == null) {
            return 0D;
        }
        return routes.get(new Route(startStation, endStation)).getAverage();
    }
}
