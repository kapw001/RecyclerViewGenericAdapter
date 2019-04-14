package demo.com.recyclerviewadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyModelViewHolder extends BaseViewHolder<MyModel, OnItemClickListener> implements View.OnClickListener {

    private TextView title;
    public RelativeLayout viewBackground, viewForeground;

    public MyModelViewHolder(@NonNull View itemView) {
        super(itemView);
        viewBackground = itemView.findViewById(R.id.view_background);
        viewForeground = itemView.findViewById(R.id.view_foreground);
        title = itemView.findViewById(R.id.title);

        itemView.setOnClickListener(this);
    }

    @Override
    public void bindView(final MyModel item) {

        title.setText(item.getName());

    }

    @Override
    public void onClick(View v) {

        if (getListener() != null && getItem() != null && getAdapterPosition() != RecyclerView.NO_POSITION)
            getListener().OnItemClick(v, getItem(), getAdapterPosition());
    }
}
