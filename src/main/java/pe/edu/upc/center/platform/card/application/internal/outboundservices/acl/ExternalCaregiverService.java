package pe.edu.upc.center.platform.card.application.internal.outboundservices.acl;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;
import pe.edu.upc.center.platform.caregiver.interfaces.acl.CaregiverContextFacade;
import pe.edu.upc.center.platform.caregiver.interfaces.rest.resources.CaregiverResource;

import java.util.Optional;

@Service("externalcaregiverservicefrompayment")
public class ExternalCaregiverService {
    private final CaregiverContextFacade caregiverContextFacade;


    public ExternalCaregiverService(CaregiverContextFacade caregiverContextFacade) {
        this.caregiverContextFacade = caregiverContextFacade;
    }

    public Optional<Caregiver> fetchCaregiverById(Long caregiverId) {
        return this.caregiverContextFacade.fetchCaregiverById(caregiverId);
    }


}
