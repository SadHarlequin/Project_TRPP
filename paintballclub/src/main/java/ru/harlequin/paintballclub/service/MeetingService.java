package ru.harlequin.paintballclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.harlequin.paintballclub.entity.Meetings;
import ru.harlequin.paintballclub.entity.UserToMeeting;
import ru.harlequin.paintballclub.repo.MeetingsRepository;
import ru.harlequin.paintballclub.repo.UserToMeetingRepository;
import ru.harlequin.paintballclub.repo.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingService {
    @Autowired
    MeetingsRepository meetingsRepository;
    @Autowired
    UserToMeetingRepository userToMeetingRepository;
    @Autowired
    UsersRepository usersRepository;


    public void createMeeting(String time, int numOfUsers){
        Meetings meeting = new Meetings();
        List<Meetings> list = meetingsRepository.findAll();
        for ( Meetings meetings: list) {
            if (time.equals(meetings.getTime())){
                return;
            }
        }
        meeting.setTime(time);
        meeting.setNumOfUsers(numOfUsers);
        meetingsRepository.save(meeting);
    }
    public void setMeeting(String time){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserToMeeting userToMeeting = new UserToMeeting();
        userToMeeting.setMeetingId(meetingsRepository.findByTime(time).getId());
        userToMeeting.setUserId(usersRepository.findByUserName(authentication.getName()).getId());
        Meetings meetings = meetingsRepository.findByTime(time);
        meetings.setNumOfUsers(meetings.getNumOfUsers()-1);
        meetingsRepository.save(meetings);
        userToMeetingRepository.save(userToMeeting);
    }

    public List<Meetings> getAll(){
        return meetingsRepository.findAll();
    }
    public Meetings getMeeting(long id){
       Optional<Meetings> meetings = meetingsRepository.findById(id);
        return meetings.get();
    }
    public List<UserToMeeting> getAllByUserId(int id){
    List<UserToMeeting> userToMeeting = userToMeetingRepository.findAllByUserId(id);
    return userToMeeting;
    }

}
