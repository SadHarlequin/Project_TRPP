package ru.harlequin.paintballclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.harlequin.paintballclub.entity.Meetings;
import ru.harlequin.paintballclub.entity.UserToMeeting;
import ru.harlequin.paintballclub.service.MeetingService;
import ru.harlequin.paintballclub.service.UsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MeetingController {
    @Autowired
    MeetingService meetingService;
    @Autowired
    UsersService usersService;

    @GetMapping("/settime")
    public String meeting(){
        return "meeting";
    }
    @GetMapping("/settimeaction")
    public String meetingAction(@RequestParam String time, @RequestParam String num){
        int numb = Integer.parseInt(num);
        meetingService.createMeeting(time,numb);
        return "home";
    }
    @GetMapping("/setmeeting")
    public String setMeeting(Model model){
        model.addAttribute("selectMeetings", meetingService.getAll());
        return "setmeeting";
    }
    @GetMapping("/setmeetingaction")
    public String setMeetingAction(Model model, @RequestParam String time){
        meetingService.setMeeting(time);
        return "home";
    }
    @GetMapping("/pc")
    public String personalCabinet(Model model){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", name);
        int id = usersService.findUsersByName(name).getId();
        List<UserToMeeting> userToMeeting = meetingService.getAllByUserId(id);
        List<Meetings> meetings = new ArrayList<Meetings>();
        for (UserToMeeting meeting:userToMeeting) {
            meetings.add(meetingService.getMeeting(meeting.getMeetingId()));
        }
        model.addAttribute("meetings", meetings);
        return "pc";
    }
}
