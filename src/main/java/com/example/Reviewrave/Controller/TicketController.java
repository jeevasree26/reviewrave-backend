package com.example.Reviewrave.Controller;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reviewrave.Dto.ResolutionRequestDto;
import com.example.Reviewrave.Entity.ResolutionTicket;
import com.example.Reviewrave.Service.TicketService;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketController {
    

    private final TicketService service;
    public TicketController(TicketService service) {
        this.service = service;
}

    @GetMapping("/my")
@PreAuthorize("hasRole('RESOLUTION_AGENT')")
public List<ResolutionTicket> myTickets(
        Authentication auth){
    return service.getMyTickets(auth.getName());

        }

@PutMapping("/{id}/assign")
@PreAuthorize("hasRole('RESOLUTION_AGENT')")
public String assign(
        @PathVariable Long id,
        Authentication auth){
    service.assignTicket(
            auth.getName(),
            id);
    return "Ticket Assigned";
}

@PostMapping("/{id}/resolve")
@PreAuthorize("hasRole('RESOLUTION_AGENT')")
public String resolve(
        @PathVariable Long id,
        @RequestBody ResolutionRequestDto dto){
    service.resolveTicket(
            id,
            dto.getNotes());
    return "Ticket Resolved";
}

}


