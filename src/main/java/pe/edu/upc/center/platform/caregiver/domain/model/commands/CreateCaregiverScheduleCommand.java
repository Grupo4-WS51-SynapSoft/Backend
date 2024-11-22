package pe.edu.upc.center.platform.caregiver.domain.model.commands;

public record CreateCaregiverScheduleCommand(Long caregiverId, String weekDay, String startHour,String endHour) {
}

