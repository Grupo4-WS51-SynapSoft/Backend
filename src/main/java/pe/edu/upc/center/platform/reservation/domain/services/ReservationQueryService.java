package pe.edu.upc.center.platform.reservation.domain.services;

import pe.edu.upc.center.platform.reservation.domain.model.entities.Reservation;
import pe.edu.upc.center.platform.reservation.domain.model.queries.GetAllReservationsQuery;
import pe.edu.upc.center.platform.reservation.domain.model.queries.GetReservationDetailsQuery;

import java.util.List;
import java.util.Optional;

public interface ReservationQueryService {
    Optional<Reservation> handle(GetReservationDetailsQuery query);
    List<Reservation> handle(GetAllReservationsQuery query);
}