package com.piszczek.rentalmanagementapi.dao;

import com.piszczek.rentalmanagementapi.entity.Apartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment,Long> {

    Page<Apartment> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);
}
