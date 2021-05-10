package Commands;

import SocialNetwork.*;

import java.util.Map;

public class ReadMessagesCommand extends Command{
    public ReadMessagesCommand(SocialNetwork socialNetwork) {
        super(socialNetwork);
    }
    public String read(String user){
        StringBuilder messages = new StringBuilder();
        for (Map.Entry<Person, String> entry : socialNetwork.getRegisteredPersonByName(user).getReceivedMessages().entrySet()) {
            messages.append(entry.getKey().getName()).append(" said ").append(entry.getValue()).append(". ");
        }
        messages.append(" Successfully read messages from friends");
        return messages.toString();
    }
}
