package Helper;

import java.net.HttpURLConnection;
import java.net.URL;

//Класс для получения статус-кодов при работе со ссылками
public class LinkUtil {

    public static int getResponseCode(String link) {

        URL url;
        HttpURLConnection connection = null;
        int responseCode = 0;

        try {

            url = new URL(link);
            connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();

        } catch (Exception e) {

        } finally {
            if (connection != null)
                connection.disconnect();
        }

        return responseCode;
    }
}
