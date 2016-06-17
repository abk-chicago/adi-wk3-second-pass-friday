package org.codeforcoffee.chicagorecommendations;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayAdapter<Landmark> mArrayAdapter;
    private ArrayList<Landmark> mList;
    private AdapterView.OnItemClickListener mListener;
    private Intent mIntentDetail;

    // todo: model code
    private void addLandmark(String name, String desc, String addy) {
        if (mList != null && mArrayAdapter != null) {
            Landmark place = new Landmark(name, desc, addy);
            mList.add(place);
            mArrayAdapter.notifyDataSetChanged();
        } else {
            mList = new ArrayList<Landmark>();
            // todo: now, add the item
        }
    }

    private void removeLandmark(int id) {
        if (mList != null) {
            mList.remove(id);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = new ArrayList<Landmark>();
        mArrayAdapter = new ArrayAdapter<Landmark>(this, R.layout.list_row, mList);
        mListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // nothing!
                Landmark place = mList.get(position);
                String name = place.getName();
                String addy = place.getAddress();
                String desc = place.getDescription();
                mIntentDetail = new Intent(MainActivity.this, DetailActivity.class);
                mIntentDetail.putExtra("NAME", name);
                mIntentDetail.putExtra("ADDRESS", addy);
                mIntentDetail.putExtra("DESCRIPTION", desc);
                Toast.makeText(MainActivity.this, "ow ow ow", Toast.LENGTH_SHORT).show();
                startActivity(mIntentDetail);
            }
        };
        mListView = (ListView) findViewById(R.id.landmarks_list_view);
        mListView.setAdapter(mArrayAdapter);
        mListView.setOnItemClickListener(mListener);

        addLandmark("Bean", "Shiny", "full of tourists");
        addLandmark("Wrigley Field", "OLD", "full of drunk 23 year olds");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLandmark("test item", "testing 123", "really rly cool y'all");
                Snackbar.make(view, "Adding demo item", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
