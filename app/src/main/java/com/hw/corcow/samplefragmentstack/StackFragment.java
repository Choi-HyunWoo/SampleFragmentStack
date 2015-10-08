package com.hw.corcow.samplefragmentstack;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StackFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StackFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StackFragment extends Fragment {

    private static final String ARG_NAME = "name";
    private String name;

   public static StackFragment newInstance(String name) {
        StackFragment fragment = new StackFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    public StackFragment() {
        // Required empty public constructor
    }

    TextView nameView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_stack, container, false);
        nameView = (TextView)v.findViewById(R.id.text_name);
        nameView.setText(name);
        return v;
    }

}
