package com.example.leon.floripapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia on 18/11/16.
 */

public class PontoTuristicoDAO extends SQLiteOpenHelper {

    public PontoTuristicoDAO(Context context) {
        super(context, "GuiaTuristico", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE PontosTuristicos(id INTEGER PRIMARY KEY, nome TEXT NOT NULL, descricao TEXT, pago BOOLEAN, dataFuncionamento TEXT, horarioFuncionamento TEXT, favorito BOOLEAN);";
        sqLiteDatabase.execSQL(sql);

        String insereDados = "INSERT INTO PontosTuristicos VALUES (1, 'Praia Joaquina', 'Uma praia muito massa', 0, 'sempre funcionando', 'sem hora')," +
                "(2, 'Lagoa da Conceição', 'altas lagoa que na real é uma laguna', 0, 'ta sempre lá', 'all day all night')," +
                "(3, 'UFSC', 'Universidade Federal de SC', 0, 'dias de semana', 'até as 10');";

        sqLiteDatabase.execSQL(insereDados);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS PontosTuristicos";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public List<PontoTuristico> buscaPontosTuristicos(){
        SQLiteDatabase database = getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * From PontosTuristicos", null);

        List<PontoTuristico> pontosTuristicos =  new ArrayList<PontoTuristico>();
        while(c.moveToNext()){
            PontoTuristico pontoTuristico = new PontoTuristico();
            pontoTuristico.setId(c.getInt(c.getColumnIndex("id")));
            pontoTuristico.setNome(c.getString(c.getColumnIndex("nome")));
            pontoTuristico.setDescricao(c.getString(c.getColumnIndex("descricao")));
            pontoTuristico.setPago(c.getInt(c.getColumnIndex("pago")) > 0);
            pontoTuristico.setDataFuncionamento(c.getString(c.getColumnIndex("dataFuncionamento")));
            pontoTuristico.setHorarioFuncionamento(c.getString(c.getColumnIndex("horarioFuncionamento")));
            pontoTuristico.setFavorito((c.getInt(c.getColumnIndex("favorito"))) > 0);

            pontosTuristicos.add(pontoTuristico);
        }
        c.close();
        return pontosTuristicos;
    }

    public List<PontoTuristico> buscaPontosTuristicosFavoritos(){
        SQLiteDatabase database = getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * From PontosTuristicos order by favorito desc", null);

        List<PontoTuristico> pontosTuristicos =  new ArrayList<PontoTuristico>();
        while(c.moveToNext()){
            PontoTuristico pontoTuristico = new PontoTuristico();
            pontoTuristico.setId(c.getInt(c.getColumnIndex("id")));
            pontoTuristico.setNome(c.getString(c.getColumnIndex("nome")));
            pontoTuristico.setDescricao(c.getString(c.getColumnIndex("descricao")));
            pontoTuristico.setPago(c.getInt(c.getColumnIndex("pago")) > 0);
            pontoTuristico.setDataFuncionamento(c.getString(c.getColumnIndex("dataFuncionamento")));
            pontoTuristico.setHorarioFuncionamento(c.getString(c.getColumnIndex("horarioFuncionamento")));
            pontoTuristico.setFavorito((c.getInt(c.getColumnIndex("favorito"))) > 0);
            pontoTuristico.setImage(c.getBlob(c.getColumnIndex("image")));

            pontosTuristicos.add(pontoTuristico);
        }
        c.close();
        return pontosTuristicos;
    }

    public void salvaAlteracao(PontoTuristico pontoTuristico){
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();
        if(pontoTuristico.isFavorito()) {
            values.put("favorito",1);
        }else{
            values.put("favorito",0);
        }
        String[] params={String.valueOf(pontoTuristico.getId())};
        database.update("PontosTuristicos",values,"id = ?",params);
    }

//    public String imagem(URL url){
//        SQLiteDatabase db = getWritableDatabase();
//        try {
//            URLConnection ucon = url.openConnection();
//            InputStream is = ucon.getInputStream();
//            BufferedInputStream bis = new BufferedInputStream(is,128);
//            byte[] bytes = new byte[128];
//            ByteBuffer barb= ByteBuffer.wrap(bytes);
//
//            int current = 0;
//            while ((current = bis.read()) != -1) {
//                barb.put((byte) current);
//            }
//
//            ContentValues filedata= new ContentValues();
//
//            bytes = new byte[barb.remaining()];
//            barb.get(bytes, 0, bytes.length);
//
//            barb.clear();
//
//            bytes = new byte[barb.capacity()];
//
//            barb.get(bytes, 0, bytes.length);
//
//
//            filedata.put("image", bytes);
//
//            String sql = "INSERT INTO PontosTuristicos (image) VALUES (" + filedata + ")";
//
//            return sql;
//
//        }catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
