package my_application.java.converter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView output;
    private TextView unit1;
    private TextView unit2;
    private Spinner unitsMenu1;
    private Spinner unitsMenu2;
    private float inches;
    private float feet;
    private float metre;
    private float mm;
    private float cm;
    private final String first_value="Feet";
    private final String second_value="Inches";
    private final String third_value="Metre";
    private final String fourth_value="Millimetre";
    private final String fifth_value="Centimetre";
    private int spinnerPosition1;
    private int spinnerPosition2;
    private long pressedTime;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        TextView border1;
        Button Swap;

        input=findViewById(R.id.input);
        output=findViewById(R.id.output);
        Swap=findViewById(R.id.Swap);
        unit1=findViewById(R.id.unit1);
        unit2=findViewById(R.id.unit2);
        unitsMenu1=findViewById(R.id.unitsMenu1);
        unitsMenu2=findViewById(R.id.unitsMenu2);
        border1=findViewById(R.id.border1);

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        unitsMenu1.setAdapter(adapter);
        unitsMenu2.setAdapter(adapter);

        ArrayAdapter<CharSequence>adapter1=ArrayAdapter.createFromResource(this,R.array.units1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence>adapter2=ArrayAdapter.createFromResource(this,R.array.units2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence>adapter3=ArrayAdapter.createFromResource(this,R.array.units3, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence>adapter4=ArrayAdapter.createFromResource(this,R.array.units4, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence>adapter5=ArrayAdapter.createFromResource(this,R.array.units5, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_item);




        spinnerPosition1=adapter.getPosition(first_value);  //First set value to 'feet'
        unitsMenu1.setSelection(spinnerPosition1);


        TextWatcher watcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String value1=unitsMenu1.getSelectedItem().toString();
                String value2=unitsMenu2.getSelectedItem().toString();

                if(value1.equals("Feet") && value2.equals("Inches")){
                    if(!isEmpty(input)) {
                        feet = Float.parseFloat(input.getText().toString());
                        inches = feet * 12;
                        output.setText("" + inches);
                        unit1.setText(" Feet ");
                        unit2.setText("Inches");
                        inches = 0;
                    }
                }else if(value1.equals("Inches") && value2.equals("Feet")){
                    if(!isEmpty(input)) {
                        inches = Float.parseFloat(input.getText().toString());
                        feet = inches / 12;
                        output.setText("" + feet);
                        unit1.setText("Inches");
                        unit2.setText(" Feet ");
                        feet = 0;
                    }
                }else if(value1.equals("Feet") && value2.equals("Metre")){
                    if(!isEmpty(input)) {
                        feet = Float.parseFloat(input.getText().toString());
                        metre = (float) (feet / 3.281);
                        output.setText("" + metre);
                        unit1.setText(" Feet ");
                        unit2.setText("Metre");
                        metre = 0;
                    }
                }else if(value1.equals("Metre") && value2.equals("Feet")){
                    if(!isEmpty(input)) {
                        metre = Float.parseFloat(input.getText().toString());
                        feet = (float) (metre * 3.281);
                        output.setText("" + feet);
                        unit1.setText("Metre");
                        unit2.setText(" Feet ");
                        feet = 0;
                    }
                }else if(value1.equals("Feet") && value2.equals("Millimetre")){
                    if(!isEmpty(input)) {
                        feet = Float.parseFloat(input.getText().toString());
                        mm = (float) (feet * 304.8);
                        output.setText(""+mm);
                        unit1.setText(" Feet ");
                        unit2.setText("Mm");
                        mm = 0;
                    }
                }else if(value1.equals("Millimetre") && value2.equals("Feet")){
                    if(!isEmpty(input)) {
                        mm = Float.parseFloat(input.getText().toString());
                        feet = (float) (mm / 304.8);
                        output.setText("" + feet);
                        unit1.setText("Mm");
                        unit2.setText(" Feet ");
                        feet = 0;
                    }
                }else if(value1.equals("Inches") && value2.equals("Metre")){
                    if(!isEmpty(input)) {
                        inches = Float.parseFloat(input.getText().toString());
                        metre = (float) (inches / 39.37);
                        output.setText("" + metre);
                        unit1.setText("Inches");
                        unit2.setText("Metre");
                        metre = 0;
                    }
                }else if(value1.equals("Metre") && value2.equals("Inches")){
                    if(!isEmpty(input)) {
                        metre = Float.parseFloat(input.getText().toString());
                        inches = (float) (metre * 39.37);
                        output.setText("" + inches);
                        unit1.setText("Metre");
                        unit2.setText("Inches");
                        inches= 0;
                    }
                }else if(value1.equals("Inches") && value2.equals("Millimetre")){
                    if(!isEmpty(input)) {
                        inches = Float.parseFloat(input.getText().toString());
                        mm = (float) (inches * 25.4);
                        output.setText("" + mm);
                        unit1.setText("Inches");
                        unit2.setText("Mm");
                        mm = 0;
                    }
                }else if(value1.equals("Millimetre") && value2.equals("Inches")){
                    if(!isEmpty(input)) {
                        mm = Float.parseFloat(input.getText().toString());
                        inches = (float) (mm / 25.4);
                        output.setText("" + inches);
                        unit1.setText("Mm");
                        unit2.setText("Inches");
                        inches = 0;
                    }
                }else if(value1.equals("Millimetre") && value2.equals("Metre")){
                    if(!isEmpty(input)) {
                        mm = Float.parseFloat(input.getText().toString());
                        metre = (mm / 1000);
                        output.setText("" + metre);
                        unit1.setText("Mm");
                        unit2.setText("Metre");
                        metre = 0;
                    }
                }else if(value1.equals("Metre") && value2.equals("Millimetre")){
                    if(!isEmpty(input)) {
                        metre = Float.parseFloat(input.getText().toString());
                        mm = (metre * 1000);
                        output.setText("" + mm);
                        unit1.setText("Metre");
                        unit2.setText("Mm");
                        mm = 0;
                    }
                }else if(value1.equals("Feet") && value2.equals("Centimetre")){
                    if(!isEmpty(input)) {
                        feet = Float.parseFloat(input.getText().toString());
                        cm = (float) (feet * 30.48);
                        output.setText("" + cm);
                        unit1.setText(" Feet ");
                        unit2.setText("Cm");
                        cm = 0;
                    }
                }else if(value1.equals("Centimetre") && value2.equals("Feet")){
                    if(!isEmpty(input)) {
                        cm = Float.parseFloat(input.getText().toString());
                        feet = (float) (cm / 30.48);
                        output.setText("" + feet);
                        unit1.setText("Cm");
                        unit2.setText(" Feet ");
                        feet = 0;
                    }
                }else if(value1.equals("Inches") && value2.equals("Centimetre")){
                    if(!isEmpty(input)) {
                        inches = Float.parseFloat(input.getText().toString());
                        cm = (float) (inches * 2.54);
                        output.setText("" + cm);
                        unit1.setText("Inches");
                        unit2.setText("Cm");
                        cm = 0;
                    }
                }else if(value1.equals("Centimetre") && value2.equals("Inches")){
                    if(!isEmpty(input)) {
                        cm = Float.parseFloat(input.getText().toString());
                        inches = (float) (cm / 2.54);
                        output.setText("" + inches);
                        unit1.setText("Cm");
                        unit2.setText("Inches");
                        inches = 0;
                    }
                }else if(value1.equals("Metre") && value2.equals("Centimetre")){
                    if(!isEmpty(input)) {
                        metre = Float.parseFloat(input.getText().toString());
                        cm = metre * 100;
                        output.setText("" + cm);
                        unit1.setText("Metre");
                        unit2.setText("Cm");
                        cm = 0;
                    }
                }else if(value1.equals("Centimetre") && value2.equals("Metre")){
                    if(!isEmpty(input)) {
                        cm = Float.parseFloat(input.getText().toString());
                        metre = cm / 100;
                        output.setText("" + metre);
                        unit1.setText("Cm");
                        unit2.setText("Metre");
                        metre = 0;
                    }
                }else if(value1.equals("Millimetre") && value2.equals("Centimetre")){
                    if(!isEmpty(input)) {
                        mm = Float.parseFloat(input.getText().toString());
                        cm = mm / 10;
                        output.setText("" + cm);
                        unit1.setText("Mm");
                        unit2.setText("Cm");
                        cm = 0;
                    }
                }else if(value1.equals("Centimetre") && value2.equals("Millimetre")){
                    if(!isEmpty(input)) {
                        cm = Float.parseFloat(input.getText().toString());
                        mm = cm * 10;
                        output.setText("" + mm);
                        unit1.setText("Cm");
                        unit2.setText("Mm");
                        mm = 0;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(isEmpty(input)){
                    output.setText(null);
                }

            }
        };

        input.addTextChangedListener(watcher);


        unitsMenu1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String value1=unitsMenu1.getSelectedItem().toString();
                String value2=unitsMenu2.getSelectedItem().toString();

                switch(value1){
                    case "Feet":
                        unitsMenu2.setAdapter(adapter1);
                        spinnerPosition1=adapter1.getPosition(value2);
                        unitsMenu2.setSelection(spinnerPosition1);
                        break;
                    case "Inches":
                        unitsMenu2.setAdapter(adapter2);
                        spinnerPosition1=adapter2.getPosition(value2);
                        unitsMenu2.setSelection(spinnerPosition1);
                        break;
                    case "Metre":
                        unitsMenu2.setAdapter(adapter3);
                        spinnerPosition1=adapter3.getPosition(value2);
                        unitsMenu2.setSelection(spinnerPosition1);
                        break;
                    case "Millimetre":
                        unitsMenu2.setAdapter(adapter4);
                        spinnerPosition1=adapter4.getPosition(value2);
                        unitsMenu2.setSelection(spinnerPosition1);
                        break;
                    case "Centimetre":
                        unitsMenu2.setAdapter(adapter5);
                        spinnerPosition1=adapter5.getPosition(value2);
                        unitsMenu2.setSelection(spinnerPosition1);
                }

                if(value1.equals("Feet") && !(value2.equals("Feet"))){
                    input.setHint("1 ft");

                    switch (value2){
                        case "Inches":
                            output.setHint("12\"");
                            break;
                        case "Metre":
                            output.setHint("0.3048 m");
                            break;
                        case "Millimetre":
                            output.setHint("304.8 mm");
                            break;
                        case "Centimetre":
                            output.setHint("30.48 cm");
                            break;
                    }

                    unit1.setText(" Feet ");

                    if(!isEmpty(input)) {
                        switch (value2){
                            case "Inches":
                                feet = Float.parseFloat(input.getText().toString());
                                inches = feet * 12;
                                output.setText("" + inches);
                                inches = 0;
                                break;
                            case "Metre":
                                feet = Float.parseFloat(input.getText().toString());
                                metre = (float) (feet / 3.281);
                                output.setText("" + metre);
                                metre = 0;
                                break;
                            case "Millimetre":
                                feet = Float.parseFloat(input.getText().toString());
                                mm = (float) (feet * 304.8);
                                output.setText("" + mm);
                                mm = 0;
                                break;
                            case "Centimetre":
                                feet = Float.parseFloat(input.getText().toString());
                                cm = (float) (feet * 30.48);
                                output.setText("" + cm);
                                cm = 0;
                                break;
                        }
                    }

                }else if(value1.equals("Inches") && !(value2.equals("Inches"))){
                    input.setHint("1\"");

                    switch (value2){
                        case "Feet":
                            output.setHint("0.08333 ft");
                            break;
                        case "Metre":
                            output.setHint("0.0254 m");
                            break;
                        case "Millimetre":
                            output.setHint("25.4 mm");
                            break;
                        case "Centimetre":
                            output.setHint("2.54 cm");
                            break;
                    }

                    unit1.setText("Inches");

                    if(!isEmpty(input)) {
                        switch (value2){
                            case "Feet":
                                inches = Float.parseFloat(input.getText().toString());
                                feet = inches / 12;
                                output.setText("" + feet);
                                feet = 0;
                                break;
                            case "Metre":
                                inches = Float.parseFloat(input.getText().toString());
                                metre = (float) (inches / 39.37);
                                output.setText("" + metre);
                                metre = 0;
                                break;
                            case "Millimetre":
                                inches = Float.parseFloat(input.getText().toString());
                                mm = (float) (inches * 25.4);
                                output.setText("" + mm);
                                mm = 0;
                                break;
                            case "Centimetre":
                                inches = Float.parseFloat(input.getText().toString());
                                cm = (float) (inches * 2.54);
                                output.setText("" + cm);
                                cm = 0;
                                break;
                        }
                    }

                }else if(value1.equals("Metre") && !(value2.equals("Metre"))){
                    input.setHint("1 m");

                    switch (value2){
                        case "Feet":
                            output.setHint("3.28084 ft");
                            break;
                        case "Inches":
                            output.setHint("39.3701\"");
                            break;
                        case "Millimetre":
                            output.setHint("1000 mm");
                            break;
                        case "Centimetre":
                            output.setHint("100 cm");
                            break;
                    }

                    unit1.setText("Metre");

                    if(!isEmpty(input)) {
                        switch (value2){
                            case "Feet":
                                metre = Float.parseFloat(input.getText().toString());
                                feet = (float) (metre * 3.281);
                                output.setText(""+feet);
                                feet = 0;
                                break;
                            case "Inches":
                                metre = Float.parseFloat(input.getText().toString());
                                inches = (float) (metre * 39.37);
                                output.setText("" + inches);
                                inches = 0;
                                break;
                            case "Millimetre":
                                metre = Float.parseFloat(input.getText().toString());
                                mm = (metre * 1000);
                                output.setText("" + mm);
                                mm = 0;
                                break;
                            case "Centimetre":
                                metre = Float.parseFloat(input.getText().toString());
                                cm = (metre * 100);
                                output.setText("" + cm);
                                cm = 0;
                                break;
                        }
                    }

                }else if(value1.equals("Millimetre") && !(value2.equals("Millimetre"))){
                    input.setHint("1 mm");

                    switch (value2){
                        case "Feet":
                            output.setHint("0.003281 ft");
                            break;
                        case "Inches":
                            output.setHint("0.03937\"");
                            break;
                        case "Metre":
                            output.setHint("0.001 m");
                            break;
                        case "Centimetre":
                            output.setHint("0.1 cm");
                            break;
                    }

                    unit1.setText("Mm");

                    if(!isEmpty(input)) {
                        switch (value2){
                            case "Feet":
                                mm = Float.parseFloat(input.getText().toString());
                                feet = (float) (mm / 304.8);
                                output.setText("" + feet);
                                feet = 0;
                                break;
                            case "Inches":
                                mm = Float.parseFloat(input.getText().toString());
                                inches = (float) (mm / 25.4);
                                output.setText("" + inches);
                                inches = 0;
                                break;
                            case "Metre":
                                mm = Float.parseFloat(input.getText().toString());
                                metre = (mm / 1000);
                                output.setText("" + metre);
                                metre = 0;
                                break;
                            case "Centimetre":
                                mm = Float.parseFloat(input.getText().toString());
                                cm = (mm / 10);
                                output.setText("" + cm);
                                cm = 0;
                                break;
                        }
                    }

                }else if(value1.equals("Centimetre") && !(value2.equals("Centimetre"))){
                    input.setHint("1 cm");

                    switch (value2){
                        case "Feet":
                            output.setHint("0.03281 ft");
                            break;
                        case "Inches":
                            output.setHint("0.393701\"");
                            break;
                        case "Metre":
                            output.setHint("0.01 m");
                            break;
                        case "Millimetre":
                            output.setHint("10 mm");
                            break;
                    }

                    unit1.setText("Cm");

                    if(!isEmpty(input)) {
                        switch (value2){
                            case "Feet":
                                cm = Float.parseFloat(input.getText().toString());
                                feet = (float) (cm / 30.48);
                                output.setText("" + feet);
                                feet = 0;
                                break;
                            case "Inches":
                                cm = Float.parseFloat(input.getText().toString());
                                inches = (float) (cm / 2.54);
                                output.setText("" + inches);
                                inches = 0;
                                break;
                            case "Metre":
                                cm = Float.parseFloat(input.getText().toString());
                                metre = (cm / 100);
                                output.setText("" + metre);
                                metre = 0;
                                break;
                            case "Millimetre":
                                cm = Float.parseFloat(input.getText().toString());
                                mm = (cm * 10);
                                output.setText("" + mm);
                                mm = 0;
                                break;
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        unitsMenu2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value1=unitsMenu1.getSelectedItem().toString();
                String value2=unitsMenu2.getSelectedItem().toString();

                switch(value2){
                    case "Feet":
                        unitsMenu1.setAdapter(adapter1);
                        spinnerPosition1=adapter1.getPosition(value1);
                        unitsMenu1.setSelection(spinnerPosition1);
                        break;
                    case "Inches":
                        unitsMenu1.setAdapter(adapter2);
                        spinnerPosition1=adapter2.getPosition(value1);
                        unitsMenu1.setSelection(spinnerPosition1);
                        break;
                    case "Metre":
                        unitsMenu1.setAdapter(adapter3);
                        spinnerPosition1=adapter3.getPosition(value1);
                        unitsMenu1.setSelection(spinnerPosition1);
                        break;
                    case "Millimetre":
                        unitsMenu1.setAdapter(adapter4);
                        spinnerPosition1=adapter4.getPosition(value1);
                        unitsMenu1.setSelection(spinnerPosition1);
                        break;
                    case "Centimetre":
                        unitsMenu1.setAdapter(adapter5);
                        spinnerPosition1=adapter5.getPosition(value1);
                        unitsMenu1.setSelection(spinnerPosition1);
                        break;
                }

                if(value2.equals("Feet") && !(value1.equals("Feet"))){

                    switch (value1){
                        case "Inches":
                            output.setHint("0.08333 ft");
                            break;
                        case "Metre":
                            output.setHint("3.28084 ft");
                            break;
                        case "Millimetre":
                            output.setHint("0.003281 ft");
                            break;
                        case "Centimetre":
                            output.setHint("0.03281 ft");
                            break;
                    }

                    unit2.setText(" Feet ");

                    if(!isEmpty(input)) {
                        switch (value1){
                            case "Inches":
                                inches = Float.parseFloat(input.getText().toString());
                                feet = inches / 12;
                                output.setText("" + feet);
                                feet = 0;
                                break;
                            case "Metre":
                                metre = Float.parseFloat(input.getText().toString());
                                feet = (float) (metre * 3.281);
                                output.setText(""+feet);
                                feet = 0;
                                break;
                            case "Millimetre":
                                mm = Float.parseFloat(input.getText().toString());
                                feet = (float) (mm / 304.8);
                                output.setText("" + feet);
                                feet = 0;
                                break;
                            case "Centimetre":
                                cm = Float.parseFloat(input.getText().toString());
                                feet = (float) (cm / 30.48);
                                output.setText("" + feet);
                                feet = 0;
                                break;
                        }
                    }

                }else if(value2.equals("Inches") && !(value1.equals("Inches"))){

                    switch (value1){
                        case "Feet":
                            output.setHint("12\"");
                            break;
                        case "Metre":
                            output.setHint("39.3701\"");
                            break;
                        case "Millimetre":
                            output.setHint("0.03937\"");
                            break;
                        case "Centimetre":
                            output.setHint("0.393701\"");
                            break;
                    }

                    unit2.setText("Inches");

                    if(!isEmpty(input)) {
                        switch (value1){
                            case "Feet":
                                feet = Float.parseFloat(input.getText().toString());
                                inches = feet * 12;
                                output.setText("" + inches);
                                inches = 0;
                                break;
                            case "Metre":
                                metre = Float.parseFloat(input.getText().toString());
                                inches = (float) (metre * 39.37);
                                output.setText("" + inches);
                                inches = 0;
                                break;
                            case "Millimetre":
                                mm = Float.parseFloat(input.getText().toString());
                                inches = (float) (mm / 25.4);
                                output.setText("" + inches);
                                inches = 0;
                                break;
                            case "Centimetre":
                                cm = Float.parseFloat(input.getText().toString());
                                inches = (float) (cm / 2.54);
                                output.setText("" + inches);
                                inches = 0;
                                break;
                        }
                    }

                }else if(value2.equals("Metre") && !(value1.equals("Metre"))){

                    switch (value1){
                        case "Feet":
                            output.setHint("0.3048 m");
                            break;
                        case "Inches":
                            output.setHint("0.0254 m");
                            break;
                        case "Millimetre":
                            output.setHint("0.001 m");
                            break;
                        case "Centimetre":
                            output.setHint("0.01 m");
                            break;
                    }

                    unit2.setText("Metre");

                    if(!isEmpty(input)) {
                        switch (value1){
                            case "Feet":
                                feet = Float.parseFloat(input.getText().toString());
                                metre = (float) (feet / 3.281);
                                output.setText("" + metre);
                                metre = 0;
                                break;
                            case "Inches":
                                inches = Float.parseFloat(input.getText().toString());
                                metre = (float) (inches / 39.37);
                                output.setText("" + metre);
                                metre = 0;
                                break;
                            case "Millimetre":
                                mm = Float.parseFloat(input.getText().toString());
                                metre = (mm / 1000);
                                output.setText("" + metre);
                                metre = 0;
                                break;
                            case "Centimetre":
                                cm = Float.parseFloat(input.getText().toString());
                                metre = (cm / 100);
                                output.setText("" + metre);
                                metre = 0;
                                break;
                        }
                    }

                }else if(value2.equals("Millimetre") && !(value1.equals("Millimetre"))){

                    switch (value1){
                        case "Feet":
                            output.setHint("304.8 mm");
                            break;
                        case "Inches":
                            output.setHint("25.4 mm");
                            break;
                        case "Metre":
                            output.setHint("1000 mm");
                            break;
                        case "Centimetre":
                            output.setHint("10 mm");
                            break;
                    }

                    unit2.setText("Mm");

                    if(!isEmpty(input)) {
                        switch (value1){
                            case "Feet":
                                feet = Float.parseFloat(input.getText().toString());
                                mm = (float) (feet * 304.8);
                                output.setText("" + mm);
                                mm = 0;
                                break;
                            case "Inches":
                                inches = Float.parseFloat(input.getText().toString());
                                mm = (float) (inches * 25.4);
                                output.setText("" + mm);
                                mm = 0;
                                break;
                            case "Metre":
                                metre = Float.parseFloat(input.getText().toString());
                                mm = (metre * 1000);
                                output.setText("" + mm);
                                mm = 0;
                                break;
                            case "Centimetre":
                                cm = Float.parseFloat(input.getText().toString());
                                mm = (cm * 10);
                                output.setText("" + mm);
                                mm = 0;
                                break;
                        }
                    }

                }else if(value2.equals("Centimetre") && !(value1.equals("Centimetre"))){

                    switch (value1){
                        case "Feet":
                            output.setHint("30.48 cm");
                            break;
                        case "Inches":
                            output.setHint("2.54 cm");
                            break;
                        case "Metre":
                            output.setHint("100 cm");
                            break;
                        case "Millimetre":
                            output.setHint("0.1 cm");
                            break;
                    }

                    unit2.setText("Cm");

                    if(!isEmpty(input)) {
                        switch (value1){
                            case "Feet":
                                feet = Float.parseFloat(input.getText().toString());
                                cm = (float) (feet * 30.48);
                                output.setText("" + cm);
                                cm = 0;
                                break;
                            case "Inches":
                                inches = Float.parseFloat(input.getText().toString());
                                cm = (float) (inches * 2.54);
                                output.setText("" + cm);
                                cm = 0;
                                break;
                            case "Metre":
                                metre = Float.parseFloat(input.getText().toString());
                                cm = (metre * 100);
                                output.setText("" + cm);
                                cm = 0;
                                break;
                            case "Millimetre":
                                mm = Float.parseFloat(input.getText().toString());
                                cm = (mm / 10);
                                output.setText("" + cm);
                                cm = 0;
                                break;
                        }
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Swap.setOnClickListener(view -> {

            String value1=unitsMenu1.getSelectedItem().toString();
            String value2=unitsMenu2.getSelectedItem().toString();

            if(value1.equals("Feet") && value2.equals("Inches")) {
                input.setHint("1\"");
                output.setHint("0.08333 ft");
                unit1.setText("Inches");
                unit2.setText(" Feet ");
                spinnerPosition1 = adapter1.getPosition(value2);
                unitsMenu1.setAdapter(adapter1);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2 = adapter2.getPosition(value1);
                unitsMenu2.setAdapter(adapter2);
                unitsMenu2.setSelection(spinnerPosition2);

            }else if(value1.equals("Inches") && value2.equals("Feet")) {
                input.setHint("1 ft");
                output.setHint("12\"");
                unit1.setText(" Feet ");
                unit2.setText("Inches");
                spinnerPosition1 = adapter2.getPosition(first_value);
                unitsMenu1.setAdapter(adapter2);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2 = adapter1.getPosition(second_value);
                unitsMenu2.setAdapter(adapter1);
                unitsMenu2.setSelection(spinnerPosition2);

            }else if(value1.equals("Feet") && value2.equals("Metre")) {
                input.setHint("1 m");
                output.setHint("3.28084 ft");
                unit1.setText("Metre");
                unit2.setText(" Feet ");
                spinnerPosition1 = adapter1.getPosition(third_value);
                unitsMenu1.setAdapter(adapter1);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2 = adapter3.getPosition(first_value);
                unitsMenu2.setAdapter(adapter3);
                unitsMenu2.setSelection(spinnerPosition2);

            }else if(value1.equals("Metre") && value2.equals("Feet")) {
                input.setHint("1 ft");
                output.setHint("0.3048 m");
                unit1.setText(" Feet ");
                unit2.setText("Metre");
                spinnerPosition1 = adapter3.getPosition(first_value);
                unitsMenu1.setAdapter(adapter3);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2 = adapter1.getPosition(third_value);
                unitsMenu2.setAdapter(adapter1);
                unitsMenu2.setSelection(spinnerPosition2);

            }else if(value1.equals("Feet") && value2.equals("Millimetre")) {
                input.setHint("1 mm");
                output.setHint("0.003281 ft");
                unit1.setText("Mm");
                unit2.setText(" Feet ");
                spinnerPosition1 = adapter1.getPosition(fourth_value);
                unitsMenu1.setAdapter(adapter1);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2 = adapter4.getPosition(first_value);
                unitsMenu2.setAdapter(adapter4);
                unitsMenu2.setSelection(spinnerPosition2);

            }else if(value1.equals("Millimetre") && value2.equals("Feet")) {
                input.setHint("1 ft");
                output.setHint("304.8 mm");
                unit1.setText(" Feet ");
                unit2.setText("Mm");
                spinnerPosition1 = adapter4.getPosition(first_value);
                unitsMenu1.setAdapter(adapter4);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2 = adapter1.getPosition(fourth_value);
                unitsMenu2.setAdapter(adapter1);
                unitsMenu2.setSelection(spinnerPosition2);

            }else if(value1.equals("Inches") && value2.equals("Metre")) {
                input.setHint("1 m");
                output.setHint("39.3701\"");
                unit1.setText("Metre");
                unit2.setText("Inches");
                spinnerPosition1 = adapter2.getPosition(third_value);
                unitsMenu1.setAdapter(adapter2);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2 = adapter3.getPosition(second_value);
                unitsMenu2.setAdapter(adapter3);
                unitsMenu2.setSelection(spinnerPosition2);

            }else if(value1.equals("Metre") && value2.equals("Inches")) {
                input.setHint("1\"");
                output.setHint("0.0254 m");
                unit1.setText("Inches");
                unit2.setText("Metre");
                spinnerPosition1 = adapter3.getPosition(second_value);
                unitsMenu1.setAdapter(adapter3);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2 = adapter2.getPosition(third_value);
                unitsMenu2.setAdapter(adapter2);
                unitsMenu2.setSelection(spinnerPosition2);

            }else if(value1.equals("Inches") && value2.equals("Millimetre")) {
                input.setHint("1 mm");
                output.setHint("0.03937\"");
                unit1.setText("Mm");
                unit2.setText("Inches");
                spinnerPosition1 = adapter2.getPosition(fourth_value);
                unitsMenu1.setAdapter(adapter2);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2 = adapter4.getPosition(second_value);
                unitsMenu2.setAdapter(adapter4);
                unitsMenu2.setSelection(spinnerPosition2);

            }else if(value1.equals("Millimetre") && value2.equals("Inches")) {
                input.setHint("1\"");
                output.setHint("25.4 mm");
                unit1.setText("Inches");
                unit2.setText("Mm");
                spinnerPosition1 = adapter4.getPosition(second_value);
                unitsMenu1.setAdapter(adapter4);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2 = adapter2.getPosition(fourth_value);
                unitsMenu2.setAdapter(adapter2);
                unitsMenu2.setSelection(spinnerPosition2);

            }else if(value1.equals("Millimetre") && value2.equals("Metre")) {
                input.setHint("1 m");
                output.setHint("1000 mm");
                unit1.setText("Metre");
                unit2.setText("Mm");
                spinnerPosition1 = adapter4.getPosition(third_value);
                unitsMenu1.setAdapter(adapter4);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2 = adapter3.getPosition(fourth_value);
                unitsMenu2.setAdapter(adapter3);
                unitsMenu2.setSelection(spinnerPosition2);

            }else if(value1.equals("Metre") && value2.equals("Millimetre")){
                input.setHint("1 mm");
                output.setHint("0.001 m");
                unit1.setText("Mm");
                unit2.setText("Metre");
                spinnerPosition1=adapter3.getPosition(fourth_value);
                unitsMenu1.setAdapter(adapter3);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2=adapter4.getPosition(third_value);
                unitsMenu2.setAdapter(adapter4);
                unitsMenu2.setSelection(spinnerPosition2);
            }else if(value1.equals("Feet") && value2.equals("Centimetre")){
                input.setHint("1 cm");
                output.setHint("0.03281 ft");
                unit1.setText("Cm");
                unit2.setText(" Feet ");
                spinnerPosition1=adapter1.getPosition(fifth_value);
                unitsMenu1.setAdapter(adapter1);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2=adapter5.getPosition(first_value);
                unitsMenu2.setAdapter(adapter5);
                unitsMenu2.setSelection(spinnerPosition2);
            }else if(value1.equals("Centimetre") && value2.equals("Feet")){
                input.setHint("1 ft");
                output.setHint("30.48 cm");
                unit1.setText(" Feet ");
                unit2.setText("Cm");
                spinnerPosition1=adapter5.getPosition(first_value);
                unitsMenu1.setAdapter(adapter5);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2=adapter1.getPosition(fifth_value);
                unitsMenu2.setAdapter(adapter1);
                unitsMenu2.setSelection(spinnerPosition2);
            }else if(value1.equals("Inches") && value2.equals("Centimetre")){
                input.setHint("1 cm");
                output.setHint("0.393701\"");
                unit1.setText("Cm");
                unit2.setText("Inches");
                spinnerPosition1=adapter2.getPosition(fifth_value);
                unitsMenu1.setAdapter(adapter2);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2=adapter5.getPosition(second_value);
                unitsMenu2.setAdapter(adapter5);
                unitsMenu2.setSelection(spinnerPosition2);
            }else if(value1.equals("Centimetre") && value2.equals("Inches")){
                input.setHint("1\"");
                output.setHint("2.54 cm");
                unit1.setText("Inches");
                unit2.setText("Cm");
                spinnerPosition1=adapter5.getPosition(second_value);
                unitsMenu1.setAdapter(adapter5);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2=adapter2.getPosition(fifth_value);
                unitsMenu2.setAdapter(adapter2);
                unitsMenu2.setSelection(spinnerPosition2);
            }else if(value1.equals("Metre") && value2.equals("Centimetre")){
                input.setHint("1 cm");
                output.setHint("0.01 m");
                unit1.setText("Cm");
                unit2.setText("Metre");
                spinnerPosition1=adapter3.getPosition(fifth_value);
                unitsMenu1.setAdapter(adapter3);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2=adapter5.getPosition(third_value);
                unitsMenu2.setAdapter(adapter5);
                unitsMenu2.setSelection(spinnerPosition2);
            }else if(value1.equals("Centimetre") && value2.equals("Metre")){
                input.setHint("1 m");
                output.setHint("100 cm");
                unit1.setText("Metre");
                unit2.setText("Cm");
                spinnerPosition1=adapter5.getPosition(third_value);
                unitsMenu1.setAdapter(adapter5);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2=adapter3.getPosition(fifth_value);
                unitsMenu2.setAdapter(adapter3);
                unitsMenu2.setSelection(spinnerPosition2);
            }else if(value1.equals("Millimetre") && value2.equals("Centimetre")){
                input.setHint("1 cm");
                output.setHint("10 mm");
                unit1.setText("Cm");
                unit2.setText("Mm");
                spinnerPosition1=adapter4.getPosition(fifth_value);
                unitsMenu1.setAdapter(adapter4);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2=adapter5.getPosition(fourth_value);
                unitsMenu2.setAdapter(adapter5);
                unitsMenu2.setSelection(spinnerPosition2);
            }else if(value1.equals("Centimetre") && value2.equals("Millimetre")){
                input.setHint("1 mm");
                output.setHint("0.1 cm");
                unit1.setText("Mm");
                unit2.setText("Cm");
                spinnerPosition1=adapter5.getPosition(fourth_value);
                unitsMenu1.setAdapter(adapter5);
                unitsMenu1.setSelection(spinnerPosition1);
                spinnerPosition2=adapter4.getPosition(fifth_value);
                unitsMenu2.setAdapter(adapter4);
                unitsMenu2.setSelection(spinnerPosition2);
            }


            if(!isEmpty(input) && output.getText().toString().length()!=0){
                if(value1.equals("Feet") && value2.equals("Inches")) {
                    feet = Float.parseFloat(input.getText().toString());
                    inches = feet * 12;
                    output.setText("" + feet);
                    input.setText(""+inches);
                    inches = 0;
                }else if(value1.equals("Inches") && value2.equals("Feet")) {
                    inches = Float.parseFloat(input.getText().toString());
                    feet = inches / 12;
                    output.setText("" + inches);
                    input.setText(""+feet);
                    feet = 0;
                }else if(value1.equals("Feet") && value2.equals("Metre")) {
                    feet = Float.parseFloat(input.getText().toString());
                    metre = (float) (feet / 3.281);
                    output.setText("" + feet);
                    input.setText(""+metre);
                    metre = 0;
                }else if(value1.equals("Metre") && value2.equals("Feet")) {
                    metre = Float.parseFloat(input.getText().toString());
                    feet = (float) (metre * 3.281);
                    output.setText(""+metre);
                    input.setText("" + feet);
                    feet = 0;
                }else if(value1.equals("Feet") && value2.equals("Millimetre")) {
                    feet = Float.parseFloat(input.getText().toString());
                    mm = (float) (feet * 304.8);
                    output.setText("" + feet);
                    input.setText(""+mm);
                    mm = 0;
                }else if(value1.equals("Millimetre") && value2.equals("Feet")) {
                    mm = Float.parseFloat(input.getText().toString());
                    feet = (float) (mm / 304.8);
                    output.setText("" + mm);
                    input.setText(""+feet);
                    feet = 0;
                }else if(value1.equals("Inches") && value2.equals("Metre")) {
                    inches = Float.parseFloat(input.getText().toString());
                    metre = (float) (inches / 39.37);
                    output.setText("" + inches);
                    input.setText(""+metre);
                    metre = 0;
                }else if(value1.equals("Metre") && value2.equals("Inches")) {
                    metre = Float.parseFloat(input.getText().toString());
                    inches = (float) (metre * 39.37);
                    output.setText("" + metre);
                    input.setText(""+inches);
                    inches = 0;
                }else if(value1.equals("Inches") && value2.equals("Millimetre")) {
                    inches = Float.parseFloat(input.getText().toString());
                    mm = (float) (inches * 25.4);
                    output.setText("" + inches);
                    input.setText(""+mm);
                    mm = 0;
                }else if(value1.equals("Millimetre") && value2.equals("Inches")) {
                    mm = Float.parseFloat(input.getText().toString());
                    inches = (float) (mm / 25.4);
                    output.setText("" + mm);
                    input.setText(""+inches);
                    inches = 0;
                }else if(value1.equals("Millimetre") && value2.equals("Metre")) {
                    mm = Float.parseFloat(input.getText().toString());
                    metre = (mm / 1000);
                    output.setText("" + mm);
                    input.setText(""+metre);
                    metre = 0;
                }else if(value1.equals("Metre") && value2.equals("Millimetre")) {
                    metre = Float.parseFloat(input.getText().toString());
                    mm = (metre * 1000);
                    output.setText("" + metre);
                    input.setText(""+mm);
                    mm = 0;
                }else if(value1.equals("Feet") && value2.equals("Centimetre")) {
                    feet = Float.parseFloat(input.getText().toString());
                    cm = (float) (feet * 30.48);
                    output.setText("" + feet);
                    input.setText(""+cm);
                    cm = 0;
                }else if(value1.equals("Centimetre") && value2.equals("Feet")) {
                    cm = Float.parseFloat(input.getText().toString());
                    feet = (float) (cm / 30.48);
                    output.setText("" + cm);
                    input.setText(""+feet);
                    feet = 0;
                }else if(value1.equals("Inches") && value2.equals("Centimetre")) {
                    inches = Float.parseFloat(input.getText().toString());
                    cm = (float) (inches * 2.54);
                    output.setText("" + inches);
                    input.setText(""+cm);
                    cm = 0;
                }else if(value1.equals("Centimetre") && value2.equals("Inches")) {
                    cm = Float.parseFloat(input.getText().toString());
                    inches = (float) (cm / 2.54);
                    output.setText("" + cm);
                    input.setText(""+inches);
                    inches = 0;
                }else if(value1.equals("Metre") && value2.equals("Centimetre")) {
                    metre = Float.parseFloat(input.getText().toString());
                    cm = metre * 100;
                    output.setText("" + metre);
                    input.setText(""+cm);
                    cm = 0;
                }else if(value1.equals("Centimetre") && value2.equals("Metre")) {
                    cm = Float.parseFloat(input.getText().toString());
                    metre = cm / 100;
                    output.setText("" + cm);
                    input.setText(""+metre);
                    metre = 0;
                }else if(value1.equals("Millimetre") && value2.equals("Centimetre")) {
                    mm = Float.parseFloat(input.getText().toString());
                    cm = mm / 10;
                    output.setText("" + mm);
                    input.setText(""+cm);
                    cm = 0;
                }else if(value1.equals("Centimetre") && value2.equals("Millimetre")) {
                    cm = Float.parseFloat(input.getText().toString());
                    mm = cm * 10;
                    output.setText("" + cm);
                    input.setText(""+mm);
                    mm = 0;
                }


            }

            input.setSelection(input.getText().length());
        });





        input.setOnClickListener(view -> {

            String value1=unitsMenu1.getSelectedItem().toString();

            switch (value1){
                case "Feet":
                    Toast.makeText(MainActivity.this, "Type a value in feet", Toast.LENGTH_SHORT).show();
                    break;
                case "Inches":
                    Toast.makeText(MainActivity.this, "Type a value in inches", Toast.LENGTH_SHORT).show();
                    break;
                case "Metre":
                    Toast.makeText(MainActivity.this, "Type a value in metres", Toast.LENGTH_SHORT).show();
                    break;
                case "Millimetre":
                    Toast.makeText(MainActivity.this, "Type a value in millimetres", Toast.LENGTH_SHORT).show();
                    break;
                case "Centimetre":
                    Toast.makeText(MainActivity.this, "Type a value in centimetres", Toast.LENGTH_SHORT).show();
                    break;
            }
        });

        output.setOnClickListener(view -> {
            String value2=unitsMenu2.getSelectedItem().toString();

            switch (value2){
                case "Feet":
                    Toast.makeText(MainActivity.this, "Feet", Toast.LENGTH_SHORT).show();
                    break;
                case "Inches":
                    Toast.makeText(MainActivity.this, "Inches", Toast.LENGTH_SHORT).show();
                    break;
                case "Metre":
                    Toast.makeText(MainActivity.this, "Metres", Toast.LENGTH_SHORT).show();
                    break;
                case "Millimetre":
                    Toast.makeText(MainActivity.this, "Millimetres", Toast.LENGTH_SHORT).show();
                    break;
                case "Centimetre":
                    Toast.makeText(MainActivity.this, "Centimetres", Toast.LENGTH_SHORT).show();
                    break;
            }
        });

        border1.setOnClickListener(view -> {
            String value2=unitsMenu2.getSelectedItem().toString();

            switch (value2){
                case "Feet":
                    Toast.makeText(MainActivity.this, "Feet", Toast.LENGTH_SHORT).show();
                    break;
                case "Inches":
                    Toast.makeText(MainActivity.this, "Inches", Toast.LENGTH_SHORT).show();
                    break;
                case "Metre":
                    Toast.makeText(MainActivity.this, "Metres", Toast.LENGTH_SHORT).show();
                    break;
                case "Millimetre":
                    Toast.makeText(MainActivity.this, "Millimetres", Toast.LENGTH_SHORT).show();
                    break;
                case "Centimetre":
                    Toast.makeText(MainActivity.this, "Centimetres", Toast.LENGTH_SHORT).show();
                    break;
            }
        });

    }

    @Override
    public void onBackPressed(){
        if(pressedTime+2000>System.currentTimeMillis()){
            super.onBackPressed();
            finish();
        }else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime=System.currentTimeMillis();
    }

    private boolean isEmpty(EditText edtTxt){
        return edtTxt.getText().toString().trim().length() == 0;
    }
}

/*
    public static void hideSpinnerDropDown(Spinner spinner){
        try{
            Method method=Spinner.class.getDeclaredMethod("onDetachedFromWindow");
            method.setAccessible(true);
            method.invoke(spinner);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getCount(){
        return first_value.length();
    }
*/

//output.setPaintFlags(output.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

/*
*   int pos1,pos2,pos3,pos4;
*
*
* pos1=adapter.getPosition(first_value);
        pos2=adapter.getPosition(second_value);
        pos3=adapter.getPosition(third_value);
        pos4=adapter.getPosition(fourth_value);

        if(unitsMenu1.getSelectedItemPosition()==pos1){
            F_I_M_mm=0;
        }else if(unitsMenu1.getSelectedItemPosition()==pos2){
            F_I_M_mm=1;
        }else if(unitsMenu1.getSelectedItemPosition()==pos3){
            F_I_M_mm=2;
        }else if(unitsMenu1.getSelectedItemPosition()==pos4){
            F_I_M_mm=3;
        }
* */


/*
*               if(F_I_M_mm==0){
                    if(!isEmpty(input)) {
                        feet = Float.parseFloat(input.getText().toString());
                        inches = feet * 12;
                        //output.setTextSize(20);
                        output.setText("" + inches);
                        unit1.setText(" Feet ");
                        unit2.setText("Inches");
                        inches = 0;
                    }
                }else if(F_I_M_mm==1){
                    if(!isEmpty(input)) {
                        inches = Float.parseFloat(input.getText().toString());
                        feet = inches / 12;
                        //output.setTextSize(20);
                        output.setText("" + feet);
                        unit1.setText("Inches");
                        unit2.setText(" Feet ");
                        feet = 0;
                    }
                }
*/


/*
                   if(isEmpty(input) && output.getText().toString().length()==0 && F_I_M_mm==0){

                    input.setHint("Inches (1)");
                    output.setHint("Feet (0.08333)");
                    unit2.setText(" Feet ");
                    unit1.setText("Inches");
                    F_I_M_mm=1;
                    spinnerPosition1=adapter.getPosition(second_value);
                    unitsMenu1.setSelection(spinnerPosition1);
                    spinnerPosition2=adapter.getPosition(first_value);
                    unitsMenu2.setSelection(spinnerPosition2);

                }else if(isEmpty(input) && output.getText().toString().length()==0 && F_I_M_mm==1){
                    input.setHint("Feet (1)");
                    output.setHint("Inches (12)");
                    unit1.setText(" Feet ");
                    unit2.setText("Inches");
                    F_I_M_mm=0;
                    spinnerPosition2=adapter.getPosition(second_value);
                    unitsMenu2.setSelection(spinnerPosition2);
                    spinnerPosition1=adapter.getPosition(first_value);
                    unitsMenu1.setSelection(spinnerPosition1);

                }else if(!(isEmpty(input)) && output.getText().toString().length()==0 && (F_I_M_mm==0 || F_I_M_mm==1)){
                    if(F_I_M_mm==0){
                        float op=Float.parseFloat(input.getText().toString());
                        float ip=op*12;

                        output.setText(""+op);
                        input.setText(""+ip);
                        unit2.setText(" Feet ");
                        unit1.setText("Inches");

                        F_I_M_mm=1;
                        spinnerPosition1=adapter.getPosition(second_value);
                        unitsMenu1.setSelection(spinnerPosition1);
                        spinnerPosition2=adapter.getPosition(first_value);
                        unitsMenu2.setSelection(spinnerPosition2);

                        input.setHint("Inches (1)");
                        output.setHint("Feet (0.08333)");

                    }else if(F_I_M_mm==1){
                        float op=Float.parseFloat(input.getText().toString());
                        float ip=op/12;

                        //output.setTextSize(20);
                        output.setText(""+op);
                        input.setText(""+ip);
                        unit1.setText(" Feet ");
                        unit2.setText("Inches");

                        F_I_M_mm=0;
                        spinnerPosition2=adapter.getPosition(second_value);
                        unitsMenu2.setSelection(spinnerPosition2);
                        spinnerPosition1=adapter.getPosition(first_value);
                        unitsMenu1.setSelection(spinnerPosition1);

                        input.setHint("Feet (1)");
                        output.setHint("Inches (12)");

                    }

                }else if(!(isEmpty(input)) && output.getText().toString().length()!=0 && F_I_M_mm==0){
                    float ip=Float.parseFloat(input.getText().toString());

                    float op=ip*12;

                    output.setText(""+ip);
                    input.setText(""+op);
                    unit2.setText(" Feet ");
                    unit1.setText("Inches");

                    F_I_M_mm=1;
                    spinnerPosition1=adapter.getPosition(second_value);
                    unitsMenu1.setSelection(spinnerPosition1);
                    spinnerPosition2=adapter.getPosition(first_value);
                    unitsMenu2.setSelection(spinnerPosition2);

                    input.setHint("Inches (1)");
                    output.setHint("Feet (0.08333)");

                }else if(!(isEmpty(input)) && output.getText().toString().length()!=0 && F_I_M_mm==1){
                    float ip=Float.parseFloat(input.getText().toString());

                    float op=ip/12;

                    output.setText(""+ip);
                    input.setText(""+op);
                    unit1.setText(" Feet ");
                    unit2.setText("Inches");

                    F_I_M_mm=0;
                    spinnerPosition2=adapter.getPosition(second_value);
                    unitsMenu2.setSelection(spinnerPosition2);
                    spinnerPosition1=adapter.getPosition(first_value);
                    unitsMenu1.setSelection(spinnerPosition1);

                    input.setHint("Feet (1)");
                    output.setHint("Inches (12)");

                }else if(isEmpty(input) && output.getText().toString().length()!=0 && (F_I_M_mm==0 || F_I_M_mm==1)){
                    if(F_I_M_mm==0){
                        float ip=Float.parseFloat(output.getText().toString());
                        float op=ip/12;

                        output.setText(""+op);
                        input.setText(""+ip);
                        unit2.setText(" Feet ");
                        unit1.setText("Inches");

                        F_I_M_mm=1;
                        spinnerPosition1=adapter.getPosition(second_value);
                        unitsMenu1.setSelection(spinnerPosition1);
                        spinnerPosition2=adapter.getPosition(first_value);
                        unitsMenu2.setSelection(spinnerPosition2);

                        input.setHint("Inches (1)");
                        output.setHint("Feet (0.08333)");

                    }else if(F_I_M_mm==1){
                        float ip=Float.parseFloat(output.getText().toString());
                        float op=ip*12;

                        //output.setTextSize(20);
                        output.setText(""+op);
                        input.setText(""+ip);
                        unit1.setText(" Feet ");
                        unit2.setText("Inches");

                        F_I_M_mm=0;
                        spinnerPosition2=adapter.getPosition(second_value);
                        unitsMenu2.setSelection(spinnerPosition2);
                        spinnerPosition1=adapter.getPosition(first_value);
                        unitsMenu1.setSelection(spinnerPosition1);

                        input.setHint("Feet (1)");
                        output.setHint("Inches (12)");

                    }
                }
 */

/*//Answer
        ViewAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isEmpty(input)){
                    Toast.makeText(MainActivity.this, "Enter a value first", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Converted", Toast.LENGTH_SHORT).show();
                }

                String value1=unitsMenu1.getSelectedItem().toString();
                String value2=unitsMenu2.getSelectedItem().toString();

                if(value1.equals("Feet") && value2.equals("Inches")){
                    if(!isEmpty(input)) {
                        feet = Float.parseFloat(input.getText().toString());
                        inches = feet * 12;
                        output.setText("" + inches);
                        unit1.setText(" Feet ");
                        unit2.setText("Inches");
                        inches = 0;
                    }
                }else if(value1.equals("Inches") && value2.equals("Feet")){
                    if(!isEmpty(input)) {
                        inches = Float.parseFloat(input.getText().toString());
                        feet = inches / 12;
                        output.setText("" + feet);
                        unit1.setText("Inches");
                        unit2.setText(" Feet ");
                        feet = 0;
                    }
                }else if(value1.equals("Feet") && value2.equals("Metre")){
                    if(!isEmpty(input)) {
                        feet = Float.parseFloat(input.getText().toString());
                        metre = (float) (feet / 3.281);
                        output.setText("" + metre);
                        unit1.setText(" Feet ");
                        unit2.setText(" Metre ");
                        metre = 0;
                    }
                }else if(value1.equals("Metre") && value2.equals("Feet")){
                    if(!isEmpty(input)) {
                        metre = Float.parseFloat(input.getText().toString());
                        feet = (float) (metre * 3.281);
                        output.setText("" + feet);
                        unit1.setText("Metre");
                        unit2.setText(" Feet ");
                        feet = 0;
                    }
                }else if(value1.equals("Feet") && value2.equals("Millimetre")){
                    if(!isEmpty(input)) {
                        feet = Float.parseFloat(input.getText().toString());
                        mm = (float) (feet * 304.8);
                        output.setText("" + mm);
                        unit1.setText(" Feet ");
                        unit2.setText("Mm");
                        mm = 0;
                    }
                }else if(value1.equals("Millimetre") && value2.equals("Feet")){
                    if(!isEmpty(input)) {
                        mm = Float.parseFloat(input.getText().toString());
                        feet = (float) (mm / 304.8);
                        output.setText("" + feet);
                        unit1.setText("Mm");
                        unit2.setText(" Feet ");
                        feet = 0;
                    }
                }else if(value1.equals("Inches") && value2.equals("Metre")){
                    if(!isEmpty(input)) {
                        inches = Float.parseFloat(input.getText().toString());
                        metre = (float) (inches / 39.37);
                        output.setText("" + metre);
                        unit1.setText("Inches");
                        unit2.setText("Metre");
                        metre = 0;
                    }
                }else if(value1.equals("Metre") && value2.equals("Inches")){
                    if(!isEmpty(input)) {
                        metre = Float.parseFloat(input.getText().toString());
                        inches = (float) (metre * 39.37);
                        output.setText("" + inches);
                        unit1.setText("Metre");
                        unit2.setText("Inches");
                        inches= 0;
                    }
                }else if(value1.equals("Inches") && value2.equals("Millimetre")){
                    if(!isEmpty(input)) {
                        inches = Float.parseFloat(input.getText().toString());
                        mm = (float) (inches * 25.4);
                        output.setText("" + mm);
                        unit1.setText("Inches");
                        unit2.setText("Mm");
                        mm = 0;
                    }
                }else if(value1.equals("Millimetre") && value2.equals("Inches")){
                    if(!isEmpty(input)) {
                        mm = Float.parseFloat(input.getText().toString());
                        inches = (float) (mm / 25.4);
                        output.setText("" + inches);
                        unit1.setText("Mm");
                        unit2.setText("Inches");
                        inches = 0;
                    }
                }else if(value1.equals("Millimetre") && value2.equals("Metre")){
                    if(!isEmpty(input)) {
                        mm = Float.parseFloat(input.getText().toString());
                        metre = (mm / 1000);
                        output.setText("" + metre);
                        unit1.setText("Mm");
                        unit2.setText("Metre");
                        metre = 0;
                    }
                }else if(value1.equals("Metre") && value2.equals("Millimetre")){
                    if(!isEmpty(input)) {
                        metre = Float.parseFloat(input.getText().toString());
                        mm = (metre * 1000);
                        output.setText("" + mm);
                        unit1.setText("Metre");
                        unit2.setText("Mm");
                        mm = 0;
                    }
                }

            }
        });

 */

/*
unitsMenu1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String value2=unitsMenu2.getSelectedItem().toString();

                if(value2.equals("Feet")){
                    unitsMenu1.setAdapter(adapter1);
                }else if(value2.equals("Inches")){
                    unitsMenu1.setAdapter(adapter2);
                }else if(value2.equals("Metre")){
                    unitsMenu1.setAdapter(adapter3);
                }else if(value2.equals("Millimetre")){
                    unitsMenu1.setAdapter(adapter4);
                }

                return false;
            }
        });

        unitsMenu2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String value1=unitsMenu1.getSelectedItem().toString();

                if(value1.equals("Feet")){
                    unitsMenu2.setAdapter(adapter1);
                }else if(value1.equals("Inches")){
                    unitsMenu2.setAdapter(adapter2);
                }else if(value1.equals("Metre")){
                    unitsMenu2.setAdapter(adapter3);
                }else if(value1.equals("Millimetre")){
                    unitsMenu2.setAdapter(adapter4);
                }

                return false;
            }
        });
* */

/*
* else if(isEmpty(input) && output.getText().toString().length()!=0){
                    if(value1.equals("Feet") && value2.equals("Inches")) {
                        inches = Float.parseFloat(output.getText().toString());
                        feet = inches / 12;
                        output.setText("" + feet);
                        input.setText(""+inches);
                        feet = 0;
                    }else if(value1.equals("Inches") && value2.equals("Feet")) {
                        feet = Float.parseFloat(output.getText().toString());
                        inches = feet * 12;
                        output.setText("" + inches);
                        input.setText(""+feet);
                        inches = 0;
                    }else if(value1.equals("Feet") && value2.equals("Metre")) {
                        metre = Float.parseFloat(output.getText().toString());
                        feet = (float) (metre * 3.281);
                        output.setText("" + feet);
                        input.setText(""+metre);
                        feet = 0;
                    }else if(value1.equals("Metre") && value2.equals("Feet")) {
                        feet = Float.parseFloat(output.getText().toString());
                        metre = (float) (feet / 3.281);
                        output.setText(""+metre);
                        input.setText("" + feet);
                        metre = 0;
                    }else if(value1.equals("Feet") && value2.equals("Millimetre")) {
                        mm = Float.parseFloat(output.getText().toString());
                        feet = (float) (mm / 304.8);
                        output.setText("" + feet);
                        input.setText(""+mm);
                        feet = 0;
                    }else if(value1.equals("Millimetre") && value2.equals("Feet")) {
                        feet = Float.parseFloat(output.getText().toString());
                        mm = (float) (feet * 304.8);
                        output.setText("" + mm);
                        input.setText(""+feet);
                        mm = 0;
                    }else if(value1.equals("Inches") && value2.equals("Metre")) {
                        metre = Float.parseFloat(output.getText().toString());
                        inches = (float) (metre * 39.37);
                        output.setText("" + inches);
                        input.setText(""+metre);
                        inches = 0;
                    }else if(value1.equals("Metre") && value2.equals("Inches")) {
                        inches = Float.parseFloat(output.getText().toString());
                        metre = (float) (inches / 39.37);
                        output.setText("" + metre);
                        input.setText(""+inches);
                        metre = 0;
                    }else if(value1.equals("Inches") && value2.equals("Millimetre")) {
                        mm = Float.parseFloat(output.getText().toString());
                        inches = (float) (mm / 25.4);
                        output.setText("" + inches);
                        input.setText(""+mm);
                        inches = 0;
                    }else if(value1.equals("Millimetre") && value2.equals("Inches")) {
                        inches = Float.parseFloat(output.getText().toString());
                        mm = (float) (inches * 25.4);
                        output.setText("" + mm);
                        input.setText(""+inches);
                        mm = 0;
                    }else if(value1.equals("Millimetre") && value2.equals("Metre")) {
                        metre = Float.parseFloat(output.getText().toString());
                        mm = (metre * 1000);
                        output.setText("" + mm);
                        input.setText(""+metre);
                        mm = 0;
                    }else if(value1.equals("Metre") && value2.equals("Millimetre")) {
                        mm = Float.parseFloat(output.getText().toString());
                        metre = (mm / 1000);
                        output.setText("" + metre);
                        input.setText(""+mm);
                        metre = 0;
                    }

                }
* */