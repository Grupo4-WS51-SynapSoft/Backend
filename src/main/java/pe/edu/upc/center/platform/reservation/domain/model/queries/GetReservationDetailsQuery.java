package pe.edu.upc.center.platform.reservation.domain.model.queries;

public class GetReservationDetailsQuery {
    private Long reservationId;

    public GetReservationDetailsQuery(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getReservationId() {
        return reservationId;
    }
}