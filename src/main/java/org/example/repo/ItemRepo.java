package org.example.repo;
import org.example.model.DiscountItem;
import org.example.model.Item;
import java.util.List;

public class ItemRepo {
   static List<Item> itemList= List.of(new Item(1,"Mask",211.95,9),
            new Item(2,"Mask2",200.95,19)
            ,new DiscountItem(3,"Mask3",100.20,20,10));
    public List<Item> getItems() {
        return itemList;

    }
    public void updateItem(int id) {
        for (Item item : itemList) {
            if (item.getId() == id) {
                if (item.getQuantity() > 0) {
                        item.setQuantity(item.getQuantity() - 1);
                    } else System.out.println(item.getName() + " O left");
            }
        }
    }

}
