package xyz.winthanhtike.travelandtour.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import xyz.winthanhtike.travelandtour.model.AgilityHero;
import xyz.winthanhtike.travelandtour.model.IntelligenceHero;
import xyz.winthanhtike.travelandtour.model.StrengthHero;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class DataProvider extends SQLiteOpenHelper {


    public DataProvider(Context context) {
        super(context, DataContract.DATABASE_NAME, null, DataContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + DataContract.StrengthTable.TABLE_NAME + "("
                    + DataContract.StrengthTable.HERO_ID + " Integer Primary key AutoIncrement,"
                    + DataContract.StrengthTable.HERO_NAME + " Text,"
                    + DataContract.StrengthTable.HERO_URL + " Text,"
                    + DataContract.StrengthTable.HERO_DESC + " Text,"
                    + DataContract.StrengthTable.HERO_HISTORY + " Text) ");

        db.execSQL("CREATE TABLE " + DataContract.AgilityTable.TABLE_NAME + "("
                + DataContract.AgilityTable.HERO_ID + " Integer Primary key AutoIncrement,"
                + DataContract.AgilityTable.HERO_NAME + " Text,"
                + DataContract.AgilityTable.HERO_URL + " Text,"
                + DataContract.AgilityTable.HERO_DESC + " Text,"
                + DataContract.AgilityTable.HERO_HISTORY + " Text) ");

        db.execSQL("CREATE TABLE " + DataContract.IntelligenceTable.TABLE_NAME + "("
                + DataContract.IntelligenceTable.HERO_ID + " Integer Primary key AutoIncrement,"
                + DataContract.IntelligenceTable.HERO_NAME + " Text,"
                + DataContract.IntelligenceTable.HERO_URL + " Text,"
                + DataContract.IntelligenceTable.HERO_DESC + " Text,"
                + DataContract.IntelligenceTable.HERO_HISTORY + " Text) ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DataContract.StrengthTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DataContract.AgilityTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DataContract.IntelligenceTable.TABLE_NAME);
        onCreate(db);
    }

    public void addDotaHeroStrength(StrengthHero strengthHero){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataContract.StrengthTable.HERO_NAME, strengthHero.getSheroName());
        values.put(DataContract.StrengthTable.HERO_URL, strengthHero.getSheroImageUrl());
        values.put(DataContract.StrengthTable.HERO_DESC, strengthHero.getSheroOverview());
     //   values.put(DataContract.StrengthTable.HERO_ROLE, strengthHero.getSheroRole());
        values.put(DataContract.StrengthTable.HERO_HISTORY, strengthHero.getSheroDetail());
        db.insert(DataContract.StrengthTable.TABLE_NAME,null,values);
        db.close();

    }

    public List<StrengthHero> getAllStrengthHero(){

        List<StrengthHero> strengthHeroList = new ArrayList<>();

        String query = "SELECT * FROM " + DataContract.StrengthTable.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){

            do {

                StrengthHero strengthHero = new StrengthHero();
                strengthHero.setSheroName(cursor.getString(1));
                strengthHero.setSheroImageUrl(cursor.getString(2));
                strengthHero.setSheroOverview(cursor.getString(3));
          //      strengthHero.setSheroRole(cursor.getString(4));
                strengthHero.setSheroDetail(cursor.getString(4));
                strengthHeroList.add(strengthHero);

            }while (cursor.moveToNext());

        }

        return strengthHeroList;

    }

    public void addDotaHeroAgility(AgilityHero agilityHero){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataContract.AgilityTable.HERO_NAME, agilityHero.getaHeroName());
        values.put(DataContract.AgilityTable.HERO_URL, agilityHero.getaHeroImageUrl());
        values.put(DataContract.AgilityTable.HERO_DESC, agilityHero.getaHeroOverview());
     //   values.put(DataContract.AgilityTable.HERO_ROLE, agilityHero.getaHeroRole());
        values.put(DataContract.AgilityTable.HERO_HISTORY, agilityHero.getaHeroDetail());
        db.insert(DataContract.AgilityTable.TABLE_NAME,null,values);
        db.close();

    }

    public List<AgilityHero> getAllAgilityHero(){

        List<AgilityHero> agilityHeroList = new ArrayList<>();

        String query = "SELECT * FROM " + DataContract.AgilityTable.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){

            do {

                AgilityHero agilityHero = new AgilityHero();
                agilityHero.setaHeroName(cursor.getString(1));
                agilityHero.setaHeroImageUrl(cursor.getString(2));
                agilityHero.setaHeroOverview(cursor.getString(3));
//                agilityHero.setaHeroRole(cursor.getString(4));
                agilityHero.setaHeroDetail(cursor.getString(4));
                agilityHeroList.add(agilityHero);

            }while (cursor.moveToNext());

        }

        return agilityHeroList;

    }

    public void addDotaHeroIntelligence(IntelligenceHero intelligenceHero){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataContract.IntelligenceTable.HERO_NAME, intelligenceHero.getiHeroName());
        values.put(DataContract.IntelligenceTable.HERO_URL, intelligenceHero.getiHeroImageUrl());
        values.put(DataContract.IntelligenceTable.HERO_DESC, intelligenceHero.getiHeroOverview());
     //   values.put(DataContract.IntelligenceTable.HERO_ROLE, intelligenceHero.getiHeroRole());
        values.put(DataContract.IntelligenceTable.HERO_HISTORY, intelligenceHero.getiHeroDetail());
        db.insert(DataContract.IntelligenceTable.TABLE_NAME,null,values);
        db.close();

    }

    public List<IntelligenceHero> getAllIntelligenceHero(){

        List<IntelligenceHero> intelligenceHeroList = new ArrayList<>();

        String query = "SELECT * FROM " + DataContract.IntelligenceTable.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){

            do {

                IntelligenceHero intelligenceHero = new IntelligenceHero();
                intelligenceHero.setiHeroName(cursor.getString(1));
                intelligenceHero.setiHeroImageUrl(cursor.getString(2));
                intelligenceHero.setiHeroOverview(cursor.getString(3));
        //        intelligenceHero.setiHeroRole(cursor.getString(4));
                intelligenceHero.setiHeroDetail(cursor.getString(4));
                intelligenceHeroList.add(intelligenceHero);

            }while (cursor.moveToNext());

        }

        return intelligenceHeroList;

    }

}
