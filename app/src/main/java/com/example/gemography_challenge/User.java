package com.example.gemography_challenge;

import java.net.URL;

public class User {
    private String name ;
    private URL  avatarUTL ;

    public User (String name , String avatar_url) {
        this.name = name ;
        try {
            this.avatarUTL = new URL(avatar_url);
        }
        catch (Exception e) {

        }

    }
}
