public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numberToWords(0));
        System.out.println(s.numberToWords(12));
        System.out.println(s.numberToWords(68));
        System.out.println(s.numberToWords(123));
        System.out.println(s.numberToWords(999));
        System.out.println(s.numberToWords(805));
        System.out.println(s.numberToWords(613));

        System.out.println(s.numberToWords(12345));
        System.out.println(s.numberToWords(1234567));

        System.out.println(s.numberToWords(2147483647));

        System.out.println(s.numberToWords(1000010));
    }

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        sb.append(simpleNumberToWords(num % 1000));
        num /= 1000;
        if(num > 0) {
            sb.insert(0, complexNumberToWords(num, "Thousand"));
            num /= 1000;
        }
        if(num > 0) {
            sb.insert(0, complexNumberToWords(num, "Million"));
            num /= 1000;
        }
        if(num > 0) {
            sb.insert(0, complexNumberToWords(num, "Billion"));
            num /= 1000;
        }
        if(num > 0) {
            sb.insert(0, complexNumberToWords(num, "Trillion"));
        }

        return sb.toString().trim();
    }

    public String complexNumberToWords(int num, String base){
        num %= 1000;
        if(num > 0) {
            return simpleNumberToWords(num) + base + " ";
        }
        return "";
    }

    public String simpleNumberToWords(int num) {
        switch(num){
            case 0:
                return "";
            case 1:
                return "One ";
            case 2:
                return "Two ";
            case 3:
                return "Three ";
            case 4:
                return "Four ";
            case 5:
                return "Five ";
            case 6:
                return "Six ";
            case 7:
                return "Seven ";
            case 8:
                return "Eight ";
            case 9:
                return "Nine ";
            case 10:
                return "Ten ";
            case 11:
                return "Eleven ";
            case 12:
                return "Twelve ";
            case 13:
                return "Thirteen ";
            case 14:
                return "Fourteen ";
            case 15:
                return "Fifteen ";
            case 16:
                return "Sixteen ";
            case 17:
                return "Seventeen ";
            case 18:
                return "Eighteen ";
            case 19:
                return "Nineteen ";
            case 20:
                return "Twenty ";
            case 30:
                return "Thirty ";
            case 40:
                return "Forty ";
            case 50:
                return "Fifty ";
            case 60:
                return "Sixty ";
            case 70:
                return "Seventy ";
            case 80:
                return "Eighty ";
            case 90:
                return "Ninety ";
        }
        if(num >= 100) {
            return simpleNumberToWords(num / 100) + "Hundred " + simpleNumberToWords(num % 100);
        }
        return simpleNumberToWords(num / 10 * 10) + simpleNumberToWords(num % 10);
    }
}
