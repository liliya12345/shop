package org.example;

import org.example.service.ItemService;

//Har skapar vi en class och funtion som  visar alla menus val.

public class MenuProgram {
    ItemService itemService = new ItemService();

    public void menuProgram() {
        System.out.println("****MENU*******");

        //Går genom alla Items och skriver ut dem
        itemService.getAllItems().forEach(System.out::println);
        System.out.println("0. Quit");
        System.out.println("Choose your option:");

    }
}
