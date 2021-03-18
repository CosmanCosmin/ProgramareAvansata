package Commands;

import Base.Catalog;

public class ListCommand extends Command{
    public ListCommand(Catalog catalog) {
        System.out.println(catalog);
    }
}
