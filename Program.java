import java.util.Scanner;
import java.util.HashMap;

public class Program {

    static HashMap<Relatives, String[]> dictPeople = new HashMap<>();
    public static void main(String[] args) {
        Relatives me = new Relatives("1", "0", "Dmitry", "Тихонов");
        Relatives wife = new Relatives("2", "0", "Darya", "Тихонова");
        Relatives daughter = new Relatives("3", "1", "Полина", "Шишлова");
        Relatives mother = new Relatives("4", "-1", "Надежда", "Тихонова");
        Relatives father = new Relatives("5", "-1", "Владимир", "Тихонов");
        Relatives grandma = new Relatives("6", "-2", "Мария", "Самохвалова");
        Relatives grandpa = new Relatives("0", "-2", "Алексей", "Самохвалов");

        dictPeople.put(me, me.getInfo());
        dictPeople.put(wife, wife.getInfo());
        dictPeople.put(daughter, daughter.getInfo());
        dictPeople.put(mother, mother.getInfo());
        dictPeople.put(father, father.getInfo());
        dictPeople.put(grandma, grandma.getInfo());
        dictPeople.put(grandpa, grandpa.getInfo());

        Scanner scanner = new Scanner(System.in, "cp866");
        CommonMethods.menu(scanner);
        scanner.close();
    }
    
}