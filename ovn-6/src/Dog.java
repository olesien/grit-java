public class Dog extends Pet {
    Dog(String name, String color) {
        super(name, color);
    }
    void Sit() {
        System.out.println(super.name + " sitter fint");
    }
    void Fetch() {
        System.out.println(super.name + " hämtar pinnen");
    }
}
