package org.example.service;

import org.example.exception.ItemNotFoundException;
import org.example.model.DiscountItem;
import org.example.model.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Skapar vi en  class ItemService med funtioner som kan ge alla item från items.txt och sparar nya egenskaperna  i filen item.txt.
public class ItemService {
   //Funktion som läser filen items.txt och returnera List av Items
    public List<DiscountItem> getAllItems() {
        List<DiscountItem> itemList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/items.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitItem = line.split(";");
                DiscountItem item = new DiscountItem();
                item.setId(Integer.parseInt(splitItem[0]));
                item.setName(splitItem[1]);
                item.setPrice(Double.parseDouble(splitItem[2]));
                item.setQuantity(Integer.parseInt(splitItem[3]));
                item.setDiscount(Integer.parseInt(splitItem[4]));
                itemList.add(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return itemList;
    }

    //funtion som uppdaterar antalet på alla varorna  som  inköpta och sparar dem i filen items.txt
    public void saleItem(int id) {
        List<DiscountItem> allItems = getAllItems();

        //Kollar om antalet >0, annars visas ett "fel meddelande".
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/items.txt", false);
            String result = "";

            for (DiscountItem allItem : allItems) {
                if (allItem.getId() == id) {
                    if (allItem.getQuantity() > 0) {
                        allItem.setQuantity(allItem.getQuantity() - 1);
                    } else System.out.println(allItem.getName() + " O left");


                }

                result = result + allItem.getId() + ";" + allItem.getName() + ";" + allItem.getPrice() + ";" + allItem.getQuantity() +";"+allItem.getDiscount() +"\n";
            }
            fileWriter.write(result);
            fileWriter.close();
            new ClientService().buyItem(id);

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
//Här får vi item by id
    public DiscountItem getItemById(int id) {
        return getAllItems().stream()
                .filter(allItem -> allItem.getId() == id)
                .findFirst().orElseThrow(
                        () ->  new ItemNotFoundException()
                );
    }
}
