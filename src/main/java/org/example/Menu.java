package org.example;

import org.example.model.Client;
import org.example.service.ClientService;
import org.example.service.ItemService;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    MenuProgram menuProgram = new MenuProgram();
    ItemService itemService = new ItemService();
    ClientService clientService = new ClientService();

    public void startMenu() {
//       menuProgram.menuProgram();

        int choice=-1;
        //Går i loop tills knapp 0 trycks in.
        do {
            //Här visas alla val av menu
            menuProgram.menuProgram();
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
        //Ropar vi på clentServise och skriver ut alla clients egenskapar
        Client client = clientService.getClient();
        System.out.println("You purchased a total of "+ client.getQuantityItems() +" items.The total cost was "+client.getTotalSumma() +" SEK");

    }
}
