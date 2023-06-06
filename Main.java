//Завдання: у тебе має бути код, який ти запускаєш і він буде створювати файл,
//        і буде записувати туда те що ти впишеш в командну строку,
//        якщо фаіл існує то він буде через крапку з комою додавати
//        туда те що ти запишеш в командну строку


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        try {//оператор який шукає винятки або помилки вказани
            File f = new File("E:\\example.txt");//папка і шлях до файлу

            if (f.createNewFile())// створює файл
                System.out.println("File created");
            else//якщо файл з таким ніком існужє пише нище
                System.out.println("File already exists");
        } catch (
                Exception e) {//Exception це супер клас із всіма винятками  які є в дажава і якщо якийсь з них виплива виведетья е
            System.err.println(e);
        }
        System.out.println("Type something into the generated file\nyes/no ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {// спрацюовує якщо користував хоче ввести дані і похуй на регстер
            try (FileWriter writer = new FileWriter("E:\\example.txt", true))//якщ ввести folse то дані в нотатках зберігатися не будудть
            {
                Scanner sc = new Scanner(System.in);
                String inform = sc.nextLine();
                writer.write(inform);//запис(або + до вже існуючої) в текстовий документ який створився інформації
                writer.append(';');//добавляє в кінці кожного записаного слова ;
                writer.append('\n');//пише з нового рядка
                writer.flush();//завершує запис інформації
            } catch (IOException ex) {//шекає помилка типу IOException якщо знаходить присвоює її  значення ex

                System.out.println(ex.getMessage());// якщо помилка виявлена виводить The system cannot find the file specified


            }

        }
        if (answer.equalsIgnoreCase("no")) {//банальний іф порівняння
            System.out.println(
                    "no new information has been added to the file");
        }
        if ((!answer.equalsIgnoreCase("yes")) && (!answer.equalsIgnoreCase("no")) != false) {//якщо користувач введе хуйню якусь
            System.out.println("an error  occurred. select yes or no");
        }


    }


}
