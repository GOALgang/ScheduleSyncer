package com.emmabr.schedulingapp.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class TimeOption implements Comparable{

    String id;
    String startTime;
    String endTime;
    int votes;
    ArrayList<User> upVoters; //possible way to keep track of who votes up
    ArrayList<User> downVoters; //possible way to keep track of who votes down

    public TimeOption(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        upVoters = new ArrayList<>();
        downVoters = new ArrayList<>();

    }

    public String getId() {
        return id;
    }

    public String getTime() {
//        int startT = startTime.indexOf("T");
//        int endT = endTime.indexOf("T");
//        int startPeriod = startTime.indexOf(".");
//        int endPeriod = endTime.indexOf(".");
//        startTime = startTime.substring(startT + 1, startPeriod);
//        endTime = endTime.substring(endT + 1, endPeriod);
        String finalTime =  startTime + " - " + endTime;
        return finalTime;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes() {
        votes = upVoters.size() - downVoters.size();
    }

    public ArrayList<User> getUpVoters() {
        return upVoters;
    }

    public void upVote(User user) {
        if (!upVoters.contains(user)) {
            upVoters.add(user);
            if (downVoters.contains(user))
                downVoters.remove(user);
        } else
            upVoters.remove(user);
        setVotes();
    }

    public ArrayList<User> getDownVoters() {
        return downVoters;
    }

    public void downVote(User user) {
        if (!downVoters.contains(user)) {
            downVoters.add(user);
            if (upVoters.contains(user))
                upVoters.remove(user);
        } else
            downVoters.remove(user);
        setVotes();
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return Integer.parseInt(o.toString()) - Integer.parseInt(toString());
    }

    @Override
    public String toString() {
        return Integer.toString(getVotes());
    }

}
