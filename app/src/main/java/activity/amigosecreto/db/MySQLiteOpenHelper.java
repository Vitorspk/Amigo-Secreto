package activity.amigosecreto.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by HP on 21/06/2015.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String TABLE_DESEJO = "desejo";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PRODUTO = "produto";
    public static final String COLUMN_CATEGORIA = "categoria";
    public static final String COLUMN_PRECO_MINIMO = "preco_minimo";
    public static final String COLUMN_PRECO_MAXIMO = "preco_maximo";
    public static final String COLUMN_LOJAS = "lojas";

    private static final String DATABASE_NAME = "lista_desejo_db";
    private static final int DATABASE_VERSION = 1;

    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sql = new StringBuilder();
        sql.append("create table " + TABLE_DESEJO + "(");
        sql.append(COLUMN_ID + " int primary key, ");
        sql.append(COLUMN_PRODUTO + " varchar not null, ");
        sql.append(COLUMN_CATEGORIA + " varchar, ");
        sql.append(COLUMN_PRECO_MINIMO + " decimal not null, ");
        sql.append(COLUMN_PRECO_MAXIMO + " decimal not null, ");
        sql.append(COLUMN_LOJAS + " varchar not null");
        sql.append(")");
        db.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteOpenHelper.class.getName(),
                "Atualizando banco de dados da versao " + oldVersion + " para a versao "
                        + newVersion + ". Todos os dados serao apagados!");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DESEJO);
        onCreate(db);
    }
}

