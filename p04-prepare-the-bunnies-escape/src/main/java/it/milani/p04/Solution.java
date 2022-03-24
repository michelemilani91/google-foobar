package it.milani.p04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

class Point {
    final int x;
    final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

public class Solution {

    private static final int[] X = {0, 0, 1, -1};
    private static final int[] Y = {1, -1, 0, 0};

    public static int solution(int[][] map) {
        final int row = map.length;
        final int col = map[0].length;
        final int[][] forward = bfs(map, row, col, 0, 0);
        final int[][] backward = bfs(map, row, col, row - 1, col - 1);

        int minPathLength = Integer.MAX_VALUE;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (forward[i][j] > 0 && backward[i][j] > 0) {
                    minPathLength = Math.min(minPathLength, forward[i][j] + backward[i][j] - 1);
                }
            }
        }
        return minPathLength;

    }

    private static int[][] bfs(int[][] map, int row, int col, int xx, int yy) {
        final Queue<Point> visitedPoints = new LinkedList<>();
        visitedPoints.add(new Point(xx, yy));

        final int[][] distance = IntStream.range(0, row)
                .mapToObj(x -> IntStream.range(0, col).map(y -> 0).toArray())
                .toArray(int[][]::new);
        distance[xx][yy] = 1;

        while (!visitedPoints.isEmpty()) {
            final Point firstElement = visitedPoints.poll();
            final int x = firstElement.getX();
            final int y = firstElement.getY();

            for (int i = 0; i < 4; ++i) {
                final int newX = x + X[i];
                final int newY = y + Y[i];
                if (newX >= 0 && newY >= 0 && newX < row && newY < col && distance[newX][newY] == 0) {
                    distance[newX][newY] = distance[x][y] + 1;
                    if (map[newX][newY] == 1)
                        continue;
                    visitedPoints.add(new Point(newX, newY));
                }
            }
        }
        return distance;
    }
}