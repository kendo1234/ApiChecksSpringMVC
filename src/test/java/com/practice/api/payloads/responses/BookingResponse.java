package com.practice.api.payloads.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponse {

    @JsonProperty
    private int bookingid;
    @JsonProperty
    private BookingDetails booking;

    public void setBooking(BookingDetails booking) {
        this.booking = booking;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public BookingDetails getBooking() {
        return booking;
    }

    public int getBookingid() {
        return bookingid;
    }
}
