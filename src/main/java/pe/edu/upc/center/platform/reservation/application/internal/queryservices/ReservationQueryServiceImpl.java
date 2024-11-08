package pe.edu.upc.center.platform.reservation.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.reservation.domain.model.entities.Reservation;
import pe.edu.upc.center.platform.reservation.domain.model.queries.GetAllReservationsQuery;
import pe.edu.upc.center.platform.reservation.domain.services.ReservationQueryService;
import pe.edu.upc.center.platform.reservation.infrastructure.persistence.jpa.repositories.ReservationRepository;
import pe.edu.upc.center.platform.reservation.domain.model.queries.GetReservationDetailsQuery;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationQueryServiceImpl implements ReservationQueryService {
    private final ReservationRepository reservationRepository;

    public ReservationQueryServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Optional<Reservation> handle(GetReservationDetailsQuery query) {
        return reservationRepository.findById(query.getReservationId());
    }

    @Override
    public List<Reservation> handle(GetAllReservationsQuery query) {
        return reservationRepository.findAll();
    }
}
