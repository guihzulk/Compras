package com.example.appcompras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DadosCompraActivity extends AppCompatActivity {

    TextView lblComprador;
    TextView lblCidade;
    TextView lblProdutos;
    TextView lblTotal;
    TextView lblFormapag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_compra);

        lblComprador = findViewById(R.id.lblComprador);
        lblCidade = findViewById(R.id.lblCidade);
        lblProdutos = findViewById(R.id.lblProdutos);
        lblTotal = findViewById(R.id.lblTotal);
        lblFormapag = findViewById(R.id.lblFormapag);

        //recuperando dados
        Bundle dados = getIntent().getExtras();

        //capturando o obejto
        Compra compra = (Compra)dados.getSerializable("objeto");

        lblComprador.setText(compra.getNome());
        lblCidade.setText(compra.getCidade());
        lblProdutos.setText(compra.getProdutos());
        lblTotal.setText(String.valueOf(compra.getTotal()));
        lblFormapag.setText(compra.getFormaPag());

    }

    public void confirmar(View v){
        Toast.makeText(this,"Compra confirmada com sucesso",Toast.LENGTH_SHORT).show();
        finishAffinity();
    }
    public void cancelar(View v){
        Toast.makeText(this,"Obrigado por usar nosso aplicativo",Toast.LENGTH_SHORT).show();
        finishAffinity();
    }
}