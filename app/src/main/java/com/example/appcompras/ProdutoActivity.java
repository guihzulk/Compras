package com.example.appcompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProdutoActivity extends AppCompatActivity {

    CheckBox ckProd1,ckProd2,ckProd3;
    TextView txtTotal;
    float calculo = 0;

    String nome,cidade,total,produtos;
    // tera todas as cores escolhidas
    List<String> check = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        ckProd1 = findViewById(R.id.ckProd1);
        ckProd2 = findViewById(R.id.ckProd2);
        ckProd3 = findViewById(R.id.ckProd3);
        txtTotal = findViewById(R.id.txtTotal);

        //recuperando dados
        Bundle dados = getIntent().getExtras();

        nome = dados.getString("nome");
        cidade = dados.getString("cidade");

    }

    public void calcular(View v){
        verificarCheck();
        total = String.valueOf(calculo);
        produtos = String.valueOf(check);
        txtTotal.setText(total);
    }

    public void proximo(View v) {

        Intent intent = new Intent(getApplicationContext(),FormaPagActivity.class);

        //txtTotal.setText(check.toString());
        intent.putExtra("nome",nome);
        intent.putExtra("cidade",cidade);
        intent.putExtra("total",calculo);
        intent.putExtra("produtos",produtos);

        startActivity(intent);
    }

    public void verificarCheck() {

        check.clear();
        calculo = 0;

        if (ckProd1.isChecked()) {
            check.add(ckProd1.getText().toString());
            calculo+=150;
        }
        if (ckProd2.isChecked()) {
            check.add(ckProd2.getText().toString());
            calculo+=200;
        }
        if (ckProd3.isChecked()) {
            check.add(ckProd3.getText().toString());
            calculo+=350;
        }
    }
}