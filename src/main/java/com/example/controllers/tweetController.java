package com.example.controllers;

import com.example.services.instanceTwitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMethod;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class tweetController {

    @Autowired
    instanceTwitter instanceTwitter;

    @RequestMapping(value = "/getTweets")
    public List<String> getUserTimeline(@RequestParam("searchString") String searchString) throws TwitterException{
        List<String> tweets = new ArrayList<>();
        try{
            Twitter twitter = instanceTwitter.getTwitter();
            List<Status>statuses = twitter.getUserTimeline(searchString);

            tweets = statuses.stream().map(
                    item -> item.getText()).collect(
                    Collectors.toList());
        }
        catch (TwitterException exc){
            System.out.println("TwitterException: " + exc);
        }
        return tweets;
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

    @RequestMapping(value = "/postTweet", method = RequestMethod.POST)
    public String createTweet(@RequestBody JSONObject jsonBody) throws TwitterException{

        Twitter twitter = instanceTwitter.getTwitter();
        String tweet = (String)jsonBody.get("tweet");
        System.out.println("tweeeet "+ tweet);
        Status status = twitter.updateStatus(tweet);
        return status.getText();

    }


    @RequestMapping(value = "/getTrendsAtPlace", method = RequestMethod.GET)
    private String[] getTrendLink(@RequestParam("searchID") int searchID) throws TwitterException {
        Twitter twitter = instanceTwitter.getTwitter();
        final int woeid = searchID;  // Where On Earth ID of JAPAN

        Trend[] arr = twitter.getPlaceTrends(woeid).getTrends();

        String[] retarr = new String[arr.length];
        for (int i=0; i<arr.length; i++) {
            retarr[i] =  arr[i].getURL() + " " + arr[i].getName() ;
        }

        return retarr;
    }

    @RequestMapping(value = "/sendDirectMessage", method = RequestMethod.POST)
    public String sendDirectMessage(@RequestBody JSONObject jsonBody) throws TwitterException {
        Twitter twitter = instanceTwitter.getTwitter();
        String recipientName = (String)jsonBody.get("recipientName");
        String msg = (String)jsonBody.get("msg");
        DirectMessage message = twitter.sendDirectMessage(recipientName, msg);
        return message.getText();
    }

    @RequestMapping(value = "/replyToATweet", method = RequestMethod.POST)
    public String replyToTweet(@RequestBody JSONObject jsonBody) throws TwitterException{

        Twitter twitter = instanceTwitter.getTwitter();
        String replyMessage = (String)jsonBody.get("replyMessage");
        Long tweetId = (Long)jsonBody.get("tweetId");//tweetId to which user would reply
        StatusUpdate statusUpdate = new StatusUpdate(replyMessage);
        statusUpdate.setInReplyToStatusId(tweetId);
        Status status = twitter.updateStatus(statusUpdate);
        return status.getText();
    }



}
