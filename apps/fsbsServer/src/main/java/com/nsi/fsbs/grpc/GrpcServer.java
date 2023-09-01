package com.nsi.fsbs.grpc;

import com.nsi.fsbs.services.grpc.impl.BookingServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {

                Server server = ServerBuilder
                        .forPort(8080)
                        .addService(new BookingServiceImpl()).build();

                server.start();
                server.awaitTermination();

    }
}
