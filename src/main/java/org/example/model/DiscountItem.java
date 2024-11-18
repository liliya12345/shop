package org.example.model;
//Model DiscountItem med constructor, getter och setter
public class DiscountItem  extends Item {
    private int discount;

    public DiscountItem(int id, String name, double price, int quantity, int discount) {
        super(id, name, price, quantity);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }


    @Override
    public String toString() {
        return   super.getId()+"."+super.getName()+", "+(super.getPrice()-super.getPrice()*discount/100)+" SEK, "+super.getQuantity()+" left";
    }
}
