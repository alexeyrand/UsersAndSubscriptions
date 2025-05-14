package ru.alexeyrand.usersandsubscriptions.entities;

import jakarta.persistence.*;
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
    @Column(name = "type")
    private String type;
}
