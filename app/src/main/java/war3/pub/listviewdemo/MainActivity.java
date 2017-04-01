package war3.pub.listviewdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            list.add("i = " + i);
        }
        ListAdapter adapter = new ListAdapter(list);
        listview.setAdapter(adapter);
    }

    class ListAdapter extends BaseAdapter {

        List<String> list;

        public ListAdapter(List<String> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder = null;
            if (view == null) {
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_list, null);
                viewHolder = new ViewHolder();
                viewHolder.tv = (TextView) view.findViewById(R.id.tv);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (i == 0) {
                viewHolder.tv.setBackground(getDrawable(R.drawable.selector_choice_start));
                view.setTag(viewHolder);
            } else if (i == list.size() - 1) {
                viewHolder.tv.setBackground(getDrawable(R.drawable.selector_choice_end));
            }else{
                viewHolder.tv.setBackground(getDrawable(R.drawable.selector_choice_normal));
            }
            viewHolder.tv.setText(list.get(i));
            return view;
        }

        class ViewHolder {
            TextView tv;
        }
    }
}
