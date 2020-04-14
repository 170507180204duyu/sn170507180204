package cn.edu.sdwu.android.classroom.sn170507180204;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;

public class Ch9Activity1 extends AppCompatActivity {
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch9_1);
        Resources resources=getResources();
        String[] countries=resources.getStringArray(R.array.countries);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,countries);
        AutoCompleteTextView autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.ch9_1_actv);
        autoCompleteTextView.setAdapter(arrayAdapter);
        progressBar=(ProgressBar)findViewById(R.id.ch9_1_pb);
    }
    public void progressStart(View view){
        //实例化一个新进程
        Thread thread=new Thread(){
            @Override
            //线程里实际执行的工作都是在run()方法里完成的
            public void run() {
                int i=0;
                while (i<=100){
                    try{
                        //让线程停顿1秒
                        Thread.sleep(1000);
                    }catch (Exception e){

                    }
                    progressBar.setProgress(i);
                    i+=25;
                }
            }
        };
        //启动新进程
        thread.start();
    }
}
