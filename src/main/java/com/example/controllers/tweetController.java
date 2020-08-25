package com.example.controllers;

import com.example.services.instanceTwitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class tweetController {

    @Autowired
    instanceTwitter instanceTwitter;

    @RequestMapping(value = "/getTweets")
    public List<String> getUserTimeline() throws TwitterException{
        Twitter twitter = instanceTwitter.getTwitter();
        List<Status> statuses = twitter.getUserTimeline("kunalkamra88");
        return statuses.stream().map(
                item -> item.getText()).collect(
                Collectors.toList());
    }

    @RequestMapping(value = "/searchTweets")
    public List<String> searchTweets(@RequestParam("searchString") String searchString) throws TwitterException {

        Twitter twitter = instanceTwitter.getTwitter();
        Query query = new Query(searchString);
        QueryResult result = twitter.search(query);

        return result.getTweets().stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }


}
