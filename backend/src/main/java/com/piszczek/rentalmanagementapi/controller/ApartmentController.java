package com.piszczek.rentalmanagementapi.controller;
import com.piszczek.rentalmanagementapi.entity.Apartment;
import com.piszczek.rentalmanagementapi.response.ApartmentsOptionalResponse;
import com.piszczek.rentalmanagementapi.response.ApartmentsResponse;
import com.piszczek.rentalmanagementapi.service.ApartmentService;

import com.piszczek.rentalmanagementapi.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/apartments")
public class ApartmentController {

    private final ApartmentService apartmentService;

    @Autowired
    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping("/rented")
    public ApartmentsOptionalResponse returnRented() throws Exception {
        return apartmentService.rented();
    }

    @GetMapping("/notRented")
    public ApartmentsResponse returnNotRented() throws Exception {
        return apartmentService.notRented();
    }

    @PutMapping("/deleteApartment")
    public void deleteApartment(@RequestParam Long apartmentId) throws Exception {
        apartmentService.deleteApartment(apartmentId);
    }
}
