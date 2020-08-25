package com.example.services;

import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Service
public class instanceTwitter {

    public Twitter getTwitter(){
        Twitter twitter = TwitterFactory.getSingleton();
        return twitter;
    }
}
