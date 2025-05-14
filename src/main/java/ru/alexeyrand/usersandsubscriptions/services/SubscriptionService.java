package ru.alexeyrand.usersandsubscriptions.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexeyrand.usersandsubscriptions.entities.Subscription;
import ru.alexeyrand.usersandsubscriptions.repositories.BaseRepository;
import ru.alexeyrand.usersandsubscriptions.repositories.SubscriptionRepository;

/**
 * Сервис по работе с подписками
 */
@Service
@RequiredArgsConstructor
public class SubscriptionService extends BaseService<Subscription> {

    private final SubscriptionRepository subscriptionRepository;

    public String findMostPopular() {
        return subscriptionRepository.findMostPopular();
    }

    public Subscription findSubscriptionByLabel(String label) {
        return subscriptionRepository.findByLabel(label);
    }

    @Override
    public BaseRepository<Subscription> getRepository() {
        return subscriptionRepository;
    }
}
