package com.piszczek.rentalmanagementapi.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "rent")
@Data
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "apartment_id")
    private Long apartmentId;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "deposit")
    private int deposit;

    @Column(name = "fee")
    private int fee;

    @Column(name = "tenant_name")
    private String tenantName;

    @Column(name = "tenant_email")
    private String tenantEmail;

    @Column(name = "tenant_number")
    private String tenantNumber;
}