package bafy.pharmacy.milkbank.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bafy.pharmacy.milkbank.R;
import bafy.pharmacy.milkbank.bll.OrdList;

public class OrdListAdapter extends RecyclerView.Adapter<OrdListAdapter.ViewHolder> {

    private List<OrdList> mOrdList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView desc;
        TextView dose;
        TextView inst;
        TextView freq;
        TextView status;

        public ViewHolder(View view) {
            super(view);
            desc = (TextView) view.findViewById(R.id.desc);
            dose = (TextView) view.findViewById(R.id.dose);
            inst = (TextView) view.findViewById(R.id.inst);
            freq = (TextView) view.findViewById(R.id.freq);
            status = (TextView) view.findViewById(R.id.status);
        }

    }

    public OrdListAdapter(List<OrdList> ordlistobj) {
        mOrdList = ordlistobj;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ordlist_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        OrdList ordlistobj = mOrdList.get(position);
        holder.desc.setText(ordlistobj.getDesc());
        holder.dose.setText(ordlistobj.getDose());
        holder.inst.setText(ordlistobj.getInst());
        holder.freq.setText(ordlistobj.getFreq());
        holder.status.setText(ordlistobj.getStatus());
    }

    @Override
    public int getItemCount() {
        return mOrdList.size();
    }

}