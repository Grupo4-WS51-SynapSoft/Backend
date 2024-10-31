package pe.edu.upc.center.platform.reservation.interfaces.rest.resources;

public record ReservationResource(Long id, Long userId, Long caregiverId, String status, Double totalFare) {
}