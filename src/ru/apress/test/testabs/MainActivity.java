package ru.apress.test.testabs;


import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Menu;

public class MainActivity extends SherlockActivity {

    private MenuItem mGoItem;
    private MenuItem mClearItem;
    
    private static final int GO_ITEM_ID = 1;
    private static final int CLEAR_ITEM_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar =  this.getSupportActionBar();
        actionBar.setTitle("σλόρ –εν- „€‚€‰"); 
        actionBar.setBackgroundDrawable(getResources().getDrawable( R.drawable.selected_background ));
        actionBar.setDisplayHomeAsUpEnabled(true);
        
                
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.menu, menu);
//        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();

/*    	
        mGoItem = menu.add(0, GO_ITEM_ID, 0, null);
        mGoItem.setIcon(R.drawable.abs__ic_go).setShowAsAction(
                MenuItem.SHOW_AS_ACTION_ALWAYS);
        mClearItem = menu.add(0, CLEAR_ITEM_ID, 0, null);
        mClearItem.setIcon(R.drawable.abs__ic_clear).setShowAsAction(
                MenuItem.SHOW_AS_ACTION_ALWAYS);
*/
        return true;
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
        case GO_ITEM_ID :
            Toast.makeText(MainActivity.this, "You have Pressed 'Go' Menu Item", Toast.LENGTH_LONG).show();
            return true;
        case CLEAR_ITEM_ID :
            Toast.makeText(MainActivity.this, "You have Pressed 'Clear' Menu Item", Toast.LENGTH_LONG).show();
            return true;
        default:
            return super.onOptionsItemSelected(item);
                
        }
        
        return false;
    }    

}

