## RecyclerViewSample [Andorid]
Item Add : Click the button on the MainActivity to add an item.
Item Delete : Swipe and delete items. (L->R or R->L)
Item In Button : There is a button event in the item. (Just ToastMessage)


#MainActivity.java
```
public class MainActivity extends AppCompatActivity {
    /**  mRecyclerView : Used RecyclerView
     *   mAdapter : Used Custom Adapter
     *   mItemTouchHelper : Used Swipe Touch Event
     * */
    private RecyclerView mRecyclerView;
    private RecyclerviewAdapter mAdapter;
    private ItemTouchHelper mItemTouchHelper;
...
```

#RecyclerviewAdapter.java
```
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
...
```



#RecyclerviewItem.java
```
/** RecyclerView ListItem */
public class RecyclerviewItem {
    /** mTime : Used Save Time */
    private String mTime;

    /** Constructor */
    public RecyclerviewItem(String mTime) {
        this.mTime = mTime;
    }
...
```

