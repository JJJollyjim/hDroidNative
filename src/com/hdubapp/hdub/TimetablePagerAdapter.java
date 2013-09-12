package com.hdubapp.hdub;


import com.actionbarsherlock.app.SherlockFragmentActivity;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

// TODO: Use FragmentStatePagerAdapter instead of FragmentPagerAdapter
public class TimetablePagerAdapter extends FragmentStatePagerAdapter {
	private static final String TAG = "hDroidNative.TimetablePagerAdapter";
	private Context ctx;

	public TimetablePagerAdapter(Context ctx) {
		super(((SherlockFragmentActivity) ctx).getSupportFragmentManager());
		
		this.ctx = ctx;
	}

	@Override
	public int getCount() {
//		Log.i(TAG, "getCount");
		return 10;
	}

	@Override
	public TimetableDayFragment getItem(int position) {
		Log.i(TAG, "Create activity " + position);
		return TimetableDayFragment.newInstance(position);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "F#" + (position);
	}

}