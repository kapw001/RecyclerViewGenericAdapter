package demo.com.recyclerviewadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NewViewHolder extends BaseViewHolder<NewModelTes, MyListener> implements View.OnClickListener {


    private TextView title;

    public NewViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);

//        itemView.setOnClickListener(this);
    }

    @Override
    public void bindView(final NewModelTes item) {
//        TestModel simpleModel = (TestModel) item;
        title.setText(item.getTitle());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getListener() != null && getAdapterPosition() != RecyclerView.NO_POSITION)
                    getListener().onItemNewTestModelClick(v, item, getAdapterPosition());
            }
        });
    }

    @Override
    public void onClick(View v) {

//        if (getListener() != null && getAdapterPosition() != RecyclerView.NO_POSITION)
//            getListener().OnItemClick(v, getAdapterPosition());
    }
}
