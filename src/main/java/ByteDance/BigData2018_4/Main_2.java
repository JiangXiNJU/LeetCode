package ByteDance.BigData2018_4;

/**
 * Created by cycy on 2018/8/24.
 */
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_2 {
    public static int getlen(int[] pos) {
        return pos[1] - pos[0] + 1;
    }

    public static int getinterval(int[] pos1, int[] pos2) {
        return pos2[0] - pos1[1] - 1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        scan.nextLine();
        String str = scan.nextLine();

        ArrayList<int[]>[] pos = new ArrayList[2];
        for (int i = 0; i < 2; i++)
            pos[i] = new ArrayList<int[]>();

        char tmp = str.charAt(0);
        int f = 0, b = 0;
        for (int i = 1; i < n; i++) {
            if (str.charAt(i) == tmp) b++;
            else {
                int[] t = {f, b};
                pos[tmp - 'a'].add(t);
                tmp = str.charAt(i);
                f = b = i;
            }
        }
        int[] t = {f, b};
        pos[tmp - 'a'].add(t);

        int max = 2;
        for (int i = 0; i < 2; i++) {
            int max_i = 0;
            if (pos[i].size() > 0) {
                max_i = getlen(pos[i].get(0));
                int start = 0, end = 1, tmp_m = m;
                while (end < pos[i].size() && tmp_m >= 0) {
                    tmp_m -= getinterval(pos[i].get(end - 1), pos[i].get(end));
                    max_i += getinterval(pos[i].get(end - 1), pos[i].get(end)) + getlen(pos[i].get(end));
                    end++;
                }
                end--;
                if (tmp_m < 0) {
                    tmp_m += getinterval(pos[i].get(end - 1), pos[i].get(end));
                    max_i -= getinterval(pos[i].get(end - 1), pos[i].get(end)) + getlen(pos[i].get(end));
                    end--;
                }
                int tmp_max = max_i;
                while (end < pos[i].size() - 1) {
                    int delta = getinterval(pos[i].get(end), pos[i].get(end + 1));
                    if (tmp_m < delta) {
                        while (tmp_m < delta && start < end) {
                            tmp_max -= getlen(pos[i].get(start)) + getinterval(pos[i].get(start), pos[i].get(start + 1));
                            tmp_m += getinterval(pos[i].get(start), pos[i].get(start + 1));
                            start++;
                        }
                        if (tmp_m < delta) {
                            tmp_max = getlen(pos[i].get(end + 1));
                            start = end = end + 1;
                            tmp_m = m;
                        } else {
                            tmp_max += getlen(pos[i].get(end + 1)) + getinterval(pos[i].get(end), pos[i].get(end + 1));
                            tmp_m -= delta;
                            end++;
                        }
                    } else {
                        tmp_max += getlen(pos[i].get(end + 1)) + getinterval(pos[i].get(end), pos[i].get(end + 1));
                        tmp_m -= delta;
                        end++;
                    }
                    if (tmp_max > max_i) max_i = tmp_max;
                }

            }
            if (max < max_i) max = max_i;
        }
        out.println(max);
    }
}

