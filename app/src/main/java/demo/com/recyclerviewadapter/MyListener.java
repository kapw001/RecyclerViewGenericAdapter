package demo.com.recyclerviewadapter;

import android.view.View;

public interface MyListener extends BaseOnItemClicklistener {


    void onItemSimpleClick(View view, SimpleModel simpleModel, int position);

    void onItemTestModelClick(View view, TestModel simpleModel, int position);

    void onItemNewTestModelClick(View view, NewModelTes simpleModel, int position);
}
