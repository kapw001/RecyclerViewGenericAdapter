package demo.com.recyclerviewadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<T extends ItemModel, L extends BaseOnItemClicklistener> extends RecyclerView.ViewHolder {

    private L listener;
    private T item;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void setClickListener(L listener) {
        this.listener = listener;
    }

    public void bindItem(T item, L listener) {
        this.item = item;
        this.listener = listener;
        bindView(item);
    }

    public abstract void bindView(T item);

    public T getItem() {
        return item;
    }

    public L getListener() {
        return listener;
    }

}
