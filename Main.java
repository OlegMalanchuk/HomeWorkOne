//Завдання: у тебе має бути код, який ти запускаєш і він буде створювати файл,
//        і буде записувати туда те що ти впишеш в командну строку,
//        якщо фаіл існує то він буде через крапку з комою добавляти
//        туда те що ти запишеш в командну строку


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException {

        Scanner scanner  = new Scanner(System.in);

        try {
            File f = new File("E:\\example.txt");

            if (f.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("Type something into the generated file\nyes/no ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")){
            try(FileWriter writer = new FileWriter("E:\\example.txt", true))
            {
                Scanner sc  = new Scanner(System.in);
                String inform= sc.nextLine();
                writer.write(inform);
                writer.append(';');
                writer.append('\n');
                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }

        }
        if (answer.equalsIgnoreCase("no")){
            System.out.println(
                    "no new information has been added to the file");
        }
        if ((!answer.equalsIgnoreCase("yes"))&&(!answer.equalsIgnoreCase("no"))!= false) {
            System.out.println("an error  occurred. select yes or no");
        }



















































    }








}
