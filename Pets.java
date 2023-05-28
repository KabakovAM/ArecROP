package ArecROP;

public class Pets {
    Integer humanFriendTypeId;
    String humanFriendType;
    Integer petId;
    String petType;
    String petName;
    String birthday;
    String command;

    public Pets(Integer humanFriendTypeId, String humanFriendType, Integer petId, String petType, String petName,
            String birthday, String command) {
        this.humanFriendTypeId = humanFriendTypeId;
        this.humanFriendType = humanFriendType;
        this.petId = petId;
        this.petType = petType;
        this.petName = petName;
        this.birthday = birthday;
        this.command = command;
    }

    @Override
    public String toString() {
        return "ID: " + petId + " || Класс: " + humanFriendType + " || Название: " + petType + " || Имя: " + petName
                + " || Дата рождения: " + birthday + " || Команда: " + command;
    }

    public Integer setPetId(Integer petId) {
        return this.petId = petId;
    }

    public String setPetType(String petType) {
        return this.petType = petType;
    }

    public String setPetName(String petName) {
        return this.petName = petName;
    }

    public String setBirthday(String birthday) {
        return this.birthday = birthday;
    }

    public String setCommand(String command) {
        return this.command = command;
    }

    public String getPetType() {
        return this.petType;
    }

    public Integer getPetId() {
        return this.petId;
    }

    public String getPetName() {
        return this.petName;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getCommand() {
        return this.command;
    }

    public Integer setHumanFriendTypeId(Integer humanFriendTypeId) {
        return this.humanFriendTypeId = humanFriendTypeId;
    }

    public String setHumanFriendType(String humanFriendType) {
        return this.humanFriendType = humanFriendType;
    }

    public Integer getHumanFriendTypeId() {
        return this.humanFriendTypeId;
    }

    public String getHumanFriendType() {
        return this.humanFriendType;
    }
}
