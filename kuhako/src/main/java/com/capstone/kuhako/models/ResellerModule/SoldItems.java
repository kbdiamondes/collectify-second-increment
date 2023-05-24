package com.capstone.kuhako.models.ResellerModule;

import javax.persistence.*;

@Entity
@Table(name = "soldItems")
public class SoldItems {
    @Id
    @GeneratedValue
    private int soldItems_id;

    @Column
    private String itemName;

    @Column
    private int stockQuantity;

    public SoldItems() {
    }
    public SoldItems(String itemName, int stockQuantity) {
        this.itemName = itemName;
        this.stockQuantity = stockQuantity;
    }

    public int getSoldItemsID() {
        return soldItems_id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
