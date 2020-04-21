package org.itstep.msk.app.halp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public class Halp {
    public String s;
    public Halp(String s){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        CharSequence charSequence ="123456";
        System.out.println(passwordEncoder.encode(charSequence));
    }

}
