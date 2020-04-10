package cn.edu.sdwu.android.classroom.sn170507180204;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ch7Activity2 extends AppCompatActivity {
    private ArrayList list;
    private ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch7_2);
        list=new ArrayList();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        ListView listView=(ListView)findViewById(R.id.ch7_2_lv) ;
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
        //设置监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //第三个参数代表当前点击数据的位置
                String content=list.get(i).toString();
                Toast.makeText(Ch7Activity2.this,content,Toast.LENGTH_SHORT).show();
            }
        });

    }
    public  void  refresh(View view){
        list.add("item4");
        list.add("item5");
        //数据源改变之后，界面不会同步刷新，需要调用相应的方法
        arrayAdapter.notifyDataSetChanged();
    }
}
