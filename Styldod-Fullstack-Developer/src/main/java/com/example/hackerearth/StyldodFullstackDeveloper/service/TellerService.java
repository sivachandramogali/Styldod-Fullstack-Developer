package com.example.hackerearth.StyldodFullstackDeveloper.service;

import com.example.hackerearth.StyldodFullstackDeveloper.bean.Teller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class TellerService {
    private static List<Teller> tellers = new ArrayList<>();
    private static int count=3;
    static {
        tellers.add(new Teller(100, "AndraBank", "Samalkota", 50000));
        tellers.add(new Teller(101, "SBI", "Samalkota", 50000));
        tellers.add(new Teller(102, "corportation Bank", "Unduru", 50000));
    }

    public List<Teller> getAllTeller() {
        return tellers;
    }

    public Teller getTeller(int id) {
        for (Teller teller : tellers) {
                if(teller.getTellerId()==id)
                {
                    return teller;
                }
        }
     return null;
    }
    public Teller createTeller(Teller teller){
        teller.setTellerId(++count);

        tellers.add(teller);
        return teller;
    }

    public Teller deleteById(int id) {
        Iterator<Teller> iterator = tellers.iterator();
        while (iterator.hasNext()) {
            Teller teller = iterator.next();
            if (teller.getTellerId() == id) {
                iterator.remove();
                return teller;
            }
        }
        return null;
    }
}

