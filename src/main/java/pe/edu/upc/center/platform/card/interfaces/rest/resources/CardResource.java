package pe.edu.upc.center.platform.card.interfaces.rest.resources;

public record CardResource(Long Id, String number, String holder, int year, int month, String code) {
}