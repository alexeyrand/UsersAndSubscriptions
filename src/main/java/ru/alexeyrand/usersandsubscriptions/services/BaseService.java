package ru.alexeyrand.usersandsubscriptions.services;

import org.springframework.transaction.annotation.Transactional;
import ru.alexeyrand.usersandsubscriptions.entities.BaseEntity;
import ru.alexeyrand.usersandsubscriptions.repositories.BaseRepository;

import java.util.List;
import java.util.Optional;

/**
 * Базовый сервис
 */
@Transactional
public abstract class BaseService<T extends BaseEntity> {
    public abstract BaseRepository<T> getRepository();


    public Optional<T> findById(Long id) {
        return getRepository().findById(id);
    }

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public T save(T entity) {
        entity = beforeSave(entity);
        entity = getRepository().save(entity);
        return afterSave(entity);
    }



    public T beforeSave(T entity) {
        return entity;
    }
    public T afterSave(T entity) {
        return entity;
    }

    public void delete(T entity) {
        getRepository().delete(entity);
    }
}
