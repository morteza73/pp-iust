package com.example.rank;

import com.example.perspolisiha.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	 private Context mContext;

//		R.drawable.esteghlal_failed,
//		R.drawable.perspolice_win,
//		R.drawable.perspolice_ghahraman,
//		R.drawable.percpolice_go_to_asia,
	    public Integer[] mThumbIds = {
	    		R.drawable.a1,
	    		R.drawable.a2,
	    		R.drawable.a3,
	    		R.drawable.a4,
	    		R.drawable.a5,
	    		R.drawable.a6,
	    		R.drawable.a7	    	
	    };
	 
	    // Constructor
	    public ImageAdapter(Context c){
	        mContext = c;
	    }
	 
	    @Override
	    public int getCount() {
	        return mThumbIds.length;
	    }
	 
	    @Override
	    public Object getItem(int position) {
	        return mThumbIds[position];
	    }
	 
	    @Override
	    public long getItemId(int position) {
	        return 0;
	    }
	 
	    
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        ImageView imageView = new ImageView(mContext);
	        imageView.setImageResource(mThumbIds[position]);
	        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	        final int w = 140;
	        imageView.setLayoutParams(new GridView.LayoutParams(w, w));
	        return imageView;
	    }
	    

	
}
