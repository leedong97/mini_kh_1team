package src.tamagotch.core;

import java.util.List;

import javax.swing.JPanel;
import java.util.ArrayList;

public class World extends JPanel {
    //월드에 존재하는 모든 오브젝트 목록
    protected final List<GameObject> actors = new ArrayList<>();
    
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

    public <T extends GameObject> T spawnActor(T actor, String objectName){
        if(actor == null){
            return null;
        }

        actor.setWorld(this);
        actor.setObject(objectName);
        actor.beginPlay();

        actors.add(actor);
        return actor;
    }

    public void updateWorld() {
        //엑터의 매프레임 호출함수 실행
        for (GameObject actor : actors) {
            if (!actor.isPendingKill()) {
                actor.update();
            }else{
                //getBody()는 JLable반환
            }
        }

        //삭제 == true 오브젝트 제거
        actors.removeIf(GameObject::isPendingKill);
    }

    public void updateAnim(){
        for(GameObject actor : actors) {
            if (!actor.isPendingKill()) {
                actor.updateAnim();
            }else{
                //getBody()는 JLable반환
            }
        }
    }

    public <T extends GameObject> T getGameObject (String objectName){
        if(objectName == null) return null;
        for(GameObject object:actors){
            if(object == null) continue;
            if(objectName.equals(object.getObjectName()))
                return (T) object;
        }

        return null;
    }
}
