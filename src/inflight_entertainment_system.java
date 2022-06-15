import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class inflight_entertainment_system {
    public static void main(String[] args){
        Scanner k= new Scanner(System.in);
        System.out.println("Put how many minutes the flight is: ");

        int input=k.nextInt();
        int flight_length=input;
        List<Integer> movies=new ArrayList<>();
        movies.add(30);
        movies.add(40);
        movies.add(20);
        movies.add(60);
        movies.add(100);
        if(length(movies,flight_length)==true){
            System.out.println("There are two movies");}
        else{
            System.out.println("There are not two movies");}


    }
    public static boolean length(List k,int length_){

        int[][] m=new int[10][10];
        boolean n=false;
        int j=0;
        for(int i=0;i<k.size();i++){

            m[0][i]= (int) k.get(i);

        }

        for(int l=0;l<k.size();l++){
            for(int f=0;f<k.size();f++){
                if((m[l][f]+m[l][f+1])==length_ && l!=f+1){
                    n=true;
                    break;
                }
            }
        }
        return n;
    }
}

