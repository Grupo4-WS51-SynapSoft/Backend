package pe.edu.upc.center.platform.payment.interfaces.rest.resources;

import java.time.YearMonth;

public record CardResource(Long Id, String number, String holder, int year, int month, String code) {
}
