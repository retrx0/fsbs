package com.nsi.fsbs;

import com.nsi.grpc.BookingRequest;
import com.nsi.grpc.BookingResponse;
import com.nsi.grpc.BookingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        BookingServiceGrpc.BookingServiceBlockingStub stub
                = BookingServiceGrpc.newBlockingStub(channel);

        BookingResponse helloResponse = stub.book(BookingRequest.newBuilder()
                .setBookingDate("Testing")
                .setUserId("gRPC")
                .build());

        System.out.println(helloResponse);

        channel.shutdown();
    }
}
