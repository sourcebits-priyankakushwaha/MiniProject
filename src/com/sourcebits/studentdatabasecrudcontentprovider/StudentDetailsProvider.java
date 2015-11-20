package com.sourcebits.studentdatabasecrudcontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

public class StudentDetailsProvider extends ContentProvider {

	// content://authority/path/id
	// We are creating URI matcher for our table that will specify the table .
	// Either it will return all rows or specific row as per our query
	static final String PROVIDER_NAME = "com.sourcebits.studentdatabasecrudcontentprovider.StudentDetailsProvider";

	static final String URL = "content://" + PROVIDER_NAME + "/student";
	static final Uri CONTENT_URI = Uri.parse(URL);

	static final int ALL_STUDENTS = 1;
	static final int SINGLE_STUDENT = 2;
	static final UriMatcher uriMatcher;

	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(PROVIDER_NAME, "student", ALL_STUDENTS);
		uriMatcher.addURI(PROVIDER_NAME, "student/#", SINGLE_STUDENT);
	}

	// Creating database and table
	private SQLiteDatabase database;
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "student";
	public static final String STUDENT_TABLE = "student_table";

	// Columns name
	public static final String STUD_ID = "_id";
	public static final String STUD_NAME = "name";
	public static final String MATHS_MARKS = "maths";
	public static final String ENGLISH_MARKS = "english";
	public static final String SCIENCE_MARKS = "science";
	public static final String HISTORY_MARKS = "history";
	public static final String SOCIAL_SCIENCE_MARKS = "social science";

	// object of database handler
	StudentDatabase dbHelper;

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {

		SQLiteDatabase database = dbHelper.getWritableDatabase();
		switch (uriMatcher.match(uri)) {
		case ALL_STUDENTS:
			// do nothing
			break;
		case SINGLE_STUDENT:
			String id = uri.getPathSegments().get(1);
			selection = STUD_ID + "=" + id + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : "");
			break;
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
		int deleteCount = database.delete(STUDENT_TABLE, selection, selectionArgs);
		getContext().getContentResolver().notifyChange(uri, null);
		return deleteCount;
	}

	@Override
	public String getType(Uri uri) {

		switch (uriMatcher.match(uri)) {
		case ALL_STUDENTS:
			return "vnd.android.cursor.dir/vnd.com.com.sourcebits.studentdatabasecrudcontentprovider.StudentDetailsProvider.students";
		case SINGLE_STUDENT:
			return "vnd.android.cursor.item/vnd.com.com.sourcebits.studentdatabasecrudcontentprovider.StudentDetailsProvider.students";
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {

		switch (uriMatcher.match(uri)) {
		case ALL_STUDENTS:
			// do nothing
			break;
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
	
		long id = database.insert(STUDENT_TABLE, null, values);
		getContext().getContentResolver().notifyChange(uri, null);
		return Uri.parse(CONTENT_URI + "/" + id);
	}

	@Override
	public boolean onCreate() {

		Context context = getContext();
		dbHelper = new StudentDatabase(context);

		// WE CAN UPDATE THE RECORDS
		database = dbHelper.getWritableDatabase();

		if (database == null)

			return false;
		else
			return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		SQLiteDatabase database = dbHelper.getWritableDatabase();
		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		queryBuilder.setTables(STUDENT_TABLE);

		switch (uriMatcher.match(uri)) {
		case ALL_STUDENTS:
			// do nothing
			break;
		case SINGLE_STUDENT:
			String id = uri.getPathSegments().get(1);
			queryBuilder.appendWhere(STUD_ID + "=" + id);
			break;
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}

		Cursor cursor = queryBuilder.query(database, projection, selection, selectionArgs, null, null, sortOrder);
		return cursor;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

		SQLiteDatabase database = dbHelper.getWritableDatabase();
		switch (uriMatcher.match(uri)) {
		case ALL_STUDENTS:
			// do nothing
			break;
		case SINGLE_STUDENT:
			String id = uri.getPathSegments().get(1);
			selection = STUD_ID + "=" + id + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : "");
			break;
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
		int updateCount = database.update(STUDENT_TABLE, values, selection, selectionArgs);
		getContext().getContentResolver().notifyChange(uri, null);
		return updateCount;
	}

	// this class is used for creating the database using sqlite
	public class StudentDatabase extends SQLiteOpenHelper {

		// constructor to initialize
		public StudentDatabase(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);

		}

		// Query to create the table inside the current database
		@Override
		public void onCreate(SQLiteDatabase db) {
			String CREATE_STUDENT_TABLE = "CREATE TABLE " + STUDENT_TABLE + "(" + STUD_ID + "INTEGER PRIMARY KEY,"
					+ STUD_NAME + " TEXT," + MATHS_MARKS + " INTEGER," + ENGLISH_MARKS + "INTEGER," + SCIENCE_MARKS
					+ "INTEGER," + HISTORY_MARKS + "INTEGER," + SOCIAL_SCIENCE_MARKS + "INTEGER," + ")";
			db.execSQL(CREATE_STUDENT_TABLE);
		}

		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		}

	}

}
