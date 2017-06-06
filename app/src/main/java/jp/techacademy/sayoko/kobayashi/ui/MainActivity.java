package jp.techacademy.sayoko.kobayashi.ui;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = (EditText) findViewById(R.id.editText);

    }
    @Override
    public void onClick(View v){
       if (v.getId() == R.id.button1){
           mTextView.setText(mEditText.getText().toString());
       } else if (v.getId() == R.id.button2){
           showAlertDialog();
       } else if(v.getId() == R.id.button3){
           showTimePickerDialog();
       }
    }

    private void showAlertDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("タイトル");
        alertDialogBuilder.setMessage("メッセージ");

        alertDialogBuilder.setPositiveButton("肯定",
                new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                Log.d("UI_PARTS", "肯定ボタン");

            }
        });

        alertDialogBuilder.setNeutralButton("中立",
                new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                Log.d("UI_PARTS", "中立ボタン");

            }
        });

        alertDialogBuilder.setNegativeButton("否定",
                new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                Log.d("UI_PARTS", "否定ボタン");

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
            @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                13,
                0,
                true);
        timePickerDialog.show();
    }


}
