package pe.edu.upc.center.platform.payment.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.payment.domain.model.aggregates.Card;
import pe.edu.upc.center.platform.payment.domain.model.queries.GetAllCardsQuery;
import pe.edu.upc.center.platform.payment.domain.model.queries.GetCardByCardNumberQuery;
import pe.edu.upc.center.platform.payment.domain.model.queries.GetCardByIdQuery;
import pe.edu.upc.center.platform.payment.domain.model.queries.GetCardByUserId;
import pe.edu.upc.center.platform.payment.domain.services.CardQueryService;
import pe.edu.upc.center.platform.payment.infrastructure.persistence.jpa.repositories.CardRepository;
import pe.edu.upc.center.platform.tutor.domain.model.queries.GetTutorByIdQuery;

import java.util.List;
import java.util.Optional;

@Service
public class CardQueryServiceImpl implements CardQueryService {

    private final CardRepository cardRepository;

    public CardQueryServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> handle(GetAllCardsQuery query) {
        return this.cardRepository.findAll();
    }

    @Override
    public Optional<Card> handle(GetCardByCardNumberQuery query) {
        return this.cardRepository.findByCardNumber(query.cardNumber());
    }

    @Override
    public Optional<Card> handle(GetCardByIdQuery query) {
        return this.cardRepository.findById(query.cardId());
    }

    @Override
    public Optional<List<Card>> handle(GetCardByUserId query) {
        return this.cardRepository.getAllByUserId(query.userId());
    }


}
