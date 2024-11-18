package org.example.service;
import org.example.model.DiscountItem;
import org.example.model.Item;
import org.example.repo.ClientRepo;
import org.example.repo.ItemRepo;

import java.text.DecimalFormat;
import java.util.List;



public class ItemService {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public List<Item> getAllItems() {
        return new ItemRepo().getItems();
    }

    public void saleItem(int id) {
        Item result = getAllItems().stream()
                .filter(item -> item.getId() == id)
                .findFirst().orElse(null);
        ClientRepo.INSTANCE.setQuantityItems(ClientRepo.INSTANCE.getQuantityItems() + 1);
        if (result.getClass().equals(DiscountItem.class)) {
            String format = df.format(ClientRepo.INSTANCE.getTotalSumma() + result.getPrice() - result.getPrice() * ((DiscountItem) result).getDiscount() / 100.0);
            ClientRepo.INSTANCE.setTotalSumma(Double.parseDouble(format.replace(',', '.')));
        } else {
            ClientRepo.INSTANCE.setTotalSumma(ClientRepo.INSTANCE.getTotalSumma() + result.getPrice());
        }
        new ItemRepo().updateItem(id);
    }
}
