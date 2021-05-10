package SocialNetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<Person> people;
    private List<Person> loggedInUsers;

    public SocialNetwork() {
        this.people = new ArrayList<>();
        this.loggedInUsers = new ArrayList<>();
    }
    public List<Person> getPeople() {
        return people;
    }
    public void setPeople(List<Person> people) {
        this.people = people;
    }
    public List<Person> getLoggedInUsers() {
        return loggedInUsers;
    }
    public void setLoggedInUsers(List<Person> loggedInUsers) {
        this.loggedInUsers = loggedInUsers;
    }
    public void addPerson(Person person){
        this.people.add(person);
    }
    public void addLoggedInUser(Person person){
        this.loggedInUsers.add(person);
    }
    public void removeLoggedInUser(Person person){this.loggedInUsers.remove(person);}
    public Person getRegisteredPersonByName(String name){
        for (Person person : people){
            if (person.getName().equals(name)) return person;
        }
        return new Person(name);
    }
    public boolean checkAlreadyRegistered(String name){
        for (Person person : people) {
            if (person.getName().equals(name)) return true;
        }
        return false;
    }
    public boolean checkAlreadyLoggedIn(String name){
        for (Person person : loggedInUsers) {
            if (person.getName().equals(name)) return true;
        }
        return false;
    }
}
