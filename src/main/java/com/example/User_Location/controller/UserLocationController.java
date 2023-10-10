package com.example.User_Location.controller;

import com.example.User_Location.entity.UserLocation;
import com.example.User_Location.service.UserLocationService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import java.util.List;

@RestController
public class UserLocationController {

    @Autowired
    UserLocationService userLocationService;
    final Logger logger = LoggerFactory.getLogger(UserLocationController.class);
 //post request
    @RequestMapping(method = RequestMethod.POST, value ="/create_userLocation")
    public void CreateUserLocation(@RequestBody UserLocation userLocation) {
        userLocationService.createUserLocation(userLocation);
    }
 // get request
    @GetMapping("/get_userLocation/{n}")
    public List<UserLocation> getAllUsers(@PathVariable int n) {
        logger.debug("I am in getAllTopics");
        return userLocationService.getAllUserLocation(n);
    }

    //delete
    @RequestMapping(method = RequestMethod.DELETE, value ="/delete_userLocation/{id}")
    public void deleteUserLocation( @PathVariable String id) throws NotFoundException {
        userLocationService.deleteUserLocation(id);
    }


}

