package ce;

import java.util.*;
import javafx.beans.binding.StringBinding;

public class Ce {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String plaintext = scan.next();
        int key = scan.nextInt();
     

    }

      public static String caesar(String plaintext, int key) {
        key = key % 26;
        String encrypted = "";
        char c;
        for (int i = 0; i < plaintext.length(); i++) {
            c = (char) (plaintext.charAt(i) + key);
            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c)) {
                    if (c > 'Z') {
                        c -= 26;
                    }
                } else {
                    if (c > 'z') {
                        c -= 26;
                    }

                }
            } else {
                c -= key;
            }
            encrypted += c;
        }
        return encrypted;
    }
}
