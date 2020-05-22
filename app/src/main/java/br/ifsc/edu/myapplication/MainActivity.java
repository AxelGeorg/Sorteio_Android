package br.ifsc.edu.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    EditText n1, n2;
    TextView resultado;
    String valor2,valor1;
    int finalValor2,finalValor1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        resultado = findViewById(R.id.resultado);
    }

    public void sortear(View v){

        Random r = new Random();

        valor2= n2.getText().toString().trim();
        valor1= n1.getText().toString().trim();

        if (valor1.equals("") || valor2.equals("")){
            Toast.makeText(getApplicationContext(), "Uma das caixas de texto esta vazia, preencha corretamente!", Toast.LENGTH_SHORT).show();
        }else{
            finalValor2=Integer.parseInt(valor2);
            finalValor1=Integer.parseInt(valor1);


            if(finalValor1>finalValor2){
                int n = r.nextInt((finalValor1 - finalValor2) + 1) + finalValor2;
                String myString = String.valueOf(n);
                resultado.setText(myString);

            }else if (finalValor2>finalValor1){
                int n = r.nextInt((finalValor2 - finalValor1) + 1) + finalValor1;
                String myString = String.valueOf(n);
                resultado.setText(myString);

            }else if(finalValor1==finalValor2){
                Toast.makeText(getApplicationContext(), "Os numeros são iguais, portanto não será possivel fazer o sorteio", Toast.LENGTH_SHORT).show();
            }
        }
    }
}