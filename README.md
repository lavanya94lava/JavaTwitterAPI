# JavaTwitterAPI

This API is made using Spring Boot 2.1.5, Maven. In this API, I performed basic CRUD operations on my tweets, also I fetched tweets of other users,using their username. I also sent and read personal personal messages. I used Twitter4j, an unofficial Java library for Twitter API to integrate my java application with twitter service.

# Prerequisites

Get your twitter credentials [https://developer.twitter.com/en](https://developer.twitter.com/en).
Use your consumer Key, consumer secret, access token, access token secret and put it in twitter4j.properties in resources folder.


# Software Requirements

Spring Boot 2.1.5 or above<br>
JDK 1.8<br>
PostMan<br>
Intellij/Eclipse<br>


# Dependencies Used

spring-boot-starter-web<br>
twitter4j-core
twitter4j-stream
json-simple



# Features of API

Fetch the user TimeLine using twitter.getUserTimeLine method, it gives you how the current timeline of user looks like.<br>
<br>
Fetch the tweets of a user using his/her username.Also use Paging method to get x number of tweets from a particular page number<br>
<br>
Search for the tweets of a particular keyword using a query method offered by twitter4j.<br>
<br>
Post a tweet using from your end using a POST request and using Postman and twitter.updateStatus method.<br>
<br>
Search for Hashtags trending in a particular region of the world using WOEID(Where On Earth Id).<br>
<br>
Send a direct message to any user using their username, and using twitter.sendDirectMessage method.
<br>
Reply to a Tweet using Status Update Method, this method would the tweet Id of the parent tweet.<br>
<br>







