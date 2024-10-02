package com.javabackendakademisi.freelancerMatchingPlatform.model.request;

import com.javabackendakademisi.freelancerMatchingPlatform.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProjectRequestDTO {

    @ManyToOne
    @JoinColumn(name = "employer_id", referencedColumnName = "userId")
    private User employer;

    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "Email cannot be null")
    @Size(min = 2, max = 100, message = "Project description must be between 2 and 100 characters")
    private String description;

    @NotNull(message = "Budget cannot be null")
    private Long budget;

    private String status;

    private LocalDateTime createdAt = LocalDateTime.now();
}
