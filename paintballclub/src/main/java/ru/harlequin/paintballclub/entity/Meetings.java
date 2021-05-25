package ru.harlequin.paintballclub.entity;

import javax.persistence.*;

@Entity
@Table(name="meetings")

public class Meetings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="meetingtime", nullable = false)
    private String time;

    @Column(name="numofusers",nullable = false)
    private int numOfUsers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumOfUsers() {
        return numOfUsers;
    }

    public void setNumOfUsers(int numOfUsers) {
        this.numOfUsers = numOfUsers;
    }
}
