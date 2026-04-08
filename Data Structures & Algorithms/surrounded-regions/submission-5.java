class Solution {
    public void solve(char[][] board) {
        boolean[][] arr = new boolean[board.length][board[0].length];
        int m = board.length;
        int n = board[0].length;
        for(int  i = 0; i < m; i++){
            if(board[i][0] == 'O' && !arr[i][0]){
                dfs(i,0,arr,board);
            }
            if(board[i][n-1] == 'O' && !arr[i][n-1]){
                dfs(i,n-1,arr,board);
            }
        }
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O' && !arr[0][j]){
                dfs(0,j,arr,board);
            }
            if(board[m-1][j] == 'O' && !arr[m-1][j]){
                dfs(m-1,j,arr,board);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j]){
                    board[i][j] ='O';
                }else{
                    board[i][j] ='X';
                }
            }
        }
        
    }
    public void dfs(int i , int j , boolean[][] arr , char[][] board){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || arr[i][j]){
            return;
        }
        arr[i][j] = true;
        dfs(i+1,j,arr,board);
        dfs(i-1,j,arr,board);
        dfs(i,j+1,arr,board);
        dfs(i,j-1,arr,board);

    }
 }

