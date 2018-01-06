package sdomain.services;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.eclipse.jetty.websocket.api.StatusCode;
import sdomain.domain.WolfUser;
import sdomain.domain.Wolfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by don on 18/2/2017.
 */
public class WolfStatWebService {

    CloseableHttpClient httpclient = HttpClients.createDefault();

    private final static String GAMES_PLAYED_TOTAL = "Games played total";
    private final static String GAME_WON = "Games won";
    private final static String GAME_LOST = "Games lost";
    private final static String GAMES_SURVIVED = "Games survived";
    private final static String MOST_COMMON_ROLE = "Most common role";
    private final static String MOST_KILLED = "Most killed";
    private final static String MOST_KILLED_BY = "Most killed by";

    private final static String tab1Pattern = "\\u003c/td\\u003e\\u003ctd\\u003e\\u003cb\\u003e";
    private final static String tab2Pattern = "\\u003c/td\\u003e\\u003ctd\\u003e";

    private final static String end = "\\u003c/b";

    public WolfUser getWolfUserStatus(Wolfs wolfs) throws IOException {
        //System.out.println("getWolfStatus: " + wolfs);
        WolfUser wolfUser = new WolfUser(wolfs.name(), wolfs.getUserId());
        HttpGet httpGet = new HttpGet("http://www.tgwerewolf.com/Stats/PlayerStats?pid=" + wolfs.getUserId());
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        try {
            if (response1.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader br;
                br = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));
                String line;
                while ((line = br.readLine()) != null) {
                    enrichedWolfUser(wolfUser, line);
                }
            }
        } finally {
            response1.close();
        }
        return wolfUser;
    }

    private void enrichedWolfUser(WolfUser wolfUser, String data) {

        int i = data.indexOf(GAMES_PLAYED_TOTAL);
        int endIndex = data.indexOf(end);
        String number = data.substring(i + GAMES_PLAYED_TOTAL.length() + tab1Pattern.length(), endIndex);
        ;
        wolfUser.setGamesPlayedTotal(number);

        i = data.indexOf(GAME_WON);
        endIndex = data.indexOf(end, i);
        String block = data.substring(i + GAME_WON.length() + tab1Pattern.length(), endIndex);
        ;
        int middle = block.indexOf(tab2Pattern);
        wolfUser.setWon(block.substring(0, middle));
        wolfUser.setWonPercentage(block.substring(middle + tab2Pattern.length(), block.length()));

        i = data.indexOf(GAME_LOST);
        endIndex = data.indexOf(end, i);
        block = data.substring(i + GAME_LOST.length() + tab1Pattern.length(), endIndex);
        ;
        middle = block.indexOf(tab2Pattern);
        wolfUser.setLost(block.substring(0, middle));
        wolfUser.setLostPercentage(block.substring(middle + tab2Pattern.length(), block.length()));

        i = data.indexOf(GAMES_SURVIVED);
        endIndex = data.indexOf(end, i);
        block = data.substring(i + GAMES_SURVIVED.length() + tab1Pattern.length(), endIndex);
        ;
        middle = block.indexOf(tab2Pattern);
        wolfUser.setSurvived(block.substring(0, middle));
        wolfUser.setSurvivedPercentage(block.substring(middle + tab2Pattern.length(), block.length()));

        i = data.indexOf(MOST_COMMON_ROLE);
        endIndex = data.indexOf(end, i);
        block = data.substring(i + MOST_COMMON_ROLE.length() + tab1Pattern.length(), endIndex);
        ;
        middle = block.indexOf(tab2Pattern);
        wolfUser.setMostCommonRole(block.substring(0, middle));
        wolfUser.setMostCommonRoleTimes(block.substring(middle + tab2Pattern.length(), block.length()));

        i = data.indexOf(MOST_KILLED);
        endIndex = data.indexOf(end, i);
        block = data.substring(i + MOST_KILLED.length() + tab1Pattern.length(), endIndex);
        ;
        middle = block.indexOf(tab2Pattern);

        String mostKilledId = getWolfUserId(block.substring(0, middle));
        wolfUser.setMostKilled(mostKilledId);
        if (Wolfs.getById(mostKilledId) != null) {
            wolfUser.setMostKilledName(Wolfs.getById(mostKilledId));
        } else {
            wolfUser.setMostKilledName(findUserById(mostKilledId));
        }

        wolfUser.setMostKilledTimes(block.substring(middle + tab2Pattern.length(), block.length()));

        i = data.indexOf(MOST_KILLED_BY);
        endIndex = data.indexOf(end, i);
        block = data.substring(i + MOST_KILLED_BY.length() + tab1Pattern.length(), endIndex);
        ;
        middle = block.indexOf(tab2Pattern);

        String mostKilledById = getWolfUserId(block.substring(0, middle));
        wolfUser.setMostKilledBy(mostKilledById);
        if (Wolfs.getById(mostKilledById) != null) {
            wolfUser.setMostKilledByName(Wolfs.getById(mostKilledById));
        } else {
            wolfUser.setMostKilledByName(findUserById(mostKilledById));
        }
        wolfUser.setMostKilledByTimes(block.substring(middle + tab2Pattern.length(), block.length()));

        //System.out.println(wolfUser);

    }

    private String findUserById(String mostKilledId) {
        String name = "Unknown id: " + mostKilledId;
        try {

            HttpGet httpGet = new HttpGet("http://www.tgwerewolf.com/Stats/Player/" + mostKilledId);
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            try {
                System.out.println(response1.getStatusLine());
                BufferedReader br;
                br = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));
                String line;
                while ((line = br.readLine()) != null) {
                    //name = findName(line);
                    System.out.println(line);
                    break;
                }
            } finally {
                response1.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    private String findName(String line) {
        System.out.println(line);
        System.out.println(line);
        return "";
    }

    private String getWolfUserId(String substring) {
        int player = substring.indexOf("Player");
        int end = substring.indexOf("\\u0027\\u003e");
        return substring.substring(player + 7, end);

    }

    public static void main(String[] args) {
        new WolfStatWebService().start();
    }

    private void start() {
        try {
            getWolfUserStatus(Wolfs.Mandy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
