package org.androidtown.gidarim;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by iseungjin on 2017. 12. 14..
 */

public class DDayCardRecyclerAdapter extends RecyclerView.Adapter<DDayCardRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<EventInfo> items;
    int item_layout;

    public DDayCardRecyclerAdapter(Context context, ArrayList<EventInfo> items, int item_layout) {
        this.context = context;
        this.items = items;
        this.item_layout = item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_dday, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final EventInfo item = items.get(position);

        holder.title.setText(item.getTitle());
        holder.date.setText(item.getDate());

        int dday = item.getdDay();
        if (dday <= 0) {
            holder.dday.setText("D " + item.getdDay());
        } else {
            holder.dday.setText("D +" + item.getdDay());
        }

        holder.cardView.setBackgroundColor(GidarimConstants.LIST_COLOR[item.getThemeNum()]);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView date;
        TextView dday;

        GridLayout cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
            dday = (TextView) itemView.findViewById(R.id.dday);

            cardView = (GridLayout) itemView.findViewById(R.id.card);
        }
    }
}
