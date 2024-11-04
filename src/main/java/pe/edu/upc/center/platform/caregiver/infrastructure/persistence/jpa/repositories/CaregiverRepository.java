package pe.edu.upc.center.platform.caregiver.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;

import java.util.List;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Long> {
    @Query("SELECT c FROM Caregiver c WHERE LOWER(c.districtsScope) LIKE LOWER(CONCAT('%', :district, '%'))")
    List<Caregiver> findByDistrictScope(String district);
}
