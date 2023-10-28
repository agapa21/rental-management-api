package com.piszczek.rentalmanagementapi.requestmodels;

import lombok.Data;

@Data
public class AddApartmentRequest {

    private String title;

    private String address;

    private String landlordName;

    private String landlordEmail;

    private String landlordMobile;

}
