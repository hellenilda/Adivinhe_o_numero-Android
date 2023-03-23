package com.example.projetoandroid_hellen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView aviso;
    private TextView tvIntervalo;
    private TextView numeroMinimo;
    private TextView numeroMaximo;
    private EditText entradaUsuario;
    private Button btnJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aviso = findViewById(R.id.tvAviso);
        tvIntervalo = findViewById(R.id.tvIntervalo);
        numeroMinimo = findViewById(R.id.tvNum1);
        numeroMaximo = findViewById(R.id.tvNum2);
        entradaUsuario = findViewById(R.id.etNumber);
        btnJogar = findViewById(R.id.btnJogar);

        Random gerador = new Random();

        int numeroCorreto = gerador.nextInt((100-1)+1)+1;
        Log.i("MEUAPP", "Número: "+numeroCorreto);

        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
//                    String strNum1 = numeroMinimo.getText().toString();
//                    int intNum1 = Integer.parseInt(strNum1);
//
//                    String strNum2 = numeroMaximo.getText().toString();
//                    int intNum2 = Integer.parseInt(strNum2);

                    String strEntradaUsuario = entradaUsuario.getText().toString();
                    int intEntradaUsuario = Integer.parseInt(strEntradaUsuario);

                    aviso.setVisibility(View.INVISIBLE);

                    if (entradaUsuario.getText() == null) {
                        aviso.setVisibility(View.VISIBLE);
                        aviso.setText("Insira um valor válido abaixo!");
                    } else {
                        if (intEntradaUsuario < numeroCorreto) {
                            if (intEntradaUsuario < 0 || intEntradaUsuario > 100) {
                                aviso.setVisibility(View.VISIBLE);
                                aviso.setText("Insira um número de 0 a 100!");
                                entradaUsuario.setText(null);
                            } else {
                                numeroMinimo.setText(String.valueOf(intEntradaUsuario));
                                entradaUsuario.setText(null);
                            }
                        } else if (intEntradaUsuario > numeroCorreto) {
                            if (intEntradaUsuario < 0 || intEntradaUsuario > 100) {
                                aviso.setVisibility(View.VISIBLE);
                                aviso.setText("Insira um número de 0 a 100!");
                                entradaUsuario.setText(null);
                            } else {
                                numeroMaximo.setText(String.valueOf(intEntradaUsuario));
                                entradaUsuario.setText(null);
                            }
                        } else if (intEntradaUsuario == 0 ) {
                            aviso.setVisibility(View.VISIBLE);
                            aviso.setText("Digite um número maior que 0!");
                            entradaUsuario.setText("");
                        } else if (intEntradaUsuario == numeroCorreto) {

                            if (intEntradaUsuario < 0 || intEntradaUsuario > 100) {
                                aviso.setVisibility(View.VISIBLE);
                                aviso.setText("Insira um número de 0 a 100!");
                                entradaUsuario.setText("");
                            } else {
                                aviso.setVisibility(View.VISIBLE);
                                aviso.setText("PARABÉNS! VOCÊ ACERTOU O NÚMERO!");
                                btnJogar.setEnabled(false);
                                tvIntervalo.setText(null);
                                entradaUsuario.setText(null);
                            }
                        }
                    }
                } catch (NumberFormatException exception) {
                    aviso.setVisibility(View.VISIBLE);
                    aviso.setText("Insira um valor válido abaixo!");
                }
            }
        });
    }
}