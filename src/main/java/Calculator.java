import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    int person; //переменная количества персон;
    double total = 0.00; //переменная для подсчета общей стоимости товара;
    Input input = new Input();
    Output output = new Output();
    
    Scanner scanner = new Scanner(System.in);
    ArrayList<Item> itemList = new ArrayList<>(); //список товара и его стоимости;
    Formater format = new Formater(); //создание объекта опредления склонения рубля;

    public void calculator() { //метод расчета товара
        String answer; //переменная ответа на предложение добавить товар;
        double cost = 0.00;
        do {
            output.print("Введите название товара");
            String item = scanner.next();
            cost = input.getInput();
            createItem(item, cost); //создали списочный массив;
            total += cost;
            output.print("Хотите ли добавить еще один товар? В противном случае напишите 'завершить'");
            answer = scanner.next();
        } while (!answer.equalsIgnoreCase("Завершить"));
        System.out.println("Добавленные товары:");
        for (int n = 0; n < itemList.size(); n++) {
            output.print(String.format("%s, стоимостью %.2f %s", itemList.get(n).item, itemList.get(n).cost, format.formater(itemList.get(n).cost)));
        }
        output.print(String.format("Итоговая сумма: %.2f %s", total, format.formater(total)));
        double totalForEach = (total / person);
        output.print(String.format("Каждый человек должен заплатить %.2f %s", totalForEach, format.formater(totalForEach)));
    }

    public void start() {
        output.print("Введите количество персон");

        while (true) {
            output.print("На скольких человек необходимо разделить счёт?");

            if (scanner.hasNextInt()) {
                person = scanner.nextInt();
                if (person > 1) {
                    calculator();
                    break;
                } else if (person == 1) {
                    output.print("Придется вам платить одному.");
                    break;
                }
            } else {
                output.print("Это некорректное значение для подсчёта. Введите целочисленное значение.");
                scanner.next();
            }
        }
    }

    public void createItem(String name, double cost) {
        Item items = new Item(name, cost);
        itemList.add(items);
        output.print("Товар " + items.item + " успешно добавлен");

    }
}