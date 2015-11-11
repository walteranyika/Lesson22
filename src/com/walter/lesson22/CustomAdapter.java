package com.walter.lesson22;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter {
	Context mContext;
	ArrayList<Item> data;
	public CustomAdapter(Context context, ArrayList<Item> data) {
		this.mContext = context;
		this.data = data;
	}
	@Override
	public int getCount() {
		return data.size();// # of items in your arraylist
	}
	@Override
	public Object getItem(int position) {
		return data.get(position);// get the actual movie
	}
	@Override
	public long getItemId(int id) {
		return id;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(R.layout.list_item_layout, parent,					false);
			viewHolder = new ViewHolder();
			viewHolder.textViewQuote = (TextView) convertView.findViewById(R.id.textViewQuote);
			viewHolder.textViewSpeaker = (TextView) convertView.findViewById(R.id.textViewSpeaker);
			//load Fonts
			Typeface font1=Typeface.createFromAsset(mContext.getAssets(), "fonts/learning.otf");
			Typeface font2=Typeface.createFromAsset(mContext.getAssets(), "fonts/lovers.otf");
			viewHolder.textViewQuote.setTypeface(font1);
			viewHolder.textViewSpeaker.setTypeface(font2);
			
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Item b = data.get(position);
		viewHolder.textViewQuote.setText(b.getQuote());
		viewHolder.textViewSpeaker.setText(b.getSpeaker());

		return convertView;
	}
	static class ViewHolder {
		TextView textViewQuote;
		TextView textViewSpeaker;

	}

}
