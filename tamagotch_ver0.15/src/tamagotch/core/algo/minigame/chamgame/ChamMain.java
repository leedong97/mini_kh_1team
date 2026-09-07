package src.tamagotch.core.algo.minigame.chamgame;

import java.util.Random;
import java.util.Scanner;

public class ChamMain {
    public static void main(String[] args) {

        System.out.println("참참참");

        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);

        int win = 0;
        int lose = 0;
        int cnt = 0;
        

        while (true) {
            int random = rnd.nextInt(3);

            System.out.println("왼쪽(0), 가운데(1), 오른쪽(2)");
            int user = sc.nextInt();

            if (user == random) {
                System.out.println("이겼습니다.");
                win++;
            }else{
                System.out.println("졌습니다");
                lose++;
            }cnt++;

            if(cnt == 5){
                System.out.println("다시하기 (y/n)");
                System.out.println("승 : " + win + " 패 : " + lose);
                String answer = sc.next();
                if(answer.equals("n")){
                    break;
                }else{
                    cnt = 0;
                }
            }
        }
    }//main

}//class
