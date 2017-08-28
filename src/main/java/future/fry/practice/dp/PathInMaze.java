package future.fry.practice.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Find paths from corner cell to middle cell in maze
 *
 * @author ranjeet
 */
public class PathInMaze {

    /*
    Given a square maze containing positive numbers, 
    find all paths from a corner cell (any of the extreme four corners) to the middle cell. 
    We can move exactly n steps from a cell in 4 directions i.e. 
    North, East, West and South where n is value of the cell,

    We can move to mat[i+n][j], mat[i-n][j], mat[i][j+n], and mat[i][j-n] 
    from a cell mat[i][j] where n is value of mat[i][j].
     */
 /*
    Input:  9 x 9 maze
[ 3, 5, 4, 4, 7, 3, 4, 6, 3 ]
[ 6, 7, 5, 6, 6, 2, 6, 6, 2 ]
[ 3, 3, 4, 3, 2, 5, 4, 7, 2 ]
[ 6, 5, 5, 1, 2, 3, 6, 5, 6 ]
[ 3, 3, 4, 3, 0, 1, 4, 3, 4 ]
[ 3, 5, 4, 3, 2, 2, 3, 3, 5 ]
[ 3, 5, 4, 3, 2, 6, 4, 4, 3 ]
[ 3, 5, 1, 3, 7, 5, 3, 6, 4 ]
[ 6, 2, 4, 3, 4, 5, 4, 5, 1 ]
     */
 /*
    Output:
(0, 0) -> (0, 3) -> (0, 7) -> 
(6, 7) -> (6, 3) -> (3, 3) -> 
(3, 4) -> (5, 4) -> (5, 2) -> 
(1, 2) -> (1, 7) -> (7, 7) ->
(7, 1) -> (2, 1) -> (2, 4) -> 
(4, 4) -> MID
     */
    public static void main(String[] args) {
        int[][] maze
                = {
                    {3, 5, 4, 4, 7, 3, 4, 6, 3},
                    {6, 7, 5, 6, 6, 2, 6, 6, 2},
                    {3, 3, 4, 3, 2, 5, 4, 7, 2},
                    {6, 5, 5, 1, 2, 3, 6, 5, 6},
                    {3, 3, 4, 3, 0, 1, 4, 3, 4},
                    {3, 5, 4, 3, 2, 2, 3, 3, 5},
                    {3, 5, 4, 3, 2, 6, 4, 4, 3},
                    {3, 5, 1, 3, 7, 5, 3, 6, 4},
                    {6, 2, 4, 3, 4, 5, 4, 5, 1}
                };
        
        PathInMaze pathInMaze = new PathInMaze();
        pathInMaze.findMidPath(maze);

    }

    private void findMidPath(int[][] maze) {
        int N = maze[0].length;
        boolean[][] visited = new boolean[N][N];
        List<Path> paths = new ArrayList<>();
        midPathUtil(maze, visited, paths, 0, 0);
    }

    private void midPathUtil(int[][] maze, boolean[][] visited, List<Path> paths, int i, int j) {

        visited[i][j] = true;
        paths.add(new Path(i, j));
        int N = maze[0].length;
        if (i == N / 2 && j == N / 2) {
            System.out.println("Found path");

            paths.forEach(System.out::println);
            return;
        }
        int n = maze[i][j]; //get the value of current cell
        //find in all directions
        //mat[i+n][j], mat[i-n][j], mat[i][j+n], and mat[i][j-n] from a cell mat[i][j]
        //north
        if (isSafe(maze, i - n, j) && !visited[i - n][j]) {
            midPathUtil(maze, visited, paths, i - n, j);
        }

        //south
        if (isSafe(maze, i, j + n) && !visited[i][j + n]) {
            midPathUtil(maze, visited, paths, i, j + n);

        }
        //east
        if (isSafe(maze, i + n, j) && !visited[i + n][j]) {
            midPathUtil(maze, visited, paths, i + n, j);

        }
        //west
        if (isSafe(maze, i, j - n) && !visited[i][j - n]) {
            midPathUtil(maze, visited, paths, i, j - n);

        }

        paths.remove(new Path(i, j));

    }

    private boolean isSafe(int[][] maze, int i, int j) {
        int N = maze[0].length;

        return i >= 0 && i < N && j >= 0 && j < N;
    }

    private static class Path {

        int i;
        int j;

        public Path(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 23 * hash + this.i;
            hash = 59 * hash + this.j;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Path other = (Path) obj;
            if (this.i != other.i) {
                return false;
            }
            return this.j == other.j;
        }

        @Override
        public String toString() {
            return "Path{" + "i=" + i + ", j=" + j + '}';
        }

    }
}
