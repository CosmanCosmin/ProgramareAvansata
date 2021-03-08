import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    void setOpeningHours(LocalTime openingHours);
    /**
     * returns the default opening hours if the method isn't overridden in the
     * class that implements this interface
     * @return the default opening hours
     */
    default LocalTime getOpeningHours(){
        return LocalTime.of(9, 30);
    }
    void setClosingHours(LocalTime closingHours);
    /**
     * returns the default closing hours if the method isn't overridden in the
     * class that implements this interface
     * @return the default closing hour
     */
    default LocalTime getClosingHours(){
        return LocalTime.of(20, 0);
    }
    /**
     * calculates and returns the time that a Visitable object is opened during a day as a Duration object
     * @param o the Visitable object
     * @return the time that the object is opened for
     */
    static Duration getVisitingDuration(Visitable o){
        return Duration.between(o.getOpeningHours(), o.getClosingHours());
    }
}
