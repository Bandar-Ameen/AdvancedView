package com.astooltech.advancedview.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.database.model.Note;
import com.astooltech.advancedview.database.model.ScriptModel;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by ravi on 15/03/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
   // private static final String DATABASE_NAME = "notes_db";

    String table_listdiff = "CREATE TABLE IF NOT EXISTS listdiff ( " +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "prodctID INTEGER NOT NULL DEFAULT 0, " +
            "tajerID INTEGER NOT NULL DEFAULT 0, " +
            "diffID INTEGER NOT NULL DEFAULT 0, " +
            "currID INTEGER NOT NULL DEFAULT 0, " +
            "photo_path TEXT NOT NULL DEFAULT '', " +
            "price REAL NOT NULL, " +
            "ram INTEGER NOT NULL DEFAULT 0, " +
            "hdd INTEGER NOT NULL DEFAULT 0, " +

            "co_nweer INTEGER NOT NULL DEFAULT 0, " +

            "co_motaba INTEGER NOT NULL DEFAULT 0, " +

            "co_mashoob INTEGER NOT NULL DEFAULT 0, " +

            "co_thmana INTEGER NOT NULL DEFAULT 0, " +

            "co_clean INTEGER NOT NULL DEFAULT 0, " +

            "co_mshrohg INTEGER NOT NULL DEFAULT 0, " +

            "co_notes TEXT NOT NULL DEFAULT '', " +

            "co_typehard INTEGER NOT NULL DEFAULT 0, " +

            "co_disp INTEGER NOT NULL DEFAULT 0, " +
            "co_dispsize INTEGER NOT NULL DEFAULT 0 " +
            ")";


    String table_prodact = "CREATE TABLE IF NOT EXISTS table_prodact ( " +
            "prodact_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "prodact_name TEXT NOT NULL DEFAULT ''" + ")";

    String table_tajer = "CREATE TABLE IF NOT EXISTS table_tajer (" +
            "tajer_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "tajer_name TEXT NOT NULL DEFAULT '', " +
            "tajer_add TEXT NOT NULL DEFAULT '', " +
            "tajer_phone TEXT NOT NULL DEFAULT '' " +

            ")";


    String table_prodactdec = "CREATE TABLE IF NOT EXISTS table_prodactdec ( " +
            "prodactdec_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "prodactdec_desc TEXT NOT NULL DEFAULT '', " +
            "prodact_idd INTEGER NOT NULL DEFAULT 0 " +
            ")";

    String table_prodacompanyes = "CREATE TABLE IF NOT EXISTS table_prodacompanyes ( " +
            "prodacompanyes_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "prodacompanyes_name TEXT NOT NULL DEFAULT '', " +
            "prodacompanyes_url TEXT NOT NULL DEFAULT '', " +
            "prodacompanyes_imageurl TEXT NOT NULL DEFAULT '' " +
            ")";
    String table_diff = "CREATE TABLE IF NOT EXISTS table_diff ( " +
            "diff_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "diff_date TEXT NOT NULL DEFAULT '', " +
            "diff_user TEXT NOT NULL DEFAULT ''" +
            ")";

    String table_curran = "CREATE TABLE IF NOT EXISTS table_curran ( " +
            "curran_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "curran_name TEXT NOT NULL DEFAULT '', " +
            "curran_conver REAL NOT NULL DEFAULT 0.00 " +


            ")";

    String table_notifactin = "CREATE TABLE IF NOT EXISTS table_notifactin ( " +
            "notifactin_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "notifactin_date TEXT NOT NULL DEFAULT '', " +
            "notifactin_content TEXT NOT NULL DEFAULT ''," +
            "notifactin_new INTEGER NOT NULL DEFAULT 0 ," +
            "notifactin_show INTEGER NOT NULL DEFAULT 0 ," +
            "notifactin_notifiid INTEGER NOT NULL DEFAULT 0 " +
            ")";



    String scriptt = "CREATE TABLE IF NOT EXISTS scriptt ( " +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "content TEXT NOT NULL DEFAULT '', " +
            "url TEXT NOT NULL DEFAULT '' " +
            ")";
    String tab_pridactforphone = "CREATE TABLE IF NOT EXISTS tab_pridactforphone ( " +
            "pridactforphone_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "companyID INTEGER NOT NULL DEFAULT 0 ," +
            "pridactforphone_name TEXT NOT NULL DEFAULT '', " +
            "pridactforphone_desc TEXT NOT NULL DEFAULT '', " +
            "pridactforphone_imageurl TEXT NOT NULL DEFAULT ''" +
            ")";

    public DatabaseHelper(Context context) {
        super(context, GlobalClass.DATABASE_NAME, null, DATABASE_VERSION);
    }
    private static final String TBL_SCRIPT = "script";
    private static final String COL_NAME = "name";
    private static final String COL_NAMESPACE = "namespace";
    private static final String COL_DOWNLOADURL = "downloadurl";
    private static final String COL_UPDATEURL = "updateurl";
    private static final String COL_INSTALLURL = "installurl";
    private static final String COL_DESCRIPTION = "description";
    private static final String COL_ICON = "icon";
    private static final String COL_RUNAT = "runat";
    private static final String COL_UNWRAP = "unwrap";
    private static final String COL_VERSION = "version";
    private static final String COL_CONTENT = "content";
    private static final String COL_ENABLED = "enabled";
    private static final String TBL_SCRIPT_CREATE = "CREATE TABLE "
            + TBL_SCRIPT + " (" + COL_NAME + " TEXT NOT NULL" + ", "
            + COL_NAMESPACE + " TEXT NOT NULL" + ", " + COL_DESCRIPTION
            + " TEXT" + ", " + COL_DOWNLOADURL + " TEXT" + ", "
            + COL_UPDATEURL + " TEXT" + ", " + COL_INSTALLURL + " TEXT"
            + ", " + COL_ICON + " TEXT" + ", " + COL_RUNAT + " TEXT" + ", "
            + COL_UNWRAP + " INTEGER" + ", " + COL_VERSION + " TEXT" + ", "
            + COL_CONTENT + " TEXT NOT NULL" + ", " + COL_ENABLED
            + " INTEGER NOT NULL DEFAULT 1" + ", PRIMARY KEY (" + COL_NAME
            + ", " + COL_NAMESPACE + "));";
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(Note.CREATE_TABLE);
        db.execSQL(Note.table_prodacta);
        db.execSQL(table_prodactdec);
        db.execSQL(table_tajer);
        db.execSQL(table_diff);
        db.execSQL(Note.CREATE_TB);
        db.execSQL(table_listdiff);
        db.execSQL(table_prodacompanyes);
        db.execSQL(table_notifactin);
        db.execSQL(tab_pridactforphone);
        db.execSQL(scriptt);




    }


    public List<ScriptModel> getAllNotes(ScriptModel dat) {
        List<ScriptModel> notes = new ArrayList<>();

        String valll="'" +dat.getUrl()+"'";
        // Select All Query


        String selectQuery = "SELECT * FROM  table_diff where  diff_user="+valll+"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ScriptModel note = new ScriptModel(cursor.getInt(cursor.getColumnIndex("diff_id")),cursor.getString(cursor.getColumnIndex("diff_date")),cursor.getString(cursor.getColumnIndex("diff_user")));

                notes.add(note);
            } while (cursor.moveToNext());
        }



        String datanam=dat.getUrl();
        StringBuilder fdc=new StringBuilder();
        for (int cx = 0; cx < notes.size(); cx++) {

            if(notes.get(cx).getUrl().equals(datanam)){
                //fdc.append("\n");
                fdc.append(notes.get(cx).getContent());
            }
        }
        ScriptModel h=new ScriptModel(dat.getId(),fdc.toString(),dat.getUrl());
        List<ScriptModel> notess = new ArrayList<>();
        notess.add(h);
        // close db connection
        //  db.close();

        // return notes list
        return notess;
    }


    public long insert(ScriptModel data) {
        SQLiteDatabase db = this.getWritableDatabase();
        long id = 0;
        try {

            List<ScriptModel> ds = getAllNotes(data);
            if (ds.size() == 0) {

                int cx = data.getContent().length();
                int cou = 2310169;
                if (cx > cou) {

                    int fd = cx / cou;
                    int mod=cx%cou;

                    int readfrom=0;
                    for(int z=0;z<fd;z++){

                        String result1=data.getContent().substring(readfrom, cou+readfrom);

                        readfrom=readfrom+cou;

                        ContentValues values = new ContentValues();
                        // `id` and `timestamp` will be inserted automatically.
                        // no need to add them

                        values.put("diff_date", result1);
                        values.put("diff_user", data.getUrl());

                        id = db.insert("table_diff", null, values);

                    }
                    if(mod>0){

                        String result1=data.getContent().substring(readfrom, cx);
                        ContentValues values = new ContentValues();
                        // `id` and `timestamp` will be inserted automatically.
                        // no need to add them

                        values.put("diff_date", result1);
                        values.put("diff_user", data.getUrl());

                        id = db.insert("table_diff", null, values);
                    }





                } else {
                    ContentValues values = new ContentValues();
                    // `id` and `timestamp` will be inserted automatically.
                    // no need to add them

                    values.put("diff_date", data.getContent());
                    values.put("diff_user", data.getUrl());

                    id = db.insert("table_diff", null, values);
                    //values.put("url", data.getUrl());
                    // values.put("content", data.getContent());
                    // insert row
                    //   long id = db.insert("scriptt", null, values);

                    // close db connection
                    db.close();
                }
                return id;


            } else {


                // String selectQuery = "DELETE * FROM  table_diff where  url="+data.getUrl()+"";
                // delete("table_diff",selectQuery);
                String valll = "'" + data.getUrl() + "'";
                db.delete("table_diff", "diff_user=" + valll + "", null);

                int cx = data.getContent().length();
                int cou = 2310169;
                if (cx > cou) {

                    int fd = cx / cou;
                    int mod=cx%cou;

                    int readfrom=0;
                    for(int z=0;z<fd;z++){

                        String result1=data.getContent().substring(readfrom, cou+readfrom);

                        readfrom=readfrom+cou;

                        ContentValues values = new ContentValues();
                        // `id` and `timestamp` will be inserted automatically.
                        // no need to add them

                        values.put("diff_date", result1);
                        values.put("diff_user", data.getUrl());

                        id = db.insert("table_diff", null, values);

                    }
                    if(mod>0){

                        String result1=data.getContent().substring(readfrom, cx);
                        ContentValues values = new ContentValues();
                        // `id` and `timestamp` will be inserted automatically.
                        // no need to add them

                        values.put("diff_date", result1);
                        values.put("diff_user", data.getUrl());

                        id = db.insert("table_diff", null, values);
                    }





                } else {
                    ContentValues values = new ContentValues();
                    // `id` and `timestamp` will be inserted automatically.
                    // no need to add them

                    values.put("diff_date", data.getContent());
                    values.put("diff_user", data.getUrl());

                    id = db.insert("table_diff", null, values);
                    //values.put("url", data.getUrl());
                    // values.put("content", data.getContent());
                    // insert row
                    //   long id = db.insert("scriptt", null, values);

                    // close db connection
                    db.close();
                }
                return id;


        /*  ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put("diff_date", data.getContent());
        values.put("diff_user", data.getUrl());

       id = db.insert("table_diff", null, values);

        // close db connection
        db.close();

        return id;*/
            }
        }catch (Exception ex){

            Log.i("999",ex.getMessage());
            String valll = "'" + data.getUrl() + "'";
            db.delete("table_diff", "diff_user=" + valll + "", null);
        }
        // return newly inserted row id
        // return id;
        return  id;
    }


public String quarys(){

        return "SELECT  *from   table_prodactdec  JOIN  table_prodactv  ON table_prodactdec.prodact_idd=table_prodactv.prodact_id";
}


    public String quarysformain(){


        String alquar="SELECT  DISTINCT *FROM(SELECT ((listdiff.co_motaba+listdiff.co_mashoob+listdiff.co_mshrohg)/3)as precents,   table_prodactv.prodact_id,\n" +
                "       table_prodactv.prodact_name,table_prodactdec.prodactdec_id,\n" +
                "       table_prodactdec.prodactdec_desc,\n" +
                "       table_prodactdec.prodact_idd, table_tajer.tajer_id,\n" +
                "       table_tajer.tajer_name,\n" +
                "       table_tajer.tajer_add,\n" +
                "       table_tajer.tajer_phone , table_diff.diff_id,\n" +
                "       table_diff.diff_date,\n" +
                "       table_diff.diff_user,\n" +
                "listdiff._id,\n" +
                "       listdiff.prodctID,\n" +
                "       listdiff.tajerID,\n" +
                "       listdiff.diffID,\n" +
                "       listdiff.currID,\n" +
                "       listdiff.photo_path,\n" +
                "       listdiff.price,\n" +
                "       listdiff.ram,\n" +
                "       listdiff.hdd,\n" +
                "       listdiff.co_nweer,\n" +
                "       listdiff.co_motaba,\n" +
                "       listdiff.co_mashoob,\n" +
                "       listdiff.co_thmana,\n" +
                "       listdiff.co_clean,\n" +
                "       listdiff.co_mshrohg,\n" +
                "       listdiff.co_notes,\n" +
                "       listdiff.co_typehard,\n" +
                "       listdiff.co_disp,\n" +
                "       listdiff.co_dispsize       \n" +
                ",CASE WHEN listdiff.currID=2 THEN 'دولار' WHEN listdiff.currID=3 THEN 'سعودي' ELSE 'محلي' END AS curraname,CASE WHEN listdiff.co_typehard=1 THEN 'HDD'  ELSE 'SSD' END AS typehard   from   table_prodactdec  JOIN  table_prodactv  ON table_prodactdec.prodact_idd=table_prodactv.prodact_id \n" +
                "JOIN listdiff ON  listdiff.prodctID=table_prodactdec.prodactdec_id JOIN table_tajer ON table_tajer.tajer_id=listdiff.tajerID JOIN table_diff \n" +
                "ON table_diff.diff_id=listdiff.diffID)as vv";

   return  alquar;
    }

    public String quarysformain(String  condations){


        String alquar="SELECT  DISTINCT *FROM(SELECT ((listdiff.co_motaba+listdiff.co_mashoob+listdiff.co_mshrohg)/3)as precents,  table_prodactv.prodact_id,\n" +
                "       table_prodactv.prodact_name,table_prodactdec.prodactdec_id,\n" +
                "       table_prodactdec.prodactdec_desc,\n" +
                "       table_prodactdec.prodact_idd, table_tajer.tajer_id,\n" +
                "       table_tajer.tajer_name,\n" +
                "       table_tajer.tajer_add,\n" +
                "       table_tajer.tajer_phone , table_diff.diff_id,\n" +
                "       table_diff.diff_date,\n" +
                "       table_diff.diff_user,\n" +
                "listdiff._id,\n" +
                "       listdiff.prodctID,\n" +
                "       listdiff.tajerID,\n" +
                "       listdiff.diffID,\n" +
                "       listdiff.currID,\n" +
                "       listdiff.photo_path,\n" +
                "       listdiff.price,\n" +
                "       listdiff.ram,\n" +
                "       listdiff.hdd,\n" +
                "       listdiff.co_nweer,\n" +
                "       listdiff.co_motaba,\n" +
                "       listdiff.co_mashoob,\n" +
                "       listdiff.co_thmana,\n" +
                "       listdiff.co_clean,\n" +
                "       listdiff.co_mshrohg,\n" +
                "       listdiff.co_notes,\n" +
                "       listdiff.co_typehard,\n" +
                "       listdiff.co_disp,\n" +
                "       listdiff.co_dispsize       \n" +
                ",CASE WHEN listdiff.currID=2 THEN 'دولار' WHEN listdiff.currID=3 THEN 'سعودي' ELSE 'محلي' END AS curraname,CASE WHEN listdiff.co_typehard=1 THEN 'HDD'  ELSE 'SSD' END AS typehard   from   table_prodactdec  JOIN  table_prodactv  ON table_prodactdec.prodact_idd=table_prodactv.prodact_id \n" +
                "JOIN listdiff ON  listdiff.prodctID=table_prodactdec.prodactdec_id JOIN table_tajer ON table_tajer.tajer_id=listdiff.tajerID JOIN table_diff \n" +
                "ON table_diff.diff_id=listdiff.diffID)as vv where "+ condations +"";

        return  alquar;
    }

    public int deleteslist(int ids){

        String quary="_id = "+ids+"";
        SQLiteDatabase db = getWritableDatabase();

        int rowsDeleted = db.delete("listdiff", quary, null);
        db.close();
        return rowsDeleted;

    }


    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Note.TABLE_NAME);

        db.execSQL("DROP TABLE IF EXISTS " + Note.table_prodactss);
        db.execSQL(Note.DROP_TB);
       // DROP_TB




       // db.execSQL("DROP TABLE IF EXISTS  table_prodact");
        // Create tables again
        onCreate(db);
    }

    public long insertNote(String note) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Note.COLUMN_NOTE, note);

        // insert row
        long id = db.insert(Note.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }





    public Note getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Note.TABLE_NAME,
                new String[]{Note.COLUMN_ID, Note.COLUMN_NOTE, Note.COLUMN_TIMESTAMP},
                Note.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        Note note = new Note(
                cursor.getInt(cursor.getColumnIndex(Note.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Note.COLUMN_NOTE)),
                cursor.getString(cursor.getColumnIndex(Note.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return note;
    }


    public List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Note.TABLE_NAME + " ORDER BY " +
                Note.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setId(cursor.getInt(cursor.getColumnIndex(Note.COLUMN_ID)));
                note.setNote(cursor.getString(cursor.getColumnIndex(Note.COLUMN_NOTE)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(Note.COLUMN_TIMESTAMP)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }
    public boolean update(String  values,String tablenam,String quary) {
        //  quary="_id = 1"
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("prodact_name", values);

        int updated_row_id = (int) db.update(tablenam, contentValues, quary, null);
      db.close();
        return updated_row_id > 0;
    }

    public boolean delete(String tabb,String quary) {
        SQLiteDatabase db = getWritableDatabase();

        int rowsDeleted = db.delete(tabb, quary, null);
      db.close();
        return rowsDeleted > 0;
    }


    public String  getpath() {
        SQLiteDatabase db = getWritableDatabase();
//db.getPath();
        //int rowsDeleted = db.delete(tabb, quary, null);
       // db.close();
        return db.getPath();
    }



    public long insert(String data) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Note.DD, data);

        // insert row
        long id = db.insert(Note.table_prodactss, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;

    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Note.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Note.COLUMN_NOTE, note.getNote());

        // updating row
        return db.update(Note.TABLE_NAME, values, Note.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
    }

    public void deleteNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Note.TABLE_NAME, Note.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }


    public long insertproddec(String desc,int prodID) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("prodactdec_desc", desc);
        values.put("prodact_idd", prodID);
        long id = db.insert("table_prodactdec", null, values);
        db.close();
        return id;
    }

    public boolean deleteprodactdec(String quary) {
        SQLiteDatabase db = getWritableDatabase();

        int rowsDeleted = db.delete("table_prodactdec", quary, null);
        db.close();
        return rowsDeleted > 0;
    }

    public boolean updatedesc(String desc,int prodID,String quary) {
        //  quary="_id = 1"
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues values = new ContentValues();
        values.put("prodactdec_desc", desc);
        //values.put("prodact_idd", prodID);

        int updated_row_id = (int) db.update("table_prodactdec", values, quary, null);
        db.close();
        return updated_row_id > 0;
    }




    public long insertproddect(String name,String ph,String add) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("tajer_name",name);
        values.put("tajer_add",add);
        values.put("tajer_phone",ph);;
        long id = db.insert("table_tajer", null, values);
        db.close();
        return id;
    }



    public boolean deleteprodactdect(String quary) {
        SQLiteDatabase db = getWritableDatabase();

        int rowsDeleted = db.delete("table_tajer", quary, null);
        db.close();
        return rowsDeleted > 0;
    }

    public boolean updatedesct(String name,String ph,String add,int prodID,String quary) {
        //  quary="_id = 1"
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues values = new ContentValues();

      //  values.put("tajer_id")));
        values.put("tajer_name",name);
        values.put("tajer_add",add);
        values.put("tajer_phone",ph);;

        //values.put("prodact_idd", prodID);

        int updated_row_id = (int) db.update("table_tajer", values, quary, null);
        db.close();
        return updated_row_id > 0;
    }



    public long insertproddectdif() {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dataa=new SimpleDateFormat("yyy-MM-dd");
        String currand=dataa.format(new Date());

        ContentValues values = new ContentValues();
        values.put("diff_date",currand);
        values.put("diff_user","notfound");

        long id = db.insert("table_diff", null, values);
        db.close();
        return id;
    }

    public boolean deleteprodactdectdif(String quary) {
        SQLiteDatabase db = getWritableDatabase();

        int rowsDeleted = db.delete("table_diff", quary, null);
        db.close();
        return rowsDeleted > 0;
    }


    public boolean deleteprodactdectdifvv(int quary) {
        SQLiteDatabase db = getWritableDatabase();
String qq="id="+quary+"";
        int rowsDeleted = db.delete("dd_TB", qq, null);
        db.close();
        return rowsDeleted > 0;
    }


    //diff_diff_main_list



   // diff_add_model
   public long add(String name,String url)
   {
       try {
           SQLiteDatabase db = getWritableDatabase();
           ContentValues cv=new ContentValues();
           cv.put(Note.NAME,name);
           cv.put(Note.URL, url);

           db.insert(Note.TB_NAME, Note.ROW_ID, cv);
           db.close();
           return 1;

       } catch (Exception e) {
           e.printStackTrace();
       }
       return 0;
   }

    //RETRIEVE
    public Cursor getTVShows()
    {
        SQLiteDatabase db = getWritableDatabase();
        String[] columns={Note.ROW_ID,Note.NAME,Note.URL};

        return db.query(Note.TB_NAME,columns,null,null,null,null,null);
    }






    public boolean deletecompanyes() {
        SQLiteDatabase db = getWritableDatabase();

        int rowsDeleted = db.delete("table_prodacompanyes", "prodacompanyes_id !=0", null);
        db.close();
        return rowsDeleted > 0;
    }
    public long insertproddectcompanyes(String prodacompanyes_name,String prodacompanyes_url,String prodacompanyes_imageurl) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("prodacompanyes_name",prodacompanyes_name);
        values.put("prodacompanyes_url",prodacompanyes_url);
        values.put("prodacompanyes_imageurl",prodacompanyes_imageurl);;
        long id = db.insert("table_prodacompanyes", null, values);
        db.close();
        return id;
    }



    public boolean deletecompanyess(int ID) {
        SQLiteDatabase db = getWritableDatabase();

        int rowsDeleted = db.delete("tab_pridactforphone", "companyID ="+ID+"", null);
        db.close();
        return rowsDeleted > 0;
    }



    public long insertproddectcompanyesv(int companyID,String pridactforphone_name,String pridactforphone_imageurl,String pridactforphone_desc) {

        SQLiteDatabase db = this.getWritableDatabase();

        /*
        *
        *     "pridactforphone_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "companyID INTEGER NOT NULL DEFAULT 0 ," +
            "pridactforphone_name TEXT NOT NULL DEFAULT '', " +
            "pridactforphone_desc TEXT NOT NULL DEFAULT '', " +
            "pridactforphone_imageurl TEXT NOT NULL DEFAULT ''" +
        *
        * */

        ContentValues values = new ContentValues();
        values.put("companyID",companyID);
        values.put("pridactforphone_name",pridactforphone_name);
        values.put("pridactforphone_imageurl",pridactforphone_imageurl);
        values.put("pridactforphone_desc",pridactforphone_desc);;
        long id = db.insert("tab_pridactforphone", null, values);
        db.close();
        return id;
    }



    public int updateinsertnotification(int typs, String quary) {

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
       // values.put("notifactin_date",mm.getNotifactin_date());
        //values.put("notifactin_content",mm.getNotifactin_content());
      if(typs==1){
          quary="notifactin_new=0";
          values.put("notifactin_new",1);
      }else {
          values.put("notifactin_show",1);
      }

      //  values.put("notifactin_show",mm.getNotifactin_show());;

        int id = (int) db.update("table_notifactin", values, quary, null);
       // long id = db.insert("table_notifactin", null, values);
        db.close();
        return id;
    }






}
