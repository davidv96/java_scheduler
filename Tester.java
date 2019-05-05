import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by David on 4/7/16.
 */
public class Tester {
    public static void main(String[] args) {

        generateShifts makeIt = new generateShifts();
        makeIt.filling();

        boolean[][] davidAvail ={{true,true,true},{true,true,true},{true,true,true},{true,true,true},
                {true,true,true},{true,true,true},{true,true,true}};
        makeIt.david_v.setAvailability(davidAvail);
        System.out.println(makeIt.david_v);
        makeIt.populate();

        System.out.print(makeIt.displayShifts());

        System.out.println("David's hrs worked are: " + makeIt.david_v.hoursWorked);
        System.out.println("We have a total of " + makeIt.all.size() + " employees in this example.");
    }
}