import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    int person; //переменная количества персон;
    double total = 0.00; //переменная для подсчета общей стоимости товара;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Item> itemList = new ArrayList<>(); //список товара и его стоимости;
    Formater format = new Formater(); //создание объекта опредления склонения рубля;

    public void calculator() { //метод расчета товара
        String answer; //переменная ответа на предложение добавить товар;
        do {
            System.out.println("Введите название товара");
            String item = scanner.next();
            System.out.println("Введите стоимость товара");
            double cost = scanner.nextDouble();
            createItem(item, cost); //создали списочный массив;
            total += cost;
            System.out.println("Хотите ли добавить еще один товар?");
            answer = scanner.next();
        } while (!answer.equalsIgnoreCase("Завершить"));
        System.out.println("Добавленные товары:");
        for (int n = 0; n < itemList.size(); n++) {
            System.out.println(String.format("%s, стоимостью %.2f %s", itemList.get(n).item, itemList.get(n).cost, format.formater(itemList.get(n).cost)));
        }
        System.out.println(String.format("Итоговая сумма: %.2f %s", total, format.formater(total)));
        double totalForEach = (total / person);
        System.out.println(String.format("Каждый человек должен заплатить %.2f %s", totalForEach, format.formater(totalForEach)));
    }

    public void start() {
        System.out.println("Введите количество персон");

        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт?");

            if (scanner.hasNextInt()) {
                person = scanner.nextInt();
                if (person > 1) {
                    calculator();
                    break;
                } else if (person == 1) {
                    System.out.println("Придется вам платить одному.");
                    break;
                }
            } else {
                System.out.println("Это некорректное значение для подсчёта. Введите целочисленное значение.");
                scanner.next();
            }
        }
    }

    public void createItem(String name, double cost) {
        Item items = new Item(name, cost);
        itemList.add(items);
        System.out.println("Товар " + items.item + " успешно добавлен");

    }
}