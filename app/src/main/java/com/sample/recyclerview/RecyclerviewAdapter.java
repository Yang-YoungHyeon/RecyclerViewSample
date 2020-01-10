package com.sample.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/** RecyclerView ListAdapter*/
public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {
    /** mList : Used to Save RecyclerviewItem Object */
    private ArrayList<RecyclerviewItem> mList = new ArrayList<>();

    /** ViewHolder : Used to Save ItemView */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTime;
        Button btnShow;
        ViewHolder(View itemView) {
            super(itemView) ;
            tvTime = itemView.findViewById(R.id.tv_item_time);
            btnShow = itemView.findViewById(R.id.btn_item_show);
        }
    }

    /** onCreateViewHolder() : return ViewHolder (initializes some private fields to be used by RecyclerView.) */
    @NonNull
    @Override
    public RecyclerviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /* Prepare to use LayoutInflater object */
        Context mContext = parent.getContext() ;
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        /* Insert XML(R.layout....) to LayoutInflater Object */
        View mView = mInflater.inflate(R.layout.recyclerview_item, parent, false) ;

        /* Create ViewHolder Object (need View) */
        RecyclerviewAdapter.ViewHolder mViewHolder = new RecyclerviewAdapter.ViewHolder(mView) ;

        return mViewHolder;
    }

    /** onBindViewHolder() : Used to Update (UI) */
    @Override
    public void onBindViewHolder(@NonNull final RecyclerviewAdapter.ViewHolder holder, final int position) {
        /* UI Update */
        String time = mList.get(position).getmTime();
        holder.tvTime.setText(time);

        /* Click Event */
        holder.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), getItemData(position)+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /** getItemCount() : return ItemSize */
    @Override
    public int getItemCount() {
        return mList.size();
    }

    /** clearItem() : Used Clear All Item */
    public void clearItem(){
        mList.clear();
    }

    /** addItem() : Used Add Item */
    public void addItem(String time){
        mList.add(new RecyclerviewItem(time));
    }

    /** delItem() : Used Remove Item */
    public void delItem(int position){
        mList.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    /** getItemData() : return Item Data */
    public String getItemData(int position){
        return mList.get(position).getmTime();
    }
}
