package com.example.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myweixin.R;

public class SwipFreshActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener{
	
	
	private SwipeRefreshLayout swipeRefreshLayout; 
	  private ListView listView; 
	  private List<String> list; 
	  private ArrayAdapter adapter; 
	  
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.swip_layout);
		
		swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.sr1); 
	    swipeRefreshLayout.setOnRefreshListener(this); 
	    list = new ArrayList<String>(); 
	    for(int i = 0;i<10;i++){
	      list.add("这是第"+i+"个数据");
	    }
	    listView = (ListView) findViewById(R.id.listview); 
	    adapter = new ArrayAdapter(this
	        , android.R.layout.simple_list_item_1 
	        , android.R.id.text1 
	        , list); 
	    listView.setAdapter(adapter); 
	}


	@Override
	public void onRefresh() {
		new Handler().postDelayed(new Runnable() { 
		      @Override
		      public void run() { 
		        swipeRefreshLayout.setRefreshing(false); 
		        adapter.clear(); 
		        list.add("这是第11个数据"); 
		        adapter.notifyDataSetChanged(); 
		      } 
		    }, 1000); 
	}
	
	

}
