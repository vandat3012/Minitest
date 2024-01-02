package model;

import java.io.Serializable;
import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount, Serializable {
    private double weight;
    public CrispyFlour() {
    }
    public CrispyFlour(double weight) {
        this.weight = weight;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturing, int cost, double weight) {
        super(id, name, manufacturing, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return this.weight * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturing().plusDays(7);
    }
    @Override
    public String toString() {
        return "CrispyFlours {" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", manufacturing=" + getManufacturing() +
                ", cost=" + getCost() +
                "weight=" + weight +
                '}';
    }

    @Override
    public double getReallyMoney() {
        LocalDate today = LocalDate.now();
        if (today.isBefore(getExpiryDate())&&today.isAfter(getExpiryDate().minusMonths(2))||today.isEqual(getExpiryDate().minusMonths(2))) {
            return getAmount()*0.6;
        }else if (today.isBefore(getExpiryDate().minusMonths(2))&&today.isAfter(getExpiryDate().minusMonths(4))||today.isEqual(getExpiryDate().minusMonths(4))) {
            return getAmount()*0.8;
        }else {
            if (today.isBefore(getExpiryDate().minusMonths(4))&&today.isAfter(getExpiryDate())||today.isEqual(getExpiryDate())) {
                return getAmount()*0.95;
            }else {
                System.out.println("Error data");
            }
        }
        return 0;
    }
}
