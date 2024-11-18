package org.example.model;
//Model Client med constructor, getter och setter
public class Client {
    private int quantityItems;
    private double totalSumma;

    public Client(int quantityItems, double totalSumma) {
        this.quantityItems = quantityItems;
        this.totalSumma = totalSumma;
    }

    public int getQuantityItems() {
        return quantityItems;
    }

    public void setQuantityItems(int quantityItems) {
        this.quantityItems = quantityItems;
    }

    public double getTotalSumma() {
        return totalSumma;
    }

    public void setTotalSumma(double totalSumma) {
        this.totalSumma = totalSumma;
    }
}
