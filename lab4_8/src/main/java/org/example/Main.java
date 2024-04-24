package org.example;

import org.example.Command.*;
import org.example.Kitchen.Chef;
import java.util.Scanner;
import java.util.logging.FileHandler;


public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.execute();
    }
}