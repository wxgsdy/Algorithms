class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        
        if (colors == null || colors.length == 0) return;
        sort(colors, 0, colors.length - 1, 1, k);      
    }

    private void sort(int[] colors,
                      int startIndex,
                      int endIndex,
                      int startColor, 
                      int endColor){

        int midk = (startColor + endColor) / 2;
        int i = startIndex, j = endIndex;
        while(i <= j){

            while(i <= j && colors[i] <= midk){
                i++;
            }

            while(i <= j && colors[j] > midk){
                j--;
            }

            // swap
            if(i <= j){
                int temp = colors[i];
                colors[i] = colors[j];
                colors[j] = temp;
                i++; j--;
            }            
        }

        sort(colors, startIndex, j, startColor, midk);
        sort(colors, i, endIndex, midk + 1, endColor);
        



    }
    
    
}