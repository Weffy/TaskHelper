package lehman.android.taskhelper;

//HotOrNot.java

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by Krirk on 5/7/2015.
 */


public class TaskDbHelper {


    public static final String KEY_ROWID = "_id";
    public static final String KEY_TASK = "task";
    public static final String KEY_DATE = "date";

    private static final String DATABASE_NAME = "todolist";
    private static final String DATABASE_TABLE = "taskTable";
    private static final int DATABASE_VERSION = 1;

    private DbHelper mHelper;
    private final Context mContext;
    private SQLiteDatabase mDatabase;




    private static class DbHelper extends SQLiteOpenHelper {

        public DbHelper (Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_TASK + " TEXT NOT NULL, " +
                            KEY_DATE + " TEXT NOT NULL);"

            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }

    }

    public TaskDbHelper(Context context){

        mContext = context;
    }

    public TaskDbHelper open() throws SQLException {
        mHelper = new DbHelper(mContext);
        mDatabase = mHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mHelper.close();

    }

    public long create(String task, String date) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_TASK, task);
        cv.put(KEY_DATE, date);
        return mDatabase.insert(DATABASE_TABLE, null, cv);

    }
    // testing github whoopee
    public String getData() {
        String[] columns = new String[] {KEY_ROWID, KEY_TASK, KEY_DATE};
        Cursor c = mDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
        String retResult = "";

        int indexRow = c.getColumnIndex(KEY_ROWID);
        int indexTask = c.getColumnIndex(KEY_TASK);
        int indexDate = c.getColumnIndex(KEY_DATE);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            retResult = retResult + c.getString(indexRow) + " " +
                    c.getString(indexTask) + " " +
                    c.getString(indexDate) + "\n";
        }


        return retResult;



    }

}


