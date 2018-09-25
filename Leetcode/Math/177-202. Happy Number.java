class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1){
            n = nextNumber(n);
            if(set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }
    
    private int nextNumber(int num){        
        int res = 0;
        while(num != 0){å
            res += (num % 10) * (num % 10);
            num = num / 10;
        }
        return res;
    }
}