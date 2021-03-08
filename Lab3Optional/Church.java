import java.time.LocalTime;

public class Church extends Location implements Visitable{
    private LocalTime openingHours;
    private LocalTime closingHours;
    public Church(String name, LocalTime openingHours, LocalTime closingHours){
        super(name);
        this.openingHours = openingHours;
        this.closingHours = closingHours;
    }
    @Override
    public void setOpeningHours(LocalTime openingHours) {
        this.openingHours = openingHours;
    }
    @Override
    public LocalTime getOpeningHours() {
        return openingHours;
    }
    @Override
    public void setClosingHours(LocalTime closingHours) {
        this.closingHours = closingHours;
    }
    @Override
    public LocalTime getClosingHours() {
        return closingHours;
    }
    @Override
    public String toString() {
        return "Church{" +
                "name=" + this.getName() +
                ", openingHours=" + openingHours +
                ", closingHours=" + closingHours +
                '}';
    }
}
