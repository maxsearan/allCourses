import java.util.Arrays;
public class drawing {

   
    public static void main(String[] args) {
        
        int[][] drawArray=
        {{0,0,1,0,0},{0,1,1,1,0},{1,1,1,1,1},{0,1,1,1,0},{0,0,1,0,0}};
            
        
        
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if (drawArray[i][j]==1)
        System.out.print(" *");
                else System.out.print("  ");
            }
            System.out.print("\n");  
        }
        
    }
    
}
