package pe.edu.upc.center.platform.payment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record CardNumber(String number) {
    public CardNumber{
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Card number cannot be null or blank");
        }
        if (!number.matches("\\d{16}")) {
            throw new IllegalArgumentException("Card number must be 16 digits long");
        }
    }
}
