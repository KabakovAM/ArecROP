package ArecROP;

import java.util.List;
import java.util.Scanner;

public class Except {
    static Scanner iScanner = new Scanner(System.in);

    public static Pets nameExcept(List<Pets> pets) {
        int a = 0;
        while (!iScanner.hasNextInt()) {
            System.out.println("\nВведено неверное значение! Повторите ввод!");
            iScanner.next();
        }
        a = iScanner.nextInt();
        for (Pets pet : pets) {
            if (a == pet.getPetId()) {
                return pet;
            }
        }
        System.out.println("\nВведено неверное значение! Повторите ввод!");
        return nameExcept(pets);
    }

    public static String stringExcept(String data) {
        if (data.contains(";")) {
            System.out.println("\nВведено неверное значение! Использовать символ ';' нельзя! Повторите ввод!");
            data = iScanner.nextLine();
            stringExcept(data);
        }
        return data;
    }

    public static String checkBirthday(String data) {
        if (checkBirthdayHelp(data)) {
            System.out.println("\nВведено неверное значение! Формат даты YYYY-MM-DD! Повторите ввод!");
            data = iScanner.nextLine();
            stringExcept(data);
        }
        return data;
    }

    public static Boolean checkBirthdayHelp(String data) {
        String[] birthdayArray = data.split("-");
        if (birthdayArray.length != 3) {
            return true;
        }
        Integer day;
        Integer month;
        Integer year;
        try {
            day = Integer.parseInt(birthdayArray[2]);
            month = Integer.parseInt(birthdayArray[1]);
            year = Integer.parseInt(birthdayArray[0]);
        } catch (Exception e) {
            return true;
        }
        if (day < 1 || day > 31 || month < 1 || month > 12) {
            return true;
        }
        return false;
    }
}
