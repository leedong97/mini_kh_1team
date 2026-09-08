package src.tamagotch.ui.ButtonEvent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import src.tamagotch.entity.Pet;
import src.tamagotch.entity.PetClone;

public class PetInfoWriter {
    //경식

    FileOutputStream fos;
    ObjectOutputStream oos;

    PetClone petClone;

    public PetInfoWriter(PetClone petClone){
        this.petClone = petClone;
    }

    public void mkdir(PetClone petClone){

        String path = "C:/kh_miniproject/user/" + petClone.getName() + "/pet.save";

        File dir1 = new File("C:/kh_miniproject/user/");

        if(!dir1.exists()){
            dir1.mkdirs();
        }

        File dir2 = new File("C:/kh_miniproject/user/" + petClone.getName());
        if(!dir2.exists()){
            dir2.mkdirs();
        }

        try{
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(petClone);
            oos.flush();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("펫의 정보저장이 실패했습니다");
        }finally{
            try{
                if(oos != null) oos.close();
                if(fos != null) fos.close();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("스트림을 닫는데 실패했습니다");
            }
        }//finally
    }//mkdir
}
