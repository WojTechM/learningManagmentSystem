package com.company.dao;

import com.company.dao.Parser.CsvParser;
import com.company.models.users.User;
import com.company.models.users.employees.Mentor;
import com.company.models.users.students.Student;

import java.util.ArrayList;
import java.util.List;

import com.company.models.users.employees.Manager;
import com.company.models.users.students.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements UserDAO {
    int idIndex = 0;
    int usernameIndex = 1;
    int passwordIndex = 2;
    int nameIndex = 3;
    int surnameIndex = 4;
    int roleIndex = 5;

    private CsvParser csvParser;
    private List<List<String>> listOfRecords;
    private Student student;
    private String filepathOfUsersCsv = "src/main/resources/users.csv";

    public StudentDAO() {
        this.csvParser = new CsvParser(filepathOfUsersCsv);
        listOfRecords = new ArrayList<>();
    }


    public CsvParser getCsvParser() {
        return csvParser;
    }
    @Override
    public void write(User user) {
        String[] toStringArrayStudent = toStringArray(user);
        csvParser.addNewRecord(toStringArrayStudent);
    }

    private String[] toStringArray(User user) {
        String[] studentArray = {String.valueOf(user.getId())
                , user.getUsername()
                , user.getName()
                , user.getSurname()
                , user.getRole()};
        return studentArray;
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User read(User user) {

        return null;
    }

    public User readUserByUsernameAndPassword(String usernameGiven, String passwordGiven) {
        this.listOfRecords = csvParser.getUpdatedList();
        System.out.println(this.listOfRecords);
        for (int i = 0; i < listOfRecords.size(); i++) {
            if (listOfRecords.get(i).get(roleIndex).equals("student")
            && listOfRecords.get(i).get(usernameIndex).equals(usernameGiven)
            && listOfRecords.get(i).get(passwordIndex).equals(passwordGiven)) {
                this.student = new Student(Integer.parseInt(listOfRecords.get(i).get(idIndex))
                        , listOfRecords.get(i).get(usernameIndex)
                        , listOfRecords.get(i).get(passwordIndex)
                        , listOfRecords.get(i).get(nameIndex)
                        , listOfRecords.get(i).get(surnameIndex)
                        , listOfRecords.get(i).get(roleIndex));
            }
        }
        return this.student;
    }

    public List<User> extractUserFromList(List<List<String>> listOfStudents) {
        String id, login, password, name, surname, role;
        List<User> studentsArray = new ArrayList<>();
        for (int i = 0; i < listOfStudents.size(); i++) {
            List<String> students = listOfStudents.get(i);
            id = students.get(0);
            login = students.get(1);
            password = "*************";
            name = students.get(3);
            surname = students.get(4);
            role = students.get(5);
            if (role.equals("student")) {
                studentsArray.add(new Student(login, password, name, surname, role));
            }
        }
        return studentsArray;
    }
}
