package com.example.Reviewrave.Service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.Reviewrave.Entity.PlatformUser;
import com.example.Reviewrave.Entity.ResolutionTicket;
import com.example.Reviewrave.Enum.Status;
import com.example.Reviewrave.Repository.PlatformUserRepository;
import com.example.Reviewrave.Repository.ResolutionTicketRepository;


@Service
public class TicketService {

    private final ResolutionTicketRepository ticketRepo;
    private  final PlatformUserRepository userRepo;

    public TicketService(ResolutionTicketRepository ticketRepo, PlatformUserRepository userRepo) {
        this.ticketRepo = ticketRepo;
        this.userRepo = userRepo;
    }

    public void assignTicket(String agentEmail, Long ticketId) {

        PlatformUser agent = userRepo.findByEmail(agentEmail)
                .orElseThrow(() -> new RuntimeException("Agent not found"));

        long count = ticketRepo.countByAgentIdAndStatus(
                agent.getId(),
                Status.IN_PROGRESS);

        if (count >= 3) {
            throw new RuntimeException("Maximum 3 tickets allowed");
        }

        ResolutionTicket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setAgent(agent);
        ticket.setStatus(Status.IN_PROGRESS);
        ticketRepo.save(ticket);
    }

    @Transactional
    public void resolveTicket(Long ticketId, String notes) {

        ResolutionTicket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setResolutionNotes(notes);
        ticket.setStatus(Status.RESOLVED);
        ticketRepo.save(ticket);
    }

    public List<ResolutionTicket> getMyTickets(String agentEmail) {
        PlatformUser agent = userRepo.findByEmail(agentEmail)
                .orElseThrow(() -> new RuntimeException("Agent not found"));
        return ticketRepo.findByAgentId(agent.getId());
    }
}