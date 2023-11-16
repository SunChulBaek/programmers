/**
 * 정수 삼각형 (다른 사람 풀이 참고, 밑에서 위로 올라가는 방식)
 */
class Q43105 {
    public static void main(String[] args) {
        // 문제
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        // 결과
        for (int i = triangle.length - 1; i > 0; i--) {
            for (int j = 0; j < triangle[i].length - 1; j++) {
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }

        System.out.println(triangle[0][0]);
    }
}