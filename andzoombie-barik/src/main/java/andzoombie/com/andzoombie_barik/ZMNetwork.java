package andzoombie.com.andzoombie_barik;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by jhovarie on 11/30/18.
 */

public abstract class ZMNetwork {
    public abstract void getPreRequest();
    public abstract void StringGetResult(final String strresult);

    public abstract void postPreRequest();
    public abstract void StringPostResult(final String strresult);

    private String keyvalhelper(final String keyval[][]) {
        final StringBuilder content = new StringBuilder();
        for(int i = 0; i < keyval.length; i++) {
            content.append(keyval[i][0]);
            content.append("=");
            content.append(URLEncoder.encode(keyval[i][1]));
            content.append("&");
        }
        content.append("remember=");
        content.append(URLEncoder.encode("on"));
        content.append("&output");
        content.append(URLEncoder.encode("xml"));
        return content.toString();
    }

    public void postRequest(final String strurl, final String keyvalue[][]) throws Exception {
        final String reqresult = new AsyncTask<String, Integer, String>() {
            protected void onPreExecute() {
                postPreRequest();
            }

            @Override
            protected String doInBackground(String... params) {
                StringBuilder str = new StringBuilder();
                try {
                    // URLConnection connection = new URL("https://jhovarie.000webhostapp.com/jsonnoarray.json").openConnection();
                    URLConnection connection = new URL(params[0]).openConnection();
                    connection.setDoOutput(true);
                    final String content = keyvalhelper(keyvalue);
                    /* String content =
                            "id=" + URLEncoder.encode("username") +
                                    "&num=" + URLEncoder.encode("password") +
                                    "&remember=" + URLEncoder.encode("on") +
                                    "&output=" + URLEncoder.encode("xml");
                    */

                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    connection.setRequestProperty("Content-Length", String.valueOf(content.getBytes().length));
                    OutputStream output = connection.getOutputStream();
                    output.write(content.getBytes());
                    output.close();

                    String line;
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    while ((line = reader.readLine()) != null) {
                        //System.out.println(line);
                        str.append(line);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return str.toString();
            }
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
            }
        }.execute(strurl).get();
        StringPostResult(reqresult);
    }

    public void getRequest(String strurl) throws Exception {
        final String reqresult = new AsyncTask<String, Integer, String>() {

            @Override
            protected void onPreExecute() {
                getPreRequest();
            }

            @Override
            protected String doInBackground(String... params) {
                StringBuilder str = new StringBuilder();
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    //url = new URL("https://jhovarie.000webhostapp.com/index.php");
                    url = new URL(params[0]);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader isw = new InputStreamReader(in);

                    int data = isw.read();
                    while (data != -1) {
                        char current = (char) data;
                        data = isw.read();
                        str.append(current);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
                return str.toString();
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
            }
        }.execute(strurl).get();
        StringGetResult(reqresult);
    }

}
