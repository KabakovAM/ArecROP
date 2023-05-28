package ArecROP;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
    static Scanner iScanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("\nArec Registry Of Pets");
        System.out.println(
                "\nВыберите действие:\n1 - Завести новое животное\n2 - Список всех животных\n0 - Выйти из программы");
        switch (iScanner.nextLine()) {
            case ("1"):
                menu1();
                break;
            case ("2"):
                changePet();
                break;
            case ("0"):
                break;
            default:
                System.out.println("\nВведено неверное значение! Повторите ввод!");
                menu();
                break;
        }
    }

    public static void menu1() {
        System.out.println(
                "\nВыберите тип животного:\n1 - Домашнее животное\n2 - Вьючное животное");
        switch (iScanner.nextLine()) {
            case ("1"):
                newPet(1);
                break;
            case ("2"):
                newPet(2);
                break;
            default:
                System.out.println("\nВведено неверное значение! Повторите ввод!");
                menu1();
                break;
        }
    }

    public static void newPet(int x) {
        Pets pet = new Pets(null, null, null, null, null, null, null);
        pet.setPetId(HumanFriendsId.idFile("ArecROP/HumanFriendsId.csv"));
        if (x == 1) {
            pet.setHumanFriendTypeId(1);
            pet.setHumanFriendType("Домашнее животное");
        } else {
            pet.setHumanFriendTypeId(2);
            pet.setHumanFriendType("Вьючное животное");
        }
        System.out.println("Введите название животного:");
        pet.setPetType(Except.stringExcept(iScanner.nextLine()));
        System.out.println("Введите имя животного:");
        pet.setPetName(Except.stringExcept(iScanner.nextLine()));
        System.out.println("Введите дату рождения животного в формате YYYY-MM-DD:");
        pet.setBirthday(Except.checkBirthday(iScanner.nextLine()));
        System.out.println("Введите команды животного:");
        pet.setCommand(Except.stringExcept(iScanner.nextLine()));
        FileInOut.fileIn(pet);
        System.out.println("\nЖивотное успешно добалено. Выход в главное меню.");
        menu();
    }

    public static void changePet() {
        ArrayList<Pets> pets = FileInOut.fileOut();
        System.out.println("\nЖивотные в наличии:\n");
        for (Pets pet : pets) {
            System.out.println(pet.toString());
        }
        System.out.println("\nВведите ID животного для его изменения:");
        Pets oldPet = Except.nameExcept(pets);
        int tempId = oldPet.getPetId();
        System.out.println("\n1 - Удалить животное\n2 - Изменить команды");
        switch (iScanner.nextLine()) {
            case ("1"):
                oldPet.setPetId(0);
                break;
            case ("2"):
                System.out.println("Введите команды животного:");
                oldPet.setCommand(Except.stringExcept(iScanner.nextLine()));
                break;
            default:
                System.out.println("\nВведено неверное значение! Повторите ввод!");
                changePet();
                break;
        }
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getPetId() == tempId){
                pets.set(i, oldPet);
            }
        }
        FileInOut.fileReWrite(pets);
        System.out.println("\nЖивотное успешно изменино(удалено). Выход в главное меню.");
        menu();
    }
}
