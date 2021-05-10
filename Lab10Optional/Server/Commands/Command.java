package Commands;

import SocialNetwork.SocialNetwork;

public abstract class Command {
    protected final SocialNetwork socialNetwork;
    public Command(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }
}
