package pe.edu.upc.center.platform.payment.domain.services;

import pe.edu.upc.center.platform.payment.domain.model.commands.CreateCardCommand;
import pe.edu.upc.center.platform.payment.domain.model.commands.DeleteCardCommand;
import pe.edu.upc.center.platform.payment.domain.model.commands.UpdateCardCommand;
import pe.edu.upc.center.platform.payment.domain.model.entities.Card;


import java.util.Optional;

public interface CardCommandService {
    Long handle(CreateCardCommand command);
    Optional<Card> handle(UpdateCardCommand command);
    void handle(DeleteCardCommand command);
}

