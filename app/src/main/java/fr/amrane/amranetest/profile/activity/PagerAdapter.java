package fr.amrane.amranetest.profile.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by aaitzeouay on 22/02/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    Fragment[] mFragments = new Fragment[3];
    Tab[] mTabs;

    private static final Field sActiveField;

    static {
        Field f = null;
        try {
            Class<?> c = Class.forName("android.support.v4.app.FragmentManagerImpl");
            f = c.getDeclaredField("mActive");
            f.setAccessible(true);
        } catch (Exception e) {}

        sActiveField = f;
    }

    public PagerAdapter(FragmentManager fm, Tab[] tabs) {
        super(fm);
        mTabs = tabs;
        mFragments = new Fragment[mTabs.length];


        //dirty way to get reference of cached fragment
        try{
            ArrayList<Fragment> mActive = (ArrayList<Fragment>)sActiveField.get(fm);
            if(mActive != null){
                for(Fragment fragment : mActive){
                    /*if(fragment instanceof ProgressFragment)
                        setFragment(Tab.PROGRESS, fragment);
                    else if(fragment instanceof ButtonFragment)
                        setFragment(Tab.BUTTONS, fragment);
                    else if(fragment instanceof SwitchesFragment)
                        setFragment(Tab.SWITCHES, fragment);
                    else if(fragment instanceof TextfieldFragment)
                        setFragment(Tab.TEXTFIELDS, fragment);
                    else if(fragment instanceof SnackbarFragment)
                        setFragment(Tab.SNACKBARS, fragment);*/
                }
            }
        }
        catch(Exception e){}
    }

    private void setFragment(Tab tab, Fragment f){
        for(int i = 0; i < mTabs.length; i++)
            if(mTabs[i] == tab){
                mFragments[i] = f;
                break;
            }
    }

    @Override
    public Fragment getItem(int position) {
        if(mFragments[position] == null){
            switch (mTabs[position]) {
                case PROGRESS:
                   // mFragments[position] = ProgressFragment.newInstance();
                    break;
                case BUTTONS:
                    //mFragments[position] = ButtonFragment.newInstance();
                    break;
                case SWITCHES:
                   // mFragments[position] = SwitchesFragment.newInstance();
                    break;
                case TEXTFIELDS:
                    //mFragments[position] = TextfieldFragment.newInstance();
                    break;
                case SNACKBARS:
                    //mFragments[position] = SnackbarFragment.newInstance();
                    break;
            }
        }

        return mFragments[position];
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs[position].toString().toUpperCase();
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }
}