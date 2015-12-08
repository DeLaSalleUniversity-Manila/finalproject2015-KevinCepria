package ph.edu.dlsu.eleksyon;

/**
 * Created by cobalt on 8/27/14.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import ph.edu.dlsu.sqliteasset.SQLiteAssetHelper;


public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "CANDIDATES.sqlite";
    private static final int DATABASE_VERSION = 1;


    public static final String TABLE_NAME = "election";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_LASTNAME = "Last_Name";
    public static final String KEY_POSITION = "Position";
    public static final String KEY_PARTY = "Party";
    public static final String KEY_EDUCATION = "Education";
    public static final String KEY_POLITICS = "Political_Backgorund";


    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // you can use an alternate constructor to specify a database location
        // (such as a folder on the sd card)
        // you must ensure that this folder is available and you have permission
        // to write to it
        //super(context, DATABASE_NAME, context.getExternalFilesDir(null).getAbsolutePath(), null, DATABASE_VERSION);

        // Delete old on upgrade (not working? java 7 problems probably 9/20)
        setForcedUpgrade(DATABASE_VERSION);
    }


    public Cursor setSearchCursor(String query) {

        //Open database
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //Enter the string query. Here we want everything from our table
        String[] sqlSelect = {"0 _id",KEY_NAME, KEY_LASTNAME, KEY_POSITION, KEY_PARTY, KEY_EDUCATION, KEY_POLITICS };

        String escaped_query = DatabaseUtils.sqlEscapeString("%" + query + "%");
        String selectQuery = MyDatabase.KEY_NAME + " LIKE " + escaped_query + " OR ";
        selectQuery += MyDatabase.KEY_LASTNAME + " LIKE " + escaped_query + " OR ";
        selectQuery += MyDatabase.KEY_POSITION + " LIKE " + escaped_query + " OR ";
        selectQuery += MyDatabase.KEY_PARTY + " LIKE " + escaped_query + " OR ";
        selectQuery += MyDatabase.KEY_EDUCATION + " LIKE " + escaped_query + " OR ";
        selectQuery += MyDatabase.KEY_POLITICS + " LIKE " + escaped_query + " ";

        String sqlTables = TABLE_NAME;

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, selectQuery, null,
                null, null, null);

        c.moveToFirst();
        return c;
    }


    public int getUpgradeVersion() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"MAX (version)"};
        String sqlTables = "upgrades";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        int v = 0;
        c.moveToFirst();
        if (!c.isAfterLast()) {
            v = c.getInt(0);
        }
        c.close();
        return v;


    }


    // Get number of events.
    public int getCount() {
        int count = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor dataCount;
        if (db != null) {
            dataCount = db.rawQuery("select * from " + TABLE_NAME, null);
            count = dataCount.getCount();
            //db.close();
        }
        return count;
    }



}