package com.example.support;

import java.util.HashMap;
import java.util.Map;

public final class Dictionary {
    private final char[] characters = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };

    private final String[] code = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    private final HashMap<Character, String> dictionary;

    public Dictionary() {
        this.dictionary = new HashMap<>();

        for (int i = 0; i < characters.length; i++) {
            this.dictionary.put(characters[i], code[i]);
        }
    }

    public String getMorseCode(char character) {
        return this.dictionary.get(character);
    }

    public Character getCharacter(String morseCode) {
        return this.dictionary
                .entrySet()
                .stream()
                .filter(entry -> morseCode.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
