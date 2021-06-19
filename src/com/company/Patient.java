package com.company;

import java.sql.*;
import java.util.Scanner;

public class Patient {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/sampledb";
    private final String DBuserName = "root";
    private final String DBpassword = "";

    private int selectedID;

    Scanner scan = new Scanner(System.in);

    public void patientLoginValidate(){

        try {
            Connection connection = DriverManager.getConnection(jdbcURL,DBuserName,DBpassword);

            System.out.print("Enter username? ");
            String username = scan.nextLine();

            System.out.print("Enter password? ");
            String password = scan.nextLine();

            String sql = "SELECT * FROM patient WHERE username='"+username+"'AND password='"+password+"'";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);


            if(result.next()) {
                MainMenu menu = new MainMenu();
                menu.patient();
            }else {
                System.out.println("\nInvalid input, Try again!");
            }

            while (result.next()){
//                selectedID = result.getInt("id");
                selectedID =2;
            }

            connection.close();

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public void SpecificPatient(){
        selectSpecificPatient(selectedID);
    }



    public void selectSpecificPatient(int id){

        try {

            Connection connection = DriverManager.getConnection(jdbcURL,DBuserName,DBpassword);

            String sql = "SELECT * FROM patient WHERE id='"+id+"'";

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
