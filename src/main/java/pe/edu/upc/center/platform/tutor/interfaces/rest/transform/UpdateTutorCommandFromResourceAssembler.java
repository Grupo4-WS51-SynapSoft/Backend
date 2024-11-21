package pe.edu.upc.center.platform.tutor.interfaces.rest.transform;

import pe.edu.upc.center.platform.tutor.domain.model.commands.UpdateTutorCommand;
import pe.edu.upc.center.platform.tutor.interfaces.rest.resources.TutorResource;

public class UpdateTutorCommandFromResourceAssembler {
    public static UpdateTutorCommand toCommandFromResource(Long profileId, TutorResource resource) {
        return new UpdateTutorCommand(profileId, resource.fullName(), resource.email(), resource.doc(), resource.password(),resource.number(), resource.street(), resource.district(),resource.role());
    }
}
