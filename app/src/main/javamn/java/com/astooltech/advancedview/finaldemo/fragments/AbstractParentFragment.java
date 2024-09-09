package com.astooltech.advancedview.finaldemo.fragments;


import android.os.Bundle;
  import androidx.fragment.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

import com.astooltech.advancedview.R;

public abstract class AbstractParentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parent, container, false);
        setupChildFragments(view, savedInstanceState);
        return view;
    }

    protected abstract void setupChildFragments(View view, Bundle savedInstanceState);
}
