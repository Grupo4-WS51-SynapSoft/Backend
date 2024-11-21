package pe.edu.upc.center.platform.caregiver.interfaces.rest.transform;

import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;
import pe.edu.upc.center.platform.caregiver.domain.model.entities.CaregiverSchedule;
import pe.edu.upc.center.platform.caregiver.interfaces.rest.resources.CaregiverResource;
import pe.edu.upc.center.platform.caregiver.interfaces.rest.resources.CaregiverScheduleResource;

public class CaregiverScheduleResourceFromEntityAssembler {
    public static CaregiverScheduleResource toResourceFromEntity(CaregiverSchedule entity) {
        return new CaregiverScheduleResource(entity.getId(), entity.getWeekDay(), entity.getStartHour(), entity.getEndHour());
    }
}
