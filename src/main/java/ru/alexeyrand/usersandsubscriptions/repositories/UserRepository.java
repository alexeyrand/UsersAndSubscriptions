package ru.alexeyrand.usersandsubscriptions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexeyrand.usersandsubscriptions.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, BaseRepository<User> {
    Optional<User> findUserByUsername(String username);
}
