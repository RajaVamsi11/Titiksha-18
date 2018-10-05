package com.example.vamsi.my;

public class Person {
    String personId;
    String personName;
    String personPhone;

    public Person() {
    }

    public Person(String personId, String personName, String personPhone) {
        this.personId = personId;
        this.personName = personName;
        this.personPhone = personPhone;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }
}
