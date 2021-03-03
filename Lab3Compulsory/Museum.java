public class Museum extends Location implements Payable, Visitable{
    private int entryFee;
    private Time openingHours;
    private Time closingHours;
    public Museum(String name, int entryFee, Time openingHours, Time closingHours){
        super(name);
        this.entryFee = entryFee;
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
    @Override
    public void setEntryFee(int entryFee) {
        this.entryFee = entryFee;
    }
    @Override
    public int getEntryFee() {
        return entryFee;
    }
}
