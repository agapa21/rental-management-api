package com.piszczek.rentalmanagementapi.controller;

import com.piszczek.rentalmanagementapi.requestmodels.AddApartmentRequest;
import com.piszczek.rentalmanagementapi.requestmodels.AddBillRequest;
import com.piszczek.rentalmanagementapi.requestmodels.AddRentRequest;
import com.piszczek.rentalmanagementapi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/admin/secure")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add/bill")
    public void postBill(@RequestHeader(value = "Authorization") String token,
                         @RequestBody AddBillRequest addBillRequest) throws Exception {
        adminService.postBill(addBillRequest);
    }

    @PutMapping("/editbill")
    public void editBill(@RequestHeader(value = "Authorization") String token,
                         @RequestParam Long billId,
                         @RequestBody AddBillRequest editBillRequest) throws Exception {
        adminService.editBill(billId, editBillRequest);
    }

    @PostMapping("add/rent")
    public void postRent(@RequestHeader(value = "Authorization") String token,
                         @RequestBody AddRentRequest addRentRequest) throws Exception {
        adminService.postRent(addRentRequest);
    }

    @PutMapping("/editrent")
    public void editRent(@RequestHeader(value = "Authorization") String token,
                         @RequestParam Long apartmentId,
                         @RequestBody AddRentRequest editRentRequest) throws Exception {
        adminService.editRent(apartmentId, editRentRequest);
    }

    @PostMapping("add/apartment")
    public void postApartment(@RequestHeader(value = "Authorization") String token,
                              @RequestBody AddApartmentRequest addApartmentRequest) throws Exception {
        adminService.postApartment(addApartmentRequest);
    }

    @PutMapping("/editapartment")
    public void editApartment(@RequestHeader(value = "Authorization") String token,
                              @RequestParam Long apartmentId,
                         @RequestBody AddApartmentRequest editApartmentRequest) throws Exception {
        adminService.editApartment(apartmentId, editApartmentRequest);
    }
}