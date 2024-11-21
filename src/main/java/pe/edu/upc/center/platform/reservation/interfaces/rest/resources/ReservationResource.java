package pe.edu.upc.center.platform.reservation.interfaces.rest.resources;

import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;
import pe.edu.upc.center.platform.reservation.domain.model.valueobjects.ReservationStatus;
import pe.edu.upc.center.platform.tutor.domain.model.aggregates.Tutor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record ReservationResource(
        Long id,
        Caregiver caregiverId,
        Long tutorId,
        LocalDateTime date,
        String startTime,
        String endTime,
        String status,
        double totalAmount
) {}