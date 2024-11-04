package pe.edu.upc.center.platform.reservation.domain.model.queries;

import lombok.Getter;

@Getter
public class GetReservationDetailsQuery {
    private final Long reservationId;

    public GetReservationDetailsQuery(Long reservationId) {
        this.reservationId = reservationId;
    }
}