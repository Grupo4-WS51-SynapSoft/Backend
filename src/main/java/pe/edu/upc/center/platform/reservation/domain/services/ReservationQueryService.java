package pe.edu.upc.center.platform.reservation.domain.services;

import pe.edu.upc.center.platform.reservation.domain.model.entities.Reservation;
import pe.edu.upc.center.platform.reservation.domain.model.queries.GetReservationDetailsQuery;
import pe.edu.upc.center.platform.reservation.domain.model.queries.GetReservationsByUserQuery;

import java.util.List;
import java.util.Optional;

public interface ReservationQueryService {
    List<Reservation> handle(GetReservationsByUserQuery query);
    Optional<Reservation> handle(GetReservationDetailsQuery query);
}