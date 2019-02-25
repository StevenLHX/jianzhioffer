package com.program.solution;

/**
 * 矩阵中的路径
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串”bcced”的路径，但是矩阵中不包含”abcb”路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class PathIn2DMatrix {
    /**
     * @param matrix 输入矩阵
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param str 待搜索的字符串
     * @return  true存在路径，false不存在路径
     */
    public static boolean hasPath(char[] matrix,int rows,int cols,char[] str){
        if (matrix==null||matrix.length==0||matrix.length!=rows*cols||str==null||str.length==0){
            return false;
        }
        //初始化访问标记矩阵
        boolean[] visited=new boolean[rows*cols];
        for (int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        //以每个起点为起始点进行搜索
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (hasPathCore(matrix,rows,cols,str,0,i,j,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯搜索算法
     * @param matrix 输入矩阵
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param str 待搜索的字符串
     * @param index 已经处理str中字符个数
     * @param row 当前处理的行数
     * @param col 当前处理的列数
     * @param visited 访问标记数组
     * @return true 存在路径， false 不存在路径
     */
    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int index, int row, int col, boolean[] visited) {
        if (index>=str.length){
            return true;
        }
        boolean hasPath=false;
        //推断位置是否合法
        if (row>=0&&row<rows&&col>=0&&col<cols&&matrix[row*cols+col]==str[index]&&!visited[row*cols+col]){
            visited[row*cols+col]=true;
            //按左上右下进行搜索
            hasPath=hasPathCore(matrix,rows,cols,str,index+1,row,col-1,visited)||
                    hasPathCore(matrix,rows,cols,str,index+1,row-1,col,visited)||
                    hasPathCore(matrix,rows,cols,str,index+1,row,col+1,visited)||
                    hasPathCore(matrix,rows,cols,str,index+1,row+1,col,visited);
            //回溯
            if (!hasPath){
                visited[row*cols+col]=false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        System.out.println(hasPath("abcesfcsadee".toCharArray(),3,4,"bcced".toCharArray()));
    }
}
