public class Main {
    public static void main(String[] args) {

        Car suz = new Car("Suzuki", "Samurai", "Black", 1986, 90);
        suz.year = 1986;

        Car volvo = new Car("Volvo", "XC90", "Saffrans Gul", 2022, 190);
        suz.info();
        volvo.info();


        suz.honk();
        Car.honk();

        suz.accelerate((70));


        suz.info();
        volvo.info();

        System.out.println("Ny hastighet för Suzukin: " + suz.accelerate((20)));
        System.out.println("Jag tvärnitar i 5s då får jag hastigheten" + suz.brake(35));


    }
}