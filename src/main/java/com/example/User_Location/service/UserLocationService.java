package com.example.User_Location.service;

import com.example.User_Location.entity.UserLocation;
import com.example.User_Location.repository.UserLocationRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class UserLocationService {
    @Autowired
     UserLocationRepository userLocationRepository;
    // creating an entry
    public void createUserLocation(UserLocation userLocation) {
        System.out.print("aaa");
        userLocationRepository.save(userLocation);
        System.out.print("bbb");
    }
    //get request
    public List<UserLocation> getAllUserLocation(int n) {
        List<UserLocation> allUserLocations = new ArrayList<UserLocation>();
        userLocationRepository.findAll().forEach(allUserLocations::add);
        Map<UserLocation, Double> distances = new HashMap<>();
        for (UserLocation userLocation : allUserLocations) {
            double distance = calculateDistance(userLocation.getLatitude(), userLocation.getLongitude(), 0.0, 0.0);
            distances.put(userLocation, distance);
        }
        List<UserLocation> nearestUsers = distances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return nearestUsers;
    }

 // for deleting an entry
    public void deleteUserLocation(String id) throws NotFoundException {
       userLocationRepository.deleteById(id);
    }


    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371000; // in meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;
        return distance;
    }

}

