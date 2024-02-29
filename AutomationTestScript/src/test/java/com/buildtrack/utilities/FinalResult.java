package com.buildtrack.utilities;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Stream;

public class FinalResult {

    public static List<String[]> addScenarioIntoTable = new ArrayList<>();

    String[] header = {"Positive testCases", "Username", "Password", "Test Start-Time","Build track page","Dashboard page","account page","sign-out popup","Login page","Test End-Time"};

    private static List<Map<String, Object>> testScenarios = new ArrayList<>();


static String [][] loginNegativeTestCase  ;
    static String [][] loginPositiveTestCase  ;

    static public String[][] setHeaderForPositiveFlowUserLoginTestCase(){
        loginPositiveTestCase=  new String[1][9];

        loginPositiveTestCase[0][0] = "TestCases";
        loginPositiveTestCase[0][1] = "Username";
        loginPositiveTestCase[0][2] = "Password";
        loginPositiveTestCase[0][3] = "Test Start-Time";
        loginPositiveTestCase[0][4] = "Build Track loginpage";
        loginPositiveTestCase[0][5] = "invalid username/password msg";
        loginPositiveTestCase[0][6] = "username required error msg";
        loginPositiveTestCase[0][7] = "Password required error msg";
        loginPositiveTestCase[0][8] = "Test End-Time";



        return loginPositiveTestCase;

    }

    public static void addTestScenario(String s, String userNameOrEmail, String userPassword, String startTime, String loadTimeInSec, String loadTimeInSec1, String loadTimeInSec2, String loadTimeInSec3, String loadTimeInSec4, String endTime, String status, List<String[]> addEachPageTimeTaken) {
    }

    @Test
   public void test(){
    //   PrinttableWithLinesAndMaxWidth(setHeaderForNegativeFlowUserLoginTestCase());
    //   PrinttableWithLinesAndMaxWidth(setHeaderForPositiveFlowUserLoginTestCase());
// Example page load times for each scenario
       long loginPageLoadTime = 3000; // 3 seconds
       long homePageLoadTime = 5000; // 5 seconds
       long logoutPageLoadTime = 1000; // 1 second
      // addTestScenario("Positive testCases", "Username", "Password", "Test Start-Time","Build track page","Dashboard page","account page","sign-out popup","Login page","Test End-Time",addScenarioIntoTable);

        String[] header = {"Positive testCases", "Username", "Password", "Test Start-Time","Build track page","Dashboard page","account page","sign-out popup","Login page","Test End-Time"};

       addTestScenario("valid username/password", "saro", "Maxval", "10","2","3","5","6","Login page","Test End-Time",addScenarioIntoTable);


       PrinttableWithLinesAndMaxWidth(header,addScenarioIntoTable);
   }



   /* public  static void addTestScenario(String scenarioName,String username,String password, String StartTime, String Loginpage, String Homepage,String accountPage,String signOutPage,String AgainLoginPage,String TestEndTime,String Status, List<String[]> tableList) {
        // Create a String array for the test scenario
        String[] scenarioArray = new String[10];
        scenarioArray[0] = scenarioName;
        scenarioArray[1] =  username;
        scenarioArray[2] =password;
        scenarioArray[3] =  StartTime;
        scenarioArray[4] =Loginpage;
        scenarioArray[5] = Homepage;
        scenarioArray[6] = accountPage;
        scenarioArray[7] = signOutPage;
        scenarioArray[8] = AgainLoginPage;
        scenarioArray[9] = TestEndTime;
        // Add the scenario to the list
        tableList.add(scenarioArray);
    }*/
    public  static void addTestScenario(String scenarioName,String username,String password, String StartTime, String Loginpage, String errorpopup ,String usernaeAlertmsg,String passwordAlertMsg,String testendTime,String Status, List<String[]> tableList) {

        //"TestCases","Username","Password","Test Start-Time","Build Track loginpage","invalid username/password msg","username required error msg","Password required error msg","Password required error msg","Test End-Time","Status"
        // Create a String array for the test scenario
        String[] scenarioArray = new String[10];
        scenarioArray[0] = scenarioName;

        if(username.isEmpty()) {
            scenarioArray[1] = "Empty user name";
        }else{
            scenarioArray[1] =  username;
        }
        if(password.isEmpty()){
            scenarioArray[2]="Empty password";
        }else{
            scenarioArray[2]=password;
        }

        scenarioArray[3] =  (StartTime != null) ? StartTime : "-";
        scenarioArray[4] =  (Loginpage != null) ? Loginpage : "-";;



        if (errorpopup.isEmpty()){
            scenarioArray[5] = "-";
        }else {
            if(errorpopup.equals("0 ms")){
                scenarioArray[5] = "-";
            }else{
                scenarioArray[5]=errorpopup;
            }



        }
        if(usernaeAlertmsg.isEmpty()){
            scenarioArray[6] = "-";
        }else{
            if(usernaeAlertmsg.equals("0 ms")){
                scenarioArray[6] = "-";
            }else{
                scenarioArray[6]=usernaeAlertmsg;
            }


        }
        if(passwordAlertMsg.isEmpty()){
            scenarioArray[7] = "-";
        }else {
            if(passwordAlertMsg.equals("0 ms")){
                scenarioArray[7] = "-";
            }else{
                scenarioArray[7]=passwordAlertMsg;
            }


        }
        scenarioArray[8] = testendTime;
        scenarioArray[9] = Status;

        // Add the scenario to the list
        tableList.add(scenarioArray);
    }

    public  static void addTestScenario(String scenarioName, String username, String password, String StartTime, String Loginpage, String Homepage , String TestEndTime, String Status,String Reason ,List<String[]> tableList) {
        // Create a String array for the test scenario
        String[] scenarioArray = new String[9];
        scenarioArray[0] = scenarioName;

        scenarioArray[1] = (username != null) ? username : "Empty";
        scenarioArray[2] = (password != null) ? password : "Empty";
        scenarioArray[3] = (StartTime != null) ? StartTime : "-";
        scenarioArray[4] = (Loginpage != null) ? Loginpage : "-";
        scenarioArray[5] = (Homepage != null) ? Homepage : "-";
        scenarioArray[6] = (TestEndTime != null) ? TestEndTime : "-";
        scenarioArray[7] = (Status != null) ? Status : "-";
        scenarioArray[8] = Reason;

        // Add the scenario to the list
        tableList.add(scenarioArray);
    }
    public static void PrinttableWithLinesAndMaxWidth(String[] header , List<String[]> addScenarioIntoTable) {
        //a header

        addScenarioIntoTable.add(0,header);

        /*
         * leftJustifiedRows - If true, it will add "-" as a flag to format string to
         * make it left justified. Otherwise right justified.
         */
        boolean leftJustifiedRows = true;

        /*
         * Maximum allowed width. Line will be wrapped beyond this width.
         */
        int maxWidth = 30;

        /*
         * Table to print in console in 2-dimensional array. Each sub-array is a row.
         */


        /*
         * Create new table array with wrapped rows
         */
       // List<String[]> tableList = new ArrayList<>(Arrays.asList(table));
        List<String[]> finalTableList = new ArrayList<>();
        for (String[] row : addScenarioIntoTable) {
            // If any cell data is more than max width, then it will need extra row.
            boolean needExtraRow = false;
            // Count of extra split row.
            int splitRow = 0;
            do {
                needExtraRow = false;
                String[] newRow = new String[row.length];
                for (int i = 0; i < row.length; i++) {
                    // If data is less than max width, use that as it is.
                    if (row[i].length() < maxWidth) {
                        newRow[i] = splitRow == 0 ? row[i] : "";
                    } else if ((row[i].length() > (splitRow * maxWidth))) {
                        // If data is more than max width, then crop data at maxwidth.
                        // Remaining cropped data will be part of next row.
                       /* int end = (row[i] != null && row[i].length() > ((splitRow * maxWidth) + maxWidth))
                                ? (splitRow * maxWidth) + maxWidth
                                : (row[i] != null) ? row[i].length() : 0;*/
                        int end = row[i].length() > ((splitRow * maxWidth) + maxWidth)
                                ? (splitRow * maxWidth) + maxWidth
                                : row[i].length();
                        newRow[i] = row[i].substring((splitRow * maxWidth), end);
                        needExtraRow = true;
                    } else {
                        newRow[i] = "";
                    }
                }
                finalTableList.add(newRow);
                if (needExtraRow) {
                    splitRow++;
                }
            } while (needExtraRow);
        }
        String[][] finalTable = new String[finalTableList.size()][finalTableList.get(0).length];
        for (int i = 0; i < finalTable.length; i++) {
            finalTable[i] = finalTableList.get(i);
        }

        /*
         * Calculate appropriate Length of each column by looking at width of data in
         * each column.
         *
         * Map columnLengths is <column_number, column_length>
         */

        Map<Integer, Integer> columnLengths = new HashMap<>();
        Arrays.stream(finalTable).forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
            if (columnLengths.get(i) == null) {
                columnLengths.put(i, 0);
            }
            if (columnLengths.get(i) < a[i].length()) {
                columnLengths.put(i, a[i].length());
            }
        }));
      //  System.out.println("columnLengths = " + columnLengths);

        /*
         * Prepare format String
         */
        final StringBuilder formatString = new StringBuilder("");
        String flag = leftJustifiedRows ? "-" : "";
        columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
        formatString.append("|\n");

        //System.out.println("formatString = " + formatString.toString());

        /*
         * Prepare line for top, bottom & below header row.
         */
        String line = columnLengths.entrySet().stream().reduce("", (ln, b) -> {
            String templn = "+-";
            templn = templn + Stream.iterate(0, (i -> i < b.getValue()), (i -> ++i)).reduce("", (ln1, b1) -> ln1 + "-",
                    (a1, b1) -> a1 + b1);
            templn = templn + "-";
            return ln + templn;
        }, (a, b) -> a + b);
        line = line + "+\n";

       // System.out.println("Line = " + line);

        /*
         * Print table
         */
        System.out.print(line);
        Arrays.stream(finalTable).limit(1).forEach(a -> System.out.printf(formatString.toString(), a));
        System.out.print(line);

        Stream.iterate(1, (i -> i < finalTable.length), (i -> ++i))
                .forEach(a -> System.out.printf(formatString.toString(), finalTable[a]));
        System.out.print(line);
    }



}
