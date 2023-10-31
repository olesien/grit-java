public class Main {
    public static void main(String[] args) {

       arv();
    }

    private static void arv() {
        Parent p = new Parent(1);
        Child c = new Child(5, 10);

        System.out.println("p.x = " + p.x);
        p.myMethod();
        System.out.println("p.x = " + p.x);

        System.out.println("c.x = " + c.x + ", c.y = " + c.y);
        c.myMethod();
        System.out.println("c.x = " + c.x + ", c.y = " + c.y);

    }
}