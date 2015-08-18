package com.season.calculadorasimples;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;

public class CalculadoraSimplesActivity extends AppCompatActivity {

    EditText primeiroNumero;
    EditText segundoNumero;
    Button   botao;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_simples);

        primeiroNumero = (EditText) findViewById(R.id.edPrimeiroNumero);
        segundoNumero  = (EditText) findViewById(R.id.edSegundoNumero);
        botao          = (Button)   findViewById(R.id.btCalcular);
        resultado      = (TextView) findViewById(R.id.edResultado);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora_simples, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void mostrar(View view){

        if (primeiroNumero.getText().toString().trim().isEmpty() ||
            segundoNumero.getText().toString().trim().isEmpty()) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Aviso");
            dlg.setMessage("Informe os 2 números!");
            dlg.setIcon(R.drawable.ic_warning);
            dlg.setPositiveButton("OK",null);
            dlg.show();
        }else {
            double numero1 = Double.parseDouble(primeiroNumero.getText().toString());
            double numero2 = Double.parseDouble(segundoNumero.getText().toString());
            double soma = numero1 + numero2;
            resultado.setText("Resultado: " + Double.toString(soma));
        }
    }
}
