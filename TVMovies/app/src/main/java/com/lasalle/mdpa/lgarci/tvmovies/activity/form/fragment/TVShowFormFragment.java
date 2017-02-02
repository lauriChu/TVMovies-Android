package com.lasalle.mdpa.lgarci.tvmovies.activity.form.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lasalle.mdpa.lgarci.tvmovies.R;
import com.lasalle.mdpa.lgarci.tvmovies.adapter.OnTVShowListener;
import com.lasalle.mdpa.lgarci.tvmovies.model.TVShow;

/**
 * Created by FurruPi on 2/2/17.
 */

public class TVShowFormFragment extends Fragment {

    private TextInputEditText nameEditText, seasonsEditText, yearEditText;
    private Button button;
    private OnTVShowListener listener;

    @Override
    public void onAttach(Context context) {
        listener = (OnTVShowListener) getActivity();
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayoutView = inflater.inflate(R.layout.fragment_tvform, container, false);
        button = (Button) fragmentLayoutView.findViewById(R.id.button);
        nameEditText = (TextInputEditText) fragmentLayoutView.findViewById(R.id.editText_name);
        seasonsEditText = (TextInputEditText) fragmentLayoutView.findViewById(R.id.editText_seasons);
        yearEditText = (TextInputEditText) fragmentLayoutView.findViewById(R.id.editText_year);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String season = seasonsEditText.getText().toString();
                String year = yearEditText.getText().toString();
                listener.onTVShowAdded(new TVShow(name, season, year));
            }
        });

        return fragmentLayoutView;

    }
}
