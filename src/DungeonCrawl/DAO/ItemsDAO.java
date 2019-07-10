package DungeonCrawl.DAO;


import DungeonCrawl.DTO.ItemsDTO;
import DungeonCrawl.Items.Item;
import DungeonCrawl.Model.Hero;

import java.io.IOException;
import java.util.Map;

public class ItemsDAO {

    public ItemsDAO() {

    }

    public void removeItemFromSlotInDatabase(Hero hero, String slotToBeRemoved) throws IOException {
        HeroDAO characterCreatorDAO = new HeroDAO();
        Map<String, Item> heroEquipment = hero.getHeroEquipment();
        heroEquipment.remove(slotToBeRemoved);
        characterCreatorDAO.addAHeroToDatabase(hero);
        System.out.println("Item removed from the " + slotToBeRemoved + " slot.");
    }

    public void putItemIntoSlotInDatabase(ItemsDTO itemShopDTO, Hero hero, String slotToBeFilled) throws IOException {
        HeroDAO characterCreatorDAO = new HeroDAO();
        Map<String, Item> heroEquipment = hero.getHeroEquipment();
        Item itemToBeAdded = itemShopDTO.getItemBySlotName(slotToBeFilled);
        heroEquipment.put(slotToBeFilled, itemToBeAdded);
        characterCreatorDAO.addAHeroToDatabase(hero);
        System.out.println("Item " + itemToBeAdded.getItemName() + " added to the " + slotToBeFilled + " slot");
    }

    public Map<String, Item> getHeroEquipmentByHeroID(int heroId) {
        HeroDAO characterCreatorDAO = new HeroDAO();
        Hero hero = characterCreatorDAO.getAHeroByID(heroId);
        return hero.getHeroEquipment();
    }
}
