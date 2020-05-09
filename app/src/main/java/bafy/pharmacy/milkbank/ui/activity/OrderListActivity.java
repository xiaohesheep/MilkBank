package bafy.pharmacy.milkbank.ui.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bafy.pharmacy.milkbank.R;
import bafy.pharmacy.milkbank.bll.OrdList;
import bafy.pharmacy.milkbank.bll.PatList;
import bafy.pharmacy.milkbank.common.MyActivity;
import bafy.pharmacy.milkbank.ui.adapter.OrdListAdapter;
import bafy.pharmacy.milkbank.ui.adapter.PatListAdapter;

public class OrderListActivity extends MyActivity {

    private List<OrdList> ordlist = new ArrayList<>();
    private List<PatList> patlist = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ordlist;
    }

    @Override
    protected void initView() {


        for(int i=0;i<2;i++){
            RecyclerView patlistview=(RecyclerView) findViewById(R.id.patlist_recyclerview);   //病人信息
            initPatList();
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            patlistview.setLayoutManager(layoutManager);
            PatListAdapter patadapter = new PatListAdapter(patlist);
            patlistview.setAdapter(patadapter);
            RecyclerView ordlistView=(RecyclerView) findViewById(R.id.ordlist_recyclerview);   //医嘱信息
            LinearLayoutManager layoutManagertwo = new LinearLayoutManager(this);
            ordlistView.setLayoutManager(layoutManagertwo);
            OrdListAdapter ordadapter = new OrdListAdapter(ordlist);
            ordlistView.setAdapter(ordadapter);

        }

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

    private void initPatList(){
        PatList item1=new PatList("701-05","测试患者","新生儿一区");
        patlist.add(item1);
    }
}
