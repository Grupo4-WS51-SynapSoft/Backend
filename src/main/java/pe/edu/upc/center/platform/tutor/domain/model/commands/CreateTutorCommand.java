package pe.edu.upc.center.platform.tutor.domain.model.commands;

public record CreateTutorCommand(String fullName, String email, String doc, String password, String number, String street,String district, String role) {
}
