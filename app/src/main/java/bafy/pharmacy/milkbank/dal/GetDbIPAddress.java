package bafy.pharmacy.milkbank.dal;

import android.os.Environment;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;

import bafy.pharmacy.milkbank.common.FileUtils;

public class GetDbIPAddress {

    public  String IPAddressSDcard ()
    {
        String IP=""; //"/dthealth/web/csp/dhc.pharmacy.pda.common.getdata.csp" ;

        File file = new File(Environment.getExternalStorageDirectory(),
                "config.txt");
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            try {
                FileInputStream inputStream = new FileInputStream(file);
                byte[] b = new byte[inputStream.available()];
                inputStream.read(b);
                String filecontent=new String(b);

                JSONTokener jsonParser = new JSONTokener(filecontent);
                JSONObject js = (JSONObject)jsonParser.nextValue();
                IP="http://"+js.getString("DataUrl")+CspName();

            } catch (Exception e) {
                return "";
            }
        }

        return IP;
    }
    public  String ConfigName ()
    {
        String Name="config.txt" ;
        return Name;

    }

    public  String CspName ()
    {
        String Name="/dthealth/web/csp/dhc.pharmacy.pda.common.getdata.csp" ;
        return Name;
    }

    ///取文件服务器地扯
    public  String WebIPAddressSDcard ()
    {
        String IP="";

        File file = new File(Environment.getExternalStorageDirectory(),
                ConfigName());
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            try {
                FileInputStream inputStream = new FileInputStream(file);
                byte[] b = new byte[inputStream.available()];
                inputStream.read(b);
                String filecontent=new String(b);

                JSONTokener jsonParser = new JSONTokener(filecontent);
                JSONObject js = (JSONObject)jsonParser.nextValue();
                IP="http://"+js.getString("WebUrl")+"/dthealth/web/";

            } catch (Exception e) {
                return "error";
            }
        }

        return IP;
    }




    ///从内存取数据服务器地扯
    public  String IPAddress ()
    {
        String IP="";
        FileUtils file=new FileUtils();
        try {
            String url="/data/data/dhc.pharmacy.activity/files/config.txt";
            String filecontent=file.read(url);

            JSONTokener jsonParser = new JSONTokener(filecontent);
            JSONObject js = (JSONObject)jsonParser.nextValue();
            IP="http://"+js.getString("DataUrl")+CspName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IP;
    }


    ///从内存取文件服务器地扯
    public  String WebIPAddress ()
    {
        String IP="";
        FileUtils file=new FileUtils();
        try {
            String url="/data/data/dhc.pharmacy.activity/files/config.txt";
            String filecontent=file.read(url);

            JSONTokener jsonParser = new JSONTokener(filecontent);
            JSONObject js = (JSONObject)jsonParser.nextValue();
            IP="http://"+js.getString("WebUrl")+"/dthealth/web/addins/client/DHCSTPDA/MobilePharmacy/";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IP;
    }


    //从内存取数据服务器地扯,显示出来
    public  String getDataIPAddress ()
    {
        String IP="";
        FileUtils file=new FileUtils();
        try {
            String url="/data/data/dhc.pharmacy.activity/files/config.txt";
            String filecontent=file.read(url);

            JSONTokener jsonParser = new JSONTokener(filecontent);
            JSONObject js = (JSONObject)jsonParser.nextValue();
            IP=js.getString("DataUrl");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IP;
    }

    //从内存取文件服务器IP,显示出来
    public  String getWebIPAddress ()
    {
        String IP="";
        FileUtils file=new FileUtils();
        try {
            String url="/data/data/dhc.pharmacy.activity/files/config.txt";
            String filecontent=file.read(url);

            JSONTokener jsonParser = new JSONTokener(filecontent);
            JSONObject js = (JSONObject)jsonParser.nextValue();
            IP=js.getString("WebUrl");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IP;
    }




}
