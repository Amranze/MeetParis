package fr.amrane.amranetest.profile.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.rey.material.widget.TabPageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.amrane.amranetest.R;
import io.realm.Realm;

/**
 * Created by aaitzeouay on 22/02/2017.
 */

public class ProfileActivity extends AppCompatActivity{
    private Tab[] mItems = new Tab[]{Tab.PROGRESS, Tab.BUTTONS, Tab.SWITCHES, Tab.TEXTFIELDS, Tab.SNACKBARS};
    private PagerAdapter mPagerAdapter;
    private ViewPager vp;

    @BindView(R.id.profile_tab_page_indicator)
    TabPageIndicator tabPageIndicator;

    private Realm realm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity_v2);
        realm = Realm.getDefaultInstance();
        ButterKnife.bind(this);
        setOnClickListener();
        //vp = (ViewPager)findViewById(R.id.pager);
        //mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mItems);
        //vp.setAdapter(mPagerAdapter);
        //tabPageIndicator.setViewPager(vp);
    }

    private void setOnClickListener() {
    }
}

enum Tab {
    PROGRESS ("Progresses"),
    BUTTONS ("Buttons"),
    SWITCHES ("Switches"),
    TEXTFIELDS ("Textfields"),
    SNACKBARS ("Snackbars");
    private final String name;

    private Tab(String s) {
        name = s;
    }

    public boolean equalsName(String otherName){
        return (otherName != null) && name.equals(otherName);
    }

    public String toString(){
        return name;
    }

}