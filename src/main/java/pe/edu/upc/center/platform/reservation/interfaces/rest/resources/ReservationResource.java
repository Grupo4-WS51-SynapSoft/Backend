package pe.edu.upc.center.platform.reservation.interfaces.rest.resources;

import pe.edu.upc.center.platform.reservation.domain.model.valueobjects.ReservationStatus;

import java.time.LocalDate;
import java.util.Date;

public record ReservationResource(
        Long id,
        Long caregiverId,
        String date,
        String startTime,
        String endTime,
        Long paymentMethodId,
        ReservationStatus status,
        String createdAt,
        String updatedAt
) {}