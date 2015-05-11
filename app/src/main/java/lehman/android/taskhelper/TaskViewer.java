package lehman.android.taskhelper;

//SQLView.java

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Krirk on 5/7/2015.
 */
public class TaskViewer extends Activity {


//private ArrayAdapter<String> mAdapter;


/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_view);
        TextView tv = (TextView) findViewById(R.id.tvSQLinfo);

        TaskDbHelper mTableInfo = new TaskDbHelper(this);
        try {
            mTableInfo.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String data = mTableInfo.getData();
        mTableInfo.close();
        tv.setText(data);

    }
*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.task_view);
        TextView tv = (TextView) findViewById(R.id.tvSQLinfo);

        TaskDbHelper mTableInfo = new TaskDbHelper(this);
        try {
            mTableInfo.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String data = mTableInfo.getData();
        mTableInfo.close();
        tv.setText(data);

    }
/*
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances) {
        String data[] = {"stuff"};
        //setContentView(R.layout.task_view);
        //ListView tv = (ListView) findViewById(R.id.tvSQLinfo);

        TaskDbHelper mTableInfo = new TaskDbHelper(getActivity());
        try {
            mTableInfo.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String tableData = mTableInfo.getData();
        mTableInfo.close();
        System.out.print(tableData);
        //tv.setText(data);

        List<String> strList = new ArrayList<String>(Arrays.asList(data));
        mAdapter = new ArrayAdapter<String>(
                getActivity(), // context
                R.layout.list_item, // layout to use for each item
                R.id.list_item_textview // textview to update with each item
                , strList);

        View rootView = inflater.inflate(R.layout.task_view, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.lvSQLinfo);
        listView.setOnItemClickListener(new ItemClickListener());
        listView.setAdapter(mAdapter);

        return rootView;
    }

    public class ItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
            Toast toast = Toast.makeText(getActivity(),
                    position,
                    Toast.LENGTH_SHORT);
            toast.show();

        }
    }
*/
/*
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances) {

    String[] data = {};
    List<String> strList = new ArrayList<String>(Arrays.asList(data));
    mAdapter = new ArrayAdapter<String>(
            getApplicationContext(), // context
            R.layout.list_item, // layout to use for each item
            R.id.list_item_textview // textview to update with each item
            , strList);

    View rootView = inflater.inflate(R.layout.task_view, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.tvSQLinfo);
        listView.setOnItemClickListener(new ItemClickListener());
        listView.setAdapter(mAdapter);

    return rootView;
    }

    public class ItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    position,
                    Toast.LENGTH_SHORT);
            toast.show();

        }
    }
    */
/*
    public void onClick(View v) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promptView = layoutInflater.inflate(R.layout.prompt, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setView(promptView);

        final EditText input = (EditText) promptView.findViewById(R.id.txtUserInput);

        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });




        AlertDialog alertD = alertDialogBuilder.create();

        alertD.show();


    }
    */
}

