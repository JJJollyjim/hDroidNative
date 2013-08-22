package com.hdubapp.hdub;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.hdubapp.hdub.R;
import com.hdubapp.hdub.R.layout;
import com.hdubapp.hdub.R.menu;

public class HomeworkActivity extends SherlockFragmentActivity {
	private static final String TAG = "hDroidNative.HomeworkActivity";
	private ListNavManager navMan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_homework);

		// Set up navigation
		navMan = new ListNavManager(this, 1);
		navMan.setupNav();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(this).inflate(R.menu.timetable, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onResume() {
		navMan.onResume();
		super.onResume();
	}

}
