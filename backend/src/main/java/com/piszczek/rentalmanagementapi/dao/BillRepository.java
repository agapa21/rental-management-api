package com.piszczek.rentalmanagementapi.dao;

import com.piszczek.rentalmanagementapi.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill,Long> {

    List<Bill> findByApartmentId(Long apartmentId);

}