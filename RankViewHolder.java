package com.example.rank;

import com.example.perspolisiha.R;

import android.view.View;
import android.widget.ImageView;

public class RankViewHolder {
ImageView icon = null;
	
	RankViewHolder(View base){
		this.icon = (ImageView)base.findViewById(R.id.pic);
	}

}
