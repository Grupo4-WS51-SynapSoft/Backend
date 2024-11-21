package pe.edu.upc.center.platform.card.interfaces.rest.resources;


public record CreateCardResource(Long userId, String number, String holder, int year, int month, String code) {
}
