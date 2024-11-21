package pe.edu.upc.center.platform.card.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.center.platform.reservation.domain.model.entities.Reservation;
import pe.edu.upc.center.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
@Table(name = "payment")
public class Payment extends AuditableAbstractAggregateRoot<Payment> {
    @Column(nullable = false)
    private Long userId;

    @OneToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;


    public Payment() {
    }


}
