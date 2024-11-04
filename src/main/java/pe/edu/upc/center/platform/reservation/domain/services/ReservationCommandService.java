package pe.edu.upc.center.platform.reservation.domain.services;

import pe.edu.upc.center.platform.reservation.domain.model.commands.CancelReservationCommand;
import pe.edu.upc.center.platform.reservation.domain.model.commands.CreateReservationCommand;

public interface ReservationCommandService {
    Long handle(CreateReservationCommand command);
}