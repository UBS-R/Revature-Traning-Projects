package studentFiles;

import loginFiles.login;
import redirectFiles.redirectToAvailableFunctions;
import reusableDataFunctions.defaultDataFunctions;
import loginFiles.login.*;

import java.sql.*;

public class studentQueryImplement extends studentAccess {

    public static Statement tempStatement; //--> Statement to store temporary
    public static ResultSet tempResultSet; //--> ResultSet to store temporary
    public static String tempQuery;
    public static int tempSize;

    redirectToAvailableFunctions redirectToAvailableFunctions = new redirectToAvailableFunctions();
    defaultDataFunctions defaultDataFunctions = new defaultDataFunctions();
    loginFiles.login login = new login();

    public void queryVariation1() {

        System.out.print("    Enter your ID --» ");
        int tempQueryValue = s.nextInt();
        System.out.println();

        try {
            defaultDataFunctions.connectionsForStudent();
            tempQuery = studentAccess.executeCurrentQuery;
            ResultSet result = tempStatement.executeQuery(tempQuery + tempQueryValue);
            tempResultSet = result;

            defaultDataFunctions.findColumnSizeForStudent();

            if (executeCurrentQuery.equals(queryType3)) {
                System.out.println("    ID of " + tempQueryValue + " is ↓ ");
            } else
                System.out.println("    Room and Bench number of " + tempQueryValue + " is ↓");

            defaultDataFunctions.printQueryforStudent();

            redirectToAvailableFunctions.forStudent();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void queryVariation2() {

        System.out.print("    Enter your name --» ");
        String tempQueryValue = s.nextLine();
        System.out.println();

        try {
            defaultDataFunctions.connectionsForStudent();
            tempQuery = studentAccess.executeCurrentQuery;
            ResultSet result = tempStatement.executeQuery(tempQuery + "\"" + tempQueryValue + "\"");
            tempResultSet = result;

            defaultDataFunctions.findColumnSizeForStudent();

            if (executeCurrentQuery.equals(queryType3)) {
                System.out.println("    ID of " + tempQueryValue + " is ↓ ");
            } else
                System.out.println("    Room and Bench number of " + tempQueryValue + " is ↓");

            defaultDataFunctions.printQueryforStudent();

            redirectToAvailableFunctions.forStudent();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static String username;
    public void queryVariation3() {
        System.out.print("    Enter your old password --» ");
        String tempQueryOldPassword = s.nextLine();
        System.out.println();

        try {
            defaultDataFunctions.loginDatabaseConnection();
            String queryCheck = "SELECT user_password FROM LoginDataOfStudent WHERE user_name = " + "'"+username +"'";
            ResultSet result = loginFiles.login.tempStatement.executeQuery(queryCheck);

            if (result.next()){
                if (result.getString("user_password").equals(tempQueryOldPassword)){
                    System.out.print("    Enter your new password --» ");
                    String tempQueryNewPassword = s.nextLine();

                    defaultDataFunctions.loginDatabaseConnection();
                    ResultSet resultSet = tempStatement.executeQuery("SELECT count from LoginDataOfStudent WHERE user_name = "
                            +"'"+username+"'");
                    if (resultSet.next()){
                        int id = result.getInt("count");
                        System.out.println(id);
                    }
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginData", "root", "SQLpassword");
                    PreparedStatement preparedStatement = con.prepareStatement("UPDATE LoginDataOfStudent " +
                            "set user_password = ? WHERE user_name = ?");

                    preparedStatement.setString(1,"'"+tempQueryNewPassword+"'");
                    preparedStatement.setString(2,"'"+ username + "'");

                    preparedStatement.executeUpdate();

                    System.out.println("\r\n"+ " • ** Your password updated successfully ** •");

                    redirectToAvailableFunctions.forStudent();
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }


    }

}
