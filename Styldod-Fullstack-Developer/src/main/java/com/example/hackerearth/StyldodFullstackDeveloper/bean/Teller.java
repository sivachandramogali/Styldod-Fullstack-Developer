package com.example.hackerearth.StyldodFullstackDeveloper.bean;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Teller {
    private int tellerId;
    @Size(min=2, message = "tellerName should be atleast 2 chanrecters")
    private String tellerName;
    @NotNull
    private String location;
    private long tellerCapacity;

    public int getTellerId() {
        return tellerId;
    }

    public void setTellerId(int tellerId) {
        this.tellerId = tellerId;
    }

    public String getTellerName() {
        return tellerName;
    }

    public void setTellerName(String tellerName) {
        this.tellerName = tellerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getTellerCapacity() {
        return tellerCapacity;
    }

    public void setTellerCapacity(long tellerCapacity) {
        this.tellerCapacity = tellerCapacity;
    }

    public Teller(int tellerId, String tellerName, String location, long tellerCapacity) {
        this.tellerId = tellerId;
        this.tellerName = tellerName;
        this.location = location;
        this.tellerCapacity = tellerCapacity;
    }

    public Teller() {
    }
}
