public class DetectiveStories extends Book{
    private String murderWeapon;
    private String killer;
    DetectiveStories(String title, String author, int pages, String murderWeapon, String killer) {
        super(title, author, pages);

        this.murderWeapon = murderWeapon;
        this.killer = killer;
    }

    public String getMurderWeapon() {
        return murderWeapon;
    }

    public String getKiller() {
        return killer;
    }
}
