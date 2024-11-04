package pe.edu.upc.center.platform.caregiver.interfaces.rest.resources;

public record UpdateCaregiverScheduleResource(Long caregiverScheduleId, String weekDay, String startHour, String endHour) {
}
