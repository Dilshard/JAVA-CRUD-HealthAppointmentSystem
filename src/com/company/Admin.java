package com.company;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class Admin {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/sampledb";
    private final String DBuserName = "root";
    private final String DBpassword = "";

    Scanner scan = new Scanner(System.in);

    public void adminLoginValidate(){

        try {
            Connection connection = DriverManager.getConnection(jdbcURL,DBuserName,DBpassword);

            System.out.print("Enter username? ");
            String username = scan.nextLine();

            System.out.print("Enter password? ");
            String password = scan.nextLine();

            String sql = "SELECT * FROM admin WHERE username='"+username+"'AND password='"+password+"'";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if(result.next()) {
                MainMenu menu = new MainMenu();
                menu.admin();
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

    public void getPatientInfo(){
        System.out.print("\nEnter new patient name? ");
        String name = scan.nextLine();

        System.out.print("Enter new user name? ");
        String username = scan.nextLine();

        System.out.print("Enter new password? ");
        String password = scan.nextLine();

        createPatient(name,username,password);

    }

    public void createPatient(String name, String username,String password){
        try {

            Connection connection = DriverManager.getConnection(jdbcURL,DBuserName,DBpassword);

            String sql = "INSERT INTO patient(name,username,password)"
                    + "VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,username);
            statement.setString(3,password);

            int rows = statement.executeUpdate();

            if(rows > 0) {
                System.out.println("\nNew Patient has been inserted successfully!");
                MainMenu menu = new MainMenu();
                menu.admin();
            }

            connection.close();

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void PatientList(){

        try {

            Connection connection = DriverManager.getConnection(jdbcURL,DBuserName,DBpassword);

            String sql = "SELECT * FROM patient";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                int userID = result.getInt("id");
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("\nUser ID: "+userID+"\nUser Name: "+username+"\nPassword : "+password);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public void getStaffInfo(){
        System.out.print("\nEnter new Staff name? ");
        String name = scan.nextLine();

        System.out.print("Enter new user name? ");
        String username = scan.nextLine();

        System.out.print("Enter new password? ");
        String password = scan.nextLine();

        createStaff(name,username,password);

    }

    public void createStaff(String name, String username,String password){
        try {

            Connection connection = DriverManager.getConnection(jdbcURL,DBuserName,DBpassword);

            String sql = "INSERT INTO staff(name,username,password)"
                    + "VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,username);
            statement.setString(3,password);

            int rows = statement.executeUpdate();

            if(rows > 0) {
                System.out.println("\nNew Staff has been inserted successfully!");
                MainMenu menu = new MainMenu();
                menu.admin();
            }

            connection.close();

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void StaffList(){

        try {

            Connection connection = DriverManager.getConnection(jdbcURL,DBuserName,DBpassword);

            String sql = "SELECT * FROM staff";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                int userID = result.getInt("id");
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("\nUser ID: "+userID+"\nUser Name: "+username+"\nPassword : "+password);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }



}
