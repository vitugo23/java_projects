/* 
This file is optional to edit and can be used for manual testing. 

Please be aware that manual testing does not affect the completion of your lab.
To ensure your lab is complete, you are required to run and pass the tests in the Testing tab.
*/

public class Main {

    /**
     * The entry point of the application.
     * 
     * This method calls manual testing methods.
     * 
     * @param args - Command line arguments (not used in this application)
     */
    public static void main(String[] args) {

        exercise1Testing();
        System.out.println();

        exercise2Testing();
        System.out.println();

        exercise3Testing();
        
    }

    /**
     * This method creates an IfStatements object and manually tests its exercise1() method by calling it several times and printing out the results.
     * 
     */
    public static void exercise1Testing() {

        IfStatements ifLab = new IfStatements();

        System.out.println("Given the values true, a=2, b=4, the method should return 2 and it returns the following: ");
        boolean bool1 = true;
        int a1 = 2;
        int b1 = 4;
        int output1 = ifLab.exercise1(bool1, a1, b1);
        System.out.println(output1);

        System.out.println("Given the values false, a=1, b=5, the method should return 5 and it returns the following: ");
        boolean bool2 = false;
        int a2 = 1;
        int b2 = 5;
        int output2 = ifLab.exercise1(bool2, a2, b2);
        System.out.println(output2);
    }

    /**
     * This method creates an IfStatements object and manually tests its exercise2() method by calling it several times and printing out the results.
     * 
     */
    public static void exercise2Testing() {
        IfStatements ifLab = new IfStatements();

        System.out.println("Given that x = 18, the lab should return \"Positive\" and it returns the following: ");
        int x = 18;
        String output = ifLab.exercise2(x);
        System.out.println(output);

        System.out.println("Given that x = -2, the lab should return \"Negative\" and it returns the following: ");
        x = -2;
        output = ifLab.exercise2(x);
        System.out.println(output);

        System.out.println("Given that x = 0, the lab should return \"Zero\" and it returns the following: ");
        x = 0;
        output = ifLab.exercise2(x);
        System.out.println(output);
    }

    /**
     * This method creates an IfStatements object and manually tests its exercise3() method by calling it several times and printing out the results.
     * 
     */
    public static void exercise3Testing() {
        IfStatements ifLab = new IfStatements();

        System.out.println("Given that year = 1983, the lab should return \"No\" and it returns the following: ");
        int year = 1983;
        String output = ifLab.exercise3(year);
        System.out.println(output);

        System.out.println("Given that year = 1800, the lab should return \"Not quite\" and it returns the following: ");
        year = 1800;
        output = ifLab.exercise3(year);
        System.out.println(output);

        System.out.println("Given that year = 1600, the lab should return \"Yes\" and it returns the following: ");
        year = 1600;
        output = ifLab.exercise3(year);
        System.out.println(output);

        System.out.println("Given that year = 1996, the lab should return \"Yes\" and it returns the following: ");
        year = 1996;
        output = ifLab.exercise3(year);
        System.out.println(output);
    }
}
