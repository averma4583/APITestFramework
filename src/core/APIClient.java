//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package core;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;

public class APIClient {
    private static final HashMap<String, String> propertiesMap = new HashMap();

    public APIClient() {
    }

    public HttpURLConnection sendGet(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", (String)propertiesMap.get("USER_AGENT"));
        con.setRequestProperty("Accept-Language", (String)propertiesMap.get("Accept-Language"));
        return con;
    }

    public HttpURLConnection sendPost(String url) throws Exception {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection)obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", (String)propertiesMap.get("USER_AGENT"));
        con.setRequestProperty("Accept-Language", (String)propertiesMap.get("Accept-Language"));
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes((String)propertiesMap.get("urlParameters"));
        wr.flush();
        wr.close();
        return con;
    }

    static {
        propertiesMap.put("USER_AGENT", "Mozilla/5.0");
        propertiesMap.put("Accept-Language", "en-US,en;q=0.5");
        propertiesMap.put("urlParameters", "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345");
    }
}
