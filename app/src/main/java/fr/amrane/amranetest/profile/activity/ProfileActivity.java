package fr.amrane.amranetest.profile.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.rey.material.widget.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.amrane.amranetest.R;
import fr.amrane.amranetest.profile.fragment.ProfileDetails;
import fr.amrane.amranetest.profile.fragment.ProfilePictures;
import fr.amrane.amranetest.profile.fragment.ProfileSettings;
import io.realm.Realm;

/**
 * Created by aaitzeouay on 22/02/2017.
 */

public class ProfileActivity extends AppCompatActivity{
    private Tab[] mItems = new Tab[]{Tab.PROGRESS, Tab.BUTTONS, Tab.SWITCHES, Tab.TEXTFIELDS, Tab.SNACKBARS};
    private static int[] tabIcons = {R.drawable.ic_drawer_account, R.drawable.ic_action_image_photo_camera, R.drawable.ic_action_parameter_inverse};
    private PagerAdapter mPagerAdapter;
    private SectionPagerAdapter mSectionPagerAdapter;

    @BindView(R.id.tab_page_indicator)
    TabPageIndicator tabPageIndicator;
    @BindView(R.id.tab_layout)
    TabLayout tab_layout;
    @BindView(R.id.pager)
    ViewPager mViewPager;

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
        setupViewPage(mViewPager);
        tabPageIndicator.setViewPager(mViewPager);
        tab_layout.setupWithViewPager(mViewPager);
        setupTabIcons();
        /*mViewPager.setAdapter(mSectionPagerAdapter);

        final TabLayout.Tab tab1 = tab_layout.newTab().setText("Settings");
        final TabLayout.Tab tab2 = tab_layout.newTab().setText("Details");
        final TabLayout.Tab tab3 = tab_layout.newTab().setText("Pictures");

        tab_layout.addTab(tab1);
        tab_layout.addTab(tab2);
        tab_layout.addTab(tab3);

        tab_layout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.common_gray));
        tab_layout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.accentColor));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));*/

    }

    private void setupTabIcons() {
        tab_layout.getTabAt(0).setIcon(tabIcons[0]);
        tab_layout.getTabAt(1).setIcon(tabIcons[1]);
        tab_layout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setOnClickListener() {
    }

    private void setupViewPage(ViewPager viewPager){
        ViewPagerAdapter PagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        PagerAdapter.addFragment(new ProfileDetails(), "Details");
        PagerAdapter.addFragment(new ProfilePictures(), "Pictures");
        PagerAdapter.addFragment(new ProfileSettings(), "Settings");
        viewPager.setAdapter(PagerAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //return mFragmentTitleList.get(position);
            //null for not getting the name of the tab
            return null;
        }
    }

}

class SectionPagerAdapter extends FragmentPagerAdapter{

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                ProfileSettings settings = new ProfileSettings();
                return settings;
            case 1:
                ProfileDetails details = new ProfileDetails();
                return details;
            case 2:
                ProfilePictures pictures = new ProfilePictures();
                return pictures;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "Settings";
            case 1:
                return "Details";
            case 2:
                return "Pictures";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
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