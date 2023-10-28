package com.piszczek.rentalmanagementapi.service;

import com.piszczek.rentalmanagementapi.dao.ApartmentRepository;
import com.piszczek.rentalmanagementapi.dao.BillRepository;
import com.piszczek.rentalmanagementapi.dao.RentRepository;
import com.piszczek.rentalmanagementapi.entity.Apartment;
import com.piszczek.rentalmanagementapi.entity.Bill;
import com.piszczek.rentalmanagementapi.entity.Rent;
import com.piszczek.rentalmanagementapi.requestmodels.AddApartmentRequest;
import com.piszczek.rentalmanagementapi.requestmodels.AddBillRequest;
import com.piszczek.rentalmanagementapi.requestmodels.AddRentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminService {

    private ApartmentRepository apartmentRepository;
    private BillRepository billRepository;
    private RentRepository rentRepository;

    @Autowired
    public AdminService (ApartmentRepository apartmentRepository,
                         BillRepository billRepository,
                         RentRepository rentRepository) {
        this.apartmentRepository = apartmentRepository;
        this.billRepository = billRepository;
        this.rentRepository = rentRepository;
    }

    public void postBill(AddBillRequest addBillRequest){
        Bill bill = new Bill();
        bill.setApartmentId(addBillRequest.getApartmentId());
        bill.setPeriod(addBillRequest.getPeriod());
        bill.setAdministrativeRent(addBillRequest.getAdministrativeRent());
        bill.setElectricityBill(addBillRequest.getElectricityBill());
        bill.setGasBill(addBillRequest.getGasBill());
        bill.setAdditionalCosts(addBillRequest.getAdditionalCosts());
        billRepository.save(bill);
    }

    public void editBill(Long id, AddBillRequest editBillRequest) throws Exception {

        if (!billRepository.existsById(id)) {
            throw new Exception("Bill not found");
        }
        else {
            Bill bill = billRepository.getReferenceById(id);
            bill.setApartmentId(editBillRequest.getApartmentId());
            bill.setPeriod(editBillRequest.getPeriod());
            bill.setAdministrativeRent(editBillRequest.getAdministrativeRent());
            bill.setElectricityBill(editBillRequest.getElectricityBill());
            bill.setGasBill(editBillRequest.getGasBill());
            bill.setAdditionalCosts(editBillRequest.getAdditionalCosts());
            billRepository.save(bill);
        }
    }

    public void postRent(AddRentRequest addRentRequest) {
        Rent rent = new Rent();
        rent.setApartmentId(addRentRequest.getApartmentId());
        rent.setStartDate(addRentRequest.getStartDate());
        rent.setEndDate(addRentRequest.getEndDate());
        rent.setDeposit(addRentRequest.getDeposit());
        rent.setFee(addRentRequest.getFee());
        rent.setTenantName(addRentRequest.getTenantName());
        rent.setTenantEmail(addRentRequest.getTenantEmail());
        rent.setTenantNumber(addRentRequest.getTenantNumber());
        rentRepository.save(rent);
    }

    public void editRent(Long apartmentId, AddRentRequest editRentRequest) throws Exception {

        Rent rent = rentRepository.findByApartmentId(apartmentId);

        if (rent == null) {
            throw new Exception("Rent not found");
        }
        else {
            rent.setStartDate(editRentRequest.getStartDate());
            rent.setEndDate(editRentRequest.getEndDate());
            rent.setDeposit(editRentRequest.getDeposit());
            rent.setFee(editRentRequest.getFee());
            rent.setTenantName(editRentRequest.getTenantName());
            rent.setTenantEmail(editRentRequest.getTenantEmail());
            rent.setTenantNumber(editRentRequest.getTenantNumber());
            rentRepository.save(rent);
        }
    }

    public void postApartment(AddApartmentRequest addApartmentRequest) {
        Apartment apartment = new Apartment();
        apartment.setTitle(addApartmentRequest.getTitle());
        apartment.setAddress(addApartmentRequest.getAddress());
        apartment.setLandlordName(addApartmentRequest.getLandlordName());
        apartment.setLandlordMobile(addApartmentRequest.getLandlordMobile());
        apartment.setLandlordEmail(addApartmentRequest.getLandlordEmail());
        apartmentRepository.save(apartment);

    }

    public void editApartment(Long apartmentId, AddApartmentRequest editApartmentRequest) throws Exception {

        if (!apartmentRepository.existsById(apartmentId)) {
            throw new Exception("Apartment not found");
        }
        else {
            Apartment apartment = apartmentRepository.getReferenceById(apartmentId);
            apartment.setTitle(editApartmentRequest.getTitle());
            apartment.setAddress(editApartmentRequest.getAddress());
            apartment.setLandlordName(editApartmentRequest.getLandlordName());
            apartment.setLandlordMobile(editApartmentRequest.getLandlordMobile());
            apartment.setLandlordEmail(editApartmentRequest.getLandlordEmail());
            apartmentRepository.save(apartment);
        }
    }
}
