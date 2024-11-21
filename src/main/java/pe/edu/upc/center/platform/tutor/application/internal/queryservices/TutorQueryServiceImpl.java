package pe.edu.upc.center.platform.tutor.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.tutor.domain.model.aggregates.Tutor;
import pe.edu.upc.center.platform.tutor.domain.model.queries.GetAllTutorsQuery;
import pe.edu.upc.center.platform.tutor.domain.model.queries.GetTutorByFullNameQuery;
import pe.edu.upc.center.platform.tutor.domain.model.queries.GetTutorByIdQuery;
import pe.edu.upc.center.platform.tutor.domain.services.TutorQueryService;
import pe.edu.upc.center.platform.tutor.infrastructure.persistence.jpa.repositories.TutorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TutorQueryServiceImpl implements TutorQueryService {

    private final TutorRepository tutorRepository;

    public TutorQueryServiceImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }


    @Override
    public List<Tutor> handle(GetAllTutorsQuery query) {
        return this.tutorRepository.findAll();
    }

    @Override
    public Optional<Tutor> handle(GetTutorByIdQuery query) {
        return this.tutorRepository.findById(query.tutorId());
    }

    @Override
    public Optional<Tutor> handle(GetTutorByFullNameQuery query) {
        return this.tutorRepository.findByFullName(query.fullName());
    }
}
