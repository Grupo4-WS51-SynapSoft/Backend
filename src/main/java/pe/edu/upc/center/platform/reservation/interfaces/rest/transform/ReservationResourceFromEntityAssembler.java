package pe.edu.upc.center.platform.reservation.interfaces.rest.transform;

import pe.edu.upc.center.platform.reservation.domain.model.aggregates.Reservation;
import pe.edu.upc.center.platform.reservation.interfaces.rest.resources.ReservationResource;

import java.text.SimpleDateFormat;

public class ReservationResourceFromEntityAssembler {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static ReservationResource toResourceFromEntity(Reservation entity) {
        return new ReservationResource(
                entity.getId(),
                entity.getCaregiver(),
                entity.getTutorId(),
                entity.getDate(),
                entity.getStartTime(),
                entity.getEndTime(),
                entity.getStatus().name(),
                entity.getTotalAmount()
        );
    }
}