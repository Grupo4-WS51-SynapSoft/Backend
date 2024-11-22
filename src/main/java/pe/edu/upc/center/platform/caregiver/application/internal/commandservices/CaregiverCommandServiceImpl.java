package pe.edu.upc.center.platform.caregiver.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;
import pe.edu.upc.center.platform.caregiver.domain.model.commands.*;
import pe.edu.upc.center.platform.caregiver.domain.model.entities.CaregiverSchedule;
import pe.edu.upc.center.platform.caregiver.domain.services.CaregiverCommandService;
import pe.edu.upc.center.platform.caregiver.infrastructure.persistence.jpa.repositories.CaregiverRepository;
import pe.edu.upc.center.platform.caregiver.infrastructure.persistence.jpa.repositories.CaregiverScheduleRepository;

import java.util.Optional;

@Service
public class CaregiverCommandServiceImpl implements CaregiverCommandService {

    private final CaregiverRepository caregiverRepository;
    private final CaregiverScheduleRepository caregiverScheduleRepository;

    public CaregiverCommandServiceImpl(CaregiverRepository caregiverRepository, CaregiverScheduleRepository caregiverScheduleRepository) {
        this.caregiverRepository = caregiverRepository;
        this.caregiverScheduleRepository = caregiverScheduleRepository;
    }

    @Override
    public Caregiver handle(CreateCaregiverCommand command) {
        var caregiver = new Caregiver(command);
        return this.caregiverRepository.save(caregiver);
    }

    @Override
    public CaregiverSchedule handle(CreateCaregiverScheduleCommand command) {
        Caregiver caregiver = this.caregiverRepository.findById(command.caregiverId())
                .orElseThrow(() -> new IllegalArgumentException("Caregiver not found"));

        var caregiverSchedule = new CaregiverSchedule(command, caregiver);

        return this.caregiverScheduleRepository.save(caregiverSchedule);
    }

    @Override
    public Optional<Caregiver> handle(UpdateCaregiverBiographyCommand command) {
        var optionalCaregiver = this.caregiverRepository.findById(command.caregiverId());
        if (optionalCaregiver.isEmpty()) {
            throw new IllegalArgumentException("Caregiver not found");
        }

        optionalCaregiver = optionalCaregiver.map(caregiver -> {
            caregiver.setBiography(command.biography());
            return caregiver;
        });

        this.caregiverRepository.save(optionalCaregiver.get());

        return optionalCaregiver;
    }

    @Override
    public Optional<Caregiver> handle(UpdateCaregiverPlaceFareCommand command) {
        var optionalCaregiver = this.caregiverRepository.findById(command.caregiverId());
        if (optionalCaregiver.isEmpty()) {
            throw new IllegalArgumentException("Caregiver not found");
        }

        optionalCaregiver = optionalCaregiver.map(caregiver -> {
            caregiver.setDistrictsScope(command.districtsScope());
            caregiver.setFarePerHour(command.farePerHour());
            return caregiver;
        });

        this.caregiverRepository.save(optionalCaregiver.get());

        return optionalCaregiver;
    }

    @Override
    public Optional<CaregiverSchedule> handle(UpdateCaregiverScheduleCommand command) {
        var optionalCaregiverSchedule = this.caregiverScheduleRepository.findById(command.caregiverScheduleId());
        if (optionalCaregiverSchedule.isEmpty()) {
            throw new IllegalArgumentException("Caregiver Schedule not found");
        }

        optionalCaregiverSchedule = optionalCaregiverSchedule.map(caregiverSchedule -> {
            caregiverSchedule.setEndHour(command.endHour());
            caregiverSchedule.setStartHour(command.startHour());
            caregiverSchedule.setWeekDay(command.weekDay());
            return caregiverSchedule;
        });

        this.caregiverScheduleRepository.save(optionalCaregiverSchedule.get());

        return optionalCaregiverSchedule;
    }

    @Override
    public void handle(DeleteCaregiverScheduleCommand command) {
        if (!this.caregiverScheduleRepository.existsById(command.caregiverScheduleId())) {
            throw new IllegalArgumentException("Caregiver Schedule with id " + command.caregiverScheduleId() + " does not exist");
        }

        try {
            this.caregiverScheduleRepository.deleteById(command.caregiverScheduleId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting caregiver schedule: " + e.getMessage());
        }
    }
}