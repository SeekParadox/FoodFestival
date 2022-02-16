import java.util.*;
public class FoodFestival {
    public static double cost;

    public static String placeOrder(Scanner input) {
        String placeOrder;
        String userInput;
        System.out.println("Welcome to the food festival!");
        do {
            System.out.println("Would you like to place an order?");
            placeOrder = input.next().toLowerCase();

        }while (!placeOrder.equals("yes") && !placeOrder.contains("no"));

      if(placeOrder.contains("no")) {
            System.out.println("Thank you for stopping by, maybe next time you’ll sample our menu.");
            System.exit(0);
        }
      System.out.println("What is your name for the order?");
      userInput = input.next();
      return userInput;
    }

    public static List<Dish> menuSelection( Scanner input, Menu menu) {
        int userInput;
        int count = 0;
        Dish[] dishes = menu.dishes;
        List<Dish> menuList = new ArrayList<>();
        System.out.printf("%s Menu: \nSelect Nothing - 0\n",menu.getName());
        for (int i = 0; i < dishes.length; i++) {
            System.out.printf("Select %s - %d\n",dishes[i].getName(), i+1);
        }
        do {
            System.out.println("Enter the number for your appetizer selection: ");
            userInput = input.nextInt();
            if(userInput == 0) break;
            if (Math.max(userInput, dishes.length) == dishes.length && Math.min(userInput, 0) == 0)
                menuList.add(dishes[userInput-1]);
            else System.out.println("Oops I didn't quite get that, try again.");
            count++;
        }while (count < 25);
        if (userInput == 0)
            System.out.printf("You selected %d items from the %s Menu\n", menuList.size(), menu.getName());
        if(userInput != 0) System.out.printf("Maximum amount of entries has been reached. " +
                "You selected %d items from the %s Menu\n", menuList.size(), menu.getName());
        menuList.forEach(dish -> cost += dish.cost);

        return menuList;
    }

    public static void main(String[] args) {
        String name = placeOrder(new Scanner(System.in));
        System.out.printf("Select from one or more menu's, %s :", name);
        Scanner input = new Scanner(System.in);
        int userInput;
        Menu appetizers = new Menu("Appetizer");
        appetizers.addDish(new Dish("Buffalo Wings",10.95));
        appetizers.addDish(new Dish("Boneless Wings",13.89));
        appetizers.addDish(new Dish("Coconut Shrimps",19.49));

        Menu mainCourse = new Menu("Main Course");
        mainCourse.addDish(new Dish("Traditional Cheese Burgers",12.95));
        mainCourse.addDish(new Dish("Stake and vegetables",15.95));
        mainCourse.addDish(new Dish("Chicken Burger",12.95));

        Menu dessert = new Menu("Dessert");
        dessert.addDish(new Dish("Lava Cake",8.95));
        dessert.addDish(new Dish("Moose Cake",3.95));
        dessert.addDish(new Dish("Fried Ice Cream",5.95));

        List<Dish> appetizerList = new ArrayList<>(),
                mainCourseList = new ArrayList<>(), dessertList = new ArrayList<>();

        do {
            System.out.println("""
                    Menu
                    0 - Nothing
                    1 - Appetizer
                    2 - Main Course
                    3 - Dessert
                    Enter the number for your selection:\s
                    """);
            userInput = input.nextInt();

            switch (userInput) {
                case 1 -> appetizerList.addAll(menuSelection(new Scanner(System.in),appetizers));
                case 2 -> mainCourseList.addAll(menuSelection(new Scanner(System.in),mainCourse));
                case 3 -> dessertList.addAll(menuSelection(new Scanner(System.in),dessert));
            }
        }while (userInput != 0);

        String whiteSpace = "";
        System.out.printf("%-15s****Mike's Burgers****\n",whiteSpace);
        System.out.printf("%-10sThank you for stopping by %s\n", whiteSpace,name);
        System.out.printf("%-25sReceipt\n",whiteSpace);
        appetizerList.forEach(dish -> System.out.printf("%-50s $%.2f\n",dish.name,dish.cost));
        mainCourseList.forEach(dish -> System.out.printf("%-50s $%.2f\n",dish.name,dish.cost));
        dessertList.forEach(dish -> System.out.printf("%-50s $%.2f\n",dish.name,dish.cost));

        System.out.printf("%-15sSubTotal = $%.2f",whiteSpace,cost);
    }
}


