package ru.alexeyrand.usersandsubscriptions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexeyrand.usersandsubscriptions.entities.Subscription;
import ru.alexeyrand.usersandsubscriptions.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>, BaseRepository<Subscription> {
    Subscription findByLabel(String label);
    List<Subscription> findSubscriptionsByUserId(Long userId);
}
