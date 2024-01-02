package model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Material implements Comparable<Material>, Serializable {
    private String id;
    private String name;
    private LocalDate manufacturing;
    private int cost;

    public Material() {
    }

    public Material(String id, String name, LocalDate manufacturing, int cost) {
        this.id = id;
        this.name = name;
        this.manufacturing = manufacturing;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(LocalDate manufacturing) {
        this.manufacturing = manufacturing;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public abstract double getAmount();
    public abstract LocalDate getExpiryDate();

    @Override
    public int compareTo(Material material) {
        return this.getCost()-material.getCost();
    }
}
