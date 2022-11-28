package boj;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contact
 */
public class _1013 {

    private final static String MATCHED = "YES";
    private final static String NON_MATCHED = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        String regex = "(100+1+|01)+";
        Pattern pattern = Pattern.compile(regex);

        while (T-- > 0) {
            String input = br.readLine();

            Matcher matcher =  pattern.matcher(input);

            if (matcher.matches())
                bw.write(MATCHED);
            else
                bw.write(NON_MATCHED);
            bw.newLine();
        }
        bw.flush();

        bw.close();
        br.close();
    }

}
