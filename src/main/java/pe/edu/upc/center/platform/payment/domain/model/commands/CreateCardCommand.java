package pe.edu.upc.center.platform.payment.domain.model.commands;

import java.time.YearMonth;

public record CreateCardCommand(String number, String holder, int year,int month, String code) {
}
