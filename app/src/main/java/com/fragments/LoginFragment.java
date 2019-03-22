package com.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.novochat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    private EditText emailLogin;
    private EditText passwordLogin;
    private Button btnLogin;
    private TextView txtCrieAqui;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_fragmente, container, false);
            emailLogin = view.findViewById(R.id.login_email);
            passwordLogin = view.findViewById(R.id.login_password);
            btnLogin = view.findViewById(R.id.btnLogin);
            txtCrieAqui = view.findViewById(R.id.txtRegister);
        return view;
    }

    //TODO - Criar métodos de LOGIN
}
