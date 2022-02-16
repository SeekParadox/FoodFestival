public class Menu {
    String name;
    Dish [] dishes;
    int count;

    public Menu(String name) {
        this.name = name;
        dishes = new Dish[3];
        count = 0;
    }

    public void addDish(Dish dish) {
        dishes[count] = dish;
        count++;
    }

    public void setDishes(Dish[] dishes) {
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public Dish[] getDishes() {
        return dishes;
    }
}
