package src.tamagotch.core;

import java.awt.Font;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class GameObject {
    protected GameInstance gameinstance;
    protected World world;
    protected JLabel body;
    protected ImageIcon imag;
    protected String objectName;
    protected int x;
    protected int y;
    protected boolean isPendingKill;

    protected String bodyPth;
    protected boolean isAnim = false;

    protected String objCase = "normal"; //move, normal
    protected ImageIcon[] animSete;
    private int currentAnimationFram = 0;

    public GameObject(){
        //모든 오브젝트가 단하나의 Gameinstance를 바라보게 설정
        gameinstance = GameInstance.getInstance();
        animSete = new ImageIcon[12];
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
        this.x = gameinstance.gameFrameSizX/2 - sizX/2;
        this.y = gameinstance.gameFrameSizY/2 - sizY/2;
        this.body.setLocation(this.x, this.y);
        world.add(body,1);
        world.repaint();
    }

    //폴더 경로만 전달 시
    public void setBody(String path){
        this.bodyPth = path;
        int sizX = 100;
        int sizY = 100;
        
        setObjectCase("normal");
        
        this.body = new JLabel(animSete[0]);
        
        this.body.setSize(sizX, sizY);
        this.x = gameinstance.gameFrameSizX/2 - sizX/2;
        this.y = gameinstance.gameFrameSizY/2 - sizY/2;
        this.body.setLocation(this.x, this.y);
        
        world.add(body,1);
        world.repaint();
    }

    //상태설정
    public void setObjectCase(String objCase){
        
        if(bodyPth == null) return;
        this.objCase = objCase;
        String path = bodyPth + "/" + this.objCase;
        File f = new File(path);
        
        if(!f.exists())
        {
            System.out.println("경로오류" + f.getPath());
            System.out.println(path);
            return;//폴더 없으면 리턴
        }

        //상태전환시 nullpointer를 방지하기 위한 얕은복사
        ImageIcon[] temp = new ImageIcon[12];
        for (int i = 0; i < temp.length; i++){
            temp[i] = new ImageIcon(path + String.format("/00%02d.png",i+1));
        }

        this.animSete = temp;
        this.currentAnimationFram = 0;
    }

    public void setBody(String path, int siz){
        this.body = new JLabel(path);
        this.body.setFont(new Font("",Font.PLAIN,siz));
        this.body.setSize(100, 100);
        this.x = gameinstance.gameFrameSizX/2 - 50;
        this.y = gameinstance.gameFrameSizY/2 - 50;
        this.body.setLocation(this.x,this.y);
        world.add(body,1);
        world.repaint();
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
        body.setLocation(x, y);
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

    public void updateAnim(){
        //애니메이션이 꺼져있으면 리턴
        if(!isAnim) return;
        //바디와 경로가 있는지
        if(body != null && bodyPth != null){
            int findFr = currentAnimationFram % animSete.length;
            body.setIcon(animSete[findFr]);
        }
        currentAnimationFram ++;
        //World의 updateAnim함수에서 업데이트 중
    }
}
