package com.piszczek.rentalmanagementapi.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "apartment")
@Data
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "address")
    private String address;

    @Column(name = "landlord_name")
    private String landlordName;

    @Column(name = "landlord_email")
    private String landlordEmail;

    @Column(name = "landlord_mobile")
    private String landlordMobile;
}
