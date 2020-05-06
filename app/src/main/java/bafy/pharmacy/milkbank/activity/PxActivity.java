package bafy.pharmacy.milkbank.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import bafy.pharmacy.milkbank.R;

public class PxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_px);

        //int dip_10 = Utils.dip2px(this, 10L);
        //TextView tv_padding = (TextView) findViewById(R.id.tv_padding);
        //tv_padding.setPadding(dip_10, dip_10, dip_10, dip_10);

    }
}
