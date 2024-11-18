package pe.edu.upc.center.platform.reservation.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.center.platform.payment.domain.model.aggregates.Card;
import pe.edu.upc.center.platform.reservation.domain.model.valueobjects.ReservationStatus;
import pe.edu.upc.center.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.edu.upc.center.platform.shared.domain.model.entities.AuditableModel;

import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "reservations")
public class Reservation extends AuditableAbstractAggregateRoot<Reservation> {

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


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status = ReservationStatus.PENDING;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false)
    private Card paymentCard;

    public Reservation() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Reservation(Long caregiverId, String date, String startTime, String endTime, Card paymentCard) {
        this.caregiverId = caregiverId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.paymentCard = paymentCard;
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
