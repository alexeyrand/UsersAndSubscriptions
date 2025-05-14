package ru.alexeyrand.usersandsubscriptions.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexeyrand.usersandsubscriptions.entities.Subscription;
import ru.alexeyrand.usersandsubscriptions.entities.User;
import ru.alexeyrand.usersandsubscriptions.services.BaseService;
import ru.alexeyrand.usersandsubscriptions.services.UserService;

import java.util.List;

/**
 * Контроллер для обработки запросов по пользователям
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserRestController extends BaseRestController<User> {

    private final UserService userService;

    /**
     * Обновление информации о пользователе
     * @param dto новая информация о пользователе
     */
    @PutMapping(value = "/")
    public ResponseEntity<User> update(@RequestBody User dto) {
        User entity = userService.update(dto);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    /**
     * Добавление подписки пользователю
     * @param username имя пользователя
     * @param subscription сущность подписки
     */
    @PostMapping("/{username}/subscriptions/")
    public ResponseEntity<User> addSubscriptionForUser(@PathVariable("username") String username, @RequestBody Subscription subscription) {
        User entity = userService.addSubscription(username, subscription);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    /**
     * Удаление подписки пользователю
     * @param username имя пользователя
     * @param subscription сущность подписки
     */
    @DeleteMapping("/{username}/subscriptions/")
    public ResponseEntity<User> deleteSubscriptionForUser(@PathVariable("username") String username, @RequestBody Subscription subscription) {
        User entity = userService.deleteSubscription(username, subscription);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    /**
     * Поиск всех подписок пользователя
     * @param username имя пользователя
     */
    @GetMapping("/{username}/")
    public ResponseEntity<List<Subscription>> getAllSubscriptionForUser(@PathVariable("username") String username) {
        List<Subscription> subscriptions = userService.findSubscriptionByUser(username);
        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
    }

    @Override
    public BaseService<User> getService() {
        return userService;
    }
}
