package com.example.appcompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CompradorActivity extends AppCompatActivity {

    EditText txtNome;
    EditText txtCidade;

    String nome,cidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprador);

        txtNome = findViewById(R.id.txtNome);
        txtCidade = findViewById(R.id.txtCidade);
    }

    public void proximo(View v) {
        nome = txtNome.getText().toString();
        cidade = txtCidade.getText().toString();

        Intent intent = new Intent(getApplicationContext(),ProdutoActivity.class);

        intent.putExtra("nome",nome);
        intent.putExtra("cidade",cidade);

        startActivity(intent);
    }
}