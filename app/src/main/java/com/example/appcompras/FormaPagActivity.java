package com.example.appcompras;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FormaPagActivity extends AppCompatActivity {

    TextView txtTotal2;
    EditText txtNumParcela;
    RadioGroup rgFormapag;

    String nome,cidade,produtos,opcaoFormapag = "voltar e calcular";
    int numParcela;
    float total;
    double desconto,valorParc;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forma_pag);

        txtTotal2 = findViewById(R.id.txtTotal2);
        txtNumParcela = findViewById(R.id.txtNumParcela);
        rgFormapag = findViewById(R.id.rgFormapag);

        //recuperando dados
        Bundle dados = getIntent().getExtras();

        nome = dados.getString("nome");
        cidade = dados.getString("cidade");
        total = dados.getFloat("total");
        produtos = dados.getString("produtos");

        txtTotal2.setText(String.valueOf(total));


    }

    public void proximo(View v) {

        String np = txtNumParcela.getText().toString();
        numParcela = Integer.parseInt(np);
        
        rgFormapag.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.rbAprazo) {
                    String p;
                    valorParc = total / numParcela;
                    p = String.valueOf(valorParc);
                    opcaoFormapag = "A prazo = "+numParcela+" x "+p;
                }
                if (i == R.id.rbAvista) {
                    String d;
                    desconto = total * 0.95;
                    d = String.valueOf(desconto);

                    opcaoFormapag = "A vista = "+d;

                }
            }
        });

        Intent intent = new Intent(getApplicationContext(),DadosCompraActivity.class);

        Compra compra = new Compra(nome,cidade,produtos,total,opcaoFormapag,numParcela);
        intent.putExtra("objeto",compra);
        startActivity(intent);

    }
}