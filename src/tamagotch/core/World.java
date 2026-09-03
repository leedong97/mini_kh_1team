package src.tamagotch.core;

import java.util.List;
import java.awt.Panel;
import java.util.ArrayList;

public class World extends Panel {
    //월드에 존재하는 모든 오브젝트 목록
    private final List<GameObject> actors = new ArrayList<>();
    
    public World(){
        GameInstance.getInstance().setWorld(this);
    }

    public <T extends GameObject> T spawnActor(T actor){
        if(actor == null){
            return null;
        }

        actor.setWorld(this);
        actor.beginPlay();

        actors.add(actor);
        return actor;
    }

    public void updateWorld() {
        //엑터의 매프레임 호출함수 실행
        for (GameObject actor : actors) {
            if (!actor.isPendingKill()) {
                actor.update();
            }
        }

        //삭제 == true 오브젝트 제거
        actors.removeIf(GameObject::isPendingKill);
    }
}
