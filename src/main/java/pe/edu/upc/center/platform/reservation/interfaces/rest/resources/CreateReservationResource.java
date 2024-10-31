package pe.edu.upc.center.platform.reservation.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateReservationResource(Long userId, Long caregiverId, LocalDateTime scheduledAt, Double totalFare) {
}
