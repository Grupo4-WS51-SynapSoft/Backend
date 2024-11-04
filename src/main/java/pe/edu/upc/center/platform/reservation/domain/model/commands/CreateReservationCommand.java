package pe.edu.upc.center.platform.reservation.domain.model.commands;


public class CreateReservationCommand {
    private Long caregiverId;
    private String date;
    private String startTime;
    private String endTime;
    private Long paymentMethodId;

    public CreateReservationCommand(Long caregiverId, String date, String startTime, String endTime, Long paymentMethodId) {
        this.caregiverId = caregiverId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.paymentMethodId = paymentMethodId;
    }

    public Long getCaregiverId() {
        return caregiverId;
    }

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }
}
