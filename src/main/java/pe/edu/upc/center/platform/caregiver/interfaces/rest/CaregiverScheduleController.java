package pe.edu.upc.center.platform.caregiver.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.center.platform.caregiver.domain.model.aggregates.Caregiver;
import pe.edu.upc.center.platform.caregiver.domain.model.commands.*;
import pe.edu.upc.center.platform.caregiver.domain.model.entities.CaregiverSchedule;
import pe.edu.upc.center.platform.caregiver.domain.model.queries.GetAllCaregiverScheduleByCaregiverIdQuery;
import pe.edu.upc.center.platform.caregiver.domain.model.queries.GetCaregiverByIdQuery;
import pe.edu.upc.center.platform.caregiver.domain.model.queries.GetCaregiverByLocationQuery;
import pe.edu.upc.center.platform.caregiver.domain.services.CaregiverCommandService;
import pe.edu.upc.center.platform.caregiver.domain.services.CaregiverQueryService;
import pe.edu.upc.center.platform.caregiver.interfaces.rest.resources.CaregiverScheduleResource;
import pe.edu.upc.center.platform.caregiver.interfaces.rest.resources.CreateCaregiverScheduleResource;
import pe.edu.upc.center.platform.caregiver.interfaces.rest.resources.UpdateCaregiverScheduleResource;
import pe.edu.upc.center.platform.caregiver.interfaces.rest.transform.*;
import pe.edu.upc.center.platform.payment.domain.model.commands.DeleteCardCommand;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/api/v1/caregiver-schedule", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Caregiver Schedule", description = "Caregiver Management Endpoints")
public class CaregiverScheduleController {
    private final CaregiverCommandService caregiverCommandService;
    private final CaregiverQueryService caregiverQueryService;

    public CaregiverScheduleController(CaregiverCommandService caregiverCommandService, CaregiverQueryService caregiverQueryService) {
        this.caregiverCommandService = caregiverCommandService;
        this.caregiverQueryService = caregiverQueryService;
    }

    @PostMapping
    ResponseEntity<CaregiverScheduleResource> createCaregiverSchedule(@RequestBody CreateCaregiverScheduleResource resource) {
        var createCaregiverScheduleCommand = CreateCaregiverScheduleCommandFromResourceAssembler.toCommandFromResource(resource);

        CaregiverSchedule caregiverSchedule = caregiverCommandService.handle(createCaregiverScheduleCommand);

        return new ResponseEntity<>(CaregiverScheduleResourceFromEntityAssembler.toResourceFromEntity(caregiverSchedule), HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<CaregiverScheduleResource> updateCaregiverSchedule(@RequestBody UpdateCaregiverScheduleResource resource) {
        var updateCaregiverBiographyCommand = UpdateCaregiverScheduleCommandFromResourceAssembler.toCommandFromResource(resource);

        CaregiverSchedule caregiverSchedule = caregiverCommandService.handle(updateCaregiverBiographyCommand).orElseThrow();

        return new ResponseEntity<>(CaregiverScheduleResourceFromEntityAssembler.toResourceFromEntity(caregiverSchedule), HttpStatus.OK);
    }

    @GetMapping("/{caregiverId}")
    ResponseEntity<List<CaregiverScheduleResource>> getAllCaregiverScheduleByCaregiverId(@PathVariable Long caregiverId) {
        var getAllCaregiverScheduleByCaregiverIdQuery = new GetAllCaregiverScheduleByCaregiverIdQuery(caregiverId);
        List<CaregiverSchedule> caregiverSchedulesList = caregiverQueryService.handle(getAllCaregiverScheduleByCaregiverIdQuery);

        return new ResponseEntity<>(caregiverSchedulesList
                .stream()
                .map(CaregiverScheduleResourceFromEntityAssembler::toResourceFromEntity)
                .toList(), HttpStatus.OK);
    }

    @DeleteMapping("/{caregiverScheduleId}")
    ResponseEntity<?> deleteCaregiverSchedule(@PathVariable Long caregiverScheduleId) {
        var deleteCaregiverScheduleCommand = new DeleteCaregiverScheduleCommand(caregiverScheduleId);
        this.caregiverCommandService.handle(deleteCaregiverScheduleCommand);

        return ResponseEntity.noContent().build();
    }

}
