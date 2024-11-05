package com.org.mailservice.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mail_id", nullable = false)
    private long mail_id;

    @Column(name = "file_name", nullable = false)
    private String file_name;

    @Column(name = "file_path", nullable = false)
    private String file_path;

    @Column(name = "file_size", nullable = false)
    private long file_size;
}
