package ru.alexeyrand.usersandsubscriptions.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexeyrand.usersandsubscriptions.entities.Subscription;
import ru.alexeyrand.usersandsubscriptions.services.BaseService;
import ru.alexeyrand.usersandsubscriptions.services.SubscriptionService;

/**
 * Контроллер для обработки запросов подписок
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/subscription")
public class SubscriptionRestController extends BaseRestController<Subscription> {

    private final SubscriptionService subscriptionService;

    /**
     * Поиск самой часто встречающийся подписки
     * @param username имя пользователя
     */
    @GetMapping("/top/")
    public ResponseEntity<String> getAllSubscriptionForUser(@PathVariable("username") String username) {
        String type = subscriptionService.findMostPopular();
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @Override
    public BaseService<Subscription> getService() {
        return subscriptionService;
    }
}
