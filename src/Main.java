import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<String> cart = new ArrayList<>();
        boolean shouldContinue = true;

        while (shouldContinue) {
            String mode = createScanner("Enter 1 to add item, Enter 2 to remove item, Enter  0 to terminate app ");

            switch (mode) {
                case "0":
                    shouldContinue = false;
                    break;
                case "1":
                    String userInput = createScanner(
                            "Enter food to add to cart,  if you want to add multiple food, separate them by using ','");
                    List<String> vegetables = new ArrayList<>(Arrays.asList(userInput.split(",")));
                    addItem(cart, vegetables);
                    print(cart);
                    break;
                case "2":
                    String scanner2 = createScanner(
                            "Enter food to remove from cart, if you want to remove multiple food, separate them by using ','");
                    List<String> itemsToRemove = new ArrayList<>();
                    addItem(itemsToRemove, Arrays.asList(scanner2.split(",")));
                    removeItem(cart, itemsToRemove);
                    print(cart);
                    break;
                default:

            }
        }
    }

    public static void addItem(List<String> list, List<String> item) {
        for (Object o : item) {
            if (o != null) {
                if (list.contains(o)) {
                    System.out.println(o + " is already exist on the list. So can not add to list");
                } else {
                    list.add(((String) o).trim());
                }
            }
        }
    }

    public static void removeItem(List<String> list, List<String> item) {
        for (Object o : item) {
            if (list.contains(o)) {
                System.out.println(o + " already exist and will be removed");
                list.remove(o);
            } else {
                System.out.println(o + " does not exist on the list so can not be removed");
            }
        }
    }

    public static void print(List<String> list) {
        System.out.println("List: " + list);
    }

    public static String createScanner(String text) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(text);
            return scanner.nextLine();
        }
    }
}