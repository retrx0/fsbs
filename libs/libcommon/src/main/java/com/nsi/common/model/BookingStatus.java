package com.nsi.common.model;

/**
 * Booking status that for orders
 * <br>
 * <p>
 * <li>DRAFT: New booking that is not yet reviewed</li>
 * <li>PENDING: Book order getting reviewed</li>
 * <li>ACCEPTED: Book order accepted by service</li>
 * <li>CANCELLED: Booking order cancelled</li>
 * <li>IN_PROGRESS: Booking order in progress</li>
 * <li>COMPLETED: Booking order completed</li>
 * </p>
 */
public enum BookingStatus {
    DRAFT, PENDING, ACCEPTED, CANCELLED, IN_PROGRESS, COMPLETED;
}
