package pe.edu.upc.center.platform.caregiver.domain.model.commands;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

public record UpdateCaregiverPlaceFareCommand(Long caregiverId, Double farePerHour, String districtsScope) {
}
