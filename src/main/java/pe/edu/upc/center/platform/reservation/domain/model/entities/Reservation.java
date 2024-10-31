package pe.edu.upc.center.platform.reservation.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.center.platform.reservation.domain.model.enums.ReservationStatus;
import pe.edu.upc.center.platform.shared.domain.model.entities.AuditableModel;

import java.time.LocalDateTime;
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
    private Long userId;

    @Column(nullable = false)
    private Long caregiverId;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private Date updatedAt;  // Asegúrate de que esto no sea nulo

    @Column(nullable = false)
    private Date scheduledAt;

    @Column(nullable = false)
    private Double totalFare;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status;

    public Reservation() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.status = ReservationStatus.PENDING;
    }

    public Reservation(Long userId, Long caregiverId, Date scheduledAt, Double totalFare) {
        this.userId = userId;
        this.caregiverId = caregiverId;
        this.scheduledAt = scheduledAt;
        this.totalFare = totalFare;
        this.createdAt = new Date();
        this.updatedAt = new Date();  // Inicializa updatedAt con la fecha actual
        this.status = ReservationStatus.PENDING;
    }

    public void update() {
        this.updatedAt = new Date();  // Actualiza updatedAt al actualizar la reserva
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