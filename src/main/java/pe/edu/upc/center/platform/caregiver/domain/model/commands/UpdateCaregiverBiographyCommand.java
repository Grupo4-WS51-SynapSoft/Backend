package pe.edu.upc.center.platform.caregiver.domain.model.commands;

public record UpdateCaregiverBiographyCommand(Long caregiverId, String biography) {
}
