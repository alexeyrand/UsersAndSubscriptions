package ru.alexeyrand.usersandsubscriptions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.alexeyrand.usersandsubscriptions.entities.Subscription;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>, BaseRepository<Subscription> {
    Subscription findByLabel(String label);
    List<Subscription> findSubscriptionsByUserId(Long userId);

    @Query("SELECT s.type FROM Subscription s GROUP BY s.type ORDER BY COUNT(s.type) DESC LIMIT 1")
    String findMostPopular();
}
