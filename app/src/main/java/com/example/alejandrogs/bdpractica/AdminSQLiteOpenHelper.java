package com.example.alejandrogs.bdpractica;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by alejandrogs on 2/05/17.
 */

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;

    // Nombre de la base de datos
    private static final String DATABASE_NAME = "DB";

    // Nombre de las tablas
    private static final String TABLE_PROC= "productos";

    // Nombre de las columnas de la tabla Notes
    private static final String proc_calve = "clave";
    private static final String proc_desc = "descripcion";
    private static final String proc_pre = "precio";

    public AdminSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table productos (clave text primaty key,descripcion text,precio real)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROC);
        onCreate(db);
    }

    public void  addproducto(String clave, String desc,String precio,View v) {
        SQLiteDatabase db = this.getWritableDatabase();


        // Insertar
        try{
            //db.insert(TABLE_NOTAS, null, values);
            String query = ("INSERT INTO "+TABLE_PROC+" ("+proc_calve+","+proc_desc+","+proc_pre+") VALUES('"+clave+"','"+desc+"','"+precio+"');");
            db.execSQL(query);
        }catch (SQLException ex){

            Snackbar.make(v, "Error al insertar el producto", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        }
        db.close();
    }

    public String getForClaveDesc(String id,View view) {
        String selectQuery = "SELECT "+proc_desc+" FROM " + TABLE_PROC +" WHERE "+proc_calve+" = '"+id+"';";
        SQLiteDatabase db = this.getWritableDatabase();
        String note = "";
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {

                    note = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        }catch (SQLiteException ex){
            Snackbar.make(view, "Error al consultar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }
        db.close();

        return note;
    }

    public String getForClavePrecio(String id,View view) {
        String selectQuery = "SELECT "+proc_pre+" FROM " + TABLE_PROC +" WHERE "+proc_calve+" = '"+id+"';";
        SQLiteDatabase db = this.getWritableDatabase();
        String note = "";
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {

                    note = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        }catch (SQLiteException ex){
            Snackbar.make(view, "Error al consultar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }
        db.close();

        return note;
    }

    public String getForDesClave(String id,View view) {
        String selectQuery = "SELECT "+proc_calve+" FROM " + TABLE_PROC +" WHERE "+proc_desc+" = '"+id+"';";
        SQLiteDatabase db = this.getWritableDatabase();
        String note = "";
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {

                    note = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        }catch (SQLiteException ex){
            Snackbar.make(view, "Error al consultar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }
        db.close();

        return note;
    }

    public String getForDesPrecio(String id,View view) {
        String selectQuery = "SELECT "+proc_pre+" FROM " + TABLE_PROC +" WHERE "+proc_desc+" = '"+id+"';";
        SQLiteDatabase db = this.getWritableDatabase();
        String note = "";
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {

                    note = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        }catch (SQLiteException ex){
            Snackbar.make(view, "Error al consultar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }
        db.close();

        return note;
    }

    public void  DeleteProduc(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            String query = ("DELETE FROM "+TABLE_PROC+ " WHERE "+proc_calve+" = '"+ID+"';" );
            db.execSQL(query);
        }catch (SQLException ex){



        }
        db.close();
    }

    public void  updatePrecioProduc(String ID, String desc,String precio,View view) {
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            //db.insert(TABLE_NOTAS, null, values);
            String query = ("UPDATE "+TABLE_PROC+ " SET "+proc_pre+" = '"+precio+"' WHERE "+proc_calve+" = '"+ID+"';" );
            db.execSQL(query);
        }catch (SQLException ex){
            Snackbar.make(view, "Error al actualizar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        db.close();
    }

    public void  updateDesProduc(String ID, String desc,String precio,View view) {
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            //db.insert(TABLE_NOTAS, null, values);
            String query = ("UPDATE "+TABLE_PROC+ " SET "+proc_desc+" = '"+desc+"' WHERE "+proc_calve+" = '"+ID+"';" );
            db.execSQL(query);
        }catch (SQLException ex){
            Snackbar.make(view, "Error al actualizar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        db.close();
    }
}
