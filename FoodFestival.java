import java.util.*;
public class FoodFestival {
    public static ArrayList<String> AppToppings = new ArrayList<>();
    public static ArrayList<String> ShortStorageToppings = new ArrayList<>();
    public static ArrayList<String> MainMeal = new ArrayList<>();
    public static ArrayList<String> ShortStorageMeal = new ArrayList<>();
    public static ArrayList<String> MealAppToppings = new ArrayList<>();
    public static ArrayList<String> MealShortStorageToppings = new ArrayList<>();
    public static ArrayList<String> DessertList = new ArrayList<>();
    public static ArrayList<String> ShortStorageDessert = new ArrayList<>();
    public static ArrayList<String> DessertAppToppings = new ArrayList<>();
    public static ArrayList<String> DessertShortStorageToppings = new ArrayList<>();
    private static double cost;

    public static String placeOrder() {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        System.out.println("Welcome to the food festival!");
        String placeOrder;
        do {
            System.out.println("Would you like to place an order?");
            placeOrder = input.next().toLowerCase();
        } while (!placeOrder.equals("yes") && !placeOrder.contains("no"));

    if (placeOrder.equals("no")) {
        System.out.println("Thank you for stopping by, maybe next time you’ll sample our menu.");
        System.exit(0);
    }
        System.out.println("What is your name for the order?");
        userInput = input.next();
        return userInput;
    }

    public static ArrayList<String> appetizer(Scanner input ) {
        int userInput;
        int count = 0;
        ArrayList<String> appetizerList = new ArrayList<>();

        System.out.println("Appetizer Menu:" +
                "\nSelect Nothing - 0 " +
                "\nSelect Buffalo Wings - 1 " +
                "\nSelect Boneless Wings - 2 " +
                "\nSelect Coconut Shrimp - 3 " +
                "\nEnter the number for your appetizer selection");
        do {
            userInput = input.nextInt();
            switch (userInput) {
                case 1 -> {
                    appetizerList.add("Buffalo Wings");
                    cost += 10.95;
                }
                case 2 -> {
                    appetizerList.add("Boneless Wings");
                    cost += 10.95;
                }
                case 3 -> {
                    appetizerList.add("Coconut Shrimp");
                    cost += 12.95;
                }
                default -> {
                    if (userInput != 0)
                        System.out.println("Oops try again. I didn't quite get that.");

                }
            }
            count++;
        }while (userInput != 0 && count < 25);

        if (userInput == 0)
            System.out.printf("You selected %d items from the Appetizer Menu\n", appetizerList.size());
        if(userInput != 0)
            System.out.printf("Maximum entries allowed has been reached. " +
                    "\nYou selected %d items from the Appetizer Menu", appetizerList.size());
        if(count > 0) appToppings();

        return appetizerList;


    }

    public static void appToppings() {
        Scanner input = new Scanner(System.in);
        int i = 0;
        int userInput;
        ArrayList<String> toppingList = new ArrayList<>();

        System.out.println("Toppings Menu: \n" +
                "Select Nothing - 0\n" +
                "Select Bleu Cheese- 1\n" +
                "Select Parmesan sauce - 2\n" +
                "Select Spicy Remoulade - 3\n" +
                "Enter the number for your topping selection: ");
        do{
            userInput = input.nextInt();
            switch (userInput) {
                case 1 -> {

                }
            }
            /*if (userInput == 0) {
                break;
            } else if (userInput == 1) {
                i++;

                toppingList.add("Bleu Cheese");
            } else if (userInput == 2) {

                toppingList.add("Parmesan sauce");
                i++;
            } else if (userInput == 3) {
                toppingList.add("Spicy Remoulade");
                i++;
            }*/
        }
        while(userInput != 0);
        for (int j = 0; j < i; j++) {
            System.out.println("You selected: " + ShortStorageToppings.toArray()[j]);

        }
    }
    public static void MainCourse () {
      Scanner input = new Scanner(System.in);
      int userInput;
      int count = 0;
      ArrayList<String> meal = new ArrayList<>();
      ShortStorageMeal = meal;
      System.out.println("Main Course Menu:\nSelect Nothing - 0 \nSelect Traditional Cheese Burgers - 1 \nSelect Stake and vegetables - 2 " +
              "\nSelect Chicken Burger - 3 " +
              "\nEnter the number for your meal selection");
      do {
          userInput = input.nextInt();
          if (userInput == 1) {
              count++;
              MainMeal.add("Traditional Cheese Burgers");
              meal.add("Traditional Cheese Burgers");
              cost += 12.95;

          } else if (userInput == 2) {
              MainMeal.add("Stake and vegetables");
              meal.add("Stake and vegetables");
              count++;
              cost += 15.95;
          } else if (userInput == 3) {
              MainMeal.add("Chicken Burger");
              meal.add("Chicken Burger");
              count++;
              cost += 12.95;
          }
      } while (userInput != 0);

      if (userInput == 0) {
          System.out.printf("You selected %d items from the Appetizer Menu\n", count);
          System.out.println("" + meal.toString() + "");
          MealToppings();
      }
  }
    public static void MealToppings () {
        Scanner input = new Scanner(System.in);
        int i = 0;
        int userInput;
        ArrayList<String> Toppings = new ArrayList<>();
        MealShortStorageToppings = Toppings;
        System.out.println("Toppings Menu: \nSelect Nothing - 0 \nSelect French Fries - 1  \nSelect Onion Rings - 2 " +
                "\nSelect Mash Potatoes - 3 \nEnter the number for your topping selection: ");
        do {
            userInput = input.nextInt();

            if (userInput == 0) {
                break;
            } else if (userInput == 1) {
                i += 1;
                MealAppToppings.add("French Fries");
                Toppings.add("French Fries");
            } else if (userInput == 2) {
                MealAppToppings.add("Onion Rings");
                Toppings.add("Onion Rings");
                i += 1;
            } else if (userInput == 3) {
                MealAppToppings.add("Mash Potatoes");
                Toppings.add("Mash Potatoes");
                i += 1;
            }
        } while (userInput != 0);
        for (int j = 0; j < i; j++) {
            System.out.println("You selected: " + MealShortStorageToppings.toArray()[j]);
        }
    }
    public static void Dessert() {
        Scanner input = new Scanner(System.in);
        int i = 0;
        int count = 0;
        int userInput;
        ArrayList<String> dessert = new ArrayList<>();
        ShortStorageDessert = dessert;
        System.out.println("Dessert Menu: \nSelect Nothing - 0 \nSelect Lava Cake - 1  \nSelect Moose Cake - 2 " +
                "\nSelect Fried Ice Cream - 3 \nEnter the number for your topping selection: ");
        do {
            userInput = input.nextInt();

            if (userInput == 0) {
                break;
            } else if (userInput == 1) {
                i++;
                DessertList.add("Lava Cake");
                dessert.add("Lava Cake");
                cost += 8.95;
            } else if (userInput == 2) {
                DessertList.add("Moose Cake");
                dessert.add("Moose Cake");
                i++;
                cost += 3.95;
            } else if (userInput == 3) {
                DessertList.add("Fried Ice Cream");
                dessert.add("Fried Ice Cream");
                i++;
                cost += 5.95;
            }
        } while (userInput != 0);
        if (userInput == 0) {
            System.out.printf("You selected %d items from the Dessert Menu\n", count);
            System.out.println("" + dessert.toString() + "");
            DessertToppings();
        }
    }

    public static void DessertToppings() {
        Scanner input = new Scanner(System.in);
        int i = 0;
        int userInput;
        ArrayList<String> Toppings = new ArrayList<>();
        DessertShortStorageToppings = Toppings;
        System.out.println("Toppings Menu: \nSelect Nothing - 0 \nSelect Ice Cream- 1  \nSelect Sprinkles - 2 " +
                "\nSelect Melted Chocolate - 3 \nEnter the number for your topping selection: ");
        do {
            userInput = input.nextInt();

            if (userInput == 0) {
                break;
            } else if (userInput == 1) {
                i++;
                DessertAppToppings.add("Ice Cream");
                Toppings.add("Ice Cream");
            } else if (userInput == 2) {
                DessertAppToppings.add("Sprinkles");
                Toppings.add("Sprinkles");
                i++;
            } else if (userInput == 3) {
                DessertAppToppings.add("Melted Chocolate");
                Toppings.add("Melted Chocolate");
                i++;
            }
        }
        while (userInput != 0);
        for (int j = 0; j < i; j++) {
            System.out.println("You selected: " + Toppings.toArray()[j]);

        }
    }


    public static void main (String[] args){
        String name = placeOrder();
        Scanner input = new Scanner(System.in);
            int menuSelection;
            List<String> appetizerList = new ArrayList<>(), mainCourseList, dessertList, tempList = new ArrayList<>();

            do {
                System.out.println("Menu\n" +
                        "0 - Nothing\n" +
                        "1 - Appetizer\n" +
                        "2 - Main Course\n" +
                        "3 - Dessert\n" + "" +
                        "Enter the number for your selection: \n");
                menuSelection = input.nextInt();

                switch (menuSelection) {
                    case 1 -> {
                        appetizerList.addAll(appetizer(input));


                    }
                    case 2 -> MainCourse();
                    case 3 -> Dessert();
                    default -> {
                    }
                }


                } while (menuSelection != 0);

            System.out.printf("Select from menu, %s:", name);
            System.out.println(" ****Mike's Burgers****    ");
            System.out.println("Thank you for stopping by " + name);
            System.out.println("       Receipt   ");

            if(appetizerList.size()>0) {
                System.out.println("Appetizer:");
                System.out.println(appetizerList);
                if (AppToppings.size() > 0) {
                    System.out.println(AppToppings);
                }if(AppToppings.size() > appetizerList.size()){
                    System.out.println("Additional $0.95 per extra Appetizer Topping");
                    for (int i = appetizerList.size(); i < AppToppings.size(); i++) {
                        cost += 0.95;
                    }
                }
            }else if ((AppToppings.size() > 0) && (appetizerList.size() == 0)) {
                System.out.println("No Appetizer only take out toppings");
                for (int i = 0; i < AppToppings.size(); i++) {
                    System.out.println(AppToppings.toArray()[i]);
                    cost += 0.95;
                }
            }if (MainMeal.size()> 0){
            System.out.println("Main Course:");
                System.out.println(MainMeal);
                if (MealAppToppings.size() > 0) {
                    System.out.println(MealAppToppings);
                    if (MealAppToppings.size() > MainMeal.size()) {
                        System.out.println("Additional $0.95 per extra Main Course toppings");
                        for (int i = MainMeal.size(); i < MealAppToppings.size(); i++) {
                            cost += 0.95;
                        }
                    }
                }
            } else if((MealAppToppings.size() > 0) && (MainMeal.size() == 0)) {
            System.out.println("No Meal only take out toppings.");
            for (int i = 0; i< MealAppToppings.size(); i++) {
                System.out.println(MealAppToppings.toArray()[i]);
                cost += 0.95;
            }
            }if(DessertList.size() > 0) {
            System.out.println("Dessert:");
            System.out.println(DessertList.toString());
            if (DessertAppToppings.size() > 0) {
                System.out.println(DessertAppToppings);
            }
            if (DessertAppToppings.size() > DessertList.size()) {
                System.out.println("Additional $0.95 per extra Main Course toppings");
                for (int i = DessertList.size(); i < DessertAppToppings.size(); i++) {
                    cost += 0.95;
                }
            }
        } else if ((DessertList.size() == 0) && DessertAppToppings.size() > 0){
            System.out.println("No Dessert only take out toppings.");
                for (int i = 0; i< DessertAppToppings.size(); i++) {
                    System.out.println(DessertAppToppings.toArray()[i]);
                    cost += 0.95;
                }
            }
            System.out.printf("Total: $%.02f", cost);
        }
    }


