package bafy.pharmacy.milkbank.ui.fragment;

import android.view.View;

import bafy.pharmacy.milkbank.R;
import bafy.pharmacy.milkbank.activity.HomeActivity;
import bafy.pharmacy.milkbank.aop.SingleClick;
import bafy.pharmacy.milkbank.common.MyFragment;
import bafy.pharmacy.milkbank.ui.activity.OrderListActivity;

public class TestFragmentANew extends MyFragment<HomeActivity> {

    public static TestFragmentANew newInstance() {
        return new TestFragmentANew();
    }

    @Override
    protected int getLayoutId() {
        ///
        return R.layout.fragment_test_a_new;
    }

    @Override
    protected void initView() {
        setOnClickListener(R.id.btn_yzlb,R.id.btn_bggl,R.id.btn_mrpz);
        this.setTitle("我要改变标题信息");
    }

    @Override
    protected void initData() {

    }

    @SingleClick
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btn_yzlb:
                startActivity(OrderListActivity.class);
                break;
            case R.id.btn_bggl:
//                startActivity(DialogActivity.class);
                break;
            case R.id.btn_mrpz:
//                startActivity(StatusActivity.class);
                break;
            default:
                break;
        }
    }


    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }
}

