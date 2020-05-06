package bafy.pharmacy.milkbank.ui.fragment;

import bafy.pharmacy.milkbank.R;
import bafy.pharmacy.milkbank.activity.HomeActivity;
import bafy.pharmacy.milkbank.common.MyFragment;

public class TestFragmentANew extends MyFragment<HomeActivity> {

    @Override
    protected int getLayoutId() {
        ///
        return R.layout.fragment_test_a_new;
    }

    @Override
    protected void initView() {
        setOnClickListener();

    }

    @Override
    protected void initData() {

    }
}

