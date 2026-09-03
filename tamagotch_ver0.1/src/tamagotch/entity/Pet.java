package src.tamagotch.entity;

import src.tamagotch.core.GameInstance;
import src.tamagotch.core.GameObject;

public class Pet extends GameObject{
    //팻
    //이름
    //나이
    //성별
    //상태
    //진화단계
    //진화단계별 기능 아이디어
    //이미지
     // 펫 정보
     private String name;        // 이름

     public Pet(String name, int age, String gender) {
        this.name = name;
     
    }

    private int clean = 100; //깨끗한 상태
    private int washCount = 50; //씻은 횟수
    private int dirty = 10; //더러운 상태

    //게임시작
    @Override
    public void beginPlay() {
        System.out.println(name + "의 게임을 시작합니다.");
    }

    //씻기
    @Override
    public void wash() {

        if( dirty > 30) {

            clean += 60;
            dirty -= 30;
            washCount++;

            //최대값 제한
            if ( clean > 100){
                clean = 100;
            }

            if ( dirty < 0) {
                dirty = 0;
            }


            System.out.println(name + "을(를) 씻겼습니다.");
            System.out.println("깨끗함 : " + clean);
            System.out.println("더러움 : " + dirty);
            System.out.println("씻은 횟수 : " + washCount);

        } else {
            System.out.println(name + "은(는) 아직 깨끗합니다.");
        }
    }
    



    // 펫 정보 출력
    public void printInfo() {
        System.out.println("===== 펫 정보 =====");
        System.out.println("이름 : " + name);

        System.out.println("깨끗함 : " + clean);
        System.out.println("더러움 : " + dirty);
        System.out.println("==================");
    }
}
