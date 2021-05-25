package ru.harlequin.paintballclub.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.harlequin.paintballclub.entity.UserToMeeting;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserToMeetingRepository extends JpaRepository<UserToMeeting, Long> {
    List<UserToMeeting> findAllByUserId(int userid);
}
