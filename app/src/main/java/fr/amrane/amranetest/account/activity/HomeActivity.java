package fr.amrane.amranetest.account.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
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

import java.util.HashMap;

import at.markushi.ui.CircleButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import fr.amrane.amranetest.Activity.FirstActivity;
import fr.amrane.amranetest.R;
import fr.amrane.amranetest.account.model.Account;
import fr.amrane.amranetest.application.AccountSync;
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
    //@BindView(R.id.slider)
    SliderLayout mSlider;
    //@BindView(R.id.btn_home_addAccount)
    Button btn_home_addAccount;
    //@BindView(R.id.btn_show_profiles)
    ImageButton btn_see_profile;
    @BindView(R.id.profile_btn)
    CircleButton profile_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_layout);
        ButterKnife.bind(this);
        setRealmConfiguration();
        setListeners();
        setMapPicture();
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    new AccountSync().execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

    private void setListeners() {
        /*btn_home_addAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showAddAccountDialog();
            }
        });
        btn_see_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            }
        });*/
        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, FirstActivity.class));
            }
        });
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
        /*RealmConfiguration config = new RealmConfiguration.Builder(this)
                .name("Account")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();*/
        realm = Realm.getDefaultInstance();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        //mSlider.stopAutoCycle();
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
