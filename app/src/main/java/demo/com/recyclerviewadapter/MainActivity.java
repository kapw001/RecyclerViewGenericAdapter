package demo.com.recyclerviewadapter;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demo.com.recyclerviewadapter.adapter.GenericAdapter;
import demo.com.recyclerviewadapter.adapter.RecyclerItemTouchHelper;

public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {


    private RecyclerView recyclerView;


    private Adapter adapter;

    private GenericAdapter<OnItemClickListener> genericAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        genericAdapter = new GenericAdapter<OnItemClickListener>() {
            @Override
            public BaseViewHolder getViewHolder(int viewType, View view) {
                return new MyModelViewHolder(view);
            }
        };


        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);


        adapter = new Adapter();

//        adapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void OnItemClick(View view, int position) {
//
//                if (adapter.getItem(position) instanceof NewModelTes) {
//
//
//                    NewModelTes modelTes = (NewModelTes) adapter.getItem(position);
//
//                    modelTes.setTitle("Item has been chnaged " + position);
//
//                    adapter.update(position, modelTes);
//
//                } else {
//
//                    adapter.remove(position);
//                }
//            }
//        });

        adapter.setList(getList());

        recyclerView.setAdapter(genericAdapter);


        genericAdapter.setList(getMyModelList());

//        genericAdapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void OnItemClick(View view, int position) {
//
//                MyModel myModel = (MyModel) genericAdapter.getItem(position);
//
//                Toast.makeText(MainActivity.this, "" + myModel.getName(), Toast.LENGTH_SHORT).show();
//
//
//                genericAdapter.remove(position);
//
//            }
//
//            @Override
//            public void OnItemClick(View view, MyModel myModel, int position) {
//
//                Toast.makeText(MainActivity.this, "" + myModel.getName(), Toast.LENGTH_SHORT).show();
//
//
//                genericAdapter.remove(position);
//            }
//        });
//        adapter.setOnItemClickListener(new MyListener() {
//            @Override
//            public void onItemSimpleClick(View view, SimpleModel simpleModel, int position) {
//
//                Toast.makeText(MainActivity.this, "" + simpleModel.getTitle(), Toast.LENGTH_SHORT).show();
//
//
//                adapter.remove(position);
//            }
//
//            @Override
//            public void onItemTestModelClick(View view, TestModel simpleModel, int position) {
//
//                adapter.remove(position);
//
//            }
//
//            @Override
//            public void onItemNewTestModelClick(View view, NewModelTes simpleModel, int position) {
//
//                NewModelTes modelTes = (NewModelTes) adapter.getItem(position);
//
//                modelTes.setTitle("Item has been chnaged " + position);
//
//                adapter.update(position, modelTes);
//
//            }
//        });


    }


    public List<ItemModel> getMyModelList() {

        List<ItemModel> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {

            MyModel myModel = new MyModel();

            myModel.setName("My Model   " + i);

            list.add(myModel);
        }

        return list;
    }


    public List<ItemModel> getList() {

        List<ItemModel> list = new ArrayList<>();


        for (int i = 0; i < 200; i++) {

            if (i % 3 == 0) {


                SimpleModel simpleModel = new SimpleModel();

                simpleModel.setTitle("Simple model " + i);

                list.add(simpleModel);

            } else if (i % 2 == 0) {

                TestModel testModel = new TestModel();
                testModel.setTitle("Test model  " + i);

                list.add(testModel);
            } else {

                NewModelTes modelTes = new NewModelTes();

                modelTes.setTitle("New Model test  " + i);

                list.add(modelTes);
            }

        }

        return list;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

        if (viewHolder instanceof MyModelViewHolder && position != RecyclerView.NO_POSITION) {

            MyModel myModel = (MyModel) genericAdapter.getItem(position);

            // get the removed item name to display it in snack bar
            String name = myModel.getName();

            // backup of removed item for undo purpose
            final MyModel deletedItem = myModel;
            final int deletedIndex = position;

            // remove the item from recycler view
            genericAdapter.remove(position);

            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar
                    .make(viewHolder.itemView, name + " removed from cart!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    genericAdapter.restoreItem(deletedItem, deletedIndex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }

    }
}
