package com.example.User_Location.repository;

import com.example.User_Location.entity.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserLocationRepository extends CrudRepository<UserLocation, String> {
}
