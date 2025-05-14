package ru.alexeyrand.usersandsubscriptions.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Базовая сущность приложения
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID")
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "LABEL")
    private String label;
}
