package pe.edu.upc.center.platform.caregiver.interfaces.rest.transform;

import pe.edu.upc.center.platform.caregiver.domain.model.commands.CreateCaregiverScheduleCommand;
import pe.edu.upc.center.platform.caregiver.interfaces.rest.resources.CreateCaregiverScheduleResource;

public class CreateCaregiverScheduleCommandFromResourceAssembler {
    public static CreateCaregiverScheduleCommand toCommandFromResource(CreateCaregiverScheduleResource resource) {
        return new CreateCaregiverScheduleCommand(resource.caregiverId(), resource.weekDay(), resource.startHour(), resource.endHour());
    }
}