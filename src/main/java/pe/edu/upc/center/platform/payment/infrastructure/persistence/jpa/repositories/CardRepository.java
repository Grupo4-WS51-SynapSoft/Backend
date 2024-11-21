package pe.edu.upc.center.platform.payment.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.center.platform.payment.domain.model.aggregates.Card;
import pe.edu.upc.center.platform.payment.domain.model.valueobjects.CardNumber;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    boolean existsByCardNumber(CardNumber cardNumber);
    boolean existsByCardNumberAndIdIsNot(CardNumber  cardNumber, Long id);
    Optional<Card> findByCardNumber(CardNumber  cardNumber);
}
