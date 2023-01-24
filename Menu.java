import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

public class Menu implements People {
    public String diffGeneration(Relatives base, Relatives compare) {
        String txt = String.format("%s относительно %s: \n", compare.getInfo()[2], base.getInfo()[2]);
        int diff = Integer.parseInt(base.getInfo()[1]) - Integer.parseInt(compare.getInfo()[1]);
        if (diff == 0)
            return txt += "одного поколения\n";
        else if (diff == -1)
            if (compare.getInfo()[4].equals("мужской"))
                return txt += "сын\n";
            else
                return txt += "дочь\n";
        else if (diff == -2)
            if (compare.getInfo()[4].equals("мужской"))
                return txt += "внук\n";
            else
                return txt += "внучка\n";
        else if (diff == -3)
            if (compare.getInfo()[4].equals("мужской"))
                return txt += "правнук\n";
            else
                return txt += "правнучка\n";
        else if (diff == 1)
            if (compare.getInfo()[4].equals("мужской"))
                return txt += "отец\n";
            else
                return txt += "мать\n";
        else if (diff == 2)
            if (compare.getInfo()[4].equals("мужской"))
                return txt += "дедушка\n";
            else
                return txt += "бабушка\n";
        else if (diff == 3)
            if (compare.getInfo()[4].equals("мужской"))
                return txt += "прадедушка\n";
            else
                return txt += "прабабушка\n";
        else
            return "нет данных\n";
    }

    public int randomNum(int max) {
        Random rnd = new Random();
        return rnd.nextInt(max);
    }

    public void showList(HashMap<Relatives, String[]> total) {
        for (String[] value : total.values()) {
            for (int count = 0; count < value.length; count++) {
                if (count == 0)
                    System.out.print("id: ");
                else if (count == 1)
                    System.out.print("Generation: ");
                else if (count == 2)
                    System.out.print("First name: ");
                else if (count == 3)
                    System.out.print("Last name: ");
                else
                    System.out.print("Gender: ");

                System.out.println(value[count]);
            }
            System.out.println();
        }
    }

    public void menu(Scanner scanner) {
        String txt = "нет";
        while (!txt.equals("да")) {
            System.out.println("Выберите действие.");
            System.out.println(
                    "1. Вывести список всех людей с информаицей о них.\n2. Получить взаимосвязь поколений между двумя случайными объектами.");
            int choice = Integer.parseInt(input(
                    "3. Получить взаимосвязь поколений между конкретными людьми.\n4. Ввести данные о новом человеке.\n",
                    scanner));
            if (choice == 1)
                showList(Program.dictPeople);
            else if (choice == 2) {
                String firstNum = Integer.toString(randomNum(Program.dictPeople.size()));
                String secondNum = Integer.toString(randomNum(Program.dictPeople.size()));
                Relatives firstObj = getKey(Program.dictPeople, firstNum, 0);
                Relatives secondObj = getKey(Program.dictPeople, secondNum, 0);
                String result = diffGeneration(firstObj, secondObj);
                System.out.println(result);
            } else if (choice == 3) {
                String firstPerson = input("Введите имя первого человека: ", scanner);
                System.out.println(firstPerson);
                String secondPerson = input("Введите имя второго человека: ", scanner);
                Relatives firstObj = getKey(Program.dictPeople, firstPerson, 2);
                Relatives secondObj = getKey(Program.dictPeople, secondPerson, 2);
                String result = diffGeneration(firstObj, secondObj);
                System.out.println(result);
            } /*
               * else {
               * Relatives obj = createPerson(Relatives.listID, scanner);
               * Program.dictPeople.put(obj, obj.getInfo());
               * }
               */
            txt = input("Введите 'да', если хотите завершить, и нажмите ввод, чтобы продолжить...", scanner);
        }

    }

    public Relatives getKey(HashMap<Relatives, String[]> map, String value, int index) {
        for (Relatives key : map.keySet())
            if (value.equals((Program.dictPeople.get(key))[index]))
                return key;
        return null;
    }
}