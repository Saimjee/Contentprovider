package com.example.sunlight1.contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.UserDictionary;

/**
 * Created by sunlight1 on 12/19/2017.
 */

public class ContentHelper {
    /** INSERT	 */
    public static Uri insertContent(ContentResolver resolver) {
        ContentValues conValues = new ContentValues();
        conValues.put(UserDictionary.Words.APP_ID, "com.concretepage");
        conValues.put(UserDictionary.Words.LOCALE, "BSCS");
        conValues.put(UserDictionary.Words.WORD, "Arshad Ali");
        conValues.put(UserDictionary.Words.FREQUENCY, "bcs02133245");
        Uri uri = resolver.insert(UserDictionary.Words.CONTENT_URI, conValues);
        return uri;
    }
    /** FETCH	 */
    public static String fetchContent(ContentResolver resolver, Uri uri) {
        StringBuffer data = new StringBuffer();
        String[] projection = 	{
                UserDictionary.Words._ID,
                UserDictionary.Words.LOCALE,
                UserDictionary.Words.WORD,
                UserDictionary.Words.FREQUENCY
        };
        String sortOrder = UserDictionary.Words.LOCALE;
        Cursor cursor = resolver.query(uri, projection, null, null, sortOrder);
        while (cursor.moveToNext()) {
            data.append(cursor.getString(1) + "," + cursor.getString(2) + ", " + cursor.getString(3));
            data.append("\n");
        }
        return data.toString();
    }
    /** UPDATE	 */
    public static int updateContent(ContentResolver resolver, Uri uri) {
        ContentValues conValues = new ContentValues();
        String selectionClause = UserDictionary.Words.WORD +  " LIKE ?";
        String[] selectionArgs = {"M%"};
        conValues.put(UserDictionary.Words.WORD, "Arshad Ali");
        int rowsUpdated = resolver.update(uri, conValues, selectionClause, selectionArgs);
        return rowsUpdated;
    }
    /** DELETE	 */
    public static int deleteContent(ContentResolver resolver) {
        String selectionClause = UserDictionary.Words.LOCALE +  " LIKE ?";
        String[] selectionArgs = {"BSCS"};
        int rowsDeleted = resolver.delete(UserDictionary.Words.CONTENT_URI, selectionClause, selectionArgs);
        return rowsDeleted;
    }
}
