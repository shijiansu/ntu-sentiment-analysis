package ci.entity;

public class Facebook {
    public static Facebook[] FACEBOOKS = new Facebook[] { //
    new Facebook(1, "Prevent Cancer Foundation", "USA"),//
            new Facebook(2, "Cancer Prevention Coalition", "USA"),//
            new Facebook(3, "Norris Cotton Cancer Center", "USA"),//
            new Facebook(4, "Prevent Cancer Now", "Canada"),//
            new Facebook(5, "365 Cancer Prevention Society", "Singapore") };

    public Facebook() {

    }

    public Facebook(int id, String facebookPage, String country) {
        super();
        this.id = id;
        this.facebookPage = facebookPage;
        this.country = country;
    }

    private int id;
    private String facebookPage;
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacebookPage() {
        return facebookPage;
    }

    public void setFacebookPage(String facebookPage) {
        this.facebookPage = facebookPage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
