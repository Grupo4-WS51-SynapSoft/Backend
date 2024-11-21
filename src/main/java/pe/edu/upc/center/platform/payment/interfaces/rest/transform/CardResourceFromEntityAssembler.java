package pe.edu.upc.center.platform.payment.interfaces.rest.transform;

import pe.edu.upc.center.platform.payment.domain.model.aggregates.Card;
import pe.edu.upc.center.platform.payment.interfaces.rest.resources.CardResource;

public class CardResourceFromEntityAssembler {
    public static CardResource toResourceFromEntity(Card entity) {
        return  new CardResource(entity.getId(),entity.getCardNumber(),entity.getCardHolder(),entity.getExpirationYear(),entity.getExpirationMonth(),entity.getCvv());
    }
}
