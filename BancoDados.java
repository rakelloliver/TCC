package com.example.raquel.tccalfabetaja;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static android.database.sqlite.SQLiteDatabase.OPEN_READWRITE;
import static android.database.sqlite.SQLiteDatabase.openDatabase;

/**
 * Created by raquel on 17/09/17.
 */

public class BancoDados extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_CRIANCA= "bd_crianca";

    private static final String TABELA_CRIANCA = "tb_crianca";
    private static final String COLUNA_CODIGO = "codigo";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_IDADE = "idade";
    private static final String COLUNA_SENHA = "senha";

    private static String path = "";
    private Context context;
    private SQLiteDatabase sDB;




    public BancoDados(Context context) {
        super(context, BANCO_CRIANCA, null, VERSAO_BANCO);

        if(android.os.Build.VERSION.SDK_INT >= 17){
            path = context.getApplicationInfo().dataDir + "/databases/";
        }else{
            path = "/data/data/" + context.getPackageName() + "/databases/";
        }

        this.context = context;

    }



    public void create()throws IOException {
        boolean bancoExist = VerificaBD();

        if(bancoExist){

        }else{
            // criando um banco em branco
            this.getReadableDatabase();

            try{
                copiaBD();
            }catch (IOException  e){
                throw new Error("Erro ao copiar banco");
            }
        }
    }



    private boolean VerificaBD(){
        SQLiteDatabase verificaBD = null;
        try{
            String caminho = path + BANCO_CRIANCA;
            verificaBD = SQLiteDatabase.openDatabase(caminho,null, SQLiteDatabase.OPEN_READONLY);
        }catch (SQLiteException e){
            e.printStackTrace();
        }
        if(verificaBD != null){
            verificaBD.close();
        }
        return verificaBD != null ? true : false;
    }



    //Copiar banco para novo arquivo
    private void copiaBD()throws IOException{
        //cria um canal de entrada
        InputStream myInput = context.getAssets().open("bd_crianca");
        //estancia o endereço de canal de saida
        String saidaDados = path + "bd_crianca";

        OutputStream myOut = new FileOutputStream(saidaDados);

        // define tamanho de dados de transferencia
        byte[] buffer = new byte[1024];
        // cria variavel int para receber tamanho do arquivo bd na pasta assets em bytes
        int comprimento;
        while ((comprimento = myInput.read(buffer)) > 0){
            myOut.write(buffer, 0, comprimento);
        }
        myOut.flush();
        myOut.close();
        myInput.close();
    }


    public boolean abrir(){
        try{
            String meu_caminho = path + BANCO_CRIANCA;
            sDB = openDatabase(meu_caminho, null, OPEN_READWRITE);
            return true;
        }catch (SQLiteException sqle){
            sDB = null;
            return false;
        }
    }



    public synchronized void close(){
        if(sDB != null)
            sDB.close();
        super.close();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

