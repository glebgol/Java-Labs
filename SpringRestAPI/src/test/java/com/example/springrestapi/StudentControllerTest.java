package com.example.springrestapi;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class StudentControllerTest {

    @Test
    void getAllStudents() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/api/students"  );

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        Assertions.assertEquals(HttpStatus.SC_OK,
                httpResponse.getCode());
    }

    @Test
    void getStudentById() {
    }
}