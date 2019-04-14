package demo.com.recyclerviewadapter;

import android.view.View;

public interface OnItemClickListener extends BaseOnItemClicklistener {

    void OnItemClick(View view, int position);

    void OnItemClick(View view, MyModel myModel, int position);

}
