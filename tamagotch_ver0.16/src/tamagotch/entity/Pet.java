package src.tamagotch.entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import src.tamagotch.core.CVector2D;
import src.tamagotch.core.GameObject;
import src.tamagotch.entity.petAlgo.UpdateFun;
import src.tamagotch.entity.petAlgo.UpdateHunger;
import src.tamagotch.entity.petAlgo.UpdateHygiene;
import src.tamagotch.entity.petAlgo.UpdateRestRoom;
import src.tamagotch.entity.petAlgo.petAlgoCore.PetAlgo;
import src.tamagotch.ui.GameWorld;

public class Pet extends GameObject{
    
    //상태
    //진화단계
    //진화단계별 기능 아이디어
    private String name;
    public float hunger = 100;//기본 값 100(나이 먹으면 커지게?)
    public Consumer<Float> hungerC;
    public float hygiene = 100; //청결도
    public Consumer<Float> hygieneC; //작업 편의성을 위해 public으로 두었습니다.
    public Consumer<String> caseC;
    public float fun = 100; //재미도
    public Consumer<Float>funC;
    public float restroom = 100;//화장실필요도
    public Consumer<Float> restroomC;
    public float health = 100;
    public Consumer<Float> healthC;
    public float stress = 0;
    public Consumer<Float> stressC;
    public float sleep = 100;
    public Consumer<Float> sleepC;
    
    public List<PetAlgo> petAlgo;
    public CVector2D targetV;
    public CVector2D mypos = new CVector2D();

    public Pet(){
        //생성자
        petAlgo = new ArrayList<PetAlgo>();
        
        //이벤트를 넣는 두가지 케이스 입니다.
        //init으로 초기화 함수를 세팅해줍니다.
        petAlgo.add((UpdateHunger)new UpdateHunger().init(this));
        //World클레스의 spawnGameObject함수와 마찬가지로, event세팅함수를 만들어두었습니다.
        setAlgo(new UpdateHygiene());
        setAlgo(new UpdateFun());
        setAlgo(new UpdateRestRoom());
    }
    
    @Override
    public void beginPlay() {
        // TODO Auto-generated method stub
        //setBody("src/tamagotch/img/Pet01/Pet01.png",100, 100);
        setBody("src/tamagotch/img/Pet01");
        //애니메이션 실행
        isAnim = true;
    }
    @Override
    public void update() {
        //월드에서 세팅 예정
        if(this.objCase.equals("death"))
            return;

        for(PetAlgo algo : petAlgo){
            algo.updateStat();
        }

        if(hygiene < 30 || fun < 30 || hunger <= 0){
            stress += 0.01;
            if(stress >= 100){
                stress = 100;
            }
            
            if(stress >= 70){
                health -= 0.01;
                if(health <= 0){
                    health = 0;
                }

                if(healthC != null) healthC.accept(health);
            }

            if(stressC != null){
                stressC.accept(stress);
            }
        }
        
        if(health <= 0){
            setObjectCase("death");
                if(caseC != null)
                    caseC.accept(objCase);
        }
        findTager();
        setMove();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    
    //배고픔 consumer
    public void setHungerC(Consumer<Float> listener) {
        hungerC = listener;
    }
    //청결도 consumer
    public void setHygieneC(Consumer<Float> listenr){
        hygieneC = listenr;
    }
    //상태 consumer
    public void setCaseC(Consumer<String> listenr){
        caseC = listenr;
    }
    //재미 consumer
    public void setFunC(Consumer<Float> listenr){
        funC = listenr;
    }
    //화장실필요도 consumer
    public void setRestRoom(Consumer<Float>lister){
        restroomC = lister;
    }
    //건강 consumer
    public void setHealthC(Consumer<Float>lister){
        healthC = lister;
    }
    //스트레스 consumer
    public void setStressC(Consumer<Float>lister){
        stressC = lister;
    }
    //잠 consumer
    public void sleepC(Consumer<Float>lister){
        sleepC = lister;
    }

    public void feeding(Food food){
        switch(food.name){
            case "분유":
                hunger += -10;
                break;
            case "쌀":
                hunger += -10;
                break;
            case "고기":
                hunger += -15;
                break;
            case "과자":
                hunger += -5;
                break;
        }
        System.out.println(hunger);
    }

    private <T extends PetAlgo> T setAlgo(T algo){
        if(algo == null)
            return null;
        algo.init(this);
        petAlgo.add(algo);
        return algo;
    }

    //심심하면, 타겟을 찾는다.
    public float delay = 0;
    public void findTager(){
        if(targetV != null) return;
        delay ++;
        if(delay == 100){
            delay = 0;
            Random r = new Random();
            int x = r.nextInt(7);
            int y = r.nextInt(7);
            GameWorld gw = (GameWorld)world;
            targetV = gw.display[y][x];
            mypos.x = body.getLocation().x;
            mypos.y = body.getLocation().y;
            setObjectCase("move");
        }
    }

    public void setMove(){
        if(targetV == null || !objCase.equals("move")) return;
        float speed = 0.5f;
        
        CVector2D normal = new CVector2D(targetV.x - mypos.x, targetV.y - mypos.y).normalize();
        
        CVector2D nextlocation = new CVector2D(
            mypos.x+normal.x * speed
            ,mypos.y + normal.y * speed
        );

        float dist = (float)targetV.distance(mypos);

        if((int)dist <= 3){
            setLocation((int)targetV.x, (int)targetV.y);
            setObjectCase("normal");
            this.targetV = null;
            return;
        }

        mypos.x = nextlocation.x;
        mypos.y = nextlocation.y;
        setLocation((int)nextlocation.x, (int)nextlocation.y);
    }
}
