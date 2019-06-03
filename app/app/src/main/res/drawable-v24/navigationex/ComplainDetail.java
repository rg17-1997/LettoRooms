package com.example.lenovo.navigationex;

public class ComplainDetail {

    String name;
    String adress;
    String city;
    String state;
    String pincoede;
    String complain;

    public ComplainDetail(String id, String city, String adress, String state, String complain, String pincoede, String name) {
        this.name = name;
        this.adress = adress;
        this.city = city;
        this.state = state;
        this.pincoede = pincoede;
        this.complain = complain;
    }
    public String getName(){
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPincoede() {
        return pincoede;
    }

    public String getComplain() {
        return complain;
    }
}
