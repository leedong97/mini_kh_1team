package src.tamagotch.ui.ButtonEvent;

import java.io.File;
import java.io.ObjectOutputStream;

import src.tamagotch.entity.PetClone;

public class PetInfoDelete {

    PetClone petClone;
    
    public PetInfoDelete(PetClone petClone){

        this.petClone = petClone;
    }

    public void petDelete(){
        String path = "C:/kh_miniproject/user/" + petClone.getName() + "/pet.save";

        File saveFile = new File(path);
        if(saveFile.exists()){
            saveFile.delete();
        }else{
            System.out.println("해당 파일을 찾지 못했습니다");
        }
        File saveFolder = new File("C:/kh_miniproject/user/" + petClone.getName());
        if(saveFolder.exists()){
            saveFolder.delete();
        }else{
            System.out.println("해당 폴더를 찾지 못했습니다");
        }

    }
}

