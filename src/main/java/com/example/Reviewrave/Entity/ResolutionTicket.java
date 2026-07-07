package com.example.Reviewrave.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import com.example.Reviewrave.Enum.Status;


@Entity
@Table(name="resolution_tickets")
public class ResolutionTicket {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private CustomerReview review;

    @ManyToOne
    private PlatformUser agent;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(columnDefinition = "TEXT")
    private String resolutionNotes;

     public ResolutionTicket(){

     }

    public ResolutionTicket(Long id, CustomerReview review, Status status, String resolutionNotes) {
        this.id = id;
        this.review = review;
        this.status = status;
        this.resolutionNotes = resolutionNotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerReview getReview() {
        return review;
    }

    public void setReview(CustomerReview review) {
        this.review = review;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResolutionNotes() {
        return resolutionNotes;
    }

    public void setResolutionNotes(String resolutionNotes) {
        this.resolutionNotes = resolutionNotes;
    }

    public PlatformUser getAgent() {
        return agent;
    }

    public void setAgent(PlatformUser agent) {
        this.agent = agent;
    }

    

    
}




