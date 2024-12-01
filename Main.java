import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int earnings = 0;
        int spendings = 0;

        Scanner scanner = new Scanner(System.in);
        boolean cycle = true;

        while(cycle) {
            menu();
            String input = scanner.nextLine();
            switch(input) {
                case "end":
                    cycle = false;
                    break;
                case "1":
                    System.out.println("Добавить новый доход");
                    earnings += scanner.nextInt();
                    break;
                case "2":
                    System.out.println("Добавить новый расход");
                    spendings += scanner.nextInt();
                    break;
                case "3":
                        int six = tax6(earnings);
                        int fifteen = tax15(earnings,spendings);
                        System.out.println("Мы соетуем вам " + (six < fifteen ? "'УСН доходы'" : "'УСН доходы минус расходы'"));
                        System.out.println("Ваш налог составит: " + (six < fifteen ? six : fifteen));
                        System.out.println("Налог на другой системе: " + (six < fifteen ? fifteen : six));
                        System.out.println("Экономия: " + (six > fifteen ? (six - fifteen) : (fifteen - six)));
                        break;
                default:
                        System.out.println("Введена неверная команда!");
                        break;
            }
        }
        System.out.println("Программа завершена!");

    }
    public static void menu(){
        System.out.println("Выберите операцию и введите ее номер или слово:\n" +
                "1. Добавить новый доход\n" +
                "2. Добавить новый расход\n" +
                "3. Выбрать систему налогообложения\n" +
                "end. Выход из программы");
    }
    public static int tax6 (int earnings){
        return (earnings * 6)/100;
    }
    public static int tax15 (int earnings,int spendings){
        return ((earnings - spendings)*15)/100;
    }
}