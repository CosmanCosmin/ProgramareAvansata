package Commands;

import Base.Catalog;
import Multimedia.Multimedia;

public class AddCommand extends Command{
    public AddCommand(Catalog catalog, Multimedia item) {
        catalog.getItems().add(item);
    }
}
