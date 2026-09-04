package src.tamagotch.core;

public class CVector2D {
    public double x;
    public double y;

    public CVector2D() {
        this(0, 0);
    }

    public CVector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // 벡터 덧셈 (위치 + 속도)
    public CVector2D add(CVector2D other) {
        return new CVector2D(this.x + other.x, this.y + other.y);
    }

    // 벡터 뺄셈 (목표 위치 - 내 위치 = 방향 벡터)
    public CVector2D subtract(CVector2D other) {
        return new CVector2D(this.x - other.x, this.y - other.y);
    }

    // 스칼라 곱 (속도 배율 적용)
    public CVector2D multiply(double scalar) {
        return new CVector2D(this.x * scalar, this.y * scalar);
    }

    // 벡터 길이(크기)
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    // 두 점 사이의 거리
    public double distance(CVector2D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // 단위 벡터화 (정규화: 길이를 1로 만들어 순수 방향만 남김)
    public CVector2D normalize() {
        double len = length();
        if (len == 0) return new CVector2D(0, 0);
        return new CVector2D(this.x / len, this.y / len);
    }
}

