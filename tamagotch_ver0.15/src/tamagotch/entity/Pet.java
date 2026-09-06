package src.tamagotch.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import src.tamagotch.core.GameObject;
import src.tamagotch.entity.petAlgo.UpdateFun;
import src.tamagotch.entity.petAlgo.UpdateHunger;
import src.tamagotch.entity.petAlgo.UpdateHygiene;
import src.tamagotch.entity.petAlgo.petAlgoCore.PetAlgo;

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

    public List<PetAlgo> petAlgo;

    public Pet(){
        //생성자
        petAlgo = new ArrayList<PetAlgo>();
        
        //이벤트를 넣는 두가지 케이스 입니다.
        //init으로 초기화 함수를 세팅해줍니다.
        petAlgo.add((UpdateHunger)new UpdateHunger().init(this));
        //World클레스의 spawnGameObject함수와 마찬가지로, event세팅함수를 만들어두었습니다.
        setAlgo(new UpdateHygiene());
        setAlgo(new UpdateFun());
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
        System.out.println(hunger);
    }

    private <T extends PetAlgo> T setAlgo(T algo){
        if(algo == null)
            return null;
        algo.init(this);
        petAlgo.add(algo);
        return algo;
    }
}
