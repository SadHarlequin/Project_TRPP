package ru.harlequin.paintballclub.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.harlequin.paintballclub.entity.Meetings;

@Repository
public interface MeetingsRepository extends JpaRepository<Meetings,Long> {
    Meetings findByTime(String time);
}
