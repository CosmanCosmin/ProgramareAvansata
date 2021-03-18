package Base;

import Multimedia.Multimedia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable{
    private List<Multimedia> items;
    public Catalog() {
        this.items = new ArrayList<Multimedia>();
    }
    public List<Multimedia> getItems() {
        return items;
    }
    public void setItems(List<Multimedia> items) {
        this.items = items;
    }
    @Override
    public String toString() {
        return "Catalog{" +
                "items=" + items +
                '}';
    }
}
