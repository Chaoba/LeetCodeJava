package com.mushuichuan.LeetAlgorithms;

import com.mushuichuan.beans.Node;

/**
 * 6. ZigZag Conversion  QuestionEditorial Solution  My Submissions
 * Total Accepted: 97721
 * Total Submissions: 395538
 * Difficulty: Easy
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Algorithm6 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int index = 0;
        int tagNum = numRows - 1;
        boolean add = true;
        char[] chars = s.toCharArray();
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        for (int i = 0; i < chars.length; i++) {
            builders[index].append(chars[i]);
            if (index == 0) {
                add = true;
            } else if (index == tagNum) {
                add = false;
            }
            index = add ? index + 1 : index - 1;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (builders[i].length() != 0) {
                result.append(builders[i]);
            }
        }
        return result.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        Node[] lists = new Node[numRows];
        Node[] tails = new Node[numRows];
        char[] chars = s.toCharArray();
        int index = 0;
        int tagNum = numRows - 1;
        boolean add = true;
        for (int i = 0; i < chars.length; i++) {
            Node node = new Node(chars[i]);
            if (lists[index] == null) {
                lists[index] = node;
                tails[index] = node;
            } else {
                tails[index].next = node;
                tails[index] = node;
            }
            if (index == 0) {
                add = true;
            } else if (index == tagNum) {
                add = false;
            }
            index = add ? index + 1 : index - 1;
        }
        char[] result = new char[chars.length];
        int j = 0;
        for (int i = 0; i < numRows; i++) {
            while (lists[i] != null) {
                result[j++] = lists[i].value;
                lists[i] = lists[i].next;
            }
        }
        return String.valueOf(result);
    }
}
