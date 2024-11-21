package pe.edu.upc.center.platform.reservation.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;
import pe.edu.upc.center.platform.reservation.domain.model.commands.CreateReservationCommand;
import pe.edu.upc.center.platform.reservation.domain.model.valueobjects.ReservationStatus;
import pe.edu.upc.center.platform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.center.platform.tutor.domain.model.aggregates.Tutor;

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

    @ManyToOne
    @JoinColumn(name = "caregiver_id", nullable = false)
    private Caregiver caregiver;

    @Column(nullable = false)
    private Long tutorId;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String startTime;

    @Column(nullable = false)
    private String endTime;

    @Column(nullable = false)
    private double totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status = ReservationStatus.PENDING;

    public Reservation(CreateReservationCommand command, Caregiver caregiver) {
        this.caregiver = caregiver;
        this.tutorId = command.tutorId();
        this.date = command.date();
        this.startTime = command.startTime();
        this.endTime = command.endTime();
        this.totalAmount = command.totalAmount();
    }

    public Reservation() {}
}
