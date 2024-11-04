package pe.edu.upc.center.platform.payment.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.payment.domain.model.commands.CreateCardCommand;
import pe.edu.upc.center.platform.payment.domain.model.commands.DeleteCardCommand;
import pe.edu.upc.center.platform.payment.domain.model.commands.UpdateCardCommand;
import pe.edu.upc.center.platform.payment.domain.model.entities.Card;
import pe.edu.upc.center.platform.payment.domain.model.valueobjects.CardNumber;
import pe.edu.upc.center.platform.payment.domain.services.CardCommandService;
import pe.edu.upc.center.platform.payment.infrastructure.persistence.jpa.repositories.CardRepository;

import java.util.Optional;

@Service
public class CardCommandServiceImpl implements CardCommandService {

    private final CardRepository cardRepository;

    public CardCommandServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Long handle(CreateCardCommand command) {
        CardNumber cardNumber = new CardNumber(command.number());
        if(this.cardRepository.existsByCardNumber(cardNumber)){
            throw new IllegalArgumentException("Card number"+cardNumber+" already exists");
        }
        var card = new Card(command);
        try {
            this.cardRepository.save(card);
        }catch (Exception e){
            throw new IllegalArgumentException("Error while saving card: "+e.getMessage());
        }
        return card.getId();
    }

    @Override
    public Optional<Card> handle(UpdateCardCommand command) {
        var cardId= command.cardId();
        CardNumber cardNumber=  new CardNumber(command.number());
        if(this.cardRepository.existsByCardNumberAndIdIsNot(cardNumber, cardId)){
            throw new IllegalArgumentException("Card number "+cardNumber+" already exists");
        }

        if(!this.cardRepository.existsById(cardId)){
            throw new IllegalArgumentException("Card with id "+cardId+" does not exist");
        }

        var cardToUpdate=this.cardRepository.findById(cardId).get();
        cardToUpdate.updateInformation(command);

        try {
            var updatedCard = this.cardRepository.save(cardToUpdate);
            return Optional.of(updatedCard);
        }catch (Exception e){
            throw new IllegalArgumentException("Error while saving card: "+e.getMessage());
        }
    }

    @Override
    public void handle(DeleteCardCommand command) {
        if(!this.cardRepository.existsById(command.cardId())){
            throw new IllegalArgumentException("Card with id "+command.cardId()+" does not exist");
        }

        try {
            this.cardRepository.deleteById(command.cardId());
        }catch (Exception e){
            throw new IllegalArgumentException("Error while deleting card: "+e.getMessage());
        }
    }
}
