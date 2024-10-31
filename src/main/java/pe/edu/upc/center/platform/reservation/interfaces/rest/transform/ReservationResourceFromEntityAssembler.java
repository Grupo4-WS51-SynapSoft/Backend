package pe.edu.upc.center.platform.reservation.interfaces.rest.transform;

import pe.edu.upc.center.platform.reservation.domain.model.entities.Reservation;
import pe.edu.upc.center.platform.reservation.interfaces.rest.resources.ReservationResource;

public class ReservationResourceFromEntityAssembler {

    public static ReservationResource toResourceFromEntity(Reservation entity) {
        return new ReservationResource(
                entity.getId(),
                entity.getUserId(),
                entity.getCaregiverId(),
                entity.getStatus().name(),
                entity.getTotalFare()
        );
    }
}