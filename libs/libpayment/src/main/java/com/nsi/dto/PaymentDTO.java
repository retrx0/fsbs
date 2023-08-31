package com.nsi.dto;

import com.nsi.model.PaymentStatus;
import com.nsi.model.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class PaymentDTO {

    String paymentId;
    String userId;
    String bookingId;
    String transactionRef;
    PaymentType paymentType;
    PaymentStatus status;
    LocalDateTime paymentDate;
    String discountId;

}
