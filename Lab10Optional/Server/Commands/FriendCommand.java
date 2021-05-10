package Commands;

import SocialNetwork.SocialNetwork;

public class FriendCommand extends Command{
    public FriendCommand(SocialNetwork socialNetwork) {
        super(socialNetwork);
    }
    public String friend(String user, String[] friends){
        StringBuilder result = new StringBuilder();
        for (String name : friends) {
            result.append(friendEachUser(user, name));
        }
        return result.toString();
    }
    private String friendEachUser(String user, String friend){
        if (!socialNetwork.checkAlreadyRegistered(friend)) return friend + "isn't a registered user. ";
        if (user.equals(friend)) return "You can't add yourself as a friend. ";
        socialNetwork.getRegisteredPersonByName(user).addFriend(socialNetwork.getRegisteredPersonByName(friend));
        return "Successfully added " + friend + " as a friend";
    }
}
