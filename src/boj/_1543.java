package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문서 검색
 */

public class _1543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String target = br.readLine();

        br.close();

        System.out.println(search(document, target));
    }

    public static int search(String document, String target) {
        Pattern pattern = Pattern.compile(target);
        Matcher matcher = pattern.matcher(document);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }

}
