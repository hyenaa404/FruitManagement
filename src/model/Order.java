/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author nhs
 */
public class Order {

    private Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();

    public Hashtable<String, ArrayList<Fruit>> getOrders() {
        return orders;
    }

    public void setOrders(Hashtable<String, ArrayList<Fruit>> orders) {
        this.orders = orders;
    }

    public boolean addNewOrder(String name, ArrayList<Fruit> order) {
        if (orders.containsKey(name)) {
            ArrayList<Fruit> existingOrder = orders.get(name);
            existingOrder.addAll(order);
            return false;
        } else {
            orders.put(name, order);
        }
        return true;
    }
    
    public boolean deleteOrder(String name) {
        if (orders.containsKey(name)) {
            orders.remove(name);
            return true;
        } 
        return false;
    }

}
