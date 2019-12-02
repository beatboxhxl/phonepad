package com.antra.phonepad.combination.service;

import com.antra.phonepad.combination.util.DictionarySet;
import com.antra.phonepad.combination.util.PhoneNumberPad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PhonePadServiceImpl implements PhonePadService{

    private String[] PHONE_PAD = PhoneNumberPad.getPAD();
    private static Set<String> dict = DictionarySet.getDict();

    @Override
    public List<String> findAllCombinations(String input) {
        List<String> res = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        helper(input, 0, sb, res);
        return res;
    }

    @Override
    public List<String> findAllEnglishWords(String str) {
        List<String> allComb = findAllCombinations(str);
        return allComb.stream().filter(comb -> dict.contains(comb)).collect(Collectors.toList());
    }

    private void helper(String digits, int level, StringBuilder sb, List<String> res) {
        if (level == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(level);
        if (Character.isLetter(c)) {
            sb.append(c);
            helper(digits, level + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            String curStr = PHONE_PAD[digits.charAt(level) - '0'];
            for (int i = 0; i < curStr.length(); i++) {
                sb.append(curStr.charAt(i));
                helper(digits, level + 1, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
