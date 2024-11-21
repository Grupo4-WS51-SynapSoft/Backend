package pe.edu.upc.center.platform.caregiver.interfaces.acl;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;
import pe.edu.upc.center.platform.caregiver.domain.model.queries.GetCaregiverByIdQuery;
import pe.edu.upc.center.platform.caregiver.domain.services.CaregiverCommandService;
import pe.edu.upc.center.platform.caregiver.domain.services.CaregiverQueryService;
import pe.edu.upc.center.platform.caregiver.interfaces.rest.resources.CaregiverResource;
import pe.edu.upc.center.platform.caregiver.interfaces.rest.transform.CaregiverResourceFromEntityAssembler;

import java.util.Optional;

@Service
public class CaregiverContextFacade {
    private final CaregiverCommandService caregiverCommandService;
    private final CaregiverQueryService caregiverQueryService;


    public CaregiverContextFacade(CaregiverCommandService caregiverCommandService, CaregiverQueryService caregiverQueryService) {
        this.caregiverCommandService = caregiverCommandService;
        this.caregiverQueryService = caregiverQueryService;
    }

    public Optional<Caregiver> fetchCaregiverById(Long caregiverId) {
        var getCaregiverByIdQuery = new GetCaregiverByIdQuery(caregiverId);
        return caregiverQueryService.handle(getCaregiverByIdQuery);
    }
}
