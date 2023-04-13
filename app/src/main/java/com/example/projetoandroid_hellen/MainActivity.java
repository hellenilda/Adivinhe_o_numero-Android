package com.example.projetoandroid_hellen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        Log.i("MEUAPP", "Número correto: "+numeroCorreto);

        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog =
                        new AlertDialog.Builder(MainActivity.this);

                alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                try {
                    String strEntradaUsuario = entradaUsuario.getText().toString();
                    int intEntradaUsuario = Integer.parseInt(strEntradaUsuario);

                    Log.i("MEUAPP", "Número que foi digitado: "+intEntradaUsuario);

                    aviso.setVisibility(View.INVISIBLE);

                    if (entradaUsuario.getText() == null) {
                        alertDialog
                                .setTitle(R.string.tituloVazio);
                        alertDialog
                                .setMessage(R.string.mensagemVazio);

                        alertDialog.create().show();
                    } else {
                        if (intEntradaUsuario < numeroCorreto) {
                            if (intEntradaUsuario < 0 | intEntradaUsuario > 100) {
                                alertDialog
                                        .setTitle(R.string.tituloIntervalo);
                                alertDialog
                                        .setMessage(R.string.mensagemIntervalo);
                                alertDialog.create().show();

                                entradaUsuario.setText(null);
                            } else {
                                numeroMinimo.setText(String.valueOf(intEntradaUsuario));
                                entradaUsuario.setText(null);
                            }
                        } else if (intEntradaUsuario > numeroCorreto) {
                            if (intEntradaUsuario < 0 | intEntradaUsuario > 100) {
                                alertDialog
                                        .setTitle(R.string.tituloIntervalo);
                                alertDialog
                                        .setMessage(R.string.mensagemIntervalo);
                                alertDialog.create().show();

                                entradaUsuario.setText(null);
                            } else {
                                numeroMaximo.setText(String.valueOf(intEntradaUsuario));
                                entradaUsuario.setText(null);
                            }
                        } else if (intEntradaUsuario == 0 ) {
                            alertDialog
                                    .setTitle(R.string.tituloMaiorQzero);
                            alertDialog
                                    .setMessage(R.string.mensagemMaiorQzero);
                            alertDialog.create().show();

                            entradaUsuario.setText(null);
                        } else if (intEntradaUsuario == numeroCorreto) {

                            if (intEntradaUsuario < 0 | intEntradaUsuario > 100) {
                                alertDialog
                                        .setTitle(R.string.tituloIntervalo);
                                alertDialog
                                        .setMessage(R.string.mensagemIntervalo);
                                alertDialog.create().show();

                                entradaUsuario.setText(null);
                            } else {
                                alertDialog
                                        .setTitle(R.string.tituloAcertou);
                                alertDialog
                                        .setMessage(R.string.mensagemAcertou);

                                alertDialog.create().show();

                                btnJogar.setEnabled(false);
                                tvIntervalo.setText(null);
                                entradaUsuario.setText(null);
                            }
                        }
                    }
                } catch (NumberFormatException exception) {
                    Toast.makeText(MainActivity.this, R.string.erroformato, Toast.LENGTH_SHORT).show();
                    alertDialog
                            .setTitle(R.string.tituloVazio);
                    alertDialog
                            .setMessage(R.string.mensagemVazio);

                    alertDialog.create().show();
                }
            }
        });
    }
}