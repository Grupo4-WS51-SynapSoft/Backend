package pe.edu.upc.center.platform.tutor.interfaces.rest.transform;

import pe.edu.upc.center.platform.tutor.domain.model.commands.CreateTutorCommand;
import pe.edu.upc.center.platform.tutor.interfaces.rest.resources.CreateTutorResource;

public class CreateTutorCommandFromResourceAssembler {
    public static CreateTutorCommand toCommandFromResource(CreateTutorResource resource) {
        return new CreateTutorCommand(resource.fullName(), resource.email(), resource.doc(), resource.password(),resource.number(), resource.street(), resource.district(),resource.role());
    }
}
