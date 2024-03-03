/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Map;
import model.Fruit;
import model.FruitList;
import model.Order;
import util.FormatString;
import util.InputUtils;

/**
 *
 * @author LENOVO
 */
public class Controller {
    public static void main(String[] args) {
        int choice;
        FruitList fl = new FruitList();
        Fruit f1 = new Fruit(1, "Apple", 4.5, 10, "American");
        Fruit f2 = new Fruit(2, "Banana", 3.9, 10, "VietNam");
        Fruit f3 = new Fruit(3, "Mango", 5.8, 10, "American");
        Fruit f4 = new Fruit(4, "Avocado", 6.2, 10, "China");
        Fruit f5 = new Fruit(5, "Apricot", 2.6, 10, "France");
        fl.addFruitList(f1);
        fl.addFruitList(f2);
        fl.addFruitList(f3);
        fl.addFruitList(f4);
        fl.addFruitList(f5);
        Order order = new Order();
        while (true) {
            choice = Menu.chooseInputOption();
            switch (choice) {
                case 1 -> {
                    createFruit(inputFruit(fl), fl);
                }
                case 2 -> {
                    viewOrder(order, fl);
                }
                case 3 -> {
                    shopping(order, fl);
                }
                case 4 ->
                    System.exit(0);
            }
        }
    }

    public static Fruit inputFruit(FruitList fl) {
        System.out.println("Enter name: ");
        String name = FormatString.formatName(InputUtils.inputName());
        System.out.println("Enter quantity: ");
        int quantity = InputUtils.inputInt();
        System.out.println("Enter origin: ");
        String origin = InputUtils.inputString();
        System.out.println("Enter price: ");
        double price = InputUtils.inputDouble();
        int fruitListSize = fl.getFruitList().size();
        Fruit f = new Fruit(fruitListSize + 1, name, price, quantity, origin);
        return f;
    }

    public static void createFruit(Fruit f, FruitList fl) {
        if (fl.addFruitList(f)) {
            System.out.println("Create successfully!");
        } else {
            System.out.println("Fruit is already existed!");
        }
    }

    public static void viewOrder(Order order, FruitList fl) {
        boolean haveOrder = false;
        for (Map.Entry<String, ArrayList<Fruit>> entry : order.getOrders().entrySet()) {
            haveOrder = true;
            System.out.println("Customer: " + entry.getKey());
            displayFruitOrder(entry.getValue());
            double totalAmount = 0;
            for (Fruit f : entry.getValue()) {
                totalAmount += f.getPrice() * f.getQuantity();
            }
            System.out.println("Total: $" + totalAmount);
            System.out.println("-------------------------------------------");
        }
        
        if(!haveOrder){
            System.out.println("Not found any order!");
        }

    }

    public static void shopping(Order order, FruitList fl) {
        displayFruitList(fl);
        ArrayList<Fruit> selectedFruit = new ArrayList<>();
        int option;
        do {
            System.out.print("Enter fruit id to order: ");
            Fruit fruitToOrder = fl.searchFruitByID(InputUtils.inputInt());
            if (fruitToOrder != null) {
                System.out.println("You selected : " + fruitToOrder.getFruitName());
                System.out.print("Please input quantity: ");
                int quantity = InputUtils.inputInt();
                fruitToOrder.setQuantity(quantity);
                selectedFruit.add(fruitToOrder);
                System.out.println("\nDo you want to order now ?\nPress 1 (Yes) or 0 (No).");
                option = InputUtils.inputOption(0, 1);
            } else {
                System.out.println("Item not found!");
                option = 0;
            }
        } while (option == 0);
        if (option == 1) {
            displayFruitOrder(selectedFruit);
            double totalAmount = 0;
            for (Fruit f : selectedFruit) {
                totalAmount += f.getPrice() * f.getQuantity();
            }
            System.out.println("Total: $" + totalAmount);
            System.out.print("Input your name: ");
            String customerName = FormatString.formatName(InputUtils.inputName());
            order.addNewOrder(customerName, selectedFruit);
            System.out.println("Ordered Successfully!");
        }
    }

    public static void displayFruitList(FruitList fl) {
        System.out.printf("%-15s|%-20s|%-20s|%-8s$\n", "Item", "Name", "Origin", "Price");
        for (Fruit f : fl.getFruitList()) {
            f.toString();
        }
    }

    public static void displayFruitOrder(ArrayList<Fruit> fl) {
        System.out.printf("|%-20s|%-15s|%-8s$  |%-15s\n", "Name", "Quantity", "Price", "Amount");
        for (Fruit f : fl) {
            f.displayInOrder();
        }
    }
}
