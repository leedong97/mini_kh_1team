package src.tamagotch.core.algo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import src.tamagotch.core.CVector2D;

public class GridPathfinder {

    // 상, 하, 좌, 우, 대각선 4방향 (총 8방향)
    private static final int[] DX = { 0,  0, -1, 1, -1,  1, -1, 1};
    private static final int[] DY = {-1,  1,  0, 0, -1, -1,  1, 1};

    private static class Node {
        int x, y;
        Node parent;

        Node(int x, int y, Node parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }
    }

    /**
     * 시작점에서 목표점까지의 전체 이동 경로를 List<CVector2D>로 반환
     * (시작 위치는 제외되고, 다음 이동할 첫 번째 칸부터 최종 도착 칸까지 담김)
     */
    public static List<CVector2D> findPath(CVector2D[][] grid, int startX, int startY, int targetX, int targetY, boolean[][] obstacles) {
        List<CVector2D> path = new ArrayList<>();

        // 이미 목표점에 도달해 있는 경우 빈 리스트 반환
        if (startX == targetX && startY == targetY) {
            return path;
        }

        int height = grid.length;
        int width = grid[0].length;

        boolean[][] visited = new boolean[height][width];
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(startX, startY, null));
        visited[startY][startX] = true;

        Node targetNode = null;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == targetX && current.y == targetY) {
                targetNode = current;
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nx = current.x + DX[i];
                int ny = current.y + DY[i];

                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (visited[ny][nx]) continue;
                if (obstacles != null && obstacles[ny][nx]) continue;

                // 코너 끼임 방지
                if (i >= 4 && obstacles != null) {
                    if (obstacles[current.y][nx] && obstacles[ny][current.x]) {
                        continue;
                    }
                }

                visited[ny][nx] = true;
                queue.add(new Node(nx, ny, current));
            }
        }

        // 경로를 찾지 못한 경우 빈 리스트 반환
        if (targetNode == null) {
            return path;
        }

        // 역추적: targetNode부터 시작점 직전까지 리스트에 담기
        Node curr = targetNode;
        while (curr.parent != null) { // 시작점(parent == null)은 경로에서 제외
            path.add(grid[curr.y][curr.x]);
            curr = curr.parent;
        }

        // 뒤에서부터 담겼으므로 올바른 진행 순서(출발 -> 도착)로 반전
        Collections.reverse(path);

        return path;
    }
}