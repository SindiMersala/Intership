import java.util.ArrayList;

public class dictonary {

    public static void main(String[] args) {

        ArrayList<String> dictonary = new ArrayList<>();
        dictonary.add("ptolemaic");
        dictonary.add("retrograde");
        dictonary.add("supplant");
        dictonary.add("undulate");
        dictonary.add("xenoepist");
        dictonary.add("asymptote");
        dictonary.add("babka");
        dictonary.add("banoffee");
        dictonary.add("engender");
        dictonary.add("karpatka");
        dictonary.add("othellolagkage");

        String a = find(dictonary);
        int index = binarySearch(dictonary, a, 0, dictonary.size());
        System.out.println(index);
    }

    public static int binarySearch(ArrayList<String> dictonary, String a, int start, int end) {

        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (dictonary.get(mid).compareTo(a)<0)
            return binarySearch(dictonary, a, mid + 1, end);
        else if(dictonary.get(mid).compareTo(a)>0)
            return binarySearch(dictonary, a, mid, end+1);
        else
            return mid;
    }



    public static String find(ArrayList<String> dictonary){
        String a="";
        for(int i=0;i<dictonary.size();i++){
            if(dictonary.get(i).charAt(0)=='a'){
                a= dictonary.get(i);
                break;
            }
        }
        return a;
    }
}
