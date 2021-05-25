package ru.harlequin.paintballclub.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.harlequin.paintballclub.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByUserName(String userName);
}
