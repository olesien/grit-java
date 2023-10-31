public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog("Pete", "brown");

        dog.Fetch();

        Enemy enemy = new Enemy("Duke", 1000.0, "Hammer", "Torch", "Rheinmetal");
        enemy.Attack("Hammer");
        enemy.Defend();

        Boss boss = new Boss("Tiny", 2000.0, "Sledgehammer", "Brick", "Glock");
        boss.Heal();
        System.out.println(boss.getEnergyLevel());

        Book book = new Book("Slated", "Some name", 500);

        System.out.println(book.getTitle());

        DetectiveStories sherlock = new DetectiveStories("Sherlock Holmes", "Some author", 5000, "Knife", "Dude");

        System.out.println(sherlock.getKiller());

        SelfHelp bible = new SelfHelp("The path to jesus", "Dumbass", 1, "Pray", new String[]{"What is the meaning of god?", "Why should we pray", "Why is god allmighty"});
        bible.DoSelfHelp();

    }
}