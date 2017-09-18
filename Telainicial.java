    package com.example.raquel.tccalfabetaja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

    public class Telainicial extends AppCompatActivity {
        EditText EditTextNome;
        EditText EditTextIdade;
        Button buttonProximo;
        String nomeCrianca, idade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telainicial);


        buttonProximo = (Button)findViewById(R.id.buttonProximo);
        EditTextNome = (EditText)findViewById(R.id.EditTextNome);
        EditTextIdade= (EditText)findViewById(R.id.EditTextIdade);

    }

        public void onClick(View v) throws IOException {
            DadosCrianca dc = new DadosCrianca();

            BancoDados bd = new BancoDados(this);
            try {
                bd.create();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
