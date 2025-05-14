package ru.alexeyrand.usersandsubscriptions.entities;

import jakarta.persistence.*;
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
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @OneToMany
    @JoinColumn(name = "user_id")
    List<Subscription> subscriptions;
}
