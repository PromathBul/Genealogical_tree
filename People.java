import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.function.Function;


public interface People {

    /**
     * Считываение ввода пользователя с типом String
     */
    UnaryOperator<String> input = msg -> {
        System.out.print(msg);
        Scanner scanner = new Scanner(System.in, "cp866");
        String txt = scanner.nextLine();
        return txt;
    };

    /**
     * Получение из массива целых чисел уникальное id
     */
    Function<int[], String> getID = list -> {
        int id = -1;

        for (int i = 0; i < list.length; i++)
            if (list[i] != -1) {
                id = list[i];
                list[i] = -1;
                break;
            }

        return Integer.toString(id);
    };

    /**
     * Запись данных о человеке в массив строк.
     * В методе вызываются метод apply через интерфейс UnaryOperator
     * и apply через интерфейс Function
     */
    Function<int[], String[]> inputInfo = listID -> {
        String[] info = new String[5];
        info[0] = getID.apply(listID);

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
            info[i] = input.apply(message);
        }
        return info;
    };

    /**
     * Метод возвращает объект с переданным конструктором полем: массив строк.
     * Внутри метода вызывается метод apply через интерфейс Function
     */
    Function<int[], Relatives> createPerson = listID -> {
        String[] any = inputInfo.apply(listID);
        return new Relatives(any);
    };

}
