package ash.ish.gridapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class ListActivity extends ActionBarActivity {

    GridView myGridView;
    MyAdapter myListAdapter;
    private String[] myListItems = {"Home", "Discover", "Radio", "Favorites", "Notifications", "Downloads", "Friends", "Offers", "Help", "Exit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        myGridView = (GridView) findViewById(R.id.my_list);
        SetOnListItemClickListener();
        SetListAdapter();
    }

    private void SetOnListItemClickListener() {
        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, myListItems[position] + " has id " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void SetListAdapter() {
        myListAdapter = new MyAdapter(this, R.layout.item_list, myListItems);
        myGridView.setAdapter(myListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
