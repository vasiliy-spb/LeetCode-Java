package matrix.workingPeoplesImitation.task_1396_Design_Underground_System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// my solution
public class UndergroundSystem {
    Map<Integer, String> userStations;
    Map<String, Station> stations;

    public UndergroundSystem() {
        this.userStations = new HashMap<>();
        this.stations = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        userStations.put(id, stationName);
        Station station = stations.get(stationName);
        if (station == null) {
            station = new Station(stationName);
            stations.put(stationName, station);
        }
        station.getUsersTime().put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        String fromStationName = userStations.get(id);
        Station fromStation = stations.get(fromStationName);
        fromStation.getDestination().putIfAbsent(stationName, new ArrayList<>());
        fromStation.getDestination().get(stationName).add(t - fromStation.getUsersTime().get(id));
    }

    public double getAverageTime(String startStation, String endStation) {
        List<Integer> routes = stations.get(startStation).getDestination().get(endStation);
        long sum = 0;
        for (int t : routes) {
            sum += t;
        }
        return (double) sum / routes.size();
    }
    private static class Station {
        private final String name;
        private final Map<Integer, Integer> usersTime;
        private final Map<String, List<Integer>> destination;
        public Station(String name) {
            this.name = name;
            this.usersTime = new HashMap<>();
            this.destination = new HashMap<>();
        }

        public String getName() {
            return name;
        }

        public Map<Integer, Integer> getUsersTime() {
            return usersTime;
        }

        public Map<String, List<Integer>> getDestination() {
            return destination;
        }
    }
}
