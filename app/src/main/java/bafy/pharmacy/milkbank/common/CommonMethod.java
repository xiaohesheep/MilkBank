package bafy.pharmacy.milkbank.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonMethod {

    /// 验证录入框是否为空
    /// 20200311
    public boolean CheckTextNull(EditText txt)
    {
        String desc=txt.getText().toString();
        desc=replaceBlank(desc);
        if(desc.length()==0){
            return false;
        }
        return true;
    }

    // 创造json格式的数据
    public String toJson(String name1,String content1,String name2,String content2){
        String jsonStr="";
        jsonStr="{"+"\""+name1+"\""+":"+"\""+content1+"\""+","+"\""+name2+"\""+":"+"\""+content2+"\""+"}";
        return jsonStr;
    }

    /// 清除空格
    public  String replaceBlank(String str) {

        String dest = "";

        if (str!=null) {

            Pattern p = Pattern.compile("\\s*|\t|\r|\n");

            Matcher m = p.matcher(str);

            dest = m.replaceAll("");


        }


        return dest;


    }

    public void msgbox (String title,String context, String btntext,Activity frm)
    {
        new AlertDialog.Builder(frm)
                .setTitle(title)
                .setMessage(context)
                .setPositiveButton(btntext, null)
                .show();

    }

}
