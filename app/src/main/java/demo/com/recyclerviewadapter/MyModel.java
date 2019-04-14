package demo.com.recyclerviewadapter;

public class MyModel implements ItemModel {


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getType() {
        return R.layout.row;
    }
}
