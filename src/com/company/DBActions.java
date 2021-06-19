package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DBActions {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/sampledb";
    private final String DBuserName = "root";
    private final String DBpassword = "";

    Scanner scan = new Scanner(System.in);


    public void getPatientInfo(){
        System.out.print("\nEnter new patient name? ");
        String name = scan.nextLine();

        System.out.print("Enter new user name? ");
        String username = scan.nextLine();

        System.out.print("Enter new password? ");
        String password = scan.nextLine();

        insert(name,username,password);

    }

    public void insert(String name, String username,String password){
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
            }

            connection.close();

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }


}
