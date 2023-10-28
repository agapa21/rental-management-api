package com.piszczek.rentalmanagementapi.requestmodels;

import lombok.Data;

@Data
public class AddBillRequest {

    private Long apartmentId;

    private String period;

    private String administrativeRent;

    private String electricityBill;

    private String gasBill;

    private String additionalCosts;
}
