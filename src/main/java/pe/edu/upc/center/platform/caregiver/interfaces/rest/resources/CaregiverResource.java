package pe.edu.upc.center.platform.caregiver.interfaces.rest.resources;

public record CaregiverResource(Long id, String completeName, Integer age, String address, Integer caregiverExperience,
                                Integer completedServices, String biography, String profileImage, Double farePerHour,
                                String districtsScope) {
}
