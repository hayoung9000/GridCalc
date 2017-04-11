package com.example.lg.gridlayoutcalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    TextView text_result;
    Button[] butNums=new Button[10];
    Button[] butOps=new Button[4];
    public  static final int SELECT_EDIT1=0;
    public  static final int SELECT_EDIT2=1;
    int selectEdit=SELECT_EDIT1;
    String numStr="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //xml을 불러오고 그 안에 있는 요소들을 사용한다
        edit1=(EditText)findViewById(R.id.edit1);
        edit2=(EditText)findViewById(R.id.edit2);
        text_result=(TextView)findViewById(R.id.text_1);
        edit1.setOnTouchListener(editHandler);
        edit2.setOnTouchListener(editHandler);

        for(int i=0; i<butNums.length; i++){
            butNums[i]=(Button)findViewById(R.id.but_num1+i);
            butNums[i].setOnClickListener(butNumHandler);

        }
        for(int i=0; i<butOps.length;i++){
            butOps[i]=(Button)findViewById(R.id.but_op1+i);
            butOps[i].setOnClickListener(butOpHandler);
        }
    }

    View.OnClickListener butNumHandler = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Button but = (Button)view;
            numStr+=but.getText();
            switch (selectEdit){
                case SELECT_EDIT1 :
                    edit1.setText(numStr);
                    break;
                case SELECT_EDIT2 :
                    edit2.setText(numStr);
                    break;
            }
        }
    };
    View.OnClickListener butOpHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int num1=Integer.parseInt(edit1.getText().toString());
            int num2=Integer.parseInt(edit2.getText().toString());
            int sum=0;
            switch (view.getId()){
                case R.id.but_op1:
                    sum=num1+num2;
                    break;
                case R.id.but_op2:
                    sum=num1-num2;
                    break;
                case R.id.but_op3:
                    sum=num1*num2;
                    break;
                case R.id.but_op4:
                    sum=num1/num2;
                    break;
            }
            text_result.setText(sum+"");
        }
    };
    View.OnTouchListener editHandler=new View.OnTouchListener(){
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent){
            numStr="";
            switch (view.getId()){
                case R.id.edit1 :
                    selectEdit=SELECT_EDIT1; break;
                case R.id.edit2 :
                    selectEdit=SELECT_EDIT2; break;
            }
            return true;
        }
    };
}