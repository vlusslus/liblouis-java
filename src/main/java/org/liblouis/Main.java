package org.liblouis;

import java.io.File;
import java.io.IOException;

/**
 * Created by vlusslus on 11.03.2016.
 */
public class Main {


    public static void main(String[] args) {


        File libPath = new File("liblouis\\liblouis.dll");
        Louis.setLibraryPath(libPath);

        Louis.LouisLibrary library = Louis.getLibrary();

        System.out.print(library.lou_version());

        try{
            String table;
            try {
                table = new File("liblouis\\ru.ctb").getCanonicalPath();
                Translator translator = new Translator(table);
                try {
                    byte[] hypPos = translator.hyphenate(new String("Это текст - с дефисом"));
                } catch (TranslationException te) {
                    System.err.print(te.getMessage());
                }
            }catch (IOException ioe) {
                System.out.print(ioe.getMessage());
            }
            //Translator translator = new Translator(table);
        } catch (CompilationException ce) {
            System.out.print(ce.getMessage());
        }


    }
}

