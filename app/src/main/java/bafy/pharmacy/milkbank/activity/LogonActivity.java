package bafy.pharmacy.milkbank.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bafy.pharmacy.milkbank.R;
import bafy.pharmacy.milkbank.bll.User;
import bafy.pharmacy.milkbank.common.CommonMethod;
import bafy.pharmacy.milkbank.common.JsonUtils;
import bafy.pharmacy.milkbank.common.LoginUser;


public class LogonActivity extends AppCompatActivity {

    private Button Logon;
    private EditText UserName;
    private EditText PassWord;
    List<Object> list = null;
    ProgressDialog mydialog;
    public ListView lv;
    boolean runflag = true;
    ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

    private ProgressDialog pd;
    private final int TASK_LOOP_COMPLETE = 0;
    String Param,ret;
    String err="";

    boolean ScanErr=false;
    boolean ScanFlag=false;

    CommonMethod met=new CommonMethod();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_logon);

        /// 用户名
        UserName = (EditText) findViewById(R.id.username);
        /// 密码
        PassWord = (EditText) findViewById(R.id.password);
        /// 登录按钮
        Logon = (Button) findViewById(R.id.login);
        Logon.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                loginSys();
            }
        });
    }

    private void loginSys(){
        try {
            if (met.CheckTextNull(UserName)==false){
                met.msgbox("提示", "用户名不能为空!", "确定", LogonActivity.this);
                return;
            }
            if (met.CheckTextNull(PassWord)==false){
                met.msgbox("提示", "密码不能为空!", "确定", LogonActivity.this);
                return;
            }

            Intent intent = new Intent();
            intent.setClass(LogonActivity.this, HomeActivity.class);
            startActivity(intent);
            LogonActivity.this.finish();



            pd = ProgressDialog.show(LogonActivity.this, "", "loading...", true, true);
            new Thread() {

                public void run() {
                    try {
                        if (runflag){

                            User login =new User();
                            //手工登录
                            ret=login.CheckUser(UserName.getText().toString(), PassWord.getText().toString(), LogonActivity.this);

                            if (ret.equals("error")){

                                err="验证失败";

                            }else{

                                JSONTokener jsonParser = new JSONTokener(ret);
                                JSONObject js = (JSONObject)jsonParser.nextValue();
                                err=js.getString("ErrorInfo");
                                if (err.length()==0)
                                {
                                    //取用户信息
                                    String userid=js.getString("UserID");
                                    String usercode=js.getString("UserCode");
                                    String username=js.getString("UserName");
                                    String userpwd=js.getString("UserPwd");
                                    if (ScanFlag)
                                    {
                                        if (userpwd.equals(PassWord.getText().toString()))
                                        {
                                        }else{
                                            ScanErr=true;
                                            return;
                                        }

                                    }

                                    LoginUser.UserCode=usercode;
                                    LoginUser.UserID=userid;
                                    LoginUser.UserName=username;
                                    list=JsonUtils.parsedata(js, "Locs");

                                    if (list.size()>0)
                                    {
                                    }else
                                    {
                                        return;
                                    }

                                    final  String[] arrayUserLocData = new String[list.size()];

                                    final  String[] name = new String[list.size()];
                                    final  String[] course = new String[list.size()];
                                    final  String[] score = new String[list.size()];
                                    final  String[] id = new String[list.size()];
                                    final  String[] py = new String[list.size()];

                                    for(int i=0;i<list.size();i++){
                                        Map itm=(Map)list.get(i);
                                        arrayUserLocData[i] =itm.get("ctloc").toString();
                                        name[i] =itm.get("ctloc").toString();
                                        id[i] = itm.get("grpdesc").toString();
                                        course[i] =itm.get("ctlocdr").toString();
                                        score[i] =itm.get("grpdr").toString();
                                        py[i] =""; //itm.get("ctloc").toString();


                                    }
                                    mylist.clear();
                                    for (int i = 0; i < name.length; i++) {
                                        HashMap<String, String> map1 = new HashMap<String, String>();
                                        map1.put("Name", name[i]);
                                        map1.put("ID", id[i]);
                                        map1.put("Course", course[i]);
                                        map1.put("Score", score[i]);
                                        map1.put("PY", py[i]);
                                        mylist.add(map1);
                                    }

                                }


                            }


                        }


                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    finally{
                        messageListener.sendEmptyMessage(TASK_LOOP_COMPLETE);
                    }
                }
            }.start();

            /////////////////////
        } catch (Exception e) {

            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }



    }

    //定义Adapter
    class SpecialAdapter extends SimpleAdapter {
        private int[] colors = new int[] { 0x30FF0000, 0x300000FF };

        public SpecialAdapter(Context context, List<? extends Map<String, ?>> data,
                              int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            if (position==0){

            }else{
                int colorPos = position % colors.length;
                if (colorPos == 1) {
                    view.setBackgroundColor(Color.argb(250, 255, 255, 255));
                } else {
                    view.setBackgroundColor(Color.argb(250, 224, 243, 250));
                }
            }

            return view;
        }
    }

    //选择登录科室
    class PopupListener implements DialogInterface.OnClickListener
    {

        @Override
        public void onClick(DialogInterface dialog, int which) {

            Map itm=(Map)list.get(which);
            String grpdr=itm.get("grpdr").toString();
            LoginUser.UserLocID=itm.get("ctlocdr").toString();
            LoginUser.UserLoc=itm.get("ctloc").toString();
            LoginUser.UserGroupID=itm.get("grpdr").toString();
            LoginUser.UserGroup=itm.get("grpdesc").toString();

            //Toast.makeText(getApplicationContext(), grpdr, Toast.LENGTH_LONG).show();
            runflag=false;
            Intent intent = new Intent();
            intent.setClass(LogonActivity.this, MainActivity.class);
            startActivity(intent);
            //overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            LogonActivity.this.finish();

        }

    }







    ///进程回调
    private Handler messageListener = new Handler() {};


}
