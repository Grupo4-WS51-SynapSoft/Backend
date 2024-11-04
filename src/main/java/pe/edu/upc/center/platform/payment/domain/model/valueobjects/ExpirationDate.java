package pe.edu.upc.center.platform.payment.domain.model.valueobjects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import pe.edu.upc.center.platform.payment.infrastructure.serialization.YearMonthDeserializer;
import pe.edu.upc.center.platform.payment.infrastructure.serialization.YearMonthSerializer;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public record ExpirationDate(int year, int month) {

    public ExpirationDate {
        if (year < 1900 || year > 2100) {
            throw new IllegalArgumentException("Year must be between 1900 and 2100");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
    }
}

