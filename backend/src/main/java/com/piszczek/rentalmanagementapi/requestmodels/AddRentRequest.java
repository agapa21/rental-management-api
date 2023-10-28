package com.piszczek.rentalmanagementapi.requestmodels;

import lombok.Data;

@Data
public class AddRentRequest {

    private Long apartmentId;

    private String startDate;

    private String endDate;

    private int deposit;

    private int fee;

    private String tenantName;

    private String tenantEmail;

    private String tenantNumber;
}
