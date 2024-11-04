package pe.edu.upc.center.platform.payment.interfaces.rest.transform;

import pe.edu.upc.center.platform.payment.domain.model.commands.UpdateCardCommand;
import pe.edu.upc.center.platform.payment.interfaces.rest.resources.CardResource;


public class UpdateCardCommandFromResourceAssembler {
    public static UpdateCardCommand toCommandFromResource(Long cardId, CardResource resource) {
        return new UpdateCardCommand(cardId, resource.number(),resource.holder(),resource.year(),resource.month(),resource.code());
    }
}
