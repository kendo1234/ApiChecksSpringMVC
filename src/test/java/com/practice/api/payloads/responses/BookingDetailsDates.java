package com.practice.api.payloads.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class BookingDetailsDates {

    @JsonProperty
    private Date checkin;

    @JsonProperty
    private Date checkout;

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }
}
