import java.util.ArrayList;
import java.util.List;

public class GridSearch {
    char[][] grid;
    boolean[][]visited;
    int[]dx=new int[]{0,-1,0,1};
    int[]dy=new int[]{-1,0,1,0};
    GridSearch(char[][]grid){
        this.grid=grid;
        visited=new boolean[grid.length][grid[0].length];
    }
    public List<int[]>location(String word){
        if(word==null)return null;
        if(word.length()==0)return null;
        List<int[]>path=new ArrayList<>();
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==word.charAt(0)){
                    visited[i][j]=true;           
                    path.add(new int[]{i,j});         
                    if(dfs(i,j,path,word,1))break;
                    visited[i][j]=false;
                    path.remove(path.size()-1);
                }
            }
        }
        return path;
    }
    public boolean dfs(int i,int j,List<int[]>path,String word,int index){
        if(index==word.length()){            
            return true;
        }
        int row=grid.length;
        int col=grid[0].length;
        for(int itr=0;itr<4;itr++){
            int new_i=i+dx[itr];
            int new_j=j+dy[itr];
            if(new_i>=0&&new_i<row&&new_j>=0&&new_j<col&&visited[new_i][new_j]==false&&grid[new_i][new_j]==word.charAt(index)){
                visited[new_i][new_j]=true;
                path.add(new int[]{new_i,new_j});
                if(dfs(new_i,new_j,path,word,index+1)){
                    return true;
                }
                path.remove(path.size()-1);    
                visited[new_i][new_j]=false;
            }
        }
        
        return false;
    }
}
