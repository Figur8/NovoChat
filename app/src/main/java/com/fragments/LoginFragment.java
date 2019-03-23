package com.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.novochat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    private FirebaseAuth auth = FirebaseAuth.getInstance();
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

            btnLogin.setOnClickListener(click);
        return view;
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loginUser();
        }
    };

    public void loginUser(){
        String email = emailLogin.getText().toString();
        String password = passwordLogin.getText().toString();

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("loginUser: ", "Sucesso!");
                            Toast.makeText(getActivity(), "Usuário Logado!", Toast.LENGTH_SHORT).show();
                        }else{
                            Log.i("loginUser: ", "Falha!");
                            Toast.makeText(getActivity(), "Usuário não Logado!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    //TODO - Criar meios de autenticação do Login
}
