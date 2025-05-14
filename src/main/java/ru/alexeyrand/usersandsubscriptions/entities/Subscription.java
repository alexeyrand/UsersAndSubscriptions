package ru.alexeyrand.usersandsubscriptions.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
/**
 * Подписка
 */
@Entity
@Getter
@Setter
@Table(name = "SUBSCRIPTIONS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subscription extends BaseEntity {
    @Column(name = "user_id")
    private Long userId;
}
