import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    double getInput() {
        Output output = new Output();
        output.print("Введите стоимость товара");
        double result;

        while (true) {
            if (scanner.hasNextDouble()) {
                double input = scanner.nextDouble();
                if (input > 0) {
                    result = input;
                    break;
                } else {
                    output.print("Стоимость не должна быть отрицательной. Введите корректное значение.");
                }

            } else {
                output.print("Введите корректное значение");
                scanner.next();
            }

        }
        return result;
    }
}
