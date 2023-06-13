 enum ClothesSize {
    XXS(32), XS(34), S(36), M(38), L(40);
 
    private final int euroSize;
 
    ClothesSize(int euroSize) {
        this.euroSize = euroSize;
    }
 
    public String getDescription() {
        if (this == XXS) {
            return "Детский размер";
        } else {
            return "Взрослый размер";
        }
    }
 
    public int getEuroSize() {
        return euroSize;
    }
}
 
interface MaleClothes {
    void dressMan();
}
 
interface FemaleClothes {
    void dressWoman();
}
 
abstract class Clothes {
    private ClothesSize size;
    private double cost;
    private String color;
 
    Clothes(ClothesSize size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }
 
    public ClothesSize getSize() {
        return size;
    }
 
    public double getCost() {
        return cost;
    }
 
    public String getColor() {
        return color;
    }
}
 
class TShirt extends Clothes implements MaleClothes, FemaleClothes {
    TShirt(ClothesSize size, double cost, String color) {
        super(size, cost, color);
    }
 
    @Override
    public void dressMan() {
        System.out.println("Мужчина одел футболку размера " + getSize().name() +
                ", цвета " + getColor() + ", стоимостью " + getCost() + ".");
    }
 
    @Override
    public void dressWoman() {
        System.out.println("Женщина одела футболку размера " + getSize().name() +
                ", цвета " + getColor() + ", стоимостью " + getCost() + ".");
    }
}
 
class Pants extends Clothes implements MaleClothes, FemaleClothes {
    Pants(ClothesSize size, double cost, String color) {
        super(size, cost, color);
    }
 
    @Override
    public void dressMan() {
        System.out.println("Мужчина одел штаны размера " + getSize().name() +
                ", цвета " + getColor() + ", стоимостью " + getCost() + ".");
    }
 
    @Override
    public void dressWoman() {
        System.out.println("Женщина одела штаны размера " + getSize().name() +
                ", цвета " + getColor() + ", стоимостью " + getCost() + ".");
    }
}
 
class Skirt extends Clothes implements FemaleClothes {
    Skirt(ClothesSize size, double cost, String color) {
        super(size, cost, color);
    }
 
    @Override
    public void dressWoman() {
        System.out.println("Женщина одела юбку размера " + getSize().name() +
                ", цвета " + getColor() + ", стоимостью " + getCost() + ".");
    }
}
 
class Tie extends Clothes implements MaleClothes {
    Tie(ClothesSize size, double cost, String color) {
        super(size, cost, color);
    }
 
    @Override
    public void dressMan() {
        System.out.println("Мужчина надел галстук размера " + getSize().name() +
                ", цвета " + getColor() + ", стоимостью " + getCost() + ".");
    }
}
 
class Atelier {
    public void dressWoman(Clothes[] clothes) {
        System.out.println("Женская одежда:");
        for (Clothes c : clothes) {
            if (c instanceof FemaleClothes) {
                ((FemaleClothes) c).dressWoman();
            }
        }
    }
 
    public void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда:");
        for (Clothes c : clothes) {
            if (c instanceof MaleClothes) {
                ((MaleClothes) c).dressMan();
            }
        }
    }
}
public class Lab18RPM {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new TShirt(ClothesSize.XXS, 15.99, "белый"),
                new Pants(ClothesSize.M, 29.99, "черный"),
                new Skirt(ClothesSize.S, 25.50, "красный"),
                new Tie(ClothesSize.L, 10.49, "синий")
        };
 
        Atelier atelier = new Atelier();
        atelier.dressWoman(clothes);
        atelier.dressMan(clothes);
    }
}