package com.antra.phonepad.combination.util;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DictionarySet {
    private static Set<String> dict;
    private DictionarySet() {
        try {
            String fileName = "dictionary";
            Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
            Stream<String> lines = Files.lines(path);
            List<String> data = lines.collect(Collectors.toList());
            lines.close();
            dict = new HashSet<>(data);
        } catch (IOException | URISyntaxException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    public static Set<String> getDict() {
        if (dict == null) {
            new DictionarySet();
        }
        return dict;
    }
}
