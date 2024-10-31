package pe.edu.upc.center.platform.reservation.domain.model.commands;

import java.time.LocalDateTime;

public class CreateReservationCommand {
    private Long userId;
    private Long caregiverId;
    private LocalDateTime scheduledAt;
    private Double totalFare;

    public CreateReservationCommand(Long userId, Long caregiverId, LocalDateTime scheduledAt, Double totalFare) {
        this.userId = userId;
        this.caregiverId = caregiverId;
        this.scheduledAt = scheduledAt;
        this.totalFare = totalFare;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCaregiverId() {
        return caregiverId;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public Double getTotalFare() {
        return totalFare;
    }
}