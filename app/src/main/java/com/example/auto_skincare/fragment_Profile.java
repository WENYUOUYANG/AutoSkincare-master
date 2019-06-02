package com.example.auto_skincare;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class fragment_Profile extends Fragment {

    Button SavePreference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        SavePreference= view.findViewById(R.id.profileUpdate);
        SavePreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goUpdateProfile = new Intent(getActivity(),profile_update.class);
                startActivity(goUpdateProfile);
            }
        });

        return view;
    }
}
