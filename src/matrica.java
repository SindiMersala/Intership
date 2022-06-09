
public class matrica {
    public static void main(String[] args){
        int[][] m={ {1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int r=0;
        int v[]=new int[m.length-1];
        int s[]=new int[m[r].length-1];
        int g[]=new int[m.length-2];


        int k=0;
        int l=0;
        int f=0;
        for(int i=0;i<1;i++){
            for(int j=0;j<m[i].length;j++){

                System.out.print(m[i][j]);

            }}
        for(int i=1;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){
                if(j==m[i].length-1){
                    v[k++]=m[i][j];
                }
            }
        }
        for(k=0;k<v.length;k++){
            System.out.print(v[k]);
        }
        for(int i=m.length-1;i<m.length;i++){
            for(int j=m[i].length-2;j>=0;j--){
                s[l++]=m[i][j];
            }
        }
        for(l=0;l<s.length;l++){
            System.out.print(s[l]);
        }

        for(int i=m.length-2;i>0;i--){
            for(int j=0;j<m[i].length-2;j++){
                if(j==0){
                    g[f++]=m[i][j];
                }

            }
        }
        for(f=0;f<g.length;f++){
            System.out.print(g[f]);
        }
        for(int i=1;i<m.length-1;i++){
            for(int j=1;j<m[i].length-1;j++){
                if(i%2==1){
                    System.out.print(m[i][j]);
                }

            }
        }
        for(int i=1;i<m.length-1;i++){
            for(int j=m[i].length-2;j>0;j--){
                if(i%2==0){
                    System.out.print(m[i][j]);
                }

            }
        }

    }}