package pe.edu.upc.center.platform.reservation.interfaces.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.center.platform.reservation.application.internal.commandservices.ReservationCommandServiceImpl;
import pe.edu.upc.center.platform.reservation.application.internal.queryservices.ReservationQueryServiceImpl;
import pe.edu.upc.center.platform.reservation.domain.model.commands.CancelReservationCommand;
import pe.edu.upc.center.platform.reservation.domain.model.commands.CreateReservationCommand;
import pe.edu.upc.center.platform.reservation.domain.model.entities.Reservation;
import pe.edu.upc.center.platform.reservation.domain.model.queries.GetReservationsByUserQuery;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationCommandServiceImpl commandService;
    private final ReservationQueryServiceImpl queryService;

    public ReservationController(ReservationCommandServiceImpl commandService, ReservationQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    public ResponseEntity<Long> createReservation(@RequestBody CreateReservationCommand command) {
        Long reservationId = commandService.handle(command);
        return ResponseEntity.ok(reservationId);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@PathVariable Long userId) {
        List<Reservation> reservations = queryService.handle(new GetReservationsByUserQuery(userId));
        return ResponseEntity.ok(reservations);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long reservationId) {
        commandService.handle(new CancelReservationCommand(reservationId));
        return ResponseEntity.noContent().build();
    }
}
