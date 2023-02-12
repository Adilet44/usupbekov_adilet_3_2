package com.example.usupbekov_adilet_3_2;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    private TextView textView;
    private Button btn_1, btn_2, btn_3;
    static final String KEY_FOR_TEXT = "w";
    Integer num;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();


    }

    private void initListener() {
        btn_1.setOnClickListener(view -> {
            num = Integer.parseInt(textView.getText().toString());
            num++;
            textView.setText(num.toString());
        });
        btn_2.setOnClickListener(view -> {
            num = Integer.parseInt(textView.getText().toString());
            num--;
            textView.setText(num.toString());
        });
        btn_3.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_FOR_TEXT, textView.getText().toString());
            fragment_result fragment_result = new fragment_result();
            fragment_result.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity, fragment_result).addToBackStack(null).commit();

        });
    }

    private void initView() {
        textView = requireActivity().findViewById(R.id.text_view);
        btn_1 = requireActivity().findViewById(R.id.btn_1);
        btn_2 = requireActivity().findViewById(R.id.btn_2);
        btn_3 = requireActivity().findViewById(R.id.btn_3);

    }
}