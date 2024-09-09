package com.astooltech.advancedview.finaldemo.fragments;


import android.os.Bundle;
     // androidx.fragment.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;

import com.astooltech.advancedview.R;


public class concorfragment extends AbstractParentFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_concrete_parent, container, false);

        TextView headerText = view.getRootView().findViewById(R.id.header_textv);
        Button actionButton = view.getRootView().findViewById(R.id.action_buttonv);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Action performed!", Toast.LENGTH_SHORT).show();
            }
        });

        setupChildFragments(view, savedInstanceState);

        return view;
    }

    @Override
    protected void setupChildFragments(View view, Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            ChildFragment1 childFragment1 = new ChildFragment1();


            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.child_fragment_container3, childFragment1);

            transaction.commit();
        }
    }
}
