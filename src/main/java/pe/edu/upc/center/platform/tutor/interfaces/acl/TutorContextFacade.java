package pe.edu.upc.center.platform.tutor.interfaces.acl;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;
import pe.edu.upc.center.platform.caregiver.domain.model.queries.GetCaregiverByIdQuery;
import pe.edu.upc.center.platform.caregiver.domain.services.CaregiverCommandService;
import pe.edu.upc.center.platform.caregiver.domain.services.CaregiverQueryService;
import pe.edu.upc.center.platform.tutor.domain.model.aggregates.Tutor;
import pe.edu.upc.center.platform.tutor.domain.model.queries.GetTutorByIdQuery;
import pe.edu.upc.center.platform.tutor.domain.services.TutorCommandService;
import pe.edu.upc.center.platform.tutor.domain.services.TutorQueryService;

import java.util.Optional;

@Service
public class TutorContextFacade {

    private final TutorCommandService tutorCommandService;
    private final TutorQueryService tutorQueryService;

    public TutorContextFacade(TutorCommandService tutorCommandService, TutorQueryService tutorQueryService) {
        this.tutorCommandService = tutorCommandService;
        this.tutorQueryService = tutorQueryService;
    }

    public Optional<Tutor> fetchTutorById(Long tutorId) {
        var GetTutorByIdQuery = new GetTutorByIdQuery(tutorId);
        return tutorQueryService.handle(GetTutorByIdQuery);
    }
}
