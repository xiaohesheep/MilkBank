package bafy.pharmacy.milkbank.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bafy.pharmacy.milkbank.R;
import bafy.pharmacy.milkbank.bll.PatList;

public class PatListAdapter extends RecyclerView.Adapter<PatListAdapter.ViewHolder>{

    private List<PatList> mPatList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView patBedNo;
        TextView patName;
        TextView patWard;

        public ViewHolder(View view) {
            super(view);
            patBedNo = (TextView) view.findViewById(R.id.patBedNo);
            patName = (TextView) view.findViewById(R.id.patName);
            patWard = (TextView) view.findViewById(R.id.patWard);
        }

    }

    public PatListAdapter(List<PatList> patlistobj) {
        mPatList = patlistobj;
    }

    @Override

    public PatListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patlist_item, parent, false);
        PatListAdapter.ViewHolder holder = new PatListAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PatListAdapter.ViewHolder holder, int position) {

        PatList patlistobj = mPatList.get(position);
        holder.patBedNo.setText(patlistobj.getPatBedNo());
        holder.patName.setText(patlistobj.getPatName());
        holder.patWard.setText(patlistobj.getPatWard());
    }

    @Override
    public int getItemCount() {
        return mPatList.size();
    }

}
