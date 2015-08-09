import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return tryToRestoreIp(s, 4);
    }

    List<String> tryToRestoreIp(String ipString, int limit) {
        StringBuilder s = new StringBuilder(ipString);
        List<String> result = new ArrayList<>();
        if (limit > 4 || limit < 1 || s.length() < limit || s.length() > limit * 3) return result;
        if (limit == 1) {
            int test = Integer.parseInt(ipString);
            if (test >= 0 && test <= 255 && String.valueOf(test).equals(ipString)) result.add(s.toString());
            return result;
        }
        int prefix = 0;
        switch (s.charAt(0)) {
            case '0':
                s.deleteCharAt(0);
                result.addAll(appendStringList(0, tryToRestoreIp(s.toString(), limit - 1)));
                return result;
            case '1':
            case '2':
                prefix = s.charAt(0) - '0';
                s.deleteCharAt(0);
                result.addAll(appendStringList(prefix, tryToRestoreIp(s.toString(), limit - 1)));
            default:
                prefix = prefix * 10 + s.charAt(0) - '0';
                s.deleteCharAt(0);
                result.addAll(appendStringList(prefix, tryToRestoreIp(s.toString(), limit - 1)));
                if (s.length() > 0) {
                    prefix = prefix * 10 + s.charAt(0) - '0';
                    if (prefix <= 255) {
                        s.deleteCharAt(0);
                        result.addAll(appendStringList(prefix, tryToRestoreIp(s.toString(), limit - 1)));
                    }
                }
        }
        return result;
    }

    List<String> appendStringList(int prefix, List<String> list) {
        String pre = String.valueOf(prefix) + ".";
        List<String> newList = new ArrayList<>();
        for (String str : list) {
            newList.add(pre + str);
        }
        return newList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] cases = {"8888", "25525511135", "1141141111", "101023", "0000", "255255255255", "2552552550", "25502550", "256123", "172162541"};

        for (String caseStr : cases) {
            List<String> list = s.restoreIpAddresses(caseStr);
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println("===========");
        }
    }
}
