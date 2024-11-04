package pe.edu.upc.center.platform.reservation.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.center.platform.reservation.domain.model.valueobjects.ReservationStatus;
import pe.edu.upc.center.platform.shared.domain.model.entities.AuditableModel;

import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "reservations")
public class Reservation extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long caregiverId;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String startTime;

    @Column(nullable = false)
    private String endTime;

    @Column(nullable = false)
    private Long paymentMethodId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status = ReservationStatus.PENDING;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private Date updatedAt;

    public Reservation() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Reservation(Long caregiverId, String date, String startTime, String endTime, Long paymentMethodId) {
        this.caregiverId = caregiverId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.paymentMethodId = paymentMethodId;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public void update() {
        this.updatedAt = new Date();
    }

    public void cancel() {
        this.status = ReservationStatus.CANCELLED;
        this.update();
    }

    public void complete() {
        this.status = ReservationStatus.COMPLETED;
        this.update();
    }
}
