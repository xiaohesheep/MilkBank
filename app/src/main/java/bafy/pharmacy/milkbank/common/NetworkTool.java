package bafy.pharmacy.milkbank.common;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkTool {

    /**
     * 请求服务器超时时间
     */
    private static final int REQUEST_TIME_OUT = 9000;
    /**
     * 读取响应的数据时间
     */
    private static final int READ_TIME_OUT = 8000;
    /**
     * 获取网址内容 url
     */
    public static String getContent(String ss) throws Exception{
        StringBuilder sb = new StringBuilder();
        String line = null;

        HttpURLConnection conn=getUrl(ss);

        if (conn != null){
            BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"), 8192);
            while((line = buffer.readLine()) != null){
                sb.append(line);
            }
        }else
        {
            sb.append("");
        }

        return sb.toString();
    }


    ///获取http连接
    public static HttpURLConnection getUrl(String ss)
    {

        HttpURLConnection conn=null;
        try{
            URL url=null;
            url = new URL(ss);
            String line = null;
            conn=(HttpURLConnection)(url.openConnection());
            conn.setConnectTimeout(REQUEST_TIME_OUT);
            conn.setReadTimeout(READ_TIME_OUT);
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                return conn;
            }


        }catch(Exception e){
            return conn;
        }
        return conn;

    }


}
