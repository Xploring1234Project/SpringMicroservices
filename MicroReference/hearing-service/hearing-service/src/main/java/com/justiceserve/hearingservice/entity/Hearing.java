package com.justiceserve.hearingservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Hearings table — stored ONLY in justice-serve-hearing database.
 *
 * caseId        → Case.caseId      in justice-serve-case      (Feign)
 * judgeId       → User.userId      in justice-serve-identity  (Feign)
 * citizenUserId → User.userId      in justice-serve-identity  (Feign, for notifications)
 * lawyerUserId  → User.userId      in justice-serve-identity  (Feign, for notifications)
 *
 * NO local User @Entity. NO users table created in this database.
 */
@Entity
@Table(name = "hearings")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Hearing {

    public enum HearingStatus { SCHEDULED, IN_PROGRESS, COMPLETED, ADJOURNED, CANCELLED }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hearingId;

    /** FK to Case in case-service — plain Long, no local cases table */
    @Column(nullable = false)
    private Long caseId;

    /** FK to User (JUDGE) in identity-service — plain Long, no local users table */
    @Column(nullable = false)
    private Long judgeId;

    /** Cached judge name to avoid Feign on every read — updated at schedule time */
    @Column(length = 100)
    private String judgeName;

    @Column(nullable = false)
    private Long citizenUserId;

    private Long lawyerUserId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(length = 250)
    private String caseTitle;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private HearingStatus status;

    @PrePersist
    public void prePersist() {
        if (status == null) status = HearingStatus.SCHEDULED;
    }
}
