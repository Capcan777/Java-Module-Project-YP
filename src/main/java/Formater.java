public class Formater {

    public String formater (double cost) { //метод склонения слова рубль
        if ((cost % 10) == 1) {
            return "рубль";
        } else if ((cost % 100) >= 11 && (cost % 100) <= 19) {
            return "рублей";
        } else if ((cost % 10) >= 2 && (cost % 10) <= 4) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}
