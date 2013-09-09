package com.hdubapp.hdub;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.viewpagerindicator.TitlePageIndicator;

public class TimetableActivity extends SherlockFragmentActivity {
	private static final String TAG = "hDroidNative.TimetableActivity";
	private ListNavManager navMan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Set up view
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timetable);

		// Connect Adapter with ViewPager
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(new TimetablePagerAdapter(getSupportFragmentManager()));

		// Connect ViewPager with VPI Title-strip
		TitlePageIndicator tabs = (TitlePageIndicator) findViewById(R.id.titles);
		tabs.setViewPager(pager);

		// Set up navigation
		navMan = new ListNavManager(this, 0);
		navMan.setupNav();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(this).inflate(R.menu.timetable, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_settings) {
			Toast.makeText(this, "Test...", Toast.LENGTH_LONG).show();
			return true;
		} else if (item.getItemId() == R.id.action_pickday) {
			APIManager man = new APIManager();

		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onResume() {
		navMan.onResume();
		super.onResume();
	}

}
