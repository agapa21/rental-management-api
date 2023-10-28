package com.piszczek.rentalmanagementapi.response;

import com.piszczek.rentalmanagementapi.entity.Apartment;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class ApartmentsResponse {

    public ApartmentsResponse(List<Apartment> apartments)
    {
        this.apartments = apartments;
    }

    public List<Apartment> apartments;

}
