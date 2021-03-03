public class Church extends Location implements Visitable{
    private Time openingHours;
    private Time closingHours;
    public Church(String name, Time openingHours, Time closingHours){
        super(name);
        this.openingHours = openingHours;
        this.closingHours = closingHours;
    }
    @Override
    public void setOpeningHours(Time openingHours) {
        this.openingHours = openingHours;
    }
    @Override
    public Time getOpeningHours() {
        return openingHours;
    }
    @Override
    public void setClosingHours(Time closingHours) {
        this.closingHours = closingHours;
    }
    @Override
    public Time getClosingHours() {
        return closingHours;
    }
}
