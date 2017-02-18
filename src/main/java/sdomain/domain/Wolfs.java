package sdomain.domain;

/**
 * Created by don on 18/2/2017.
 */
public enum Wolfs {

    DON("327901078"),
    FongE("362730774"),
    Kimberly("318250167"),
    Carrie("213090708"),
    Bowie("195363026"),
    Mia("276080654"),
    Mary("348843344"),
    Joey("255650454"),
    ;

    public String getUserId() {
        return userId;
    }

    String userId;

    Wolfs(String userId) {
        this.userId = userId;
    }

    public static String getById(String id) {
        for (Wolfs wolfs : Wolfs.values()) {
            String i = wolfs.getUserId();
            if (i.equals(id)) {
                return wolfs.name();
            };
        }
        System.out.println("id " + id + " not found in Wolfs.java enum");
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Wolfs.getById("362730774"));
    }
}
