package pe.edu.upc.center.platform.reservation.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record CreateReservationResource(
        Long caregiverId,
        String date,
        String startTime,
        String endTime,
        Long paymentMethodId
) {}