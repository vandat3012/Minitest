package controller;

import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ManagerMaterial {
    public static ArrayList<Material> materials = new ArrayList<>();

    public static void addMaterial(Material material) {
        materials.add(material);
    }

    public static void deleteMaterial(String id) {
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getId().equals(id)) {
                materials.remove(materials.get(i));
                break;
            }
        }
        System.out.println("Bạn đã xóa vật liệu có id là " + id);
    }

    public static void printMaterial() {
        for (Material e : materials) {
            System.out.println(e);
        }
    }

    public static void editMaterial(int index,Material newMaterial) {
        materials.set(index,newMaterial);
    }

    public static double getTotalMoney() {
        double total = 0;
        for (Material material : materials) {
            total += material.getAmount();
        }
        return total;
    }

    public static double getAmountMeatAfterDiscount() {
        double total = 0;
        for (Material material : materials) {
            if (material instanceof Meat) {
                Meat meat = (Meat) material;
                total += meat.getReallyMoney();
            }
        }
        return total;
    }

    public static double getAmountCrispyFloursAfterDiscount() {
        double total = 0;
        for (Material material : materials) {
            if (material instanceof CrispyFlour) {
                CrispyFlour crispyFlour = (CrispyFlour) material;
                total += crispyFlour.getReallyMoney();
            }
        }
        return total;
    }

    public static void arrangeCost() {
        Collections.sort(materials);
        for (Material material : materials) {
            System.out.println(material);
        }
    }

    public static double moneyDiscount() {
        return getTotalMoney() - getAmountMeatAfterDiscount() - getAmountCrispyFloursAfterDiscount();
    }

    public static void writeDataToFile(String path, ArrayList<Material> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Material> readDataFromFile(String path) {
        ArrayList<Material> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (ArrayList<Material>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }
}
