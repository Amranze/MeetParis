package fr.amrane.amranetest.profile.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.amrane.amranetest.R;

/**
 * Created by aaitzeouay on 23/02/2017.
 */

public class ProfileSettings extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_settings_fragment, container, false);
    }
}