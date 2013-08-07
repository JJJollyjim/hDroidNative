package com.hdubapp.hdub;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

// TODO: Use FragmentStatePagerAdapter instead of FragmentPagerAdapter
public class TimetablePagerAdapter extends FragmentPagerAdapter {

	public TimetablePagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public TimetableDayFragment getItem(int position) {
		return TimetableDayFragment.newInstance(position);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "F#" + (position + 1);
	}

}
