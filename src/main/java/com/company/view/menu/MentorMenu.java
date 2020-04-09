package com.company.view.menu;

public class MentorMenu {
    public static void displayMenu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *              Mentor  MENU            *");
        System.out.println("     ****************************************");
        System.out.println("     What do you want to do ?");
        System.out.println("     (1) See list of students");
        System.out.println("     (2) Display all classes and add student to class");
        System.out.println("     (3) Display all classes and remove student from class");
        System.out.println("     (4) Edit student's data");
        System.out.println("     (5) Display all assignments and add assignment");
        System.out.println("     (6) WIP - Grade student assignments");
        System.out.println("     (7) WIP - Check attendence");
        System.out.println("     (8) See list of my students");
        System.out.println("     (0) Log out");
        System.out.println();
        System.out.println("What is Your choice : ");
    }


    public static void displayFirstEditingStudentMenu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *              Mentor  MENU           *");
        System.out.println("     ****************************************");
        System.out.println("        Which student do you want to edit?");
    }

    public static void displaySecondEditingStudentMenu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *              Mentor  MENU           *");
        System.out.println("     ****************************************");
        System.out.println("     Which student data do you want to edit?");
        System.out.println("     (1) Username");
        System.out.println("     (2) Password");
        System.out.println("     (3) Name");
        System.out.println("     (4) Surname");
        System.out.println("     (5) Edit all data");
        System.out.println("     (0) Back to the main menu");
        System.out.println();
        System.out.println("What is Your choice : ");
    }

    public static void displayAddingStudentToClass() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *              Mentor  MENU           *");
        System.out.println("     ****************************************");
        System.out.println("  Which student do you want to add to your class?");
    }
}
