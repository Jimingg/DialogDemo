package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btndemo1;
    Button btndemo2;
    Button btndemo3;
    Button btne;
    Button btndemo4;
    Button btndemo5;
    TextView tvdemo2;
    TextView tvdemo3;
    TextView tve3;
    TextView tvdemo4;
    TextView tvdemo5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btndemo1=findViewById(R.id.buttonDemo1);
        btndemo2=findViewById(R.id.buttonDemo2);
        btndemo3=findViewById(R.id.buttonDemo3);
        btndemo4=findViewById(R.id.buttonDemo4);
        btndemo5=findViewById(R.id.buttonDemo5);
        btne=findViewById(R.id.buttonExcercise);
        tvdemo2=findViewById(R.id.textViewDemo2);
        tvdemo3=findViewById(R.id.textViewDemo3);
        tvdemo4=findViewById(R.id.textViewDemo4);
        tvdemo5=findViewById(R.id.textViewDemo5);
        tve3=findViewById(R.id.textViewExcercise);
        btndemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    tvdemo5.setText("Time : "+ hourOfDay+" : "+minute);
                    }
                };
                Calendar calendar= Calendar.getInstance();
                int hour=calendar.get(calendar.HOUR_OF_DAY);
                Log.d("button5",hour+"");
                int minute=calendar.get(calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,myTimeListener,hour,minute,true);
                myTimeDialog.show();
            }
        });
        btndemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvdemo4.setText("Date : "+dayOfMonth+"/"+(month+1)+"/"+ year);
                    }
                };
                Calendar calendar= Calendar.getInstance();
                int Y=calendar.get(Calendar.YEAR);
                int M=calendar.get(Calendar.MONTH);
                int D=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener,Y,M,D);
                myDateDialog.show();
            }
        });
        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.excercise, null);

                final EditText enter1 = viewDialog.findViewById(R.id.editTextNumber1);
                final EditText enter2  = viewDialog.findViewById(R.id.editTextNumber2);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //set the dialog details
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         int number1 = Integer.parseInt(enter1.getText().toString());
                        int number2 = Integer.parseInt(enter2.getText().toString());
                         int sum =number1+number2;
                        tve3.setText("The sum is "+sum);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btndemo3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                            View viewDialog = inflater.inflate(R.layout.input, null);

                                            final EditText etInput = viewDialog.findViewById(R.id.editTextInput);
                                            AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                                            //set the dialog details
                                            myBuilder.setView(viewDialog);
                                            myBuilder.setTitle("Demo 3-Text Input Dialog");
                                            myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    String message = etInput.getText().toString();
                                                    tvdemo3.setText(message);
                                                }


                                            });
                                            myBuilder.setNegativeButton("CANCEL", null);
                                            AlertDialog myDialog = myBuilder.create();
                                            myDialog.show();
                                        }
                                    });
        btndemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //set the dialog details
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Button below");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvdemo2.setText("You have selected positive.");
                    }
                });
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvdemo2.setText("You have selected Negative");
                    }
                });
                myBuilder.setNeutralButton("cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btndemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //set the dialog details
                myBuilder.setTitle("Congratulation");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss",null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
    }
}
