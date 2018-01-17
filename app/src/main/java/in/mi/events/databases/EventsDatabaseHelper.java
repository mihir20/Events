package in.mi.events.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import in.mi.events.classes.Event;
import in.mi.events.classes.User;

/**
 * Created by mi on 17/1/18.
 */

public class EventsDatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Events.db";

    // User table name
    private static final String TABLE_EVENTS = "events";

    // User Table Columns names
    private static final String COLUMN_EVENT_ID = "event_id";
    private static final String COLUMN_EVENT_AUTHOR = "event_author";
    private static final String COLUMN_EVENT_TITLE = "event_title";
    private static final String COLUMN_EVENT_DESCRIPTION = "event_description";
    private static final String COLUMN_EVENTS_IMAGE = "event_image";

    // create table sql query
    private String CREATE_EVENT_TABLE = "CREATE TABLE " + TABLE_EVENTS + "("
            + COLUMN_EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_EVENT_AUTHOR + " TEXT,"
            + COLUMN_EVENT_TITLE + " TEXT," + COLUMN_EVENT_DESCRIPTION + " TEXT,"
            + COLUMN_EVENTS_IMAGE + " TEXT" + ")";

    // drop table sql query
    private String DROP_EVENT_TABLE = "DROP TABLE IF EXISTS " + TABLE_EVENTS;


    public EventsDatabaseHelper(Context context) {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EVENT_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_EVENT_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create new Event
     *
     * @param event
     */
    public void addEvent(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EVENT_AUTHOR, event.getAuthor());
        values.put(COLUMN_EVENT_TITLE, event.getTitle());
        values.put(COLUMN_EVENT_DESCRIPTION, event.getDescription());
        values.put( COLUMN_EVENTS_IMAGE,event.getImageUri() );

        // Inserting Row
        db.insert(TABLE_EVENTS, null, values);
        db.close();
    }

    /**
     * This method is to fetch all events and return the list of events
     *
     * @return list
     */
    public ArrayList<Event> getAllEvents() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_EVENT_ID,
                COLUMN_EVENT_AUTHOR,
                COLUMN_EVENT_TITLE,
                COLUMN_EVENT_DESCRIPTION,
                COLUMN_EVENTS_IMAGE
        };
        // sorting orders
        String sortOrder =
                COLUMN_EVENT_ID + " DESC";
        ArrayList<Event> eventList = new ArrayList<Event>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the events table
        /**
         * Here query function is used to fetch events from events table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT event_id, event_author, event_title, event_description, event_image FROM user ORDER BY event_id;
         */
        Cursor cursor = db.query(TABLE_EVENTS, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Event event = new Event();
                event.setPostID(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_EVENT_ID))));
                event.setAuthor(cursor.getString(cursor.getColumnIndex(COLUMN_EVENT_AUTHOR)));
                event.setTitle(cursor.getString(cursor.getColumnIndex(COLUMN_EVENT_TITLE)));
                event.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_EVENT_DESCRIPTION)));
                event.setImageUri( cursor.getString( cursor.getColumnIndex( COLUMN_EVENTS_IMAGE ) ) );
                // Adding user record to list
                eventList.add(event);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return eventList;
    }

}
