package cafe.model;

public class Check {

    private static String title;
    private static String adress;
    private static String passWifi;
    private static String wish;

    public Check() {
    }

    public Check(String title, String adress, String passWifi, String wish) {
        Check.title = title;
        Check.adress = adress;
        Check.passWifi = passWifi;
        Check.wish = wish;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(final String title) {
        Check.title = title;
    }

    public static String getAdress() {
        return adress;
    }

    public static void setAdress(final String adress) {
        Check.adress = adress;
    }

    public static String getPassWifi() {
        return passWifi;
    }

    public static void setPassWifi(final String passWifi) {
        Check.passWifi = passWifi;
    }

    public static String getWish() {
        return wish;
    }

    public static void setWish(final String wish) {
        Check.wish = wish;
    }

}
