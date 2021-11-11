package com.practice.api;

import com.practice.api.payloads.requests.AuthPayload;
import com.practice.api.payloads.requests.BookingPayload;
import com.practice.api.payloads.responses.AuthResponse;
import com.practice.api.payloads.responses.BookingResponse;
import com.practice.api.requests.Auth;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import com.practice.api.requests.Booking;

import java.sql.SQLOutput;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;


public class bookingChecks {

    @Test
    public void getBookingShouldReturn200(){
        ResponseEntity<String> response = Booking.getBookings();

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void getBookingIdShouldReturn200() {
        ResponseEntity<String> response = Booking.getBooking(1, MediaType.APPLICATION_JSON);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void getBookingWithBadAcceptShouldReturn418() {
        try {
            Booking.getBooking(1, MediaType.TEXT_PLAIN);

            fail("HttpClientError not thrown"); //add in fail to communicate error never thrown
        } catch (HttpClientErrorException e) {
            assertThat(e.getStatusCode(), is(HttpStatus.I_AM_A_TEAPOT));
        }
    }

    @Test
    public void postBookingReturns200() {
            BookingPayload payload = new BookingPayload.BookingPayloadBuilder()
                    .setFirstname("Steve")
                    .setLastname("Rogers")
                    .setTotalprice(500)
                    .setDepositpaid(true)
                    .setCheckin(new Date())
                    .setCheckout(new Date())
                    .setAdditionalneeds("None")
                    .build();

            ResponseEntity<BookingResponse> response =  Booking.postBooking(payload);

            assertThat(response.getStatusCode(), is(HttpStatus.OK));

        }

        @Test
        public void deleteBookingReturns200() {

            BookingPayload payload = new BookingPayload.BookingPayloadBuilder()
                    .setFirstname("Tony")
                    .setLastname("Stark")
                    .setTotalprice(500)
                    .setDepositpaid(true)
                    .setCheckin(new Date())
                    .setCheckout(new Date())
                    .setAdditionalneeds("None")
                    .build();

            ResponseEntity<BookingResponse> createdBookingResponse =  Booking.postBooking(payload);

            AuthPayload authPayload = new AuthPayload.AuthPayloadBuilder()
                .setUsername("admin")
                .setPassword("password123")
                .build();

            ResponseEntity<AuthResponse> authResponse = Auth.postAuth(authPayload);

            int id = createdBookingResponse.getBody().getBookingid();
            String token = authResponse.getBody().getToken();

            ResponseEntity<String> deleteResponse = Booking.deleteBooking(id, token);

            assertThat(deleteResponse.getStatusCode(), is(HttpStatus.CREATED));


        }
    }

