package com.free.dennisg.clickingbad.model;

/**
 * Created by Dennis Gimbergsson on 2017-09-30.
 **/

public class Distribution {

    private int itemId = 0;
    private String name;
    private String description;
    private int cost;
    private int risk;
    private int purity;
    private int cook;
    private int owned;

    public Distribution(int itemId, String name, String description, int cost, int risk, int purity, int cook, int owned) {
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

    public int getOwned() {
        return owned;
    }

    public void setOwned(int owned) {
        this.owned = owned;
    }

    public static Builder builder() {
        return new Builder();
    }

    private Distribution(Builder builder){
        this.itemId = builder.itemId;
        this.name = builder.name;
        this.description = builder.description;
        this.cost = builder.cost;
        this.risk = builder.risk;
        this.purity = builder.purity;
        this.cook = builder.cook;
        this.owned = builder.owned;
    }


    public static final class Builder {
        private int itemId = 0;
        private String name;
        private String description;
        private int cost;
        private int risk;
        private int purity;
        private int cook;
        private int owned;

        public Builder() {
        }

        public Builder(Distribution distribution) {
            itemId = distribution.getItemId();
            name = distribution.getName();
            description = distribution.getDescription();
            cost = distribution.getCost();
            risk = distribution.getRisk();
            purity = distribution.getPurity();
            cook = distribution.getCook();
            owned = distribution.getOwned();
        }

        public Builder itemId(int itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder cost(int cost) {
            this.cost = cost;
            return this;
        }

        public Builder risk(int risk) {
            this.risk = risk;
            return this;
        }

        public Builder purity(int purity) {
            this.purity = purity;
            return this;
        }

        public Builder cook(int cook) {
            this.cook = cook;
            return this;
        }

        public Builder owned(int owned) {
            this.owned = owned;
            return this;
        }

        public Distribution build() {
            return new Distribution(this);
        }
    }

}
