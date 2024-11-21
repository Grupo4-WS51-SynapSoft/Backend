package pe.edu.upc.center.platform.tutor.domain.services;

import pe.edu.upc.center.platform.tutor.domain.model.aggregates.Tutor;
import pe.edu.upc.center.platform.tutor.domain.model.queries.GetAllTutorsQuery;
import pe.edu.upc.center.platform.tutor.domain.model.queries.GetTutorByFullNameQuery;
import pe.edu.upc.center.platform.tutor.domain.model.queries.GetTutorByIdQuery;

import java.util.List;
import java.util.Optional;

public interface TutorQueryService {
    List<Tutor> handle(GetAllTutorsQuery query);
    Optional<Tutor> handle(GetTutorByIdQuery query);
    Optional<Tutor> handle(GetTutorByFullNameQuery query);
}
