package src.tamagotch.ui.ButtonEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import src.tamagotch.entity.PetClone;

public class PetInfoReader {
    
    FileInputStream fis;
    ObjectInputStream ois;

    public PetClone getPetClone(String id){

        String path = "C:/kh_miniproject/user/" + id + "/pet.save";
        File f = new File(path);
        if(!f.exists()){
            return null;
        }

        try{
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            PetClone petClone = (PetClone)ois.readObject();
            return petClone;

        }catch(Exception e){
            System.out.println("펫 정보를 불러오는데 실패했습니다");
            System.out.println("문제가 발생한 파일 : " + path);
            e.printStackTrace();
            return null;
        }finally{  
            try{
                if(ois != null) ois.close();
                if(fis != null) fis.close();

            }catch(Exception e){
                e.printStackTrace();
                System.out.println("스트림을 닫는데 실패");
            }

        }
    }
}
