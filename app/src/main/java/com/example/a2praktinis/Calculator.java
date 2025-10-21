package com.example.a2praktinis;

public class Calculator {
    /**
     * Suskaičiuoja žodžių skaičių tekste.
     */
    public static int countWords(String text) {
        // Patikriname, ar tekstas tuščias ar null.
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        // trim() pašalina pradinius/galinius tarpus.
        // split("\\s+") atskiria pagal vieną ar daugiau tarpų.
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    /**
     * Suskaičiuoja rašybos ženklų (simbolių) skaičių tekste.
     * @param text Tekstas, kuriame skaičiuojami ženklai.
     * @return Ženklų skaičius.
     */
    public static int countCharacters(String text) {
        if (text == null) {
            return 0;
        }
        // Tiesiog grąžiname teksto ilgį.
        return text.length();
    }
}
