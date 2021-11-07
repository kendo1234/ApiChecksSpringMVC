package com.practice.api.requests;

import com.practice.api.payloads.BookingPayload;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class Booking {
    private static RestTemplate restTemplate =  new RestTemplate();

    public static ResponseEntity<String> getBookings() {
        return restTemplate.getForEntity("http://localhost:3001/booking", String.class);
    }

    public static ResponseEntity<String> getBooking(int id, MediaType accept) throws HttpClientErrorException {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(accept));

        HttpEntity<String> httpEntity = new HttpEntity<String>(requestHeaders);

        return restTemplate.exchange("http://localhost:3001/booking/" + Integer.toString(id) , HttpMethod.GET, httpEntity, String.class);
    }

    public static ResponseEntity<String> postBooking(BookingPayload payload) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));


        HttpEntity<String> httpEntity = new HttpEntity<String>(requestHeaders);

        return restTemplate.exchange("http://localhost:3001/booking/", HttpMethod.POST, httpEntity, String.class);
    }
}
