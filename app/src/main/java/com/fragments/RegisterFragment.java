package com.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activitys.MainActivity;
import com.example.novochat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private Button btRegister;
    private EditText edEmail;
    private EditText edPassword;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
            edEmail = view.findViewById(R.id.emailRegister);
            edPassword = view.findViewById(R.id.passwordRegister);
            btRegister = view.findViewById(R.id.btnRegister);

            btRegister.setOnClickListener(click);
        return view;
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            createUser();
        }
    };

    public void createUser(){

        String email = edEmail.getText().toString();
        String password = edPassword.getText().toString();

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("createUser: ", "Sucesso!");
                            Toast.makeText(getActivity(), "Sucesso!", Toast.LENGTH_SHORT).show();
                        }else{
                            Log.i("createUser: ", "Falha!");
                            Toast.makeText(getActivity(), "Falha!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    //TODO - Criar meios de autenticação do registro

}
