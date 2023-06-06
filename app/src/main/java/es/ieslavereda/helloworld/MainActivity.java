package es.ieslavereda.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private Button buttonClear, buttonPlus, buttonMinus, buttonMultiply, buttonDividir,buttonEquals,buttonAns, buttonPoint;
    private CheckBox opciones;
    private RadioButton division, multi, suma, resta;
    private double ans;
    private RadioGroup radioGroup;

    private double operando;
    private Operador operador;
    private boolean checkedCB=false;
    private boolean comma=false;

    private boolean[] checkedArr = new boolean[4];


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
        buttonAns = findViewById(R.id.buttonAns);
        opciones = findViewById(R.id.Opciones);
        suma=findViewById(R.id.suma);
        resta=findViewById(R.id.resta);
        division=findViewById(R.id.division);
        multi=findViewById(R.id.multi);
        buttonPoint=findViewById(R.id.buttonPoint);
        radioGroup=findViewById(R.id.operaciones);

        buttonClear.setOnClickListener(view -> display.setText("0"));

        buttonPlus.setOnClickListener(view -> {
            if (checkedArr[0]==false){
            operando = Double.parseDouble(display.getText().toString());
            operador = Operador.SUMA;
            display.setText("0");
                comma=false;}

        });
        buttonMinus.setOnClickListener(view -> {
            if (checkedArr[1]==false){
            operando = Double.parseDouble(display.getText().toString());
            operador = Operador.RESTA;
            display.setText("0");
                comma=false;
            }

        });
        buttonMultiply.setOnClickListener(view -> {
            if (checkedArr[2]==false) {
                operando = Double.parseDouble(display.getText().toString());
                operador = Operador.MULTIPLICACION;
                display.setText("0");
                comma=false;
            }

        });
        buttonDividir.setOnClickListener(view -> {
            if (checkedArr[3]==false){
            operando = Double.parseDouble(display.getText().toString());
            operador = Operador.DIVISION;
            display.setText("0");
                comma=false;
            }

        });

        buttonAns.setOnClickListener(view -> {
           display.setText(String.valueOf(ans));
            comma=false;
        });

        buttonPoint.setOnClickListener(view -> {
            if (comma==false){
                display.setText(display.getText().toString()+".");
                comma=true;
            }
        });

        buttonEquals.setOnClickListener(view -> {
            Double resultado=0.0;
            if (operador == Operador.SUMA){
                resultado = operando +
                        Double.parseDouble(display.getText().toString());
            }
            if (operador == Operador.RESTA){
                 resultado = operando -
                        Double.parseDouble(display.getText().toString());

            }
            if (operador == Operador.MULTIPLICACION){
                resultado = operando *
                        Double.parseDouble(display.getText().toString());

            }
            if (operador == Operador.DIVISION){

                 resultado = operando /
                        Double.parseDouble(display.getText().toString());

            }

            if (resultado == Math.floor(resultado)) {
                int resultadoInt = resultado.intValue();
                display.setText(resultadoInt+"");
                comma=false;
            } else {
                display.setText(resultado.toString());
            }
            ans=Double.parseDouble(display.getText().toString());
        });


    }
    public void cheked(View view){
        checkedCB=!checkedCB;
        if (checkedCB==false){
            radioGroup.setVisibility(View.INVISIBLE);
            radioGroup.clearCheck();
            for (int i=0;checkedArr.length>i; i++){
                checkedArr[i]=false;
            }
        }else {
            radioGroup.setVisibility(View.VISIBLE);
        }
    }


    public void onClick(View view){

        if (view.getId()==suma.getId()||view.getId()==resta.getId()||view.getId()==multi.getId()||view.getId()==division.getId()){
            if (view.getId()==suma.getId()){
                checkedArr[0]=true;
            }else {
                checkedArr[0]=false;
            }

            if (view.getId()==resta.getId()){
                checkedArr[1]=true;
            }else {
                checkedArr[1]=false;
            }

            if (view.getId()==multi.getId()){
                checkedArr[2]=true;
            }else {
                checkedArr[2]=false;
            }

            if (view.getId()==division.getId()){
                checkedArr[3]=true;
            }else {
                checkedArr[3]=false;
            }
        }else {

            if (display.getText().equals("0")) {
                display.setText(((Button) view).getText());
            } else {
                display.setText(display.getText().toString() + ((Button) view).getText());
            }
        }

    }

}