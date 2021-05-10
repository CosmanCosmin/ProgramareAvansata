package Commands;

import SocialNetwork.*;

public class RegisterCommand extends Command{
    public RegisterCommand(SocialNetwork socialNetwork) {
        super(socialNetwork);
    }
    public String register(String name){
        // check if the name is empty or already in the list of registered users
        if (name.equals("")) return "Name cannot be empty.";
        if (this.socialNetwork.checkAlreadyRegistered(name)) return "This name is already taken.";
        // create a new person and add it to the network
        this.socialNetwork.addPerson(new Person(name));
        return "Successfully registered with the name " + name;
    }
}
