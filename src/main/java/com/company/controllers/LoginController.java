package com.company.controllers;

import com.company.dao.UserDAOFromCSV;
import com.company.models.users.User;
import com.company.service.DataHandler;
import com.company.service.TerminalView;
import com.company.view.menu.LoginMenu;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LoginController {
    Scanner scanner = new Scanner(System.in);
    Path path = Paths.get("");
    Path absolutePath = path.toAbsolutePath();
    String location = absolutePath.toString();

    public void init() throws FileNotFoundException {
        boolean isRunning = true;


        while (isRunning) {
//            TerminalView.clearScreen();
            DataHandler.printFromFile(location + "/src/main/resources/Menu CcMS/Small/MainScreen");
            DataHandler.printFromFile(location + "/src/main/resources/Menu CcMS/Small/MainMenu");
//            DataHandler.printFromFile(location);

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
//                    TODO: logging user

                    DataHandler.printFromFile(location + "/src/main/resources/Menu CcMS/Small/MainScreen");
                    DataHandler.printFromFile(location + "/src/main/resources/Menu CcMS/Small/MainMenu");

                    loggingUser();
                    break;
                case 2:
                    DataHandler.printFromFile(location + "/src/main/resources/Menu CcMS/Small/Credits");
//                    TODO: show credits
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("            Wrong input !!!");
            }
        }
    }

    public void loggingUser() throws FileNotFoundException {
        DataHandler.printFromFile(location + "/src/main/resources/Menu CcMS/Small/LoginMenu");
        Scanner scanner = new Scanner(System.in);

        TerminalView.printString("          User name: ");
        String username = scanner.nextLine();

        TerminalView.printString("          User password: ");
        String password = scanner.nextLine();

        if (new UserDAOFromCSV().readUserByUsernameAndPassword(username,password).getName()==null){
            TerminalView.printString("          Wrong username or password.");
        } else {
            User user = new UserDAOFromCSV().readUserByUsernameAndPassword(username,password);
            System.out.println("            userFound name = " + user.getName());
            System.out.println("            userFound role = " + user.getRole());

            if (user.getRole().equals("manager")) {
                System.out.println("            Manager Role here");
                ManagerController managerController = new ManagerController(user);
                managerController.init();
            } else if (user.getRole().equals("student")) {
                System.out.println("            Student Role here");
                StudentController studentController = new StudentController(user);
                studentController.init();
            } else if (user.getRole().equals("mentor")) {
                System.out.println("            Mentor Role here");
                MentorController mentorController = new MentorController(user);
                mentorController.init();
            } else if (user.getRole().equals("regularEmployee")) {
                System.out.println("            RegularEmployee Role here");
                RegularEmployeeController regularEmployeeController = new RegularEmployeeController(user);
                regularEmployeeController.init();
            }
        }
    }
}
