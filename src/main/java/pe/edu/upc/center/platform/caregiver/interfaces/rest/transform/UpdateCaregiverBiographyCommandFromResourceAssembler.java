package pe.edu.upc.center.platform.caregiver.interfaces.rest.transform;

import pe.edu.upc.center.platform.caregiver.domain.model.commands.UpdateCaregiverBiographyCommand;
import pe.edu.upc.center.platform.caregiver.interfaces.rest.resources.UpdateCaregiverBiographyResource;

public class UpdateCaregiverBiographyCommandFromResourceAssembler {
    public static UpdateCaregiverBiographyCommand toCommandFromResource(UpdateCaregiverBiographyResource resource) {
        return new UpdateCaregiverBiographyCommand(resource.caregiverId(), resource.biography());
    }
}
