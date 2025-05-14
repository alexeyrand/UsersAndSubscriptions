package ru.alexeyrand.usersandsubscriptions.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

/**
 * Пользователь
 */
@Entity
@Getter
@Setter
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseEntity {
    String username;
    String password;
    @OneToMany
    @JoinColumn(name = "user_id")
    List<Subscription> subscriptions;
}
