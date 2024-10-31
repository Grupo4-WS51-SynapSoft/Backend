package pe.edu.upc.center.platform.reservation.domain.model.queries;

import lombok.Getter;

@Getter
public class GetReservationsByUserQuery {
    private Long userId;

    public GetReservationsByUserQuery(Long userId) {
        this.userId = userId;
    }

}