package org.example.service;

import org.example.exception.ItemNotFoundException;
import org.example.model.Client;
import org.example.model.DiscountItem;
import org.example.model.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
// Vi skapar en class Clienservice med alla logik
public class ClientService {
      ItemService itemService=new ItemService();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    //Funtion läser först filen client.txt och uppdaterar inköpta varor i fil client.txt
    public void buyItem(int id) {
        try {
            DiscountItem item = itemService.getItemById(id);
            Scanner scanner = new Scanner(new File("src/main/resources/client.txt"));
            String[] split = scanner.next().split(";");
            Client client = new Client(Integer.parseInt(split[0]), Double.parseDouble(split[1]));
            client.setQuantityItems(client.getQuantityItems()+1);
            countNewPrice(client, item);
            FileWriter fileWriter= new FileWriter("src/main/resources/client.txt",false);
            fileWriter.write(client.getQuantityItems()+";"+client.getTotalSumma());
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (ItemNotFoundException e) {
            System.out.println("Choose the right number!");
        }

    }
 //funtion som räknar ut ett discount price
    private void countNewPrice(Client client, DiscountItem item) {
        String format = df.format(client.getTotalSumma() + item.getPrice() - item.getPrice() * item.getDiscount() / 100.0);
        client.setTotalSumma(Double.parseDouble(format.replace(',', '.')));
    }
// funtion som läser fil clent.txt och får egenskaperna  och returnara en client-objekt
    public Client getClient(){
        Scanner scanner = null;
        Client client = new Client();
        try {
            scanner = new Scanner(new File("src/main/resources/client.txt"));
            String[] split = scanner.next().split(";");
           client = new Client(Integer.parseInt(split[0]), Double.parseDouble(split[1]));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return client;
    }
}
