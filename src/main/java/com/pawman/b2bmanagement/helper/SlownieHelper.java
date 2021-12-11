package com.pawman.b2bmanagement.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SlownieHelper {

    public static String getText(double value) {
        List<String> documents = new ArrayList<>();

        try {
            // Construct data
            String data = URLEncoder.encode("key1", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("value1", StandardCharsets.UTF_8);
            data += "&" + URLEncoder.encode("key2", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("value2", StandardCharsets.UTF_8);

            // Send data
            URL url = new URL("https://slownie.pl/" + value);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                documents.add(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
        }

        for (String s : documents) {
            if (s.contains("id=\"dataWord\"")) {
                s = s.replace("<p id=\"dataWord\" class=\"word\">", "");
                s = s.replace("</p>", "");
                return s;
            }
        }
        return "";
    }
}
