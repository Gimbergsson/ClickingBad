package com.free.dennisg.clickingbad.model;

/**
 * Created by Dennis Gimbergsson on 2017-09-24.
 */

public class Manufacturing {

    private int itemId = 0;
    private String name;
    private String description;
    private int cost;
    private int risk;
    private int purity;
    private int cook;



    public Manufacturing(int itemId, String name, String description, int cost, int risk, int purity, int cook) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.risk = risk;
        this.purity = purity;
        this.cook = cook;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public int getPurity() {
        return purity;
    }

    public void setPurity(int purity) {
        this.purity = purity;
    }

    public int getCook() {
        return cook;
    }

    public void setCook(int cook) {
        this.cook = cook;
    }
}
