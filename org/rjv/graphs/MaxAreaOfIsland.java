package org.rjv.graphs;

import java.util.*;

class MaxAreaOfIsland {
    int curCount;
    int maxCount;
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        if( rows == 0 ) return 0;
        int cols = grid[ 0 ].length;
        maxCount = 0;
        
        for( int i = 0; i < rows; i ++ ) {
            for( int j = 0; j < cols; j ++ ) {
                curCount = 0;
                if( grid[ i ][ j ] == 1 ) {
                    getMax( grid, i , j, rows, cols );
                    maxCount = Math.max( maxCount, curCount );
                }
            }
        }
        
        return maxCount;
    }
    
    public void getMax( int[][] grid, int row, int col, int rowLength, int colLength ) {
        if( grid[ row ][ col ] == 1 ) { 
            curCount ++;
            grid[ row ][ col ] = 2;
        }
        else return;
        if( row - 1 >= 0 && grid[ row - 1 ][ col ] == 1 ) getMax( grid, row - 1, col, rowLength, colLength );
        if( col - 1 >= 0 && grid[ row ][ col - 1 ] == 1 ) getMax( grid, row, col - 1, rowLength, colLength );
        if( row + 1 < rowLength && grid[ row + 1 ][ col ] == 1 ) getMax( grid, row + 1, col, rowLength, colLength );
        if( col + 1 < colLength && grid[ row ][ col + 1 ] == 1 ) getMax( grid, row, col + 1, rowLength, colLength );
    }
}
