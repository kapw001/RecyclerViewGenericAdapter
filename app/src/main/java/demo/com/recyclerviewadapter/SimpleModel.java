package demo.com.recyclerviewadapter;

import android.view.View;

public class SimpleModel implements ItemModel {


    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getType() {
        return R.layout.row;
    }


}
