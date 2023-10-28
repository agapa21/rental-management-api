package com.piszczek.rentalmanagementapi.service;

import com.piszczek.rentalmanagementapi.response.RentRemainingDaysResponse;
import com.piszczek.rentalmanagementapi.dao.BillRepository;
import com.piszczek.rentalmanagementapi.dao.RentRepository;
import com.piszczek.rentalmanagementapi.entity.Bill;
import com.piszczek.rentalmanagementapi.entity.Rent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class RentService {

    private BillRepository billRepository;
    private RentRepository rentRepository;

    public RentService(BillRepository billRepository, RentRepository rentRepository) {
        this.billRepository = billRepository;
        this.rentRepository = rentRepository;
    }

    public RentRemainingDaysResponse daysLeft(Long apartmentId) throws Exception {

       RentRemainingDaysResponse rentRemainingDaysResponse;

       Rent rent = rentRepository.findByApartmentId(apartmentId);

       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

       Date d1 = sdf.parse(rent.getEndDate());
       Date d2 = sdf.parse(LocalDate.now().toString());

       TimeUnit time = TimeUnit.DAYS;

       long difference_In_Time = time.convert(d1.getTime() - d2.getTime(),
               TimeUnit.MILLISECONDS);

           rentRemainingDaysResponse = new RentRemainingDaysResponse(rent, difference_In_Time);

        return rentRemainingDaysResponse;
    }

    public void extendLease(Long apartmentId) throws Exception {

        Rent validateRent = rentRepository.findByApartmentId(apartmentId);

        if (validateRent == null) {
            throw new Exception("Rent does not exist");
        }

        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date d1 = sdFormat.parse(validateRent.getEndDate());
        Date d2 = sdFormat.parse(LocalDate.now().toString());

        if (d1.compareTo(d2) > 0 || d1.compareTo(d2) == 0) {
            validateRent.setEndDate(LocalDate.now().plusDays(365).toString());
            rentRepository.save(validateRent);
        }
    }

    public void endLease(Long apartmentId) throws Exception {

        Rent rent = rentRepository.findByApartmentId(apartmentId);

        if (rent == null) {
            throw new Exception("Rent does not exist");
        }

        rentRepository.deleteById(rent.getId());

        List<Bill> bills = billRepository.findByApartmentId(apartmentId);

        for(Bill bill: bills){
            billRepository.deleteById(bill.getId());
        }
    }
}
