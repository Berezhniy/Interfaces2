package ru.startandroid.interfaces;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

    private MainContract.Listener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_main, container, false);
        Button btn = (Button) v.findViewById(R.id.btn_main_open_second);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null) mListener.openSecondActivities();
                // проверяется листенер использован или нет, если результат не равен null то переходим с лояута на фрагмент
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainContract.Listener) {
            mListener = (MainContract.Listener) context;
            //проверяю контекст листенера и что-то происходит
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
            // то что происходит в случае отсутствия контекста
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
