package com.piszczek.rentalmanagementapi.dao;

import com.piszczek.rentalmanagementapi.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;


public interface RentRepository extends JpaRepository<Rent,Long> {
    Rent findByApartmentId(Long apartmentId);
}
