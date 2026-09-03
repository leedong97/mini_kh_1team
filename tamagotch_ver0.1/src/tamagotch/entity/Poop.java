package src.tamagotch.entity;

import src.tamagotch.core.GameObject;

public class Poop extends GameObject {
    
    private int dirtyPoint =10; // 특정시간마다 더러움의 정도가 10씩 올라감
    private boolean cleaned = false; //청소했는지 여부, true로 바뀔시 remove or destroy하려고 만듬
    private int age =0; // 똥이 생성된 시기
    private int smellPoint = 10; // 똥 냄새 심화도

    public void clean(){
        cleaned = true;
        destory();
    }

    public boolean iscleaned(){
        return cleaned;
    }

    public int getDirtyPoint(){
        if(cleaned== true){
            dirtyPoint = 0;
        }
        return dirtyPoint;
    }

    public int age(){
        return age;
    }
    
    public int smellPoint(){
        if(cleaned == true){
            smellPoint = 0;
        }
        return smellPoint;
    }





    @Override
    public void beginPlay() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }


    
    
}
