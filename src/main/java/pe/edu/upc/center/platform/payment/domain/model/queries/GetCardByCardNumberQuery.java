package pe.edu.upc.center.platform.payment.domain.model.queries;

import pe.edu.upc.center.platform.payment.domain.model.valueobjects.CardNumber;

public record GetCardByCardNumberQuery(CardNumber cardNumber) {
}
