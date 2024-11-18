package org.example;

import org.example.repo.ClientRepo;
import org.example.service.ItemService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    MenuProgram menuProgram = new MenuProgram();
    ItemService itemService = new ItemService();

    public void startMenu() {
       menuProgram.menuProgram();

        int choice=-1;
        //Går i loop tills knapp 0 trycks in.
        do {
            //Här visas alla val av menu

            //Här läsas users val av menu
            Scanner scanner = new Scanner(System.in);
           try {
               choice = scanner.nextInt();
           }
           catch (InputMismatchException e) {
               System.out.println("Invalid input");

              continue;
           }

            if (choice != 0) {
                itemService.saleItem(choice);
                menuProgram.menuProgram();
            }

        } while (choice != 0);
        System.out.println("You purchased a total of "+ ClientRepo.INSTANCE.getQuantityItems() +" items.The total cost was "+ClientRepo.INSTANCE.getTotalSumma() +" SEK");

    }
}
