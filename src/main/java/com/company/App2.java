package com.company;

import com.company.controllers.LoginController;

import java.io.FileNotFoundException;

public class App2 {
    public static void main(String[] args) throws FileNotFoundException {
        LoginController logging = new LoginController();
        logging.init();
    }
}
