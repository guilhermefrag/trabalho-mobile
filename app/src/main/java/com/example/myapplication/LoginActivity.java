package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.dao.UsuarioDAO;
import com.example.myapplication.database.model.UsuarioModel;

import java.sql.SQLException;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private EditText editEmail;
    private EditText editSenha;
    private CheckBox checkLembrarSenha;
    private Button btnEntrar;
    private Button btnCadastrar;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        checkLembrarSenha = findViewById(R.id.checkLembrarSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        SharedPreferences sharedPreferences = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);

        boolean lembrarSenha = sharedPreferences.getBoolean("lembrar_senha", false);

        if (lembrarSenha) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            return;
        }
        checkLembrarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("lembrar_senha", true);

                editor.apply();
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();
                String senha = editSenha.getText().toString();

                UsuarioDAO usuarioDAO = new UsuarioDAO(LoginActivity.this);

                try {

                    List<UsuarioModel> usuario = usuarioDAO.Login(email, senha);
                    if (!usuario.isEmpty()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("id_usuario", (int) usuario.get(0).getId());
                        editor.apply();
                        if (checkLembrarSenha.isChecked()) {
                            editor.putBoolean("lembrar_senha", true);
                            editor.apply();
                        }

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Usuário ou senha inválidos", Toast.LENGTH_LONG).show();
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });
    }
}
