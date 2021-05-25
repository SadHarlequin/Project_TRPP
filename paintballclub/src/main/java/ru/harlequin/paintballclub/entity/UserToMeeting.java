package ru.harlequin.paintballclub.entity;

import javax.persistence.*;

@Entity
@Table(name="usertomeeting")
public class UserToMeeting {
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="userid", nullable = false)
    private int userId;

    @Column(name="meetingid", nullable = false)
    private Long meetingId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }

}
