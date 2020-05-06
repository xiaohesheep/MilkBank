package bafy.pharmacy.milkbank.bll;

import android.app.Activity;

import java.util.HashMap;
import java.util.Map;

public class User {
    //验证用户
    public String CheckUser(String UserName, String PassWord, Activity frm) throws Exception {
        String Param=UserName+"^"+PassWord;
        Map<String, String> map = new HashMap<String, String>();
        map.put("params",Param );
        String ret=bafy.pharmacy.milkbank.dal.ConnectByWs.LinkData("logon", map, frm);
        //对应webservice 的method,名称一致
        return ret ;
    }

}
