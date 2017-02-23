package fr.amrane.amranetest.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.rey.material.widget.FloatingActionButton;

import butterknife.ButterKnife;
import fr.amrane.amranetest.R;
import fr.amrane.amranetest.account.activity.HomeActivity;
import fr.amrane.amranetest.profile.activity.ProfileActivity;

/**
 * Created by aaitzeouay on 23/02/2017.
 */

public class Test  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        FloatingActionButton bt_float_wave_color = (FloatingActionButton)findViewById(R.id.button_bt_float_wave_color);
        FloatingActionButton bt_float_wave = (FloatingActionButton)findViewById(R.id.button_bt_float_wave);
        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(v instanceof  FloatingActionButton){
                    FloatingActionButton bt = (FloatingActionButton)v;
                    bt.setLineMorphingState((bt.getLineMorphingState() + 1) % 2, true);
                }
            }
        };

        View.OnClickListener listener_delay = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(v instanceof  FloatingActionButton){
                    FloatingActionButton bt = (FloatingActionButton)v;
                    bt.setLineMorphingState((bt.getLineMorphingState() + 1) % 2, true);
                }
            }
        };
        bt_float_wave.setOnClickListener(listener);
        bt_float_wave_color.setOnClickListener(listener_delay);

    }
}
