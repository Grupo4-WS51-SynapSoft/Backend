package pe.edu.upc.center.platform.payment.interfaces.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.center.platform.payment.domain.model.commands.DeleteCardCommand;
import pe.edu.upc.center.platform.payment.domain.model.queries.GetAllCardsQuery;
import pe.edu.upc.center.platform.payment.domain.model.queries.GetCardByIdQuery;
import pe.edu.upc.center.platform.payment.domain.services.CardCommandService;
import pe.edu.upc.center.platform.payment.domain.services.CardQueryService;
import pe.edu.upc.center.platform.payment.interfaces.rest.resources.CardResource;
import pe.edu.upc.center.platform.payment.interfaces.rest.resources.CreateCardResource;
import pe.edu.upc.center.platform.payment.interfaces.rest.transform.CardResourceFromEntityAssembler;
import pe.edu.upc.center.platform.payment.interfaces.rest.transform.CreateCardCommandFromResourceAssembler;
import pe.edu.upc.center.platform.payment.interfaces.rest.transform.UpdateCardCommandFromResourceAssembler;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/api/v1/cards", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardsController {

    private final CardQueryService cardQueryService;
    private final CardCommandService cardCommandService;


    public CardsController(CardQueryService cardQueryService, CardCommandService cardCommandService) {
        this.cardQueryService = cardQueryService;
        this.cardCommandService = cardCommandService;
    }

    @PostMapping
    public ResponseEntity<CardResource> createCard(@RequestBody CreateCardResource resource) {
        var createCardCommand = CreateCardCommandFromResourceAssembler.toCommandFromResource(resource);
        var cardId=this.cardCommandService.handle(createCardCommand);

        if(cardId.equals(0L)){
            return ResponseEntity.badRequest().build();
        }

        var getCardByIdQuery = new GetCardByIdQuery(cardId);
        var optionalCard = this.cardQueryService.handle(getCardByIdQuery);

        var cardResource = CardResourceFromEntityAssembler.toResourceFromEntity(optionalCard.get());
        return new ResponseEntity<>(cardResource, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<CardResource>> getAllCards() {
        var getAllCardsQuery = new GetAllCardsQuery();
        var cards = this.cardQueryService.handle(getAllCardsQuery);
        var cardResources = cards.stream().map(CardResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cardResources);
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<CardResource> getCardById(@PathVariable Long cardId) {
        var getCardByIdQuery = new GetCardByIdQuery(cardId);
        var optionalCard = this.cardQueryService.handle(getCardByIdQuery);
        if(optionalCard.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var cardResource = CardResourceFromEntityAssembler.toResourceFromEntity(optionalCard.get());
        return ResponseEntity.ok(cardResource);
    }

    @PutMapping("/{cardId}")
    public  ResponseEntity<CardResource> updateCard(@PathVariable Long cardId, @RequestBody CardResource resource) {
        var updateCardCommand = UpdateCardCommandFromResourceAssembler.toCommandFromResource(cardId,resource);
        var optionalCard = this.cardCommandService.handle(updateCardCommand);

        if(optionalCard.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var cardResource = CardResourceFromEntityAssembler.toResourceFromEntity(optionalCard.get());
        return ResponseEntity.ok(cardResource);

    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<?> deleteCard(@PathVariable Long cardId) {
        var deleteCardCommand= new DeleteCardCommand(cardId);
        this.cardCommandService.handle(deleteCardCommand);
        return ResponseEntity.noContent().build();
    }

}