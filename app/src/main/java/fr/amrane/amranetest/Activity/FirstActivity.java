package fr.amrane.amranetest.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.amrane.amranetest.R;
import fr.amrane.amranetest.conversation.adapter.ListModel;
import fr.amrane.amranetest.conversation.adapter.ListAdapter;

/**
 * Created by aaitzeouay on 12/12/2016.
 */

public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        String[] foods = {"Amrane", "test", "Simona", "Hamada", "Wow", "Amine"};
        int[] img = {R.drawable.app_logo, R.drawable.eiffel_tower_icon_2014, R.drawable.eiffel_logo, R.drawable.ic_contact_sncf,
        R.drawable.ic_dashboard_hearth, R.drawable.ic_sms_big_blue};
        List<ListModel> map = new ArrayList<ListModel>();
        map.add(new ListModel(img[0], foods[0], "This is the first conversation"));
        map.add(new ListModel(img[1], foods[1], "This is the 2nd conversation"));
        map.add(new ListModel(img[2], foods[2], "This is the 3rd conversation"));
        map.add(new ListModel(img[3], foods[3], "This is the 4th conversation"));
        map.add(new ListModel(img[4], foods[4], "This is the 5th conversation"));
        map.add(new ListModel(img[5], foods[5], "This is the 6th conversation"));

        ListAdapter adapter = new ListAdapter(this, map);
        //ListAdapter adapter = new ListAdapter(this, foods, img);
        ListView foodListView = (ListView) findViewById(R.id.listView);
        foodListView.setAdapter(adapter);

        foodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListModel food = (ListModel) adapterView.getItemAtPosition(i);
                Toast.makeText(FirstActivity.this, food.getName(), Toast.LENGTH_LONG).show();
            }
        });
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.first_activity);*/
    }
}
