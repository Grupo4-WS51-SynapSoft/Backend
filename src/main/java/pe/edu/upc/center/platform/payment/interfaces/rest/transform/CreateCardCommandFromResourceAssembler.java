package pe.edu.upc.center.platform.payment.interfaces.rest.transform;

import pe.edu.upc.center.platform.payment.domain.model.commands.CreateCardCommand;
import pe.edu.upc.center.platform.payment.domain.model.valueobjects.CardNumber;
import pe.edu.upc.center.platform.payment.interfaces.rest.resources.CreateCardResource;

public class CreateCardCommandFromResourceAssembler {
    public static CreateCardCommand toCommandFromResource(CreateCardResource resource) {
        return new CreateCardCommand(resource.number(),resource.holder(),resource.year(),resource.month(),resource.code());
    }
}

