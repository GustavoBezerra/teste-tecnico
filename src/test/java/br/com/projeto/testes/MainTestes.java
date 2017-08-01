package br.com.projeto.testes;

import java.util.Random;
import java.util.UUID;

/**
 * @author Gustavo de Souza Bezerra <gustavo.bezerra@hotmail.com>
 * @date 01/08/2017
 */
public class MainTestes {

    protected static String getStringAleatoria(int tamanho) {
        String possiveisCaracteres = "ABCDEFGHIJKLMNOPQRSTUVYWXZ0123456789";
        Random random = new Random();
        int index;
        String textoFinal = "";
        
        for (int i = 0; i < tamanho; i++) {
            index = random.nextInt(possiveisCaracteres.length());
            textoFinal += possiveisCaracteres.charAt(index);
        }
        return textoFinal;
    }

}
