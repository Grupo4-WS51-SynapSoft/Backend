package pe.edu.upc.center.platform.caregiver.domain.services;

import org.springframework.scheduling.annotation.Scheduled;
import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;
import pe.edu.upc.center.platform.caregiver.domain.model.commands.*;
import pe.edu.upc.center.platform.caregiver.domain.model.entities.CaregiverSchedule;

import java.util.Optional;

public interface CaregiverCommandService {
    Caregiver handle(CreateCaregiverCommand command);

    CaregiverSchedule handle(CreateCaregiverScheduleCommand command);

    Optional<Caregiver> handle(UpdateCaregiverBiographyCommand command);

    Optional<Caregiver> handle(UpdateCaregiverPlaceFareCommand command);

    Optional<CaregiverSchedule> handle(UpdateCaregiverScheduleCommand command);
}