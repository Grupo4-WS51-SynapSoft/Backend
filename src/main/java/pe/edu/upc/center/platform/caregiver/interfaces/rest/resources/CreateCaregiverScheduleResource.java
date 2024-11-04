package pe.edu.upc.center.platform.caregiver.interfaces.rest.resources;

public record CreateCaregiverScheduleResource(Long caregiverId, String weekDay, String startHour,String endHour) {
}
