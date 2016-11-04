package com.example.csuthar.testing;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements thirdFragment.OnFragmentInteractionListener, firstFragment.OnFragmentInteractionListener, secondFragment.OnFragmentInteractionListener {

    public int refValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*LinearLayout relativeLayout=(LinearLayout) findViewById(R.id.masterLayout);
        int hight=relativeLayout.getHeight();
        int width=relativeLayout.getWidth();

        Log.e("tag","hight"+hight);
        Log.e("tag","width"+width);*/
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        android.support.v4.app.Fragment xx = new thirdFragment();
        fragmentTransaction.add(R.id.frame, xx);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);

    }

    public void OnChamge(View view) {
        if (refValue == 11) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack();  // pop back is use for finish prev activity
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            android.support.v4.app.Fragment yy = new firstFragment();
            fragmentTransaction.replace(R.id.frame, yy);
            fragmentTransaction.addToBackStack(null); // add to back stack is use for save prev activity and use on back button
            fragmentTransaction.commit();
            refValue = 0;


        /*    Intent intent = new Intent(view.getContext(), MyNewActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            // use for activity finish

            */


        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            android.support.v4.app.Fragment zz = new secondFragment();
            fragmentTransaction.replace(R.id.frame, zz);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            refValue = 11;

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.test, menu);
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            SpannableString spanString = new SpannableString(menu.getItem(i).getTitle().toString());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), 0, spanString.length(), 0); //fix the color to white
            item.setTitle(spanString);

            //menu.findItem(R.id.one).setTitle(Html.fromHtml("<font color='#ff3824'>Settings</font>"));


        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.e("inteface calling ", "log");
        Toast.makeText(this, "third fragment interface", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFragmentInteraction(View view) {
        Log.e("inteface calling ", "log");
        Toast.makeText(this, "third fragment interface", Toast.LENGTH_SHORT).show();

    }
}
