package ru.apress.test.testabs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockFragmentActivity implements ActionBar.TabListener {


	final static public String STATE_SELECTED_NAVIGATION_ITEM = "selected_tab";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar =  this.getSupportActionBar();
        actionBar.setTitle("èÛÎ¸Ò ñÂÌ- èêéÑÄÇÄâ"); 
        actionBar.setBackgroundDrawable(getResources().getDrawable( R.drawable.selected_background ));
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (int i = 1; i <= 3; i++) {
            ActionBar.Tab tab = getSupportActionBar().newTab();
            tab.setText("ÄÍÍ‡ÛÌÚ");
            tab.setIcon(R.drawable.ic_search);
            tab.setTabListener(this);
            getSupportActionBar().addTab(tab);
        }        
               
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
      // Restore the previously serialized current tab position.
      if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
    	  getSupportActionBar().setSelectedNavigationItem(savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
      }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
      // Serialize the current tab position.
      outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getSupportActionBar()
          .getSelectedNavigationIndex());
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
      // When the given tab is selected, show the tab contents in the
      // container view.
    	SherlockFragment fragment;
    	Toast.makeText(this, "tab "+ tab.getPosition() , Toast.LENGTH_LONG).show();
    	switch (tab.getPosition()+1) {
    case 1:
        fragment = new DummySectionFragment1();
    	break;
    case 2:
    	fragment = new DummySectionFragment2();
    	break;
    case 3:
    	fragment = new DummySectionFragment3();
    	break;
    default:
    	fragment = new DummySectionFragment1();
    }
      getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    

    public static class DummySectionFragment1 extends SherlockFragment {
      public static final String ARG_SECTION_NUMBER = "placeholder_text";

      protected String getStr() {
    	  return "kuku";
      }
      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
          Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.CENTER);
       	textView.setText(this.getStr());
       	return textView;
      }
    }

    public static class DummySectionFragment2 extends DummySectionFragment1 {
        protected String getStr() {
      	  return "kuku22    22222      222222     222222";
        }
    }    
    
    public static class DummySectionFragment3 extends DummySectionFragment1 {
        protected String getStr() {
      	  return "kuku33      3333333      33333     333333     33333";
        }
    }    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
        
    }
    
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
			menu.removeItem(R.id.submenu);
			return super.onPrepareOptionsMenu(menu);
	}
    

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
        case android.R.id.home:
            Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_LONG).show();
        	  Intent intent = new Intent(this, MainActivity.class);
        	  intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	  startActivity(intent); 
        	  break;         
        case R.id.menu_fotos :
            Toast.makeText(MainActivity.this, "You have Pressed 'unbup photos' Menu Item", Toast.LENGTH_LONG).show();
            return true;
        case R.id.menu_login :
            Toast.makeText(MainActivity.this, "You have Pressed 'login' Menu Item", Toast.LENGTH_LONG).show();
            return true;
        case R.id.menu_search :
            Toast.makeText(MainActivity.this, "You have Pressed 'search' Menu Item", Toast.LENGTH_LONG).show();
            return true;
        case R.id.menu_settings :
            Toast.makeText(MainActivity.this, "You have Pressed 'setings' Menu Item", Toast.LENGTH_LONG).show();
            return true;
        default:
            return super.onOptionsItemSelected(item);
                
        }
        
        return false;
    }    

}

