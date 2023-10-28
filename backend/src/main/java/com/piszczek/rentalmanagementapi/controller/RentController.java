package com.piszczek.rentalmanagementapi.controller;

import com.piszczek.rentalmanagementapi.response.RentRemainingDaysResponse;
import com.piszczek.rentalmanagementapi.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/rents/")
public class RentController {

    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/daysLeft")
    public RentRemainingDaysResponse daysLeft(@RequestParam Long apartmentId) throws Exception
    {
        return rentService.daysLeft(apartmentId);
    }

    @PutMapping("/extendLease")
    public void extendLease(@RequestParam Long apartmentId) throws Exception
    {
        rentService.extendLease(apartmentId);
    }

    @PutMapping("/endLease")
    public void endLease(@RequestParam Long apartmentId) throws Exception
    {
        rentService.endLease(apartmentId);
    }
}
