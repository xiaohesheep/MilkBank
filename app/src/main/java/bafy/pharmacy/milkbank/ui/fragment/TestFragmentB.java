package bafy.pharmacy.milkbank.ui.fragment;

import android.view.View;
import android.widget.ImageView;

import bafy.pharmacy.milkbank.R;
import bafy.pharmacy.milkbank.activity.HomeActivity;
import bafy.pharmacy.milkbank.common.MyFragment;
import bafy.pharmacy.milkbank.widget.CountdownView;
import bafy.pharmacy.milkbank.widget.SwitchButton;
import butterknife.BindView;

/**
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/10/18
 *    desc   : 项目自定义控件展示
 */
public final class TestFragmentB extends MyFragment<HomeActivity>
        implements SwitchButton.OnCheckedChangeListener {

    @BindView(R.id.iv_test_circle)
    ImageView mCircleView;

    @BindView(R.id.sb_test_switch)
    SwitchButton mSwitchButton;
    @BindView(R.id.cv_test_countdown)
    CountdownView mCountdownView;

    public static TestFragmentB newInstance() {
        return new TestFragmentB();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test_b;
    }

    @Override
    protected void initView() {
        mSwitchButton.setOnCheckedChangeListener(this);

        setOnClickListener(R.id.cv_test_countdown);
    }

    @Override
    protected void initData() {
//        GlideApp.with(this)
//                .load(R.drawable.bg_launcher)
//                .circleCrop()
//                .into(mCircleView);
    }

//    @SingleClick
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cv_test_countdown) {
//            toast(R.string.common_code_send_hint);
            mCountdownView.start();
        }
    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }

    /**
     * {@link SwitchButton.OnCheckedChangeListener}
     */

    @Override
    public void onCheckedChanged(SwitchButton button, boolean isChecked) {
        toast(isChecked);
    }
}