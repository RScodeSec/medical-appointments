package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;


public class UIMenu {
    public static  final String[] MONTHS = {"January","February", "March", "April", "May","June","July","August","September", "October","November", "December" };
    public static Doctor doctorLogged;
    public static Patient patientLogged;
    public static void showMenu(){
        System.out.println("Welcome to my Appointments");
        System.out.println("Select the Option: ");
        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Exit");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response){
                case 1:
                    System.out.println("Doctor ");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response =0;
                    authUser(2);
                case 0:
                    System.out.println("thank you for you visit");
                    break;
                default:
                    System.out.println("Please select the correct option");

            }
        }while(response!=0);
    }
    private static  void authUser(int userType){
        //conditions 1->doctor and 2-> patient
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Juan Salazar", "juan@gmail.com"));
        doctors.add(new Doctor("Ana Rivas", "rivas@gmail.com"));
        doctors.add(new Doctor("Elon Musk", "juan@gmail.com"));
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Roger Salazar", "roger@gmail.com"));
        patients.add(new Patient("Anahi Salgado", "anahi@gmail.com"));
        patients.add(new Patient("kuna ama", "ama@gmail.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email: [a@gmail.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.next();
            if (userType == 1){
                for (Doctor d: doctors){
                    if (d.getEmail().equals(email)){
                        emailCorrect = true;
                        doctorLogged = d;
                        //showDoctorMenu
                        UIDoctorMenu.showDoctorMenu();

                    }
                }

            }
            if (userType == 2){
                for (Patient p: patients){
                    if (p.getEmail().equals(email)){
                        emailCorrect =true;
                        patientLogged =p;
                        //showPatientMenu
                        UIPatientMenu.showPatientMenu();
                    }
                }

            }

        }while (!emailCorrect);

    }
    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 1; i < 3; i++) {
                        System.out.println(i+ "."+MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;

            }

        }while (response !=0);

    }
}
