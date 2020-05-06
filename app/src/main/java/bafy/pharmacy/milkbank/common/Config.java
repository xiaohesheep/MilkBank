package bafy.pharmacy.milkbank.common;


import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

import org.json.JSONArray;
import org.json.JSONObject;


///程序配置类
///Creator:LiangQiang
///CreatDate:2013-09-12
public class Config {
    private static final String TAG = "Config";

    public static String DATA_SERVER="";
    public static String UPDATE_SERVER = "";
    public static String UPDATE_APKNAME = "MobilePharmacy.apk";
    public static String UPDATE_VERJSON = "ver.txt";
    public static String UPDATE_SAVENAME = "MobilePharmacy.apk";
    ///获取当前apk版本号
    ///Creator:LiangQiang
    ///CreatDate:2013-09-12
    public static int getVersionCode(Context context)
    {
        int verCode = -1;
        try {
            verCode = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionCode;

        }catch(NameNotFoundException e){
            return verCode;
        }

        return verCode;

    }

    public static String getVersionName(Context context)
    {
        String verCode = "";
        try {
            verCode = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        }catch(NameNotFoundException e){
            return verCode;
        }
        return verCode;

    }

    ///获取文件服务器中的apk版本号
    ///Creator:LiangQiang
    ///CreatDate:2013-09-12
    public static int getServerVerCode() {
        int newVerCode=-1;
        try {

            String verjson = NetworkTool.getContent(Config.UPDATE_SERVER
                    + Config.UPDATE_VERJSON);
            JSONArray array = new JSONArray(verjson);
            if (array.length() > 0) {
                JSONObject obj = array.getJSONObject(0);
                try {
                    newVerCode = Integer.parseInt(obj.getString("verCode"));
                } catch (Exception e) {
                    newVerCode = -1;
                    return newVerCode;
                }
            }
        } catch (Exception e) {
            //Log.e(TAG, e.getMessage());
            return newVerCode;
        }
        return newVerCode;
    }

    public static String getServerVerName() {

        String newVerName="";
        try {

            String verjson = NetworkTool.getContent(Config.UPDATE_SERVER
                    + Config.UPDATE_VERJSON);
            JSONArray array = new JSONArray(verjson);
            if (array.length() > 0) {
                JSONObject obj = array.getJSONObject(0);
                try {

                    newVerName = obj.getString("verName");
                } catch (Exception e) {

                    return newVerName;
                }
            }
        } catch (Exception e) {
            //Log.e(TAG, e.getMessage());
            return newVerName;
        }
        return newVerName;
    }



}
