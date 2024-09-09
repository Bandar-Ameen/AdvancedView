package com.astooltech.advancedview.database.model;

/**
 * Created by ravi on 20/02/18.
 */

public class Note {
    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String  CC="prodact_id";
    public static final String DD="prodact_name";
    public static final String table_prodactss="table_prodactv";
    private int id;
    private String note;
    private String timestamp;

   public static final String ROW_ID="id";
   public static final String NAME="name";
   public static final String URL="url";

    //DB PROPERTIES
   public static final String DB_NAME="dd_DB";
  public   static final String TB_NAME="dd_TB";


    //CREATE TABLE STMT
  public   static final String CREATE_TB="CREATE TABLE dd_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT NOT NULL,url TEXT NOT NULL);";

    //UPGRADE TB STMT
   public static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;
    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOTE + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public static final String table_prodacta =
            "CREATE TABLE " + table_prodactss + "("
                    + CC + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + DD + " TEXT"
                    + ")";


    public Note() {
    }

    public Note(int id, String note, String timestamp) {
        this.id = id;
        this.note = note;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
