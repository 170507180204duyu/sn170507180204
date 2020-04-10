package cn.edu.sdwu.android.classroom.sn170507180204;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Ch7Activity3 extends AppCompatActivity {
    private ArrayList list;
    private SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch7_3);
        //准备数据
        list=new ArrayList();
        HashMap hashMap1=new HashMap();
        hashMap1.put("name","goods1");
        hashMap1.put("price","50");
        hashMap1.put("img",R.drawable.img);
        list.add(hashMap1);
        HashMap hashMap2=new HashMap();
        hashMap2.put("name","goods2");
        hashMap2.put("price","500");
        hashMap2.put("img",R.drawable.img);
        list.add(hashMap2);
        HashMap hashMap3=new HashMap();
        hashMap3.put("name","goods3");
        hashMap3.put("price","80");
        hashMap3.put("img",R.drawable.img);
        list.add(hashMap3);
        //实例化适配器new String[]{"name","price","img"}要与hashMap.put("name","goods2");里的key值对应，new int[]{R.id.goods_name,R.id.goods_price,R.id.goods_img}值要与new String[]{"name","price","img"}对应
        simpleAdapter=new SimpleAdapter(this,list,R.layout.layout_goods,new String[]{"name","price","img"},new int[]{R.id.goods_name,R.id.goods_price,R.id.goods_img});
        //设置到listview
        ListView listView=(ListView)findViewById(R.id.ch7_3_lv);
        listView.setAdapter(simpleAdapter);
    }
}
