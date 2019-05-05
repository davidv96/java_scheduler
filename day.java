/**
 * Created by David on 4/9/16.
 */
public class day {
    String name = "";
    int shifts = 0;
    int min = 0;
    public double[] shiftsHours;

    public day(String day, int shifts, int min) {
        this.name = day;
        this.shifts = shifts;
        this.min = min;
        this.dayShift = new employee[shifts][min];
    }


    void setDay(int shifts, int min){
        this.shifts =shifts;
        this.min = min;
    }
    employee[][] dayShift = new employee[shifts][min];

    String getNames() {
        String names = "";
        for (int i = 0; i<shifts; i++){
            names += displayShift(i) + "\n";
        }
        return names;
    }
    @Override
    public String toString() {
        return "\n" + name + ": " + "\n" + getNames();


    }


    /**
     *  "Open: " + displayShift(0) + "\n" +

     "Mid: " + displayShift(1) + "\n" +

     "Close: " + displayShift(2) + "\n";
     */


    String displayShift(int shift) {
        String retString = " ";

        for (int i = 0; i < dayShift[shift].length; i ++){
            retString += dayShift[shift][i].firstName + " "  + dayShift[shift][i].lastName + ", ";
        }

        return retString;
    }

}