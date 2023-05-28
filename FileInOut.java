package ArecROP;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class FileInOut {

    public static ArrayList<Pets> fileOut() {
        ArrayList<Pets> pets = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("ArecROP/pet.csv"));) {
            while (scanner.hasNextLine()) {
                pets.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return pets;
    }

    public static Pets getRecordFromLine(String line) {
        Pets pet = new Pets(null, null, null, null, null, null, null);
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(";");
            while (rowScanner.hasNext()) {
                pet.setHumanFriendTypeId(Integer.parseInt(rowScanner.next()));
                pet.setHumanFriendType(rowScanner.next());
                pet.setPetId(Integer.parseInt(rowScanner.next()));
                pet.setPetType(rowScanner.next());
                pet.setPetName(rowScanner.next());
                pet.setBirthday(rowScanner.next());
                pet.setCommand(rowScanner.next());
            }
        }
        return pet;
    }

    public static void fileIn(Pets pet) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("ArecROP/pet.csv", true))) {
            StringBuilder sb = new StringBuilder();
            sb.append(pet.getHumanFriendTypeId());
            sb.append(';');
            sb.append(pet.getHumanFriendType());
            sb.append(';');
            sb.append(pet.getPetId());
            sb.append(';');
            sb.append(pet.getPetType());
            sb.append(';');
            sb.append(pet.getPetName());
            sb.append(';');
            sb.append(pet.getBirthday());
            sb.append(';');
            sb.append(pet.getCommand());
            sb.append('\n');
            writer.write(sb.toString());
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void fileReWrite(List<Pets> pets) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("ArecROP/pet.csv", false))) {
            for (Pets pet : pets) {
                if (pet.getPetId() != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(pet.getHumanFriendTypeId());
                    sb.append(';');
                    sb.append(pet.getHumanFriendType());
                    sb.append(';');
                    sb.append(pet.getPetId());
                    sb.append(';');
                    sb.append(pet.getPetType());
                    sb.append(';');
                    sb.append(pet.getPetName());
                    sb.append(';');
                    sb.append(pet.getBirthday());
                    sb.append(';');
                    sb.append(pet.getCommand());
                    sb.append('\n');
                    writer.write(sb.toString());
                }
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
