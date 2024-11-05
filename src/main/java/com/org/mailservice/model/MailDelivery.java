package com.org.mailservice.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "MailDelivery")
public class MailDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mail_id", nullable = false)
    private long mail_id;

    @Column(name = "to_user_id", nullable = false)
    private long to_user_id;

    @Column(name = "folder_id")
    private long folder_id;

    @Column(name = "is_read", nullable = false)
    private boolean is_read = false;

    @Column(name = "is_flag", nullable = false)
    private boolean is_flag;

    @Column(name = "is_trash", nullable = false)
    private boolean is_trash;
}
