package com.conti.vinfo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import com.baidu.mapapi.BMapManager;  
import com.baidu.mapapi.map.MapController;  
import com.baidu.mapapi.map.MapView;  
import com.baidu.platform.comapi.basestruct.GeoPoint;

public class MainActivity extends Activity {
	
	BMapManager mBMapMan = null;  
	MapView mMapView = null; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBMapMan=new BMapManager(getApplication());  
		mBMapMan.init("9FB9BDA606A9BC0E3F347703D2C825AF58F437BA", null);   
		
		//initial BMapManager object before invoke setContentView
		setContentView(R.layout.activity_main);
		mMapView=(MapView)findViewById(R.id.bmapsView);  
		mMapView.setBuiltInZoomControls(true);   
		MapController mMapController=mMapView.getController();    
		GeoPoint point =new GeoPoint((int)(31.283* 1E6),(int)(121.501* 1E6));   
		mMapController.setCenter(point);
		mMapController.setZoom(15);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override  
	protected void onDestroy(){  
	        mMapView.destroy();  
	        if(mBMapMan!=null){  
	                mBMapMan.destroy();  
	                mBMapMan=null;  
	        }  
	        super.onDestroy();  
	}  
	@Override  
	protected void onPause(){  
	        mMapView.onPause();  
	        if(mBMapMan!=null){  
	               mBMapMan.stop();  
	        }  
	        super.onPause();  
	}  
	@Override  
	protected void onResume(){  
	        mMapView.onResume();  
	        if(mBMapMan!=null){  
	                mBMapMan.start();  
	        }  
	       super.onResume();  
	}
}
