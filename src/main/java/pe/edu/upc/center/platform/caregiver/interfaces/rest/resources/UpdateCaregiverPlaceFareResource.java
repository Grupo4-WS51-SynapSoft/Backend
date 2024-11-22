package pe.edu.upc.center.platform.caregiver.interfaces.rest.resources;

public record UpdateCaregiverPlaceFareResource(Long caregiverId, Double farePerHour, String districtsScope) {
}

