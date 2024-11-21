package pe.edu.upc.center.platform.reservation.application.internal.outboundservices.acl;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;
import pe.edu.upc.center.platform.caregiver.interfaces.acl.CaregiverContextFacade;
import pe.edu.upc.center.platform.caregiver.interfaces.rest.resources.CaregiverResource;
import pe.edu.upc.center.platform.tutor.domain.model.aggregates.Tutor;
import pe.edu.upc.center.platform.tutor.interfaces.acl.TutorContextFacade;

import java.util.Optional;

@Service("externalcaregiverservicefromreservation")
public class ExternalCaregiverService {
    private final CaregiverContextFacade caregiverContextFacade;


    public ExternalCaregiverService(CaregiverContextFacade caregiverContextFacade) {
        this.caregiverContextFacade = caregiverContextFacade;
    }

    public Optional<Caregiver> fetchCaregiverById(Long caregiverId) {
        return this.caregiverContextFacade.fetchCaregiverById(caregiverId);
    }
}