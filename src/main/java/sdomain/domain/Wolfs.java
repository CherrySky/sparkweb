package sdomain.domain;

/**
 * Created by don on 18/2/2017.
 */
public enum Wolfs {

    DON("327901078", true),
    FongE("362730774", true),
    Kimberly("318250167", true),
    Carrie("213090708", true),
    Bowie("195363026", true),
    Mia("276080654", true),
    Mary("348843344", true),
    Joey("255650454", true),
    Mandy("371226639", true)
    ;

    public boolean isEnable() {
        return enable;
    }

    public String getUserId() {
        return userId;
    }

    String userId;
    boolean enable;

    Wolfs(String userId, boolean enable) {
        this.userId = userId;
        this.enable = enable;
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
