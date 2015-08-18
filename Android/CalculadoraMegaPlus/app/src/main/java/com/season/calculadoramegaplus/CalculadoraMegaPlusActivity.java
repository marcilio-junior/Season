package com.season.calculadoramegaplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.towel.math.Expression;

public class CalculadoraMegaPlusActivity extends AppCompatActivity implements View.OnClickListener,
                                                                              View.OnLongClickListener {

    // botoes numericos
    private Button zero, um, dois, tres, quatro, cinco, seis, sete, oito, nove,

    // botoes das operacoes
    som, sub, mul, div,

    // botao do ponto
    ponto,

    // botoes das funcoes
    limpar, igual,

    // botoes dos parenteses
    abrePar, fechaPar;

    // Visores
    private TextView conta, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_mega_plus);

        // numeros
        zero = (Button) findViewById(R.id.bt0);
        um = (Button) findViewById(R.id.bt1);
        dois = (Button) findViewById(R.id.bt2);
        tres = (Button) findViewById(R.id.bt3);
        quatro = (Button) findViewById(R.id.bt4);
        cinco = (Button) findViewById(R.id.bt5);
        seis = (Button) findViewById(R.id.bt6);
        sete = (Button) findViewById(R.id.bt7);
        oito = (Button) findViewById(R.id.bt8);
        nove = (Button) findViewById(R.id.bt9);

        // ponto
        ponto = (Button) findViewById(R.id.btPonto);

        // operacoes
        div = (Button) findViewById(R.id.btDiv);
        mul = (Button) findViewById(R.id.btMul);
        sub = (Button) findViewById(R.id.btSub);
        som = (Button) findViewById(R.id.btSom);

        // funcoes
        limpar = (Button) findViewById(R.id.btLimpar);
        igual = (Button) findViewById(R.id.btIgual);

        // parenteses
        abrePar = (Button) findViewById(R.id.btAbrePar);
        fechaPar = (Button) findViewById(R.id.btFechaPar);

        // visores
        conta = (TextView) findViewById(R.id.tvConta);
        resultado = (TextView) findViewById(R.id.tvResultado);

        // atribui os eventos aos widgets
        zero.setOnClickListener(this);
        um.setOnClickListener(this);
        dois.setOnClickListener(this);
        tres.setOnClickListener(this);
        quatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        sete.setOnClickListener(this);
        oito.setOnClickListener(this);
        nove.setOnClickListener(this);

        ponto.setOnClickListener(this);

        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        sub.setOnClickListener(this);
        som.setOnClickListener(this);

        limpar.setOnClickListener(this);
        limpar.setOnLongClickListener(this);
        igual.setOnClickListener(this);

        abrePar.setOnClickListener(this);
        fechaPar.setOnClickListener(this);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_calculadora_mega_plus, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt0:
                conta.setText(conta.getText().toString() + zero.getText().toString());
                calculaResultado(false);
                break;

            case R.id.bt1:
                conta.setText(conta.getText().toString() + um.getText().toString());
                calculaResultado(false);
                break;

            case R.id.bt2:
                conta.setText(conta.getText().toString() + dois.getText().toString());
                calculaResultado(false);
                break;

            case R.id.bt3:
                conta.setText(conta.getText().toString() + tres.getText().toString());
                calculaResultado(false);
                break;

            case R.id.bt4:
                conta.setText(conta.getText().toString() + quatro.getText().toString());
                calculaResultado(false);
                break;

            case R.id.bt5:
                conta.setText(conta.getText().toString() + cinco.getText().toString());
                calculaResultado(false);
                break;

            case R.id.bt6:
                conta.setText(conta.getText().toString() + seis.getText().toString());
                calculaResultado(false);
                break;

            case R.id.bt7:
                conta.setText(conta.getText().toString() + sete.getText().toString());
                calculaResultado(false);
                break;

            case R.id.bt8:
                conta.setText(conta.getText().toString() + oito.getText().toString());
                calculaResultado(false);
                break;

            case R.id.bt9:
                conta.setText(conta.getText().toString() + nove.getText().toString());
                calculaResultado(false);
                break;

            case R.id.btPonto:
                // nao permite a repeticao da operacao
                if(conta.getText().toString().equals(ponto.getText().toString())) {
                    break;
                }else {
                    conta.setText(conta.getText().toString() + ponto.getText().toString());
                    calculaResultado(false);
                    break;
                }

            case R.id.btDiv:
                // so permite a operacao caso ja tenha sido digitado algum numero
                if(!conta.getText().toString().isEmpty()) {
                    conta.setText(conta.getText().toString() + div.getText().toString());
                    calculaResultado(false);
                }
                break;

            case R.id.btMul:
                // so permite a operacao caso ja tenha sido digitado algum numero
                if(!conta.getText().toString().isEmpty()) {
                    conta.setText(conta.getText().toString() + mul.getText().toString());
                    calculaResultado(false);
                }
                break;

            case R.id.btSub:
                // nao permite a repeticao da operacao
                if(conta.getText().toString().equals(sub.getText().toString())) {
                    break;
                }else{
                    conta.setText(conta.getText().toString() + sub.getText().toString());
                    calculaResultado(false);
                    break;
                }

            case R.id.btSom:
                // so permite a operacao caso ja tenha sido digitado algum numero
                if(!conta.getText().toString().isEmpty()) {
                    conta.setText(conta.getText().toString() + som.getText().toString());
                    calculaResultado(false);
                }
                break;

            case R.id.btIgual:
                calculaResultado(true);
                break;

            case R.id.btLimpar:
                if(!conta.getText().toString().trim().isEmpty()) {
                    conta.setText(conta.getText().toString().substring(0, conta.getText().toString().length() - 1));
                    calculaResultado(false);
                    if(conta.getText().toString().trim().isEmpty()) {
                        resultado.setText("");
                    }
                }else
                {
                    conta.setText("");
                    resultado.setText("");
                }
                break;

            case R.id.btAbrePar:
                conta.setText(conta.getText().toString() + abrePar.getText().toString());
                calculaResultado(false);
                break;

            case R.id.btFechaPar:
                conta.setText(conta.getText().toString() + fechaPar.getText().toString());
                calculaResultado(false);
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        conta.setText("");
        resultado.setText("");
        return true;
    }

    public void calculaResultado(boolean igual){
        String formula = conta.getText().toString();
        try {
            Expression exp = new Expression(formula);
            String result = String.valueOf(exp.resolve());
            if(String.valueOf(result) != conta.getText().toString())
                if (igual) {
                    resultado.setText("");
                    conta.setText(result);
                } else {
                    resultado.setText(result);
                }
        }catch(Exception e){
            if(igual){
                resultado.setText("Erro");
            }
        }
    }

}
