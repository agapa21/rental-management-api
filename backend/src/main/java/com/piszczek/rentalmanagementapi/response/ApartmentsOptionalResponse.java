package com.piszczek.rentalmanagementapi.response;

import com.piszczek.rentalmanagementapi.entity.Apartment;

import java.util.List;
import java.util.Optional;

public class ApartmentsOptionalResponse {

    public ApartmentsOptionalResponse(List<Optional<Apartment>> apartments)
    {
        this.apartmentsOptional = apartments;
    }

    public List<Optional<Apartment>> apartmentsOptional;
}
