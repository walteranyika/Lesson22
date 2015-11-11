package com.walter.lesson22;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

	public Database(Context context) {
		super(context, "quotes", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql =
			    "CREATE TABLE IF NOT EXISTS quotes "+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+ 
                " quote TEXT NOT NULL, " +		
				" speaker TEXT NOT NULL)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql="DROP TABLE IF EXISTS quotes";
		db.execSQL(sql);		
	}
   	/**
	 * Saves an item into sqlite database
	 * @param names
	 * @param quantity
	 */
	public void save(String quote, String speaker)
	{
	  SQLiteDatabase db=this.getWritableDatabase();
	  ContentValues values=new ContentValues();
	  values.put("quote", quote);
	  values.put("speaker", speaker);
	  db.insert("quotes", null, values);
	  db.close();
	}
	/**
	 * Fetches all unsynced records from the database
	 * Where the status is no
	 * @return
	 */
	public ArrayList<Item> fetch()
	{
		ArrayList<Item> data=new ArrayList<Item>();
		SQLiteDatabase db=this.getReadableDatabase();
		String sql="SELECT * FROM quotes LIMIT 20";
		Cursor cursor= db.rawQuery(sql, null);
		if(cursor.moveToFirst())
		{
		  do
		  {
			String id =cursor.getString(0);
			String quote= cursor.getString(1); 
			String speaker= cursor.getString(2);
			Item t=new Item(id, quote, speaker);
			data.add(t);			
		  }while(cursor.moveToNext());	
		}
		db.close();
		return data;
	}

	/**
	 * Counts records from the db
	 * @return
	 */
	public int count()
	{
		SQLiteDatabase db=this.getReadableDatabase();
		String sql="SELECT * FROM quotes";
		Cursor cursor =db.rawQuery(sql, null);		
		return cursor.getCount();
	}
	
	
	
	
	
	
}
