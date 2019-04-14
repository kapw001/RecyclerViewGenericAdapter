package demo.com.recyclerviewadapter.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import demo.com.recyclerviewadapter.BaseOnItemClicklistener;
import demo.com.recyclerviewadapter.BaseViewHolder;
import demo.com.recyclerviewadapter.ItemModel;
import demo.com.recyclerviewadapter.MyModel;

public abstract class GenericAdapter<L extends BaseOnItemClicklistener> extends RecyclerView.Adapter<BaseViewHolder> {


    private List<ItemModel> list = new ArrayList<>();

    protected L listener;

    public void setOnItemClickListener(L listener) {
        this.listener = listener;
    }

    public void setList(List<ItemModel> list) {

        this.list.clear();
        this.list.addAll(list);

        notifyDataSetChanged();
    }

    public void remove(int position) {

        this.list.remove(position);

        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(viewType, viewGroup, false);

        return getViewHolder(viewType, view);
    }

    abstract public BaseViewHolder getViewHolder(int viewType, View view);

    @Override
    public void onBindViewHolder(@NonNull final BaseViewHolder viewHolder, int i) {


        viewHolder.bindItem(getItem(i), listener);
//        onBindHolder(viewHolder, i);

    }


    public ItemModel getItem(int pos) {
        return list.get(pos);
    }

//    public abstract void onBindHolder(VH holder, int pos);

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    public void update(int position, ItemModel modelTes) {


        list.set(position, modelTes);

        notifyItemChanged(position);


    }

    public void restoreItem(MyModel item, int position) {

        list.add(position, item);
        // notify item added by position
        notifyItemInserted(position);

    }
}
