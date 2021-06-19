package com.company;

import java.sql.*;
import java.util.Scanner;

public class Staff extends Admin{
    private final String jdbcURL = "jdbc:mysql://localhost:3306/sampledb";
    private final String DBuserName = "root";
    private final String DBpassword = "";

    Scanner scan = new Scanner(System.in);

    public void staffLoginValidate(){

        try {
            Connection connection = DriverManager.getConnection(jdbcURL,DBuserName,DBpassword);

            System.out.print("Enter username? ");
            String username = scan.nextLine();

            System.out.print("Enter password? ");
            String password = scan.nextLine();

            String sql = "SELECT * FROM staff WHERE username='"+username+"'AND password='"+password+"'";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if(result.next()) {
                MainMenu menu = new MainMenu();
                menu.staff();
            }else {
                System.out.println("\nInvalid input, Try again!");
                MainMenu menu = new MainMenu();
                menu.mainMenu();
            }

            connection.close();

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
