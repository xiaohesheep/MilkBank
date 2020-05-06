package bafy.pharmacy.milkbank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import bafy.pharmacy.milkbank.R;

public class StartPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 隐藏标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_start_page);
        Start();
    }

    public void Start(){
        new Thread(){
            public void run(){
                try{
                    Thread.sleep(2500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent();
                    intent.setClass(StartPageActivity.this, LogonActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }.start();
    }
}
