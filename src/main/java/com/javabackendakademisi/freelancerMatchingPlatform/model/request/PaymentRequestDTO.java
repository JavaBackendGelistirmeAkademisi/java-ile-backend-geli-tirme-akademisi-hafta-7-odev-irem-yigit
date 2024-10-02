package com.javabackendakademisi.freelancerMatchingPlatform.model.request;

import com.javabackendakademisi.freelancerMatchingPlatform.model.Project;
import com.javabackendakademisi.freelancerMatchingPlatform.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class PaymentRequestDTO {

    private Double amount;  // Ödeme miktarı

    private String status;  // Ödeme durumu ("pending", "completed", "failed")

    @ManyToOne
    @JoinColumn(name = "freelancer_id", nullable = false)
    private User freelancer;  // Ödemeyi alan freelancer

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;  // Ödeme yapılan proje

    private LocalDateTime paymentDate = LocalDateTime.now();
}
