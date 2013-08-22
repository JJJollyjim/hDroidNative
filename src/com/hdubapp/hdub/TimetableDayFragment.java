package com.hdubapp.hdub;

import com.hdubapp.hdub.R;
import com.hdubapp.hdub.R.id;
import com.hdubapp.hdub.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TimetableDayFragment extends Fragment {
	static final String KEY_POSITION = "position";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.fragment_timetable_day, container, false);
		TextView text = (TextView) result.findViewById(R.id.text);
		
		int position = getArguments().getInt(KEY_POSITION, -1);
		text.setText("Fragment #" + (position + 1));
		
		return result;
	}

	static TimetableDayFragment newInstance(int position) {
		TimetableDayFragment frag = new TimetableDayFragment();

		Bundle args = new Bundle();
		args.putInt(KEY_POSITION, position);

		frag.setArguments(args);

		return frag;
	}

}
