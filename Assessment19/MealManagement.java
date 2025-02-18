import java.util.*;

abstract class MealPlan {
    String mealName;
    int price;
    
    MealPlan(String mealName, int price) {
        this.mealName = mealName;
        this.price = price;
    }
    
    abstract void displayInfo();
}

class VegetarianMeal extends MealPlan {
    VegetarianMeal(String mealName, int price) {
        super(mealName, price);
    }

    @Override
    void displayInfo() {
        System.out.println("Vegetarian Meal: " + mealName + ", Price: " + price);
    }
}

class VeganMeal extends MealPlan {
    VeganMeal(String mealName, int price) {
        super(mealName, price);
    }

    @Override
    void displayInfo() {
        System.out.println("Vegan Meal: " + mealName + ", Price: " + price);
    }
}

class NonVegetarianMeal extends MealPlan {
    NonVegetarianMeal(String mealName, int price) {
        super(mealName, price);
    }

    @Override
    void displayInfo() {
        System.out.println("Non-Vegetarian Meal: " + mealName + ", Price: " + price);
    }
}

class HighProteinMeal extends MealPlan {
    HighProteinMeal(String mealName, int price) {
        super(mealName, price);
    }

    @Override
    void displayInfo() {
        System.out.println("High-Protein Meal: " + mealName + ", Price: " + price);
    }
}

class KetoMeal extends MealPlan {
    KetoMeal(String mealName, int price) {
        super(mealName, price);
    }

    @Override
    void displayInfo() {
        System.out.println("Keto Meal: " + mealName + ", Price: " + price);
    }
}

// Generic class to manage meals
class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public void displayParticularMealInfo() {
        for (T meal : meals) {
            meal.displayInfo();
        }
    }

    public void personalisedMealPlan(T meal) {
        System.out.println("\nPersonalized Meal Plan for: " + meal.mealName);
        // meal.getClass().getSimpleName() returns the class name of the object stored in meal, without the package name.
        switch (meal.getClass().getSimpleName()) {
            case "VegetarianMeal":
                System.out.println("Suggested items: Grilled Vegetables, Paneer Curry, Rice");
                break;
            case "VeganMeal":
                System.out.println("Suggested items: Tofu Stir-fry, Quinoa, Green Salad");
                break;
            case "NonVegetarianMeal":
                System.out.println("Suggested items: Grilled Chicken, Fish Curry, Boiled Eggs");
                break;
            case "HighProteinMeal":
                System.out.println("Suggested items: Chicken Breast, Lentil Soup, Egg Whites");
                break;
            case "KetoMeal":
                System.out.println("Suggested items: Avocado Salad, Keto Bread, Butter Coffee");
                break;
            default:
                System.out.println("No suggestions available.");
        }
    }
}

// Wildcard method to display mixed meal types
public class Main {
    public static void displayAllMeals(List<? extends MealPlan> mealList) {
        for (MealPlan meal : mealList) {
            meal.displayInfo();
        }
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeals = new Meal<>();
        vegMeals.addMeal(new VegetarianMeal("Paneer Tikka", 300));
        vegMeals.addMeal(new VegetarianMeal("Vegetable Curry", 250));

        Meal<VeganMeal> veganMeals = new Meal<>();
        veganMeals.addMeal(new VeganMeal("Vegan Salad", 350));
        veganMeals.addMeal(new VeganMeal("Tofu Rice", 400));

        Meal<KetoMeal> ketoMeals = new Meal<>();
        ketoMeals.addMeal(new KetoMeal("Keto Chicken", 500));
        ketoMeals.addMeal(new KetoMeal("Bulletproof Coffee", 200));

        System.out.println("Vegetarian Meals:");
        vegMeals.displayParticularMealInfo();

        System.out.println("\nVegan Meals:");
        veganMeals.displayParticularMealInfo();

        System.out.println("\nKeto Meals:");
        ketoMeals.displayParticularMealInfo();

        // Using Personalized Meal Plan
        vegMeals.personalisedMealPlan(new VegetarianMeal("Vegetable Curry", 250));
        ketoMeals.personalisedMealPlan(new KetoMeal("Keto Chicken", 500));

        System.out.println("\nDisplaying All Meals Using Wildcard:");
        List<MealPlan> allMeals = new ArrayList<>();
        allMeals.add(new VegetarianMeal("Dal Makhani", 350));
        allMeals.add(new VeganMeal("Vegan Pasta", 450));
        allMeals.add(new KetoMeal("Bacon Wrap", 600));

        displayAllMeals(allMeals);
    }
}

// class Example {}

// public class Main {
//     public static void main(String[] args) {
//         Example obj = new Example();
//         System.out.println(obj.getClass().getSimpleName());
//     }
// }
// Output:
// Example
// Comparison:
// Method	                               Output
// obj.getClass().getName()	            package_name.Example
// obj.getClass().getSimpleName()	    Example
// obj.getClass().getCanonicalName()	package_name.Example
