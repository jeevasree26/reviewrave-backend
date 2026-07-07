package com.example.Reviewrave.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Reviewrave.Entity.ResolutionTicket;
import com.example.Reviewrave.Enum.Status;

@Repository
public interface ResolutionTicketRepository
        extends JpaRepository<ResolutionTicket, Long> {

            List<ResolutionTicket> findByAgentId(Long agentId);

            List<ResolutionTicket> findByAgentIdAndStatus(Long agentId,
            Status status);

    long countByAgentIdAndStatus(Long agentId,
            Status status);

}