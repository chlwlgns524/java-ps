package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 팰린드롬수
 */
public class _1259 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String number = br.readLine();

            if (number.equals("0"))
                break;

            if (isPalindrome(number))
                bw.write("yes");
            else
                bw.write("no");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isPalindrome(String number) {
        int first = 0;
        int last = number.length() - 1;

        while (first < last) {
            if (number.charAt(first) != number.charAt(last))
                return false;
            first++;
            last--;
        }

        return true;
    }

}
