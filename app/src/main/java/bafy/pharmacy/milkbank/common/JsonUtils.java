package bafy.pharmacy.milkbank.common;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    public static List<Object> parsedata(JSONObject js,String head)
    {
        List<Object> list=null;

        try
        {
            JSONArray jsonArray1 = new JSONArray(js.getString(head));
            list=new ArrayList<Object>();

            for (int i = 0; i < jsonArray1.length(); i++) {
                Map<String , Object> LocArr=new HashMap<String, Object>();
                JSONObject jsonObject = jsonArray1.getJSONObject(i);
                Iterator<?> it = jsonObject.keys();
                String aa2 = "";
                String bb2 = null;
                while(it.hasNext()){//遍历JSONObject
                    bb2 = (String) it.next().toString();
                    aa2 = jsonObject.getString(bb2);
                    LocArr.put(bb2, aa2);
                }
                list.add(LocArr);
            }
            return list;
        } catch (JSONException ex) {
            System.out.println(ex.toString());
            return list;
            // 异常处理代码
        }
    }
    public void parseJson(String jsonData) {
        try {
            //创建JsonReader 对象

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }


}
