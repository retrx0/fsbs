package com.nsi.fsbs.services.grpc.impl;

import com.nsi.grpc.BookingRequest;
import com.nsi.grpc.BookingResponse;
import com.nsi.grpc.BookingServiceGrpc;
import io.grpc.stub.StreamObserver;

public class BookingServiceImpl extends BookingServiceGrpc.BookingServiceImplBase {

    @Override
    public void book(BookingRequest request, StreamObserver<BookingResponse> responseObserver) {

        String greeting = "Hello, " +
                request.getBookingDate() +
                " " +
                request.getUserId();

        BookingResponse response = BookingResponse.newBuilder()
                .setStatus(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}