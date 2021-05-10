package SocialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private String name;
    private List<Person> friends = new ArrayList<>();
    private Map<Person, String> receivedMessages= new HashMap<>();

    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Person> getFriends() {
        return friends;
    }
    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }
    public Map<Person, String> getReceivedMessages() {
        return receivedMessages;
    }
    public void setReceivedMessages(Map<Person, String> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }
    public void addFriend(Person person){
        friends.add(person);
    }
    public void receiveMessage(Person person, String message){
        receivedMessages.put(person, message);
    }
}
