package com.javabackendakademisi.freelancerMatchingPlatform.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "project")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @ManyToOne
    @JoinColumn(name = "employer_id", referencedColumnName = "userId")
    private User employer;      // İşveren kullanıcı (User class'ına bağlı foreign key)

    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "Email cannot be null")
    @Size(min = 2, max = 100, message = "Project description must be between 2 and 100 characters")
    private String description;

    @NotNull(message = "Budget cannot be null")
    private BigDecimal budget;

    private String status;      // Projenin durumu (örn: "open", "in progress", "completed")


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @NotNull(message = "Budget cannot be null") BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
