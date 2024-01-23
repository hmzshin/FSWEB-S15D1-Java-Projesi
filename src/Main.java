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
                    String userInput = createScanner("Enter food to add to cart,  if you want to add multiple food, separate them by using ','");
                    userInput.split(" ");
                    List<String> vegetables = new ArrayList<>(Arrays.asList(userInput.split(",")));
                    cart = addItem(cart, vegetables);
                    print(cart);
                    break;
                case "2":
                    String scanner2 = createScanner("Enter food to remove from cart, if you want to remove multiple food, separate them by using ','");
                    List<String> itemsToRemove = new ArrayList<>();
                    addItem(itemsToRemove, Arrays.asList(scanner2.split(",")));
                    removeItem(cart, itemsToRemove);
                    print(cart);
                    break;
                default:

            }
        }
    }


    public static List addItem(List list, List item) {
        for (int i = 0; i < item.size(); i++) {
            if (item.get(i) != null) {
                if (list.contains(item.get(i))) {
                    System.out.println(item.get(i) + " is already exist on the list. So can not add to list");
                } else {
                    list.add(((String) item.get(i)).trim());
                }
            }
        }

        return list;
    }

    public static List removeItem(List list, List item) {
        for (int i = 0; i < item.size(); i++) {
            if (list.contains(item.get(i))) {
                System.out.println(item.get(i) + " already exist and will be removed");
                list.remove(item.get(i));
            } else {
                System.out.println(item.get(i) + " does not exist on the list so can not be removed");
            }
        }
        return list;
    }

    public static void print(List list) {
        System.out.println("List: " + list);
    }


    public static String createScanner(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextLine();
    }
}