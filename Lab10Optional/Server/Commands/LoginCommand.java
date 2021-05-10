package Commands;

import SocialNetwork.*;

public class LoginCommand extends Command{
    public LoginCommand(SocialNetwork socialNetwork) {
        super(socialNetwork);
    }
    public String login(String name){
        if (name.equals("")) return "Name cannot be empty.";
        if (!socialNetwork.checkAlreadyRegistered(name)) return "No person registered with this name.";
        if (socialNetwork.checkAlreadyLoggedIn(name)) return "You are already logged in.";

        socialNetwork.addLoggedInUser(socialNetwork.getRegisteredPersonByName(name));
        return "Successfully logged in as " + name;
    }
}
