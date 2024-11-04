package pe.edu.upc.center.platform.reservation.domain.model.commands;

import pe.edu.upc.center.platform.reservation.domain.model.valueobjects.ReservationStatus;

public class UpdateReservationStatusCommand {
    private Long reservationId;
    private ReservationStatus status;

    public UpdateReservationStatusCommand(Long reservationId, ReservationStatus status) {
        this.reservationId = reservationId;
        this.status = status;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public ReservationStatus getStatus() {
        return status;
    }
}
