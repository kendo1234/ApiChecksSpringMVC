package com.practice.api.requests;

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
}
