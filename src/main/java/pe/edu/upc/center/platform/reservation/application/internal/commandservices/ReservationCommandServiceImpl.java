package pe.edu.upc.center.platform.reservation.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.reservation.domain.model.commands.CancelReservationCommand;
import pe.edu.upc.center.platform.reservation.domain.model.commands.CreateReservationCommand;
import pe.edu.upc.center.platform.reservation.domain.model.entities.Reservation;
import pe.edu.upc.center.platform.reservation.domain.services.ReservationCommandService;
import pe.edu.upc.center.platform.reservation.infrastructure.persistence.jpa.repositories.ReservationRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ReservationCommandServiceImpl implements ReservationCommandService {
    private final ReservationRepository reservationRepository;

    public ReservationCommandServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Long handle(CreateReservationCommand command) {
        Reservation reservation = new Reservation(
                command.getUserId(),
                command.getCaregiverId(),
                convertToDate(command.getScheduledAt()),  // Conversión de LocalDateTime a Date
                command.getTotalFare()
        );

        reservationRepository.save(reservation);
        return reservation.getId();
    }

    @Override
    public void handle(CancelReservationCommand command) {
        reservationRepository.deleteById(command.getReservationId());
    }

    private Date convertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
