package com.Fit.track.Entity;

import java.time.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String activityName;

    @NotNull
    private LocalDate date;

    @Min(1)
    @Max(1440)
    private Integer duration; // Duration in minutes

    @DecimalMin("0.0")
    private Double caloriesBurned; // Estimated calories burned

    @Size(max = 50)
    private String intensityLevel; // e.g., "Low", "Moderate", "High"

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}