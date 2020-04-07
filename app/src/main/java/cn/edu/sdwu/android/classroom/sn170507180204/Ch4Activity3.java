package cn.edu.sdwu.android.classroom.sn170507180204;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Ch4Activity3 extends AppCompatActivity {
    private ArrayList list;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch4_3);
        list=new ArrayList();
        textView=(TextView) findViewById(R.id.ch4_3_tv) ;
        //通过界面的容器，找到他所包含的所有子元素，再来注册监听器
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.ch4_3_ll);
        int count=linearLayout.getChildCount();
        for(int i=0;i<count;i++){
            View view=linearLayout.getChildAt(i);
            if(view instanceof CheckBox){
                final CheckBox checkBox=(CheckBox)view;
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton,boolean b){
                        //参数b代表是否选中，第一个参数代表事件源
                        if(b){
                            list.add(compoundButton);
                        }else{
                            list.remove(compoundButton);
                        }
                        String content="you select:";
                        for(int t=0;t<list.size();t++){
                            CheckBox checkBox1=(CheckBox) list.get(t);
                            String sel=checkBox1.getText().toString();
                            content+=sel+",";

                        }
                        textView.setText(content);
                    }
                });
            }
        }
    }
}
