package src.tamagotch.core;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class GameObject {
    protected GameInstance gameinstance;
    protected World world;
    protected JLabel body;
    protected ImageIcon imag;
    protected String objectName;

    private int x;
    private int y;

    protected boolean isPendingKill;

    public GameObject(){
        //모든 오브젝트가 단하나의 Gameinstance를 바라보게 설정
        gameinstance = GameInstance.getInstance();
    }

    /**
     * 게임 실행 시 초기화
     * World 클레스에서 실행중
    */
    public abstract void beginPlay();
    /**
     * 게임 중 매 Tick(deltatime)실행
     * World 클레스에서 실행중
     */
    public abstract void update();

    public void setWorld(World world){
        this.world = world;
    }

    public void destory(){
        if (this.body != null) {
            //나의 부모를 찾아냄
            if (world != null) {
                world.remove(this.body); // 부모가 누구든 찾아가서 스스로 제거
                world.revalidate();//
                world.repaint();//화면갱신
            }
        }

        this.isPendingKill = true;
    }

    public boolean isPendingKill(){
        return isPendingKill;
    }

    public void setBody(String path, int sizX, int sizY){
        this.imag = new ImageIcon(path);
        this.body = new JLabel(this.imag);
        this.body.setSize(sizX, sizY);
        this.body.setLocation(gameinstance.gameFrameSizX/2 - sizX/2, gameinstance.gameFrameSizY/2 - sizX/2);
        world.add(body);
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;

        body.setLocation(this.x, this.y);
    }

    public void setObject(String objectName){
        this.objectName = objectName;
    }

    public String getObjectName(){
        return objectName;
    }

    public JLabel getBody(){
        return body;
    }
}
