package boj;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 모음의 개수
 */

public class _1264 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String regex = "(?i)[aeiou]";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            String input = br.readLine();

            if (input.equals("#")) break;

            Matcher matcher = pattern.matcher(input);

            int occurrences = 0;
            while (matcher.find())
                occurrences++;

            bw.write(Integer.toString(occurrences));
            bw.newLine();
        }
        bw.flush();

        bw.close();
        br.close();
    }

}
