package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.nio.file.Files;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Lob
    private byte [] profilePic;
}
