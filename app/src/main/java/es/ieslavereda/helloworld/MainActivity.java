package es.ieslavereda.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private Button buttonClear;
    private Button buttonPlus;
    private  Button buttonMinus;
    private  Button buttonMultiply;
    private Button buttonDividir;
    private Button buttonEquals;
    private double operando;
    private Operador operador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        buttonClear = findViewById(R.id.buttonClear);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDividir = findViewById(R.id.buttonDivide);

        buttonClear.setOnClickListener(view -> display.setText("0"));
        buttonPlus.setOnClickListener(view -> {
            operando = Double.parseDouble(display.getText().toString());
            operador = Operador.SUMA;
            display.setText("0");

        });
        buttonMinus.setOnClickListener(view -> {
            operando = Double.parseDouble(display.getText().toString());
            operador = Operador.RESTA;
            display.setText("0");

        });
        buttonMultiply.setOnClickListener(view -> {
            operando = Double.parseDouble(display.getText().toString());
            operador = Operador.MULTIPLICACION;
            display.setText("0");

        });
        buttonDividir.setOnClickListener(view -> {
            operando = Double.parseDouble(display.getText().toString());
            operador = Operador.DIVISION;
            display.setText("0");

        });

        buttonEquals.setOnClickListener(view -> {
            if (operador == Operador.SUMA){
                Double resultado = operando +
                        Double.parseDouble(display.getText().toString());
                display.setText(resultado.toString());
            }
            if (operador == Operador.RESTA){
                Double resultado = operando -
                        Double.parseDouble(display.getText().toString());
                display.setText(resultado.toString());
            }
            if (operador == Operador.MULTIPLICACION){
                Double resultado = operando *
                        Double.parseDouble(display.getText().toString());
                display.setText(resultado.toString());
            }
            if (operador == Operador.DIVISION){
                Double resultado = operando /
                        Double.parseDouble(display.getText().toString());
                display.setText(resultado.toString());
            }
        });
    }



    public void onClick(View view){
        if (display.getText().equals("0")){
            display.setText(((Button) view).getText());
        }else {
            display.setText(display.getText().toString()+((Button) view).getText());
        }
    }

}