package pe.edu.upc.center.platform.caregiver.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;
import pe.edu.upc.center.platform.caregiver.domain.model.entities.CaregiverSchedule;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaregiverScheduleRepository extends JpaRepository<CaregiverSchedule, Long> {
    List<CaregiverSchedule> findByCaregiver(Caregiver caregiver);

}
