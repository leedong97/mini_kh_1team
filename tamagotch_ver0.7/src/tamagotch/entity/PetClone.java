package src.tamagotch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import src.tamagotch.core.GameInstance;

public class PetClone implements Serializable{
    

    private String name;
    private float hunger;//기본 값 100(나이 먹으면 커지게?)
    private float hygiene; //청결도
    private float fun; //재미도
    private float restroom;//화장실필요도
    private LocalDateTime now;
    private String saveDateTime;

    public PetClone(Pet pet){
        this.name = pet.getName();
        this.hunger = pet.hunger;
        this.hygiene = pet.hygiene;
        this.fun = pet.fun;
        this.restroom = pet.restroom;
        this.now = LocalDateTime.now();
        DateTimeFormatter formatter =
                            DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm");
        saveDateTime = now.format(formatter);

    }
    public String getSaveDateTime() {
        return saveDateTime;
    }

    public void setSaveDateTime(String saveDateTime) {
        this.saveDateTime = saveDateTime;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHunger() {
        return hunger;
    }

    public void setHunger(float hunger) {
        this.hunger = hunger;
    }

    public float getHygiene() {
        return hygiene;
    }

    public void setHygiene(float hygiene) {
        this.hygiene = hygiene;
    }

    public float getFun() {
        return fun;
    }

    public void setFun(float fun) {
        this.fun = fun;
    }

    public float getRestroom() {
        return restroom;
    }

    public void setRestroom(float restroom) {
        this.restroom = restroom;
    }
}
