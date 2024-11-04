package pe.edu.upc.center.platform.reservation.interfaces.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.center.platform.reservation.application.internal.commandservices.ReservationCommandServiceImpl;
import pe.edu.upc.center.platform.reservation.domain.model.commands.CreateReservationCommand;
import pe.edu.upc.center.platform.reservation.domain.model.commands.UpdateReservationStatusCommand;
import pe.edu.upc.center.platform.reservation.domain.model.entities.Reservation;
import pe.edu.upc.center.platform.reservation.domain.model.valueobjects.ReservationStatus;


@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationCommandServiceImpl commandService;

    public ReservationController(ReservationCommandServiceImpl commandService) {
        this.commandService = commandService;
    }

    @PostMapping
    public ResponseEntity<Long> createReservation(@RequestBody CreateReservationCommand command) {
        Long reservationId = commandService.handle(command);
        return ResponseEntity.ok(reservationId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        Reservation reservation = commandService.findById(id);
        return ResponseEntity.ok(reservation);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateReservationStatus(@PathVariable Long id, @RequestBody ReservationStatus status) {
        commandService.handle(new UpdateReservationStatusCommand(id, status));
        return ResponseEntity.noContent().build();
    }
}
