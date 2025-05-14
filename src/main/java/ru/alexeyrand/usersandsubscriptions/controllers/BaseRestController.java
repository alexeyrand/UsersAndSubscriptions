package ru.alexeyrand.usersandsubscriptions.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexeyrand.usersandsubscriptions.entities.BaseEntity;
import ru.alexeyrand.usersandsubscriptions.services.BaseService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Базовый контроллер
 */
@AllArgsConstructor
public abstract class BaseRestController<T extends BaseEntity> {
    public abstract BaseService<T> getService();

    /**
     * Найти все сущности
     */
    @GetMapping(value = "/")
    public ResponseEntity<List<T>> getAll() {
        List<T> entities = getService().findAll();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    /**
     * Найти сущность по id
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<T> get(@PathVariable("id") Long id) {
        T entity = getService().findById(id).orElseThrow(() -> new NoSuchElementException(id.toString()));
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    /**
     * Создать сущность в базе данных
     */
    @PostMapping(value = "/")
    public ResponseEntity<T> create(@RequestBody T dto) {
        T entity = getService().save(dto);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    /**
     * Удалить сущность из базы данных
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<T> delete(@PathVariable("id") Long id) {
        T entity = getService().findById(id).orElseThrow(() -> new NoSuchElementException(id.toString()));
        getService().delete(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<>("error404 " + e, HttpStatus.NOT_FOUND);
    }
}
