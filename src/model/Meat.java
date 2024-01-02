package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Meat extends Material implements Discount, Serializable {
    private int quality;

    public Meat() {
    }

    public Meat(int quality) {
        this.quality = quality;
    }

    public Meat(String id, String name, LocalDate manufacturing, int cost, int quality) {
        super(id, name, manufacturing, cost);
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public double getAmount() {
        return this.quality * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturing().plusYears(1);
    }


    @Override
    public String toString() {
        return "Meat {" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", manufacturing=" + getManufacturing() +
                ", cost=" + getCost() +
                "quality=" + quality +
                '}';
    }

    @Override
    public double getReallyMoney() {
        LocalDate today = LocalDate.now();
        if (today.isBefore(getExpiryDate()) && today.isAfter(getExpiryDate().minusDays(5)) || today.isEqual(getExpiryDate().minusDays(5))) {
            return getAmount() * 0.7;
        } else {
            if (today.isBefore(getExpiryDate().minusDays(5)) && today.isAfter(getExpiryDate()) || today.isEqual(getExpiryDate())) {
                return getAmount() * 0.9;
            } else {
                System.out.println("Error data");
            }
            return 0;
        }
    }
}
