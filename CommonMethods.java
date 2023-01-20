import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

public class CommonMethods {
    public static String diffGeneration(Relatives base, Relatives compare) {
        int diff = Integer.parseInt(base.getGeneration()) - Integer.parseInt(compare.getGeneration());
        if (diff == 0)
            return String.format("%s относительно %s одного поколения\n", compare.getFirstName(), base.getFirstName());
        else if (diff == -1)
            return String.format("%s относительно %s сын или дочь\n", compare.getFirstName(), base.getFirstName());
        else if (diff == -2)
            return String.format("%s относительно %s внук или внучка\n", compare.getFirstName(), base.getFirstName());
        else if (diff == -3)
            return String.format("%s относительно %s правнук или правнучка\n", compare.getFirstName(),
                    base.getFirstName());
        else if (diff == 1)
            return String.format("%s относительно %s отец или мать\n", compare.getFirstName(), base.getFirstName());
        else if (diff == 2)
            return String.format("%s относительно %s дедушка или бабушка\n", compare.getFirstName(),
                    base.getFirstName());
        else if (diff == 3)
            return String.format("%s относительно %s прадедушка или прабабушка\n", compare.getFirstName(),
                    base.getFirstName());
        else
            return "нет данных\n";
    }

    public static String input(String msg, Scanner scanner) {
        System.out.print(msg);
        String txt = scanner.nextLine();
        return txt;
    }

    public static int randomNum(int max) {
        Random rnd = new Random();
        return rnd.nextInt(max);
    }

    public static void showList(HashMap<Relatives, String[]> total) {
        for (String[] value : total.values()) {
            for (int count = 0; count < value.length; count++) {
                if (count == 0)
                    System.out.print("id: ");
                else if (count == 1)
                    System.out.print("Generation: ");
                else if (count == 2)
                    System.out.print("First name: ");
                else
                    System.out.print("Last name: ");

                System.out.println(value[count]);
            }
            System.out.println();
        }
    }

    public static void menu(Scanner scanner) {
        System.out.println("Выберите действие.");
        int choice = Integer.parseInt(input(
                "1. Вывести список всех людей с информаицей о них.\n2. Получить взаимосвязь поколений между двумя случайными объектами.\n3. Получить взаимосвязь поколений между конкретными людьми.\n", scanner));
        if (choice == 1)
            showList(Program.dictPeople);
        else if (choice == 2) {
            String firstNum = Integer.toString(randomNum(Program.dictPeople.size()));
            String secondNum = Integer.toString(randomNum(Program.dictPeople.size()));
            Relatives firstObj = getKey(Program.dictPeople, firstNum, 0);
            Relatives secondObj = getKey(Program.dictPeople, secondNum, 0);
            String result = diffGeneration(firstObj, secondObj);
            System.out.println(result);
        }
        else {
            String firstPerson = input("Введите имя первого человека: ", scanner);
            String secondPerson = input("Введите имя второго человека: ", scanner);
            Relatives firstObj = getKey(Program.dictPeople, firstPerson, 2);
            Relatives secondObj = getKey(Program.dictPeople, secondPerson, 2);
            String result = diffGeneration(firstObj, secondObj);
            System.out.println(result);
        }
    }

    public static Relatives getKey(HashMap<Relatives, String[]> map, String value, int index) {
        for (Relatives key : map.keySet())
            if (value.equals((Program.dictPeople.get(key))[index]))
                return key;
        return null;
    }
}