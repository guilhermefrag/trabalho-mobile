package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.dao.AbstrataDAO;
import com.example.myapplication.database.dao.UsuarioDAO;
import com.example.myapplication.database.model.UsuarioModel;

public class CadastroActivity extends AppCompatActivity {

    private Button btnSair;
    private Button btnCadastrar;

    private EditText editNomeCompleto;

    private EditText editNEmailCadastro;

    private EditText editIdade;

    private EditText editSenhaCadastro;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        AbstrataDAO abstrataDAO = new AbstrataDAO();
        btnSair = findViewById(R.id.btnSair);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        editNomeCompleto = findViewById(R.id.editNomeCompleto);
        editNEmailCadastro = findViewById(R.id.editNEmailCadastro);
        editIdade = findViewById(R.id.editIdade);
        editSenhaCadastro = findViewById(R.id.editSenhaCadastro);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeCompleto = editNomeCompleto.getText().toString();
                String email = editNEmailCadastro.getText().toString();
                String idade = editIdade.getText().toString();
                String senha = editSenhaCadastro.getText().toString();
                Integer countErros = 0;

                if (nomeCompleto.isEmpty()) {
                    editNomeCompleto.setError("Campo obrigatório");
                    countErros++;
                }

                if (email.isEmpty()) {
                    editNEmailCadastro.setError("Campo obrigatório");
                    countErros++;
                }

                if (idade.isEmpty()) {
                    editIdade.setError("Campo obrigatório");
                    countErros++;
                }

                if (senha.isEmpty()) {
                    editSenhaCadastro.setError("Campo obrigatório");
                    countErros++;
                }
                if (countErros > 0) {
                    Toast.makeText(CadastroActivity.this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
                    return;
                }

                UsuarioModel usuarioModel = new UsuarioModel();

                usuarioModel.setEmail(email);
                usuarioModel.setNomeCompleto(nomeCompleto);
                usuarioModel.setIdade(Integer.parseInt(idade));
                usuarioModel.setSenha(senha);

                UsuarioDAO dao = new UsuarioDAO(CadastroActivity.this);

                try {

                    dao.Insert(usuarioModel);

                } catch (Exception e) {
                    Toast.makeText(CadastroActivity.this, "Erro ao cadastrar usuário", Toast.LENGTH_LONG).show();
                    return;
                }

                Toast.makeText(CadastroActivity.this, "Usuário cadastrado com sucesso", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
