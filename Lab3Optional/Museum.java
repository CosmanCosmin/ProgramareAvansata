import java.time.LocalTime;

public class Museum extends Location implements Payable, Visitable{
    private int entryFee;
    private LocalTime openingHours;
    private LocalTime closingHours;
    public Museum(String name, int entryFee, LocalTime openingHours, LocalTime closingHours){
        super(name);
        this.entryFee = entryFee;
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
    public void setEntryFee(int entryFee) {
        this.entryFee = entryFee;
    }
    @Override
    public int getEntryFee() {
        return entryFee;
    }
    @Override
    public String toString() {
        return "Museum{" +
                "name=" + this.getName() +
                ", entryFee=" + entryFee +
                ", openingHours=" + openingHours +
                ", closingHours=" + closingHours +
                '}';
    }
}
