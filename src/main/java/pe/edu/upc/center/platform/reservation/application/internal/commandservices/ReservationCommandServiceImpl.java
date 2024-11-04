package pe.edu.upc.center.platform.reservation.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.reservation.domain.model.commands.CreateReservationCommand;
import pe.edu.upc.center.platform.reservation.domain.model.commands.UpdateReservationStatusCommand;
import pe.edu.upc.center.platform.reservation.domain.model.entities.Reservation;
import pe.edu.upc.center.platform.reservation.infrastructure.persistence.jpa.repositories.ReservationRepository;


@Service
public class ReservationCommandServiceImpl {
    private final ReservationRepository reservationRepository;

    public ReservationCommandServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Long handle(CreateReservationCommand command) {
        Reservation reservation = new Reservation(
                command.getCaregiverId(),
                command.getDate(),
                command.getStartTime(),
                command.getEndTime(),
                command.getPaymentMethodId()
        );
        reservationRepository.save(reservation);
        return reservation.getId();
    }

    public void handle(UpdateReservationStatusCommand command) {
        Reservation reservation = reservationRepository.findById(command.getReservationId())
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
        reservation.setStatus(command.getStatus());
        reservation.update();
        reservationRepository.save(reservation);
    }

    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }
}
