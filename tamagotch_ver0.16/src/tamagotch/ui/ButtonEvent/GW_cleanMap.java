package src.tamagotch.ui.ButtonEvent;

import src.tamagotch.entity.Poop;
import src.tamagotch.ui.ButtonEvent.btnE_Core.BtnECore;

public class GW_cleanMap extends BtnECore{
    @Override
    public void btnEvent() {
        Poop poop = pet.getWorld().getGameObject("Poop");
        if(poop != null) poop.destory();
    }
}
