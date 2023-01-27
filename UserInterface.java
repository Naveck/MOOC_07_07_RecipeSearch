import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {

    private Scanner scanner;
    private RecipeList recipeList;

    public UserInterface(RecipeList recipeList, Scanner scanner) {
        this.scanner = scanner;
        this.recipeList = recipeList;
    }

    public void start() {
        System.out.println("File to read: ");
        String file = scanner.nextLine();

        try (Scanner fileReader = new Scanner(Paths.get(file))) {

            while (fileReader.hasNextLine()) {
                String name = fileReader.nextLine();
                int cookingTime = Integer.valueOf(fileReader.nextLine());
                ArrayList<String> ingredients = new ArrayList<>();

                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();

                    if (line.isEmpty()) {
                        break;
                    }

                    ingredients.add(line);
                }

                Recipe recipe = new Recipe(name, cookingTime, ingredients);
                recipeList.addRecipe(recipe);
            }
        } catch (Exception e) {
            System.out.println("Reading the file failed.");
        }

        System.out.println("\n"
                + "Commands:\n"
                + "list - lists the recipes\n"
                + "stop - stops the program\n"
                + "find name - searches recipes by name\n"
                + "find cooking time - searches recipes by cooking time\n"
                + "find ingredient - searches recipes by ingredient");

        while (true) {
            System.out.println("\n"
                    + "Enter command:");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                break;
            }

            if (command.equals("list")) {
                System.out.println("\n"
                        + "Recipes:");
                recipeList.printRecipeList();
            }

            if (command.equals("find name")) {
                System.out.println("Searched word: ");
                String search = scanner.nextLine();

                System.out.println("\n"
                        + "Recipes:");
                recipeList.findRecipe(search);
            }

            if (command.equals("find cooking time")) {
                System.out.println("Max cooking time: ");
                int maxTime = Integer.valueOf(scanner.nextLine());

                System.out.println("\n"
                        + "Recipes:");
                recipeList.findCookingTime(maxTime);
            }

            if (command.equals("find ingredient")) {
                System.out.println("Ingredient:");
                String ingredient = scanner.nextLine();

                System.out.println("\n"
                        + "Recipes:");
                recipeList.findIngredient(ingredient);
            }

        }

    }

}
