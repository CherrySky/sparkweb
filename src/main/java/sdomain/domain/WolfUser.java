package sdomain.domain;

/**
 * Created by don on 17/2/2017.
 */
public class WolfUser implements Comparable<WolfUser> {

    String userId;
    String name;
    String gamesPlayedTotal;
    String won;
    String wonPercentage;
    String lost;
    String lostPercentage;
    String survived;
    String survivedPercentage;
    String mostCommonRole;
    String mostCommonRoleTimes;
    String mostKilled;
    String mostKilledName;
    String mostKilledTimes;
    String mostKilledBy;
    String mostKilledByName;
    String mostKilledByTimes;

    public WolfUser(String wolfs, String userId) {
        name = wolfs;
        this.userId = userId;
    }

    public String getMostKilledName() {
        return mostKilledName;
    }

    public void setMostKilledName(String mostKilledName) {
        this.mostKilledName = mostKilledName;
    }

    public String getMostKilledByName() {
        return mostKilledByName;
    }

    public void setMostKilledByName(String mostKilledByName) {
        this.mostKilledByName = mostKilledByName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGamesPlayedTotal() {
        return gamesPlayedTotal;
    }

    public void setGamesPlayedTotal(String gamesPlayedTotal) {
        this.gamesPlayedTotal = gamesPlayedTotal;
    }

    public String getWon() {
        return won;
    }

    public void setWon(String won) {
        this.won = won;
    }

    public String getWonPercentage() {
        return wonPercentage;
    }

    public void setWonPercentage(String wonPercentage) {
        this.wonPercentage = wonPercentage;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }

    public String getLostPercentage() {
        return lostPercentage;
    }

    public void setLostPercentage(String lostPercentage) {
        this.lostPercentage = lostPercentage;
    }

    public String getSurvived() {
        return survived;
    }

    public void setSurvived(String survived) {
        this.survived = survived;
    }

    public String getSurvivedPercentage() {
        return survivedPercentage;
    }

    public void setSurvivedPercentage(String survivedPercentage) {
        this.survivedPercentage = survivedPercentage;
    }

    public String getMostCommonRole() {
        return mostCommonRole;
    }

    public void setMostCommonRole(String mostCommonRole) {
        this.mostCommonRole = mostCommonRole;
    }

    public String getMostCommonRoleTimes() {
        return mostCommonRoleTimes;
    }

    public void setMostCommonRoleTimes(String mostCommonRoleTimes) {
        this.mostCommonRoleTimes = mostCommonRoleTimes;
    }

    public String getMostKilled() {
        return mostKilled;
    }

    public void setMostKilled(String mostKilled) {
        this.mostKilled = mostKilled;
    }

    public String getMostKilledTimes() {
        return mostKilledTimes;
    }

    public void setMostKilledTimes(String mostKilledTimes) {
        this.mostKilledTimes = mostKilledTimes;
    }

    public String getMostKilledBy() {
        return mostKilledBy;
    }

    public void setMostKilledBy(String mostKilledBy) {
        this.mostKilledBy = mostKilledBy;
    }

    public String getMostKilledByTimes() {
        return mostKilledByTimes;
    }

    public void setMostKilledByTimes(String mostKilledByTimes) {
        this.mostKilledByTimes = mostKilledByTimes;
    }

    @Override
    public String toString() {
        return "WolfUser{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", gamesPlayedTotal='" + gamesPlayedTotal + '\'' +
                ", won='" + won + '\'' +
                ", wonPercentage='" + wonPercentage + '\'' +
                ", lost='" + lost + '\'' +
                ", lostPercentage='" + lostPercentage + '\'' +
                ", survived='" + survived + '\'' +
                ", survivedPercentage='" + survivedPercentage + '\'' +
                ", mostCommonRole='" + mostCommonRole + '\'' +
                ", mostCommonRoleTimes='" + mostCommonRoleTimes + '\'' +
                ", mostKilled='" + mostKilled + '\'' +
                ", mostKilledName='" + mostKilledName + '\'' +
                ", mostKilledTimes='" + mostKilledTimes + '\'' +
                ", mostKilledBy='" + mostKilledBy + '\'' +
                ", mostKilledByName='" + mostKilledByName + '\'' +
                ", mostKilledByTimes='" + mostKilledByTimes + '\'' +
                '}';
    }

    @Override
    public int compareTo(WolfUser wolfUser) {
        try {
            int i = Integer.valueOf(wolfUser.getWonPercentage().replace("%", ""));
            int e = Integer.valueOf(this.wonPercentage.replace("%", ""));
            return i - e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
