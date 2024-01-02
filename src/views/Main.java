package views;

import controller.ManagerMaterial;
import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static ArrayList<Material> materials = ManagerMaterial.materials;

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        int choice = -1;
        Material meat1 = new Meat("1", "a", LocalDate.of(2024, 1, 6), 190000, 5);
        Material meat2 = new Meat("2", "b", LocalDate.of(2023, 12, 1), 110000, 6);
        Material meat3 = new Meat("3", "c", LocalDate.of(2023, 12, 1), 120000, 7);
        Material meat4 = new Meat("4", "d", LocalDate.of(2023, 12, 1), 130000, 8);
        Material meat5 = new Meat("5", "e", LocalDate.of(2023, 12, 1), 140000, 9);
        Material crispyFlour1 = new CrispyFlour("6", "f", LocalDate.of(2023, 12, 1), 15000, 50);
        Material crispyFlour2 = new CrispyFlour("7", "g", LocalDate.of(2023, 12, 1), 16000, 55);
        Material crispyFlour3 = new CrispyFlour("8", "h", LocalDate.of(2023, 12, 1), 17000, 56);
        Material crispyFlour4 = new CrispyFlour("9", "i", LocalDate.of(2023, 12, 1), 18000, 57);
        Material crispyFlour5 = new CrispyFlour("10", "k", LocalDate.of(2023, 12, 1), 19000, 80);
        materials.add(meat1);
        materials.add(meat2);
        materials.add(meat3);
        materials.add(meat4);
        materials.add(meat5);
        materials.add(crispyFlour1);
        materials.add(crispyFlour2);
        materials.add(crispyFlour3);
        materials.add(crispyFlour4);
        materials.add(crispyFlour5);
        ManagerMaterial.writeDataToFile("list.txt", materials);
        ArrayList<Material> materialDataFromFile = ManagerMaterial.readDataFromFile("list.txt");
        for (Material material : materialDataFromFile){
            System.out.println(material);
        }
        do {
            System.out.println("MENU");
            System.out.println("0. Exit");
            System.out.println("1. Thêm vật liệu ");
            System.out.println("2. Xóa vật liệu ");
            System.out.println("3. Sửa vật liệu ");
            System.out.println("4. Tính tổng tiền vật liệu ");
            System.out.println("5. Sắp xếp vật liệu theo giá ");
            System.out.println("6. Tính nếu thịt còn 5 ngày hết hạn thì giảm 30%, còn lại thì giảm 10% ");
            System.out.println("7. Tính nếu bột còn 2 tháng hết hạn thì giảm 40%, bột còn 4 tháng hết hạn thì giảm 20%, còn lại thì giảm 5% ");
            System.out.println("8. Tính số chênh lệch giữa chiết khấu và không chiết khấu tại ngày hôm nay ");
            System.out.println("9 Kiểm tra số lượng nguyên liệu trong kho ");
            System.out.println("Lựa chọn của bạn là : ");
            choice = scanner1.nextInt();

            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    addMaterial();
                    break;
                case 2:
                    deleteMaterial();
                    break;
                case 3:
                    updateMaterial();
                    break;
                case 4:
                    System.out.println("Tổng số tiền là " + ManagerMaterial.getTotalMoney());
                    break;
                case 5:
                    ManagerMaterial.arrangeCost();
                    break;
                case 6:
                    System.out.println("Số tiền bột sau khi giảm giá là " + ManagerMaterial.getAmountCrispyFloursAfterDiscount());
                    break;
                case 7:
                    System.out.println("Số tiền thịt sau khi giảm giá là " + ManagerMaterial.getAmountMeatAfterDiscount());
                    break;
                case 8:
                    System.out.println("Chiết khấu là " + ManagerMaterial.moneyDiscount());
                    break;
                case 9:
                    ManagerMaterial.printMaterial();
                    break;
                default:
                    System.out.println("invalid input");
            }
        } while (choice != -1);
    }
    public static void addMaterial() {
        System.out.println("Lựa chọn vật liệu muốn thêm ");
        System.out.println("Nhập 'm' nếu chọn meat, nhập 'c' nếu chọn crispyflour");
        String value = scanner.nextLine();
        if (value.equals("m")) {
            System.out.println("id");
            String id = scanner.nextLine();
            System.out.println("name ");
            String name = scanner.nextLine();
            System.out.println("Year,month,day");
            String manufacturing = scanner.nextLine();
            System.out.println("cost ");
            int cost = scanner.nextInt();
            System.out.println("quality ");
            int quantity = scanner.nextInt();
            Material meat = new Meat(id, name, LocalDate.parse(manufacturing), cost, quantity);
            ManagerMaterial.addMaterial(meat);
        } else if (value.equals("c")) {
            System.out.println("id ");
            String id = scanner.nextLine();
            System.out.println("name ");
            String name = scanner.nextLine();
            System.out.println("Year,month,day");
            String manufacturing = scanner.nextLine();
            System.out.println("cost ");
            int cost = scanner.nextInt();
            System.out.println("quality ");
            double weight = scanner.nextDouble();
            Material crispyFlour = new CrispyFlour(id, name, LocalDate.parse(manufacturing), cost, weight);
            ManagerMaterial.addMaterial(crispyFlour);
        } else {
            System.out.println("Sai òi");
        }
    }
    public static void deleteMaterial() {
        ManagerMaterial.printMaterial();
        System.out.println("Id vật liệu mà bạn muốn xóa ");
        String id = scanner.nextLine();
        ManagerMaterial.deleteMaterial(id);
    }
    public static void updateMaterial() {
        System.out.println("Chọn vị trí phần tử muốn sua ");
        int index = scanner.nextInt();
        System.out.println("id");
        String id1 = scanner.nextLine();
        System.out.println("name ");
        String name = scanner.nextLine();
        System.out.println("Year,month,day");
        String manufacturing = scanner.nextLine();
        System.out.println("cost ");
        int cost = scanner.nextInt();
        System.out.println("quality ");
        int quantity = scanner.nextInt();
        Material meat = new Meat(id1, name, LocalDate.parse(manufacturing), cost, quantity);
        ManagerMaterial.editMaterial(index,meat);
    }

}