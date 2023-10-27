public class Pet {
    String name;
    String type;
    String color;

    Pet(String name, String type, String color) {
        this.name = name;
        this.type = type;
        this.color = color;
    }

    String info() {
        return "Your " + type + " is named " + name + " and they are " + color;
    }
}
