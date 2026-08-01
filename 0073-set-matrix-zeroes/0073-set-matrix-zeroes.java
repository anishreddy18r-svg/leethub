class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean fR=false;
        boolean fC=false;

        for(int i=0;i<m;i++){
            if(matrix[i][0]==0) fC=true;
        }
        for(int j=0;j<n;j++){
            if(matrix[0][j]==0) fR=true;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(fR){
            for(int j=0;j<n;j++) matrix[0][j]=0;
        }
        if(fC){
            for(int i=0;i<m;i++) matrix[i][0]=0;
        }

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna