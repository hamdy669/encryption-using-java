/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

/**
 *
 * @author lenovo
 */
import java.util.*;
import javafx.beans.binding.StringBinding;
public class JavaApplication10 {

 


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String plaintext = scan.next();
        String key = scan.next();
        System.out.println(JavaApplication10.playf(plaintext, key));

    }

    public static String playf(String plaintext, String key) {
        String encrypted = "";
        StringBuilder st = new StringBuilder();
        StringBuilder newplaintext = new StringBuilder();
        st.append(key);

        char arr[][] = new char[5][5];
        char alpha;
        int c = 0, kpos1 = 0, jpos1 = 0, jpos2 = 0, kpos2 = 0;
        Boolean flag = true;
//edit keystring
        for (int i = 0; i < 26; i++) {
            alpha = (char) (97 + i);
            for (int j = 0; j < key.length(); j++) {

                if (alpha == st.charAt(j)) {
                    flag = false;
                    break;

                }
                if (alpha == 'j') {
                    flag = false;
                }
            }
            if (flag == true) {
                st.append(alpha);
            }
            flag = true;
        }
        //make matrix
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = st.charAt(c);
                c++;
                if (c == st.length()) {
                    break;
                }

            }
            if (c == st.length()) {
                break;
            }
        }
        //editplaintext  

        for (int i = 0; i < plaintext.length() - 1; i++) {
            if (plaintext.charAt(i) == plaintext.charAt(i + 1)) {
                newplaintext.append('x');
            } else {
                newplaintext.append(plaintext.charAt(i));
            }
            if ((i + 1) == plaintext.length() - 1) {
                newplaintext.append(plaintext.charAt(i + 1));
            }
        }
        if (newplaintext.length() % 2 != 0) {
            newplaintext.append('x');
        }
        //encrypted msg
        for (int i = 0; i < newplaintext.length(); i += 2) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (newplaintext.charAt(i) == arr[j][k]) {
                        jpos1 = j;
                        kpos1 = k;
                    }
                    if (newplaintext.charAt(i + 1) == arr[j][k]) {
                        jpos2 = j;
                        kpos2 = k;
                    }

                }
            }

            if (jpos1 == jpos2) {
                if ((kpos1 + 1) == 5) {
                    encrypted += arr[jpos1][0];
                } else {
                    encrypted += arr[jpos1][kpos1 + 1];
                }
                if ((kpos2 + 1 == 5)) {
                    encrypted += arr[jpos2][kpos2 + 1];
                } else {
                    encrypted += arr[jpos2][kpos2 + 1];
                }
            } else if (kpos1 == kpos2) {
                if ((jpos1+1==5))
                    encrypted += arr[0][kpos1];
                else
                encrypted += arr[jpos1 + 1][kpos1];
                if ((jpos2+1==5))
                encrypted += arr[0][kpos2];else
                    
                encrypted += arr[jpos2 + 1][kpos2];
            }
            if (jpos1 != jpos2 && kpos1 != kpos2) {
                encrypted += arr[jpos1][kpos2];
                encrypted += arr[jpos2][kpos1];
            }

            jpos1 = jpos2 = kpos1 = kpos2 = 0;
        }
        return encrypted;
    }

}
