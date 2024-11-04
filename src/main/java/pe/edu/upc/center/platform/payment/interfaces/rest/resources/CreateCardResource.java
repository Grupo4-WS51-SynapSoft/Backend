package pe.edu.upc.center.platform.payment.interfaces.rest.resources;


public record CreateCardResource(String number, String holder, int year, int month, String code) {
}
