package com.sample.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    /**  mRecyclerView : Used RecyclerView
     *   mAdapter : Used Custom Adapter
     *   mItemTouchHelper : Used Swipe Touch Event
     * */
    private RecyclerView mRecyclerView;
    private RecyclerviewAdapter mAdapter;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** RecyclerView set LayoutManager(LinearLayoutManger) */
        mRecyclerView = findViewById(R.id.recyclerView) ;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

        /** RecyclerView set Adapter(RecyclerviewAdapter) */
        mAdapter = new RecyclerviewAdapter() ;
        mRecyclerView.setAdapter(mAdapter) ;

        /** RecyclerView set Item Touch(Swipe) */
        mItemTouchHelper = new ItemTouchHelper(ItemTouchCallBack);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);

        /** Button Click Event : Used Add Item */
        findViewById(R.id.btn_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Get Current Time */
                long mNow = System.currentTimeMillis();
                Date mData = new Date(mNow);
                SimpleDateFormat mSdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String mStrNow = mSdfNow.format(mData);
                /* Add Item */
                mAdapter.addItem(mStrNow);
                mAdapter.notifyItemInserted(mAdapter.getItemCount());
            }
        });
    }

    /** ItemTouchCallBack : Used Swiped Item Event(Used Delete) */
    ItemTouchHelper.SimpleCallback ItemTouchCallBack = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }
        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            /* Get Item Position & Delete */
            int mPosition = viewHolder.getAdapterPosition();
            mAdapter.delItem(mPosition);
        }
    };
}
