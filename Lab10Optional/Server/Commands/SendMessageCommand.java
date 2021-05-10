package Commands;

import SocialNetwork.*;

public class SendMessageCommand extends Command{
    public SendMessageCommand(SocialNetwork socialNetwork) {
        super(socialNetwork);
    }
    public String send(String user, String message){
        for (Person person : socialNetwork.getRegisteredPersonByName(user).getFriends()) {
            person.receiveMessage(socialNetwork.getRegisteredPersonByName(user), message);
        }
        return "Successfully sent the message to " + socialNetwork.getRegisteredPersonByName(user).getFriends().size() + " friends";
    }
}
