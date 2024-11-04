package pe.edu.upc.center.platform.caregiver.interfaces.rest.transform;

import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;
import pe.edu.upc.center.platform.caregiver.interfaces.rest.resources.CaregiverResource;

public class CaregiverResourceFromEntityAssembler {
    public static CaregiverResource toResourceFromEntity(Caregiver entity) {
        return new CaregiverResource(entity.getId(), entity.getCompleteName(), entity.getAge(), entity.getAddress(), entity.getCaregiverExperience(),
                entity.getCompletedServices(), entity.getBiography(), entity.getProfileImage(), entity.getFarePerHour(),
                entity.getDistrictsScope());
    }
}