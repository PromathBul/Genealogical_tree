
import java.util.Scanner;

/**
 * People
 */
public interface People {

    default String input(String msg, Scanner scanner) {
        System.out.print(msg);
        String txt = scanner.nextLine();
        return txt;
    }

    default String getID(int[] list) {
        int id = -1;

        for (int i = 0; i < list.length; i++)
            if (list[i] != -1) {
                id = list[i];
                list[i] = -1;
                break;
            }

        return Integer.toString(id);
    }

    default String[] inputInfo(int[] listID, Scanner scanner) {
        String[] info = new String[5];
        info[0] = getID(listID);

        for (int i = 1; i < info.length; i++) {
            String message = "Введите ";
            if (i == 1)
                message += "номер поколения: ";
            else if (i == 2)
                message += "имя: ";
            else if (i == 3)
                message += "фамилию: ";
            else
                message += "пол: ";
            info[i] = input(message, scanner);
        }
        return info;
    }
    
    default Relatives createPerson(int[] listID, Scanner scanner){

        String[] any = inputInfo(listID, scanner);
        Relatives obj = new Relatives(any);

        return obj;
    }

}
