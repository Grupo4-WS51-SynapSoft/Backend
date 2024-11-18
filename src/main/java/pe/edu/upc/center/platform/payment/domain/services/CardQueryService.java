package pe.edu.upc.center.platform.payment.domain.services;

import pe.edu.upc.center.platform.payment.domain.model.aggregates.Card;
import pe.edu.upc.center.platform.payment.domain.model.queries.GetAllCardsQuery;
import pe.edu.upc.center.platform.payment.domain.model.queries.GetCardByCardNumberQuery;
import pe.edu.upc.center.platform.payment.domain.model.queries.GetCardByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CardQueryService {
    List<Card> handle(GetAllCardsQuery query);
    Optional<Card> handle(GetCardByCardNumberQuery query);
    Optional<Card> handle(GetCardByIdQuery query);
}
