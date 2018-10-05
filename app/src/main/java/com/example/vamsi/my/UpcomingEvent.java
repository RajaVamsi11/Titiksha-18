package com.example.vamsi.my;

import java.util.Date;

public class UpcomingEvent {
    public String event_name,event_type,event_location,event_coordinator;
    public Date event_time;

    public UpcomingEvent(){

    }

    public UpcomingEvent(String event_name, String event_type, String event_location, String event_coordinator, Date event_time) {
        this.event_name = event_name;
        this.event_type = event_type;
        this.event_location = event_location;
        this.event_coordinator = event_coordinator;
        this.event_time = event_time;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getEvent_location() {
        return event_location;
    }

    public void setEvent_location(String event_location) {
        this.event_location = event_location;
    }

    public String getEvent_coordinator() {
        return event_coordinator;
    }

    public void setEvent_coordinator(String event_coordinator) {
        this.event_coordinator = event_coordinator;
    }

    public Date getEvent_time() {
        return event_time;
    }

    public void setEvent_time(Date event_time) {
        this.event_time = event_time;
    }
}
