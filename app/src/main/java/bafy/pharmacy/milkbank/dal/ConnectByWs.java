package bafy.pharmacy.milkbank.dal;

import android.app.Activity;

import java.util.Map;

import bafy.pharmacy.milkbank.common.WsApiUtil;

public class ConnectByWs {
    public static String LinkData(String mth,Map MapParams,Activity frm) throws Exception{
        String DataIp=new GetDbIPAddress().getDataIPAddress();
        DataIp="http://"+DataIp+"/dthealth/web/web.DHCSTPDAService.PIVA.cls";
        String getretinfo=WsApiUtil.loadSoapObject(DataIp,mth,MapParams);
        return getretinfo;
    }
}
