import java.util.Scanner;
import java.util.HashMap;

public class Program {

    static HashMap<Relatives, String[]> dictPeople = new HashMap<>();
    public static void main(String[] args) {
        Relatives common = new Relatives(null);
        
        Scanner scanner = new Scanner(System.in, "cp866");

        String[] first = common.inputInfo(Relatives.listID, scanner);
        Relatives one = new Relatives(first);

        String[] second = common.inputInfo(Relatives.listID, scanner);
        Relatives two = new Relatives(second);

        // String[] third = common.inputInfo(Relatives.listID, scanner);
        // Relatives three = new Relatives(third);
        
        // String[] forth = common.inputInfo(Relatives.listID, scanner);
        // Relatives four = new Relatives(forth);

        // String[] fifth = common.inputInfo(Relatives.listID, scanner);
        // Relatives five = new Relatives(fifth);

        // String[] sixth = common.inputInfo(Relatives.listID, scanner);
        // Relatives six = new Relatives(sixth);

        // String[] seventh = common.inputInfo(Relatives.listID, scanner);
        // Relatives seven = new Relatives(seventh);

        dictPeople.put(one, one.getInfo());
        dictPeople.put(two, two.getInfo());
        // dictPeople.put(three, three.getInfo());
        // dictPeople.put(four, four.getInfo());
        // dictPeople.put(five, five.getInfo());
        // dictPeople.put(six, six.getInfo());
        // dictPeople.put(seven, seven.getInfo());

        Menu obj = new Menu();
        obj.menu(scanner);
        scanner.close();
    }
    
}