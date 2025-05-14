package ru.alexeyrand.usersandsubscriptions.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexeyrand.usersandsubscriptions.entities.Subscription;
import ru.alexeyrand.usersandsubscriptions.entities.User;
import ru.alexeyrand.usersandsubscriptions.repositories.BaseRepository;
import ru.alexeyrand.usersandsubscriptions.repositories.SubscriptionRepository;
import ru.alexeyrand.usersandsubscriptions.repositories.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Сервис по работе с пользователями
 */
@Service
@RequiredArgsConstructor
public class UserService extends BaseService<User> {

    private final UserRepository userRepository;
    private final SubscriptionService subscriptionService;
    private final SubscriptionRepository subscriptionRepository;

    /**
     * Метод поиска пользователя по имени
     */
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    /**
     * Метод обновления информации о пользователе
     */
    public User update(User user)  {
        User entity = findUserByUsername(user.getUsername()).orElseThrow(() -> new NoSuchElementException("User not found"));
        if (user.getUsername() != null && !user.getUsername().isEmpty()) {
            entity.setUsername(user.getUsername());
        }
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            entity.setPassword(user.getPassword());
        }
        if (user.getLabel() != null && !user.getLabel().isEmpty()) {
            entity.setLabel(user.getLabel());
        }
        return userRepository.save(entity);
    }

    /**
     * Метод добавления подписок пользователя по имени
     */
    public User addSubscription(String username, Subscription subscription) {
        User user = findUserByUsername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
        List<Subscription> subscriptions = user.getSubscriptions();
        subscriptions.add(subscription);
        user.setSubscriptions(subscriptions);
        subscriptionService.save(subscription);
        return this.save(user);
    }

    /**
     * Метод удаления подписок пользователя по имени
     */
    public User deleteSubscription(String username, Subscription subscription) {
        User user = findUserByUsername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
        Subscription sub = subscriptionService.findSubscriptionByLabel(subscription.getLabel());
        List<Subscription> subscriptions = user.getSubscriptions();
        List<Subscription> actualSubs = subscriptions.stream().filter(s -> !s.getLabel().equals(subscription.getLabel())).toList();
        user.setSubscriptions(actualSubs);
        subscriptionService.delete(sub);
        return this.save(user);
    }

    public List<Subscription> findSubscriptionByUser(String username) {
        User user = this.findUserByUsername(username).orElseThrow(() -> new NoSuchElementException("User not found"));
        return subscriptionRepository.findSubscriptionsByUserId(user.getId());
    }

    @Override
    public BaseRepository<User> getRepository() {
        return userRepository;
    }
}
