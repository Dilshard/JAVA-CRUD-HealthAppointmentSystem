package com.company;

import java.util.Scanner;

public class MainMenu {
    Scanner scan = new Scanner(System.in);

    public void mainMenu(){

        System.out.println("1. Admin");
        System.out.println("2. Staff");
        System.out.println("3. Patient");
        System.out.print("\nSelect the type of the user? ");

        int selection = scan.nextInt();

        if(selection == 1){
            Admin admin = new Admin();
            admin.adminLoginValidate();
        }else if(selection == 2){
            Staff staff = new Staff();
            staff.staffLoginValidate();
        }else if(selection == 3){
            Patient patient = new Patient();
            patient.patientLoginValidate();
        }else {
            System.out.println("\nWrong selection, Please select again!");
        }

    }

    public void admin(){

        System.out.println("\nLogged as Administrator!");

        System.out.println("1. Create new Staff");
        System.out.println("2. Create new Patient");
        System.out.println("3. View Registered Staff list");
        System.out.println("4. View Registered Patient list");
        System.out.print("Pick a number of action from above list? ");

        int selection = scan.nextInt();

        if(selection == 1){
            Admin admin = new Admin();
            admin.getStaffInfo();
        }else if(selection == 2){
            Admin admin = new Admin();
            admin.getPatientInfo();
        }else if(selection == 3){
            Admin admin = new Admin();
            admin.StaffList();
        }else if(selection == 4){
            Admin admin = new Admin();
            admin.PatientList();
        }else {
            System.out.println("\nWrong selection, Please select again!");
        }
    }

    public void staff(){
        System.out.println("\nLogged as Staff!");

        System.out.println("1. Create new Patient");
        System.out.println("2. View Registered Patient list");
        System.out.print("Pick a number of action from above list? ");

        int selection = scan.nextInt();

        if(selection == 1){
            Staff staff = new Staff();
            staff.getPatientInfo();
        }else if(selection == 2){
            Staff staff = new Staff();
            staff.PatientList();
        }else {
            System.out.println("\nWrong selection, Please select again!");
        }

    }

    public void patient(){
        System.out.println("\nLogged as Patient!");

        System.out.println("1. View booked details");
        System.out.print("Pick a number of action from above list? ");

        int selection = scan.nextInt();

        if(selection == 1){
            Patient patient = new Patient();
            patient.selectSpecificPatient(1);
        }else {
            System.out.println("\nWrong selection, Please select again!");
        }




    }

}
