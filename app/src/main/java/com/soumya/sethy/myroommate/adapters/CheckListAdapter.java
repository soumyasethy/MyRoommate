package com.soumya.sethy.myroommate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.soumya.sethy.myroommate.R;

import java.util.ArrayList;

public class CheckListAdapter extends BaseAdapter {
	static ArrayList<RoommateName> objects;
	Context ctx;
	LayoutInflater lInflater;
	OnCheckedChangeListener myCheckChangList = new OnCheckedChangeListener() {
		public void onCheckedChanged(CompoundButton buttonView,
									 boolean isChecked) {
			getProduct((Integer) buttonView.getTag()).box = isChecked;
		}
	};

	public CheckListAdapter(Context context, ArrayList<RoommateName> products) {
		ctx = context;
		objects = products;
		lInflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public static ArrayList<RoommateName> getBox() {
		ArrayList<RoommateName> box = new ArrayList<RoommateName>();
		if (objects == null) {

		} else {
			for (RoommateName p : objects) {
				if (p.box)
					box.add(p);
			}
		}

		return box;
	}

	@Override
	public int getCount() {
		return objects.size();
	}

	@Override
	public Object getItem(int position) {
		return objects.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			view = lInflater.inflate(R.layout.check_item, parent, false);
		}

		RoommateName p = getProduct(position);

		((TextView) view.findViewById(R.id.tvDescr)).setText(p.name);

		CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbBox);
		cbBuy.setOnCheckedChangeListener(myCheckChangList);
		cbBuy.setTag(position);
		cbBuy.setChecked(p.box);
		return view;
	}

	RoommateName getProduct(int position) {
		return ((RoommateName) getItem(position));
	}
}