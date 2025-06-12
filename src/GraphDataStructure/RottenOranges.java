package GraphDataStructure;
import java.util.*;

class Pair{
    int row;
    int col;
    int time;
    public Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
public class RottenOranges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int freshCount=0;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 2){
                    q.add(new Pair(i, j,0));
                }
                else if(matrix[i][j] == 1){
                    freshCount++;
                }
            }
        }
        int elapsedTime = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row=p.row;
            int col=p.col;
            int time=p.time;
            elapsedTime=time;
            int x[]={-1,1,0,0};
            int y[]={0,0,1,-1};
            for(int i=0;i<4;i++){
                int newRow=row+x[i];
                int newCol=col+y[i];
                if(newRow>=0 && newRow<matrix.length && newCol>=0 && newCol<matrix[0].length && matrix[newRow][newCol]==1){
                    matrix[newRow][newCol]=2;
                    freshCount--;
                    q.add(new Pair(newRow,newCol,time+1));
                }
            }
        }
        if(freshCount==0){
            System.out.println(elapsedTime);
        }
        else{
            System.out.println(freshCount);
        }
    }
}
