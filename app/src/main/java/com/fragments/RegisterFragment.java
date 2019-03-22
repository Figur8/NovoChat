package com.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.novochat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private Button register;
    private EditText email;
    private EditText password;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
            email = view.findViewById(R.id.emailRegister);
            password = view.findViewById(R.id.passwordRegister);
            register = view.findViewById(R.id.btnRegister);
        return view;
    }
    //TODO - Criar métodos para registrar um novo usuário
}
