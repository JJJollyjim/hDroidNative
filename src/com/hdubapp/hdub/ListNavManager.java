package com.hdubapp.hdub;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class ListNavManager implements OnNavigationListener {
	private static final String TAG = "hDroidNative.ListNavManager";
	private String[] labels = new String[] { "Timetable", "Homework" };
	private SherlockFragmentActivity ctx;
	private int ctxPosition;

	public ListNavManager(Context ctx, int ctxPosition) {
		this.ctx = (SherlockFragmentActivity) ctx;
		this.ctxPosition = ctxPosition;

		Log.i(TAG, "Constructor: " + ctxPosition);
	}

	public void setupNav() {
		ArrayAdapter<String> navAdapter;
		ActionBar bar = ctx.getSupportActionBar();

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			// ICS & JB
			navAdapter = new ArrayAdapter<String>(bar.getThemedContext(),
					android.R.layout.simple_spinner_item, labels);
		} else {
			// Froyo & Gb
			navAdapter = new ArrayAdapter<String>(ctx,
					android.R.layout.simple_spinner_item, labels);
		}

		navAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		bar.setListNavigationCallbacks(navAdapter, this);
		bar.setSelectedNavigationItem(ctxPosition);
	}

	public void onResume() {
		ctx.getSupportActionBar().setSelectedNavigationItem(ctxPosition);
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		Log.i(TAG, "OnNavigationItemSelected: " + itemPosition
				+ ". Constructor: " + ctxPosition);
		if (itemPosition != ctxPosition) {
			Intent intent = null;
			
			if (itemPosition == 0) {
				intent = new Intent(ctx.getApplicationContext(),
						TimetableActivity.class);
			} else if (itemPosition == 1) {
				intent = new Intent(ctx.getApplicationContext(),
						HomeworkActivity.class);
			} else {
				Log.wtf(TAG, "Unknown itemPosition! What a terrible failiure!");
			}
			
			ctx.startActivity(intent);
			ctx.overridePendingTransition(0, 0);
		}

		return true;
	}
}
