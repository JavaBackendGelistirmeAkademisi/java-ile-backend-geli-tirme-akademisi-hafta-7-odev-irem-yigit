package com.javabackendakademisi.freelancerMatchingPlatform.model.request;

import com.javabackendakademisi.freelancerMatchingPlatform.model.Project;
import com.javabackendakademisi.freelancerMatchingPlatform.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class OfferRequestDTO {

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "freelancer_id", nullable = false)
    private User freelancer;  // Teklifi yapan freelancer

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;  // Teklif yapılan proje

    private String status;  // Teklif durumu (örneğin: "pending", "accepted", "rejected")

    private LocalDateTime offerDate = LocalDateTime.now();
}
