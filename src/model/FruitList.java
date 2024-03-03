package model;

import java.util.ArrayList;

/**
 *
 * @author nhs
 */
public class FruitList {

    private ArrayList<Fruit> fruitList = new ArrayList<>();

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public boolean addFruitList(Fruit f) {
        for (Fruit fruit : fruitList) {
            if (f.getFruitName().equalsIgnoreCase(fruit.getFruitName())) {
                return false;
            }
        }
        fruitList.add(f);
        return true;
    }
    
    public Fruit searchFruitByID(int id){
        for (Fruit fruit : fruitList) {
            if (id == fruit.getFruitId()) {
                return fruit;
            }
        }
        return null;
    }

    public boolean removeFruit(Fruit f) {
        boolean isDelete = false;
        for (Fruit fruit : fruitList) {
            if (f.getFruitId() == fruit.getFruitId()) {
                fruitList.remove(f);
                isDelete = true;
            }
        }
        if(isDelete){
            for(int i = f.getFruitId()-1; i<fruitList.size(); i++){
                Fruit fruit = fruitList.get(i);
                fruit.setFruitId(i+1);
            }
        }
        return false;
    }

}
