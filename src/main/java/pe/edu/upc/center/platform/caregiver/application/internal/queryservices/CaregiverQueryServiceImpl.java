package pe.edu.upc.center.platform.caregiver.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;
import pe.edu.upc.center.platform.caregiver.domain.model.entities.CaregiverSchedule;
import pe.edu.upc.center.platform.caregiver.domain.model.queries.GetAllCaregiverScheduleByCaregiverIdQuery;
import pe.edu.upc.center.platform.caregiver.domain.model.queries.GetCaregiverByIdQuery;
import pe.edu.upc.center.platform.caregiver.domain.model.queries.GetCaregiverByLocationQuery;
import pe.edu.upc.center.platform.caregiver.domain.services.CaregiverQueryService;
import pe.edu.upc.center.platform.caregiver.infrastructure.persistence.jpa.repositories.CaregiverRepository;
import pe.edu.upc.center.platform.caregiver.infrastructure.persistence.jpa.repositories.CaregiverScheduleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CaregiverQueryServiceImpl implements CaregiverQueryService {

    private final CaregiverRepository caregiverRepository;
    private final CaregiverScheduleRepository caregiverScheduleRepository;

    public CaregiverQueryServiceImpl(CaregiverRepository caregiverRepository, CaregiverScheduleRepository caregiverScheduleRepository) {
        this.caregiverRepository = caregiverRepository;
        this.caregiverScheduleRepository = caregiverScheduleRepository;
    }

    @Override
    public List<CaregiverSchedule> handle(GetAllCaregiverScheduleByCaregiverIdQuery query) {

        Caregiver caregiver = this.caregiverRepository.findById(query.caregiverId())
                .orElseThrow(() -> new IllegalArgumentException("Caregiver not found"));

        return caregiverScheduleRepository.findByCaregiver(caregiver);
    }

    @Override
    public Optional<Caregiver> handle(GetCaregiverByIdQuery query) {
        return caregiverRepository.findById(query.caregiverId());
    }

    @Override
    public List<Caregiver> handle(GetCaregiverByLocationQuery query) {
        return caregiverRepository.findByDistrictScope(query.district());
    }
}
