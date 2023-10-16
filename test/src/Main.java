import java.util.Scanner;
/*
* Detta är en kommentar i Java - den kan
* täcka flera rader och det som skrivs här ignoreras av kompilatorn.
* */
// En kommentar kan också täcka en rad på detta sättet.
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int age; //Heltal
        String name = "Linus"; //Sträng
        Double point = 0.0; //Flyttal

        System.out.println("Hej " + name + "!");
        System.out.println("Hur gammal är du?");
        Scanner scanner = new Scanner(System.in);
        age = scanner.nextInt();

        final int MAXYEAR = 100;
        int until = MAXYEAR - age;

        System.out.println("Ha ha - det kan inte vara sant att du är " + age + " år gammal!" );

        System.out.println("Det är " + until + " år tills du är i graven (100 år gammal)");
    }
}