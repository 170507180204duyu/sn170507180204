package cn.edu.sdwu.android.classroom.sn170507180204;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class Ch7Activity1 extends AppCompatActivity {
    private ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch7_1);
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.ch7_1_tb);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(Ch7Activity1.this, "on", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Ch7Activity1.this, "off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.ch7_1_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //参数i,代表当前选中的索引值
                String[] strArr=getResources().getStringArray(R.array.strArr);
                String content=strArr[i];
                Toast.makeText(Ch7Activity1.this,content,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner=(Spinner)findViewById(R.id.ch7_1_spinner2);
        //准备数据
        list=new ArrayList();
        list.add("spinnerItem1");
        list.add("spinnerItem2");
        list.add("spinnerItem3");
        //实例化数组适配器
        //ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.layout_spinner_item,list);//第二项展示每一项数据使用的样式
        //设置到spinner中
        spinner.setAdapter(arrayAdapter);
        //处理事件响应
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //参数i,代表当前选中的索引值
                String[] strArr=getResources().getStringArray(R.array.strArr);
                String content=list.get(i).toString();
                Toast.makeText(Ch7Activity1.this,content,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
