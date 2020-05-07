package bafy.pharmacy.milkbank.ui.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bafy.pharmacy.milkbank.R;
import bafy.pharmacy.milkbank.bll.OrdList;
import bafy.pharmacy.milkbank.common.MyActivity;
import bafy.pharmacy.milkbank.ui.adapter.OrdListAdapter;

public class OrderListActivity extends MyActivity {

    private List<OrdList> ordlist = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ordlist;
    }

    @Override
    protected void initView() {
        initOrdList();
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.ordlist_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        OrdListAdapter adapter = new OrdListAdapter(ordlist);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    private void initOrdList(){
        for(int i=0;i<2;i++){
            OrdList item1=new OrdList("亲母乳或足月配方奶","70","鼻饲","Q3h","核实");
            ordlist.add(item1);

            OrdList item2=new OrdList("亲母乳或足月配方奶","70","鼻饲","Q3h","核实");
            ordlist.add(item2);

            OrdList item3=new OrdList("亲母乳或足月配方奶","70","鼻饲","Q3h","核实");
            ordlist.add(item3);

            OrdList item4=new OrdList("亲母乳或足月配方奶","70","鼻饲","Q3h","核实");
            ordlist.add(item4);
        }
    }
}
