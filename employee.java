/**
 * Created by David on 4/7/16.
 */
public class employee {
    String firstName = null;
    String lastName = null;
    int maxHours = 0;
    int hoursWorked = 0;
    final int shifts = 3;
    final int days = 7;
    boolean speaksSpanish = false;
    boolean[][] availability = new boolean[days][shifts];

    public employee(String firstName, String lastName, int maxHours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.maxHours = maxHours;
        this.availability = new boolean[days][shifts];
        speaksSpanish = false;
    }

    void setAvailability(boolean [][] newAvail) {
        for(int i = 0; i < availability.length; i++){
            for(int j = 0; j< availability[i].length; j++){
                availability[i][j] = newAvail[i][j];
            }
        }
    }

    void alwaysAvailabile() {
        for (int i = 0; i < availability.length; i++) {
            for (int j = 0; j < availability[i].length; j++) {
                availability[i][j] = true;
            }
        }
    }

    void setMaxHours(int newMax) {
        this.maxHours = newMax;
    }

    void biLingual() {
        speaksSpanish = true;
    }


    @Override
    public String toString() {
        return firstName + " " + lastName + "\n"
                + getAvail();
    }

    public String getAvail() {
        String avail = "";
        for (int i = 0; i <availability.length; i++){
            for(int j = 0; j <availability[i].length; j++){
                avail += String.format("%s ", availability[i][j]);
            }
            avail += "\n";
        }

        return avail;
    }
}
