import javax.print.attribute.standard.NumberOfInterveningJobs;
import javax.swing.text.html.StyleSheet.ListPainter;

// import sun.security.krb5.internal.ktab.KeyTabInputStream;

/*************************************************************************
 *  Compilation:  javac HeartTransplant.java
 *  Execution:    java HeartTransplant < data.txt
 *
 *  @author:
 *
 *************************************************************************/

public class HeartTransplant {

    /* ------ Instance variables  -------- */

    // Person array, each Person is read from the data file
    private Person[] listOfPatients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge[] survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause[] survivabilityByCause;

    /* ------ Constructor  -------- */
    
    /*
     * Initializes all instance variables to null.
     */
    public HeartTransplant() {
        listOfPatients = null;
        survivabilityByAge = null;
        survivabilityByCause = null;
    }

    /* ------ Methods  -------- */

    /*
     * Inserts Person p into listOfPatients
     * 
     * Returns:  0 if successfully inserts p into array, 
     *          -1 if there is not enough space to insert p into array
     */
    public int addPerson(Person p, int arrayIndex) {
        if(listOfPatients[arrayIndex] != null)
            return -1;

        else
            listOfPatients[arrayIndex] = p;

        return 0;
    }

    /*
     * 1) Creates the listOfPatients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file.
     *    File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health
     *    Each line refers to one Person.
     * 
     * 3) Inserts each person from file into listOfPatients
     *    Hint: uses addPerson() method
     * 
     * Returns the number of patients read from file
     */
    public int readPersonsFromFile(int numberOfLines) {
        listOfPatients = new Person[numberOfLines];

        for(int i = 0; i < numberOfLines; i++){
            int ID = StdIn.readInt();
            int ethinicity = StdIn.readInt();
            int gender = StdIn.readInt();
            int age = StdIn.readInt();
            int cause = StdIn.readInt();
            int urgency = StdIn.readInt();
            int soh = StdIn.readInt();

            Person p = new Person(ID, ethinicity, gender, age, cause, urgency, soh);
            
            addPerson(p, i);
        }

        return numberOfLines;
    }

    /*
     * 1) Creates the survivabilityByAge array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     * 3) Inserts each rate from file into the survivabilityByAge array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {
        survivabilityByAge = new SurvivabilityByAge[numberOfLines];


        for(int i = 0; i < numberOfLines; i++){
            int age = StdIn.readInt();
            int years = StdIn.readInt();
            double rate = StdIn.readDouble();

            SurvivabilityByAge s = new SurvivabilityByAge(age, years, rate);

            survivabilityByAge[i] = s;
        }

        return numberOfLines;
    }

    /*
     * 1) Creates the survivabilityByCause array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     * 3) Inserts each rate from file into the survivabilityByCause array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {
        survivabilityByCause = new SurvivabilityByCause[numberOfLines];

        for(int i = 0; i < numberOfLines; i++){
            int cause = StdIn.readInt();
            int years = StdIn.readInt();
            double rate = StdIn.readDouble(); 

            SurvivabilityByCause s = new SurvivabilityByCause(cause, years, rate);

            survivabilityByCause[i] = s;
        }

        return numberOfLines;
    }
    
    /*
     * Returns listOfPatients
     */
    public Person[] getListOfPatients() {
        return listOfPatients;
    } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge[] getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause[] getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * Returns a Person array in which with every Person that has 
     * age above the parameter age from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with age above the parameter age.
     * 
     * Return null if there is no Person with age above the 
     * parameter age.
     */ 
    public Person[] getPatientsWithAgeAbove(int age) {
        int c = 0;
        Person[] ageAbove = new Person[listOfPatients.length];

        for(Person p : listOfPatients){
            if(age < p.getAge()){
                ageAbove[c] = p;
                c++;
            }
        }

        Person[] ageAboveTrimmed = new Person[c];
        for(int i = 0; i < c; i++)
            ageAboveTrimmed[i] = ageAbove[i];
        

        if(c == 0)
            return null;

        else
            return ageAboveTrimmed;
    }
    
    /*
     * Returns a Person array with every Person that has the state of health 
     * equal to the parameter state from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the state of health equal to the parameter state.
     * 
     * Return null if there is no Person with the state of health 
     * equal to the parameter state.
     */ 
    public Person[] getPatientsByStateOfHealth(int state) {
        int c = 0;
        Person[] stateofHealth = new Person[listOfPatients.length];

        for(Person p : listOfPatients){
            if(state == p.getStateOfHealth()){
                stateofHealth[c] = p;
                c++;
            }
        }

        Person[] stateTrimmed = new Person[c];
        for(int i = 0; i < c; i++)
            stateTrimmed[i] = stateofHealth[i];
        
        if(c == 0)
            return null;

        else
            return stateTrimmed;
    }

    /*
     * Returns a Person array with every person that has the heart 
     * condition cause equal to the parameter cause from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Person with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Person[] getPatientsByHeartConditionCause(int cause) {
        int c = 0;
        Person[] patientCause = new Person[listOfPatients.length];

        for(Person p : listOfPatients){
            if(cause == p.getCause()){
                patientCause[c] = p;
                c++;
            }
        }

        Person[] pCTrimmed = new Person[c];
        for(int i = 0; i < c; i++)
            pCTrimmed[i] = patientCause[i];
        
        if(c == 0)
            return null;

        else
            return pCTrimmed;
    }

    /*
     * Assume there are numberOfHearts available for transplantation surgery.
     * Also assume that the hearts are of the same blood type as the
     * persons on the listOfPatients.
     * This method finds a set of persons to be the recepients of these
     * hearts.
     * 
     * The method returns a Person array from the listOfPatients
     * array that have the highest potential for survivability after
     * the transplant. The array size is numberOfHearts.
     * 
     * If numberOfHeartsAvailable is greater than listOfPatients
     * array size all Persons will receive a transplant.
     * 
     * If numberOfHeartsAvailable is smaller than listOfPatients
     * array size find the set of people with the highest
     * potential for survivability.
     * 
     * There is no correct solution, you may come up with any set of
     * persons from the listOfPatients array.
     */ 
    public Person[] match(int numberOfHearts) {
        if(numberOfHearts >= listOfPatients.length)
            return listOfPatients;

        else{
            Person[] pTRH = new Person[numberOfHearts]; //patients to receive heart

            int counter = 0;
            for(SurvivabilityByAge s : survivabilityByAge){
                if(counter == numberOfHearts - 1)
                    break;

                for(Person p : listOfPatients){
                    if(counter == numberOfHearts)
                        break;
                    if(s.getYears() == 1){
                            pTRH[counter] = p;
                        counter++;
                    }
                }
            }


            return pTRH;
        }
    }

    /*
     * Client to test the methods you write
     */
    public static void main (String[] args) {

        HeartTransplant ht = new HeartTransplant();
        System.out.println();

        // read persons from file
        int numberOfLines = StdIn.readInt();
        int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
        // StdOut.println(numberOfReadings + " patients read from file.");
 
        // read survivability by age from file
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
        // StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

        // read survivability by heart condition cause from file        
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
        // StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

        // list all patients
        // for (Person p : ht.getListOfPatients()) {
        //     StdOut.println(p);
        // }

        // System.out.println();
        
        // //getPatientsWithAgeAbove check
        // for(Person p : ht.getPatientsWithAgeAbove(70))
        //     StdOut.println(p.getAge());

        // System.out.println();
        
        // //getPatientsByStateOfHealth check
        // for(Person p : ht.getPatientsByStateOfHealth(6))
        //     StdOut.println(p.getStateOfHealth());

        // System.out.println();

        // //getPatientsByHeartConditionCause check
        // for(Person p : ht.getPatientsByHeartConditionCause(3))
        //     StdOut.println(p.getCause());

        // System.out.println();

        // // list survivability by age rates
        // for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
        //     StdOut.println(rate);
        // }

        // System.out.println();

        // // list survivability by cause rates
        // for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
        //     StdOut.println(rate);
        // }

        // System.out.println();
        // System.out.println();
        // System.out.println();

        //match check
        for(Person p : ht.match(10))
            StdOut.println(p);

    }
}
