package demo.com.recyclerviewadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SomeViewHolder extends BaseViewHolder<SimpleModel, MyListener> implements View.OnClickListener {

    private TextView titlel;

    public SomeViewHolder(@NonNull View itemView) {
        super(itemView);

        titlel = itemView.findViewById(R.id.title);

//        itemView.setOnClickListener(this);
    }

    @Override
    public void bindView(final SimpleModel item) {
//        SimpleModel simpleModel = (SimpleModel) item;
        titlel.setText(item.getTitle());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getListener() != null && getAdapterPosition() != RecyclerView.NO_POSITION)
                    getListener().onItemSimpleClick(v, item, getAdapterPosition());
            }
        });
    }

    @Override
    public void onClick(View v) {

//        if (getListener() != null && getAdapterPosition() != RecyclerView.NO_POSITION)
//            getListener().OnItemClick(v, getAdapterPosition());
    }
}
