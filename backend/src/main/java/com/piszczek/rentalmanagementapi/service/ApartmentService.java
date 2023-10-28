package com.piszczek.rentalmanagementapi.service;
import com.piszczek.rentalmanagementapi.dao.ApartmentRepository;
import com.piszczek.rentalmanagementapi.dao.BillRepository;
import com.piszczek.rentalmanagementapi.dao.RentRepository;
import com.piszczek.rentalmanagementapi.entity.Apartment;
import com.piszczek.rentalmanagementapi.entity.Bill;
import com.piszczek.rentalmanagementapi.entity.Rent;
import com.piszczek.rentalmanagementapi.response.ApartmentsOptionalResponse;
import com.piszczek.rentalmanagementapi.response.ApartmentsResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ApartmentService {

    private ApartmentRepository apartmentRepository;
    private RentRepository rentRepository;
    private BillRepository billRepository;

    public ApartmentService(ApartmentRepository apartmentRepository, RentRepository rentRepository,
                            BillRepository billRepository) {
        this.apartmentRepository = apartmentRepository;
        this.rentRepository = rentRepository;
        this.billRepository = billRepository;
    }

    public ApartmentsOptionalResponse rented(){
        List<Rent> rents = rentRepository.findAll();
        List<Optional<Apartment>> apartments = new ArrayList<>();

        for(Rent rent: rents) {
            apartments.add(apartmentRepository.findById(rent.getApartmentId()));
        }

        return new ApartmentsOptionalResponse(apartments);
    }

    public ApartmentsResponse notRented(){
        List<Rent> rents = rentRepository.findAll();
        List<Apartment> apartments = apartmentRepository.findAll();

        for(Rent rent: rents) {
            apartments.remove(apartmentRepository.getById(rent.getApartmentId()));
        }

        return new ApartmentsResponse(apartments);
    }

    public void deleteApartment(Long apartmentId) throws Exception {

        Apartment apartment = apartmentRepository.getById(apartmentId);

        if (apartment == null) {
            throw new Exception("Apartment does not exist");
        }

        apartmentRepository.deleteById(apartment.getId());

        if (rentRepository.findByApartmentId(apartmentId) != null) {
            rentRepository.deleteById(rentRepository.findByApartmentId(apartmentId).getId());
        }

        List<Bill> bills = billRepository.findByApartmentId(apartmentId);
        if(bills != null) {
            for (Bill bill : bills) {
                billRepository.deleteById(bill.getId());
            }
        }
    }
}
