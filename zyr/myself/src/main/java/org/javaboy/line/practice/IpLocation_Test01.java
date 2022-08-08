package org.javaboy.line.practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IpLocation_Test01 {
    private static ArrayList<IpLocation> sortedIpLocations = new ArrayList<>();

    static {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("G:\\IdeaProject2\\Algorithm\\zyr\\algoritm\\src\\main\\java\\com\\douma\\data\\ip_location.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] temps = line.split(" ");
                IpLocation ipLocation = new IpLocation();
                ipLocation.startIp = ip2Score(temps[0]);
                ipLocation.endIp = ip2Score(temps[1]);
                ipLocation.locationCity = temps[2];
                sortedIpLocations.add(ipLocation);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException("解析 ip 地址库出错" + e);
        }

        Collections.sort(sortedIpLocations, new Comparator<IpLocation>() {
            @Override
            public int compare(IpLocation o1, IpLocation o2) {
                if (o1.startIp < o2.startIp) {
                    return -1;
                } else if (o1.startIp > o2.startIp) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public static void main(String[] args) {
        System.out.println(getIpLocation("202.102.156.211"));
    }

    public static String getIpLocation(String ipLocation) {
        Long score = ip2Score(ipLocation);
        int left = 0;
        int right = sortedIpLocations.size() - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            // 在 sortedIpLocations 中找到最后一个 startIp 小于等于 score 的这个 ip 段
            if (score >= sortedIpLocations.get(mid).startIp) {
                if (mid == sortedIpLocations.size() - 1 || score < sortedIpLocations.get(mid + 1).startIp) {
                    if (score <= sortedIpLocations.get(mid).endIp) {
                        return sortedIpLocations.get(mid).locationCity;
                    } else {
                        // bug 修复：
                        // 如果查询的 ip > (mid 对应 ip 段的 startIp) 且 ip < (mid + 1 对应 ip 段的 startIp)，
                        // 但是如果 ip > (mid 对应 ip 段的 endIp)
                        // 说明 ip 超出了 mid 对应的 ip 段，又不属于 mid + 1 对应 ip 段直接退出即可
                        break;
                    }
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // 将ip转成长整型
    public static Long ip2Score(String ip) {
        String[] temps = ip.split("\\.");
        Long score = 256 * 256 * 256 * Long.parseLong(temps[0])
                + 256 * 256 * Long.parseLong(temps[1])
                + 256 * Long.parseLong(temps[2])
                + Long.parseLong(temps[3]);
        return score;
    }

    private static class IpLocation {
        public long startIp;
        public long endIp;
        public String locationCity;
    }

}
