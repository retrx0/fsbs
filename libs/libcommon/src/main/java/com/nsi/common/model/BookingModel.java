package com.nsi.common.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Currency;

@Data
public abstract class BookingModel {

    String bookingId;
    LocalDateTime bookingDate;
    LocalDateTime completionDate;
    LocalDateTime cancellationDate;
    LocalDateTime modifiedTime;
    BookingStatus bookingStatus;
    String userId;
    String deletedBy;
    boolean isCanceled;
    boolean isDeleted;
    String bookingPrice;
    Currency currency;
    String bookingFor;

}
