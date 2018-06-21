import static java.lang.System.out;

/**
 * Created by cycy on 2018/4/4.
 */
public class Main_reOrderArray {
    public void reOrderArray(int [] array) {
        int len=array.length;
        int[] even=new int[len];
        int lenofeven=0;
        int lenofodd=0;
        int index=0;
        while(index<len){
            if(array[index]%2==0){
                even[lenofeven++]=array[index];
            }
       else{
                array[lenofodd++]=array[index];
            }
            index++;
        }
        System.arraycopy(even,0,array,lenofodd,lenofeven);
    }
    public static void main(String[] args){
        Main_reOrderArray tmp=new Main_reOrderArray();
        int [] array={2,2,2,2};
        tmp.reOrderArray(array);
        for(int i=0;i<array.length;i++){
            out.print(array[i]+" ");
        }
    }
}
