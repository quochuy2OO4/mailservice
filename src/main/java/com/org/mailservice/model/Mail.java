package com.org.mailservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Mail")
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "from_user_id", nullable = false)
    private long from_user_id;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "body", nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column(name = "priority", nullable = false)
    private byte priority;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime date_time;

    @Column(name = "status", nullable = false)
    private byte status;
}
