package com.piszczek.rentalmanagementapi.response;
import com.piszczek.rentalmanagementapi.entity.Rent;
import lombok.Data;

@Data
public class RentRemainingDaysResponse {
    public RentRemainingDaysResponse(Rent rent, long daysLeft) {
        this.rent = rent;
        this.daysLeft = daysLeft;
    }

    private Rent rent;
    private long daysLeft;
}
