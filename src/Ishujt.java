public class Ishujt {
    public static void main(String[] args){
        char[][] grid={
                {'1','1','1','1','0'},
                {'0','0','1','1','0'},
                {'1','1','0','1','0'},
                {'0','0','0','1','0'}
        };
        System.out.print(numIslands(grid));
    }



    public static int numIslands(char[][] grid) {

        int nriishujve=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    kufijte(grid,i,j);
                    nriishujve++;
                }
            }
        }
        return nriishujve;
    }
    public static void kufijte(char grid[][],int i,int j) {

        grid[i][j]='2';
        if(i+1<grid.length && grid[i+1][j]=='1'){
            kufijte(grid,i+1,j);
        }
        if(i-1>=0 && grid[i-1][j]=='1'){
            kufijte(grid,i-1,j);
        }
        if(j-1>=0 && grid[i][j-1]=='1'){
            kufijte(grid,i,j-1);
        }
        if(j+1<grid[0].length&&grid[i][j+1]=='1'){
            kufijte(grid,i,j+1);
        }

    }

}

