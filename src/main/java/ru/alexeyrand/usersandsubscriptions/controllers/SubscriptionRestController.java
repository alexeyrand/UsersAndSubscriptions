package ru.alexeyrand.usersandsubscriptions.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexeyrand.usersandsubscriptions.entities.Subscription;
import ru.alexeyrand.usersandsubscriptions.entities.User;
import ru.alexeyrand.usersandsubscriptions.services.BaseService;
import ru.alexeyrand.usersandsubscriptions.services.SubscriptionService;
import ru.alexeyrand.usersandsubscriptions.services.UserService;

import java.util.List;

/**
 * Контроллер для обработки запросов подписок
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/subscription")
public class SubscriptionRestController extends BaseRestController<Subscription> {

    private final SubscriptionService subscriptionService;


    @Override
    public BaseService<Subscription> getService() {
        return subscriptionService;
    }
}
