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
public class WorkoutPlan {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @Size(min = 5, max = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel; // Enum for difficulty levels

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Min(1)
    @Max(120)
    private Integer duration; // Duration in minutes per session

    @Min(1)
    @Max(7)
    private Integer frequency; // Sessions per week

    private String goal; // e.g., "Weight Loss", "Muscle Gain"

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDate createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}