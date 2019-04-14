package demo.com.recyclerviewadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import demo.com.recyclerviewadapter.adapter.GenericAdapter;

public class Adapter extends GenericAdapter<MyListener> {


    @Override
    public BaseViewHolder getViewHolder(int viewType, View view) {

        if (viewType == R.layout.row) {

            return new SomeViewHolder(view);

        } else if (viewType == R.layout.row1) {

            return new TestViewHolder(view);
        } else if (viewType == R.layout.row2) {

            return new NewViewHolder(view);
        }
//
        throw new IllegalArgumentException("There is no layout set and Invalid position, Please check itemmodel getType  " + viewType);
    }


}
