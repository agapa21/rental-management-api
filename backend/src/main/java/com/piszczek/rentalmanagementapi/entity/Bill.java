package com.piszczek.rentalmanagementapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "bill")
@Data
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "apartment_id")
    private Long apartmentId;

    @Column(name = "period")
    private String period;

    @Column(name = "administrative_rent")
    private String administrativeRent;

    @Column(name = "electricity_bill")
    private String electricityBill;

    @Column(name = "gas_bill")
    private String gasBill;

    @Column(name = "additional_costs")
    private String additionalCosts;
}