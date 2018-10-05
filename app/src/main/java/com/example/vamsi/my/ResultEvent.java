package com.example.vamsi.my;

public class ResultEvent {
    String event_name,event_type,first_winner,second_winner;
    public ResultEvent(){

    }

    public ResultEvent(String event_name, String event_type, String first_winner, String second_winner) {
        this.event_name = event_name;
        this.event_type = event_type;
        this.first_winner = first_winner;
        this.second_winner = second_winner;
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

    public String getFirst_winner() {
        return first_winner;
    }

    public void setFirst_winner(String first_winner) {
        this.first_winner = first_winner;
    }

    public String getSecond_winner() {
        return second_winner;
    }

    public void setSecond_winner(String second_winner) {
        this.second_winner = second_winner;
    }
}
