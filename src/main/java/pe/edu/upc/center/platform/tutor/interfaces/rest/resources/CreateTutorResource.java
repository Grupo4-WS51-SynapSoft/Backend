package pe.edu.upc.center.platform.tutor.interfaces.rest.resources;

public record CreateTutorResource(String fullName, String email, String doc, String password, String number, String street,String district, String role)  {

}
