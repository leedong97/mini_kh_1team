package src.tamagotch.entity.petAlgo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

import src.tamagotch.core.CVector2D;
import src.tamagotch.entity.Pet;
import src.tamagotch.entity.petAlgo.petAlgoCore.PetAlgo;

public class UpdateMove extends PetAlgo{


    private List<CVector2D> pathList = new ArrayList<>();
    private CVector2D currentTarget = null;
    private float moveSpeed = 3.0f;           // 틱당 이동 거리 (픽셀)
    private final float ARRIVAL_THRESHOLD = 3.0f; // 경유지 도달 판정 반경

    public UpdateMove() {
    }

    /**
     * 외부(Pet 또는 Pathfinder)에서 경로를 주입하는 함수
     */
    public void setPath(List<CVector2D> newPath) {
        if (newPath == null || newPath.isEmpty()) {
            this.pathList.clear();
            this.currentTarget = null;
            return;
        }

        this.pathList = new ArrayList<>(newPath);
        this.currentTarget = this.pathList.remove(0); // 첫 번째 목적지 꺼내기
    }

    /**
     * Pet의 update() 루프에서 틱마다 호출되는 이동 로직
     */
    @Override
    public void updateStat() {
        if (this.pet == null || this.currentTarget == null) return;

        // 1. 현재 펫 위치 -> 목표 지점까지의 벡터 및 거리 계산
        float dx = (float) this.currentTarget.x - this.pet.getX();
        float dy = (float) this.currentTarget.y - this.pet.getY();
        float dist = (float) Math.sqrt(dx * dx + dy * dy);

        // 2. 경유지 도착 판정
        if (dist <= ARRIVAL_THRESHOLD) {
            // 위치 보정 (떨림 현상 방지)
            this.pet.setLocation((int) this.currentTarget.x, (int) this.currentTarget.y);

            // 다음 경유지가 남아있다면 교체, 없으면 정지
            if (!this.pathList.isEmpty()) {
                this.currentTarget = this.pathList.remove(0);
            } else {
                this.currentTarget = null; // 최종 도착
            }
            return;
        }

        // 3. 목표 방향으로 정규화(Normalize) 후 이동
        float dirX = dx / dist;
        float dirY = dy / dist;

        int nextX = Math.round(this.pet.getX() + (dirX * moveSpeed));
        int nextY = Math.round(this.pet.getY() + (dirY * moveSpeed));

        this.pet.setLocation(nextX, nextY);
    }

    public boolean isMoving() {
        return this.currentTarget != null;
    }
}
