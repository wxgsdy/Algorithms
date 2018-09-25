// Method 1 :
class Solution {
    
    public String intToRoman(int num) {        
        String thousand[] = new String[]{"", "M", "MM", "MMM"};
        String hundrad[] = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String ten[] = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String unit[] = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return "" + thousand[num/1000] + hundrad[num % 1000 / 100] + ten[num % 100 / 10] + unit[num % 10];
    }
}

// Method 2:
class Solution {
    
    public String intToRoman(int num) {
        String[] symbols= new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX" ,"V","IV" ,"I"};
        int[] values = new int[]{1000, 900, 500, 400,   100, 90,   50,  40,   10,   9,   5,  4,  1};
        
        String res = "";
        int i = 0;
        while(num > 0){
            while(i < values.length && num >= values[i]){
                num -= values[i];
                res += symbols[i];
            }
            i++;
        }
        return res;

    }
}