public class Dish {
    String name;
    double cost;

    public Dish(String name, double cost) {
        this.name = name;
        this.cost = Math.max(cost,0);
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
