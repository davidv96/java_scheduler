import java.util.ArrayList;

/**
 * Created by David on 4/26/16.
 */
public class generateShifts {

        static ArrayList<employee> all = new ArrayList<>();


        employee miriam_j = new employee("Miriam", "Jaber", 28);
        employee david_v = new employee("DAVID", "VELASQUEZ",28);
        employee gusty_c = new employee("Ian", "Brown", 28);
        employee amber_r = new employee("Christine", "Mears", 28);
        employee anne_s = new employee("Summer", "Rivera", 28);
        employee carl_m = new employee("Alyssa", "Winegarden",28);
        employee carl_j = new employee("Carl", "Jones", 28);
        employee john_g = new employee("John", "Gaffner", 28);
        employee lindsay_s = new employee("Lindsay", "Sorto", 0);


        public generateShifts(){
        }

        static day [] schedule = new day[7];

        void filling() {

            day monday = new day("Monday",2,4);
            day tuesday = new day("Tuesday",2,4);
            day wednesday = new day("Wednesday",2,4);
            day thursday = new day("Thursday",2,4);
            day friday = new day("Friday",3,5);
            day saturday = new day("Saturday",3,6);
            day sunday = new day("Sunday",3,6);


            monday.shiftsHours = new double[]{7, 6.5};
            tuesday.shiftsHours = new double[]{7, 6.5};
            wednesday.shiftsHours = new double[]{7, 6.5};
            thursday.shiftsHours = new double[]{7, 6.5};
            friday.shiftsHours = new double[]{7,7,6.5};
            saturday.shiftsHours = new double[]{7,7,6.5};
            sunday.shiftsHours = new double[]{7,7,6.5};



            schedule[2] = monday;
            schedule[3] = tuesday;
            schedule[4] = wednesday;
            schedule[5] = thursday;
            schedule[6] = friday;
            schedule[0] = saturday;
            schedule[1] = sunday;














            all.add(david_v);
            all.add(miriam_j);
            all.add(gusty_c);
            all.add(amber_r);
            all.add(anne_s);
            all.add(carl_j);
            all.add(carl_m);
            all.add(john_g);


            all.forEach(employee::alwaysAvailabile);
        }
    void populate() {

        for (day d: schedule) {
            populateDay(d);

        }
    }
    void getAll() {
        for(employee e: all){
            System.out.println(e.firstName + " " + e.lastName);
        }
    }



    void populateDay(day day){
        int num = 0;
        switch (day.name){
            case "Monday":
                num = 0;
                break;
            case "Tuesday":
                num = 1;
                break;
            case "Wednesday":
                num = 2;
                break;
            case "Thursday":
                num = 3;
                break;
            case "Friday":
                num = 4;
                break;
            case "Saturday":
                num = 5;
                break;
            case "Sunday":
                num = 6;
                break;

        }






        for(int i = 0; i< day.dayShift.length; i++){
            ArrayList<employee> stillAvailable = new ArrayList<>();
            for(employee e: all){
                if(e.availability[num][i] == true && LinearSearch(day,e) == -1
                        && e.hoursWorked != e.maxHours){
                    stillAvailable.add(e);
                }
            }
            for (int j = 0; j<day.dayShift[i].length; j++){


                employee pick = null;
                if(stillAvailable.size() >0) pick = stillAvailable.get((int)(Math.random() * stillAvailable.size()));
                else pick = new employee("NEED", "EMPLOYEE",100);

                day.dayShift[i][j]= pick;
                stillAvailable.remove(pick);
                pick.hoursWorked += day.shiftsHours[i];

                if(pick.firstName.equals("Lindsay")){
                    stillAvailable.remove(david_v);
                }

                if(pick.firstName.equals("Miriam")){
                    stillAvailable.remove(david_v);
                    stillAvailable.remove(lindsay_s);
                }

                if(pick.firstName.equals("David")){
                    stillAvailable.remove(miriam_j);
                    stillAvailable.remove(lindsay_s);
                }
            }
            stillAvailable.clear();
            }
        }


    String displayShifts() {
        String retString = "";
        for (int i = 0; i < schedule.length; i++) {
            retString += schedule[i];
        }

        return retString;
    }

    public static int LinearSearch(day day, employee ele) {
        for (int j = 0; j < day.dayShift.length; j++) {
            for (int f = 0; f < day.dayShift[j].length; f++) {
                if (day.dayShift[j][f] == ele) {
                    return 0;
                }
            }
        }
        return -1;
    }

}



