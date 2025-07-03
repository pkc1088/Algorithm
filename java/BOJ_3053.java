import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double r = Double.parseDouble(st.nextToken());
        bw.write(String.format("%.6f", (double)r*r*3.14159265358979323846));
        bw.newLine();
        bw.write(String.format("%.6f", (double)r*r*2.000000));


        bw.flush();
        bw.close();
    }
}

