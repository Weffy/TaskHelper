package lehman.android.taskhelper;

//SQLiteExample.java

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TaskHelper extends Activity /*ActionBarActivity*/ implements View.OnClickListener {

    Button btnAddItem;
    Button btnView;
    EditText txtAdd;
    EditText txtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_task_helper);

        txtAdd = (EditText)findViewById(R.id.txtAddItem);
        txtDate = (EditText)findViewById(R.id.txtAddTime);

        btnAddItem = (Button)findViewById(R.id.btnAddItem);
        btnAddItem.setOnClickListener(this);

        btnView = (Button)findViewById(R.id.btnView);
        btnView.setOnClickListener(this);

        System.out.println("ohai");

    }
    // Let's test this thing

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnAddItem:
                boolean tryTest = true;
                try {
                    String task = txtAdd.getText().toString();
                    String date = txtDate.getText().toString();

                    TaskDbHelper input = new TaskDbHelper(TaskHelper.this);

                    input.open();
                    input.create(task, date);
                    input.close();

                }catch(Exception e) {
                    tryTest = false;
                    String errMsg = e.toString();
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errMsg,
                            Toast.LENGTH_LONG);
                    toast.show();
                }finally{
                    if (tryTest) {

                        Toast toast = Toast.makeText(getApplicationContext(),
                                "tryTest passed!",
                                Toast.LENGTH_SHORT);
                        toast.show();


                    }
                }
                break;

            case R.id.btnView:
                Intent intent = new Intent ("lehman.android.TASKVIEWER");
                startActivity(intent);

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Opening SQL View!",
                        Toast.LENGTH_SHORT);
                toast.show();

                break;
        }
    }

    //Menu stuff
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_helper, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Fragment fragment = new Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            /*
            * Need to implement
            */

            //openSettings();
            return true;
        }
        else if (id == R.id.add_action) {
            /*
            * Need to implement
            */
            //fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
//          addAction();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    /**
     * A placeholder fragment containing a simple view.
     */
    /*
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_task_helper, container, false);
            return rootView;
        }
    }*/
}
