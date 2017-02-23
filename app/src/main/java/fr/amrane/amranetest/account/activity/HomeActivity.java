package fr.amrane.amranetest.account.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.rey.material.widget.FloatingActionButton;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.amrane.amranetest.Activity.Test;
import fr.amrane.amranetest.R;
import fr.amrane.amranetest.account.model.Account;
import fr.amrane.amranetest.common.dialog.AddAccountDialog;
import fr.amrane.amranetest.profile.activity.ProfileActivity;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class HomeActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
    private Realm realm;
    //@BindView(R.id.tv_mail)
    //TextView tv_mail;
    @BindView(R.id.slider)
    SliderLayout mSlider;
    @BindView(R.id.btn_show_profiles)
    ImageButton btn_see_profile;
    @BindView(R.id.button2)
    Button button2;
    private boolean isBtnOff= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_layout);
        ButterKnife.bind(this);
        setRealmConfiguration();
        setListeners();
        setMapPicture();

        FloatingActionButton bt_float_wave_color = (FloatingActionButton)findViewById(R.id.button_bt_float_wave_color);
        bt_float_wave_color.setIcon(getDrawable(R.drawable.ic_drawer_account), true);

        //FloatingActionButton bt_float_wave = (FloatingActionButton)findViewById(R.id.button_bt_float_wave);
        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(v instanceof  FloatingActionButton){
                    FloatingActionButton bt = (FloatingActionButton)v;
                    bt.setLineMorphingState((bt.getLineMorphingState() + 1) % 2, true);
                    bt.setBackgroundColor(getResources().getColor(R.color.accentColor));
                }
            }
        };

        View.OnClickListener listener_delay = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(v instanceof  FloatingActionButton){
                    FloatingActionButton bt = (FloatingActionButton)v;
                    if(!isBtnOff) {
                        bt.setIcon(getDrawable(R.drawable.ic_drawer_account), true);
                        isBtnOff = true;
                    }
                    else {
                        bt.setIcon(getDrawable(R.drawable.ic_drawer_account_list), true);
                        isBtnOff = false;
                    }

                    bt.setLineMorphingState((bt.getLineMorphingState() + 1) % 2, true);
                    //bt.setBackgroundColor(getResources().getColor(R.color.accentColor));
                    //bt.setIcon(getDrawable(R.drawable.ic_drawer_account), true);
                }
            }
        };
        //bt_float_wave.setOnClickListener(listener);
        bt_float_wave_color.setOnClickListener(listener_delay);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Test.class));
            }
        });
    }


    private void setListeners() {
    }

    private void showAddAccountDialog() {
        final AddAccountDialog accountDialog = new AddAccountDialog();
        accountDialog.show(getSupportFragmentManager(), accountDialog.getClass().getName());
        accountDialog.setListener(new AddAccountDialog.OnAddAccountClickListener(){
            @Override
            public void OnAddAccountClickListener(Account account) {
                Log.d("Dialog", "Account");
                accountDialog.dismiss();
            }
        });
    }

    private void setMapPicture() {
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.hannibal);
        file_maps.put("Big Bang Theory",R.drawable.bigbang);
        file_maps.put("House of Cards",R.drawable.house);
        file_maps.put("Game of Thrones", R.drawable.game_of_thrones);

        for(String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            mSlider.addSlider(textSliderView);
        }
        mSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        //mSlider.setDuration(4000);
        mSlider.stopAutoCycle();
        mSlider.addOnPageChangeListener(this);
        mSlider.setPresetTransformer("Stack");
        /*ListView l = (ListView)findViewById(R.id.transformers);
        l.setAdapter(new TransformerAdapter(this));
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSlider.setPresetTransformer(((TextView) view).getText().toString());
                Toast.makeText(HomeActivity.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    public void setRealmConfiguration(){
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .name("Account")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(config);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        mSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        //menuInflater.inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
