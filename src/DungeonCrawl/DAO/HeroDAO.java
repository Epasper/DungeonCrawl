package DungeonCrawl.DAO;

import DungeonCrawl.DTO.HeroDTO;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.Items.Item;
import DungeonCrawl.Items.ItemFactory;
import DungeonCrawl.Model.ConsoleColors;
import DungeonCrawl.Model.Hero;
import DungeonCrawl.StaticRules.HeroClassInformationFactory;
import javafx.scene.image.Image;
import org.json.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class HeroDAO {

    public HeroDAO() {
        //todo decryption takes place here
    }
    public Image getHeroPortraitByID(int id) {
        File file = new File("src\\DungeonCrawl\\GUI\\Images\\HeroPortraits\\FullArts\\" + id + ".jpg");
        System.out.println("Overwriting base Portrait with Following: " + id);
        return new Image(file.toURI().toString());
    }

    public Image getHeroIconByID(int id) {
        File file = new File("src\\DungeonCrawl\\GUI\\Images\\HeroPortraits\\icon" + id + ".png");
        System.out.println("Overwriting base image with HeroIcon: " + id);
        return new Image(file.toURI().toString());
    }

    public List<Image> getAllHeroIcons() {
        List<Image> listOfIcons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Image newImage = getHeroIconByID(i);
            listOfIcons.add(newImage);
        }
        return listOfIcons;
    }

    public String jsonToString(String path) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public List<String> getAllHeroNames() {
        String json = jsonToString("src\\DungeonCrawl\\UserFiles\\HeroNames.JSON");
        List<String> jsonNamesToBeReturned = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("heroIDs");
        for (int i = 0; i < jsonArray.length(); i++) {
            String stringFromJson = jsonArray.getString(i);
            jsonNamesToBeReturned.add(stringFromJson);
        }
        for (String name : jsonNamesToBeReturned) {
            System.out.println("Name from JSon: " + name);
        }
        return jsonNamesToBeReturned;
    }

    public String getHeroNameByID(int ID) {
        String json = jsonToString("src\\DungeonCrawl\\UserFiles\\HeroNames.JSON");
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("heroIDs");
        return jsonArray.getString(ID);
    }

    public Hero getAHeroByID(int ID) {
        Hero hero = new Hero();
        String heroName = getHeroNameByID(ID);
        String json = jsonToString("src\\DungeonCrawl\\UserFiles\\" + heroName + ".JSON");
        hero.setHitPoints(100); //todo set HP properly
        hero.setCurrentHitPoints(80);
        hero.updateTheDefensesMap();
        System.out.println("-----> Hero ID From DAO:  " + ID);
        JSONObject jsonObject = new JSONObject(json);
        hero.setCreatureIcon(getHeroIconByID(jsonObject.getInt("heroIconId")));
        hero.setCreaturePortrait(getHeroPortraitByID(jsonObject.getInt("heroIconId")));
        hero.setHeroName(jsonObject.getString("heroName"));
        hero.setHeroIconId(jsonObject.getInt("heroIconId"));
        hero.setID(ID);
        String heroClass = jsonObject.getString("heroClass");
        hero.setHeroClass(heroClass);
        hero.setHeroClass(heroClass);
        hero.setHeroRace(jsonObject.getString("heroRace"));
        hero.setHeroLevel(jsonObject.getInt("heroLevel"));
        hero.setStrength(jsonObject.getInt("strength"));
        hero.setConstitution(jsonObject.getInt("constitution"));
        hero.setDexterity(jsonObject.getInt("dexterity"));
        hero.setIntelligence(jsonObject.getInt("intelligence"));
        hero.setWisdom(jsonObject.getInt("wisdom"));
        hero.setCharisma(jsonObject.getInt("charisma"));
        hero.setGold(jsonObject.getInt("gold"));
        Map<String, Item> heroEquipment = new HashMap<>();
        JSONArray equipmentSlotNames = jsonObject.getJSONArray("heroEquipmentNames");
        JSONArray equipment = jsonObject.getJSONArray("heroEquipment");
        ItemFactory itemFactory = new ItemFactory();
        for (int i = 0; i < equipment.length(); i++) {
            String currentSlotName = equipmentSlotNames.get(i).toString();
            String currentItem = equipment.get(i).toString();
            Item item = itemFactory.getItemByName(currentItem);
            heroEquipment.put(currentSlotName, item);
        }
        hero.setHeroEquipment(heroEquipment);
        manageHeroDefenses(hero, jsonObject);
        manageHeroSkills(hero, jsonObject);
        HeroClassInformationFactory heroClassInformationFactory = new HeroClassInformationFactory(heroClass);
        manageHeroPowers(hero, heroClassInformationFactory, jsonObject);
        hero.updateTheAttributesMap();
        return hero;
    }

    private void manageHeroDefenses(Hero hero, JSONObject jsonObject) {
        hero.setAC(jsonObject.getInt("ac"));
        hero.setFortitude(jsonObject.getInt("fortitude"));
        hero.setReflex(jsonObject.getInt("reflex"));
        hero.setWill(jsonObject.getInt("will"));
    }

    private void manageHeroSkills(Hero hero, JSONObject jsonObject) {
        hero.setAcrobatics(jsonObject.getInt("acrobatics"));
        hero.setArcana(jsonObject.getInt("arcana"));
        hero.setAthletics(jsonObject.getInt("athletics"));
        hero.setBluff(jsonObject.getInt("bluff"));
        hero.setDiplomacy(jsonObject.getInt("diplomacy"));
        hero.setDungeoneering(jsonObject.getInt("dungeoneering"));
        hero.setEndurance(jsonObject.getInt("endurance"));
        hero.setHeal(jsonObject.getInt("heal"));
        hero.setHistory(jsonObject.getInt("history"));
        hero.setInsight(jsonObject.getInt("insight"));
        hero.setIntimidate(jsonObject.getInt("intimidate"));
        hero.setNature(jsonObject.getInt("nature"));
        hero.setPerception(jsonObject.getInt("perception"));
        hero.setReligion(jsonObject.getInt("religion"));
        hero.setStealth(jsonObject.getInt("stealth"));
        hero.setStreetwise(jsonObject.getInt("streetwise"));
        hero.setThievery(jsonObject.getInt("thievery"));
    }

    private void manageHeroPowers(Hero hero, HeroClassInformationFactory heroClassInformationFactory, JSONObject jsonObject) {
        String atWillPower1 = jsonObject.getString("atWillPower1");
        String atWillPower2 = jsonObject.getString("atWillPower2");
        String encounterPower1 = jsonObject.getString("encounterPower1");
        String DailyPower1 = jsonObject.getString("dailyPower1");
        String atWill1IconID = jsonObject.getString("atWillPower1IconID");
        String atWill2IconID = jsonObject.getString("atWillPower2IconID");
        String encounterIconID = jsonObject.getString("encounterPowerIconID");
        String dailyIconID = jsonObject.getString("dailyPowerIconID");
        List<HeroPower> allAtWillPowersForHero = heroClassInformationFactory.getAtWillPowersAtLevel1();
        List<HeroPower> validAtWillPowersForHero = new ArrayList<>();
        for (HeroPower currentPower : allAtWillPowersForHero) {
            if (atWillPower1.contains(currentPower.getPowerName())) {
                currentPower.setPowerIconId(atWill1IconID);
                validAtWillPowersForHero.add(currentPower);
            }
        }
        for (HeroPower currentPower : allAtWillPowersForHero) {
            if (atWillPower2.contains(currentPower.getPowerName())) {
                currentPower.setPowerIconId(atWill2IconID);
                validAtWillPowersForHero.add(currentPower);
            }
        }
        hero.setAtWillPowers(validAtWillPowersForHero);
        List<HeroPower> allEncounterPowersForHero = heroClassInformationFactory.getEncounterPowersAtLevel1();
        List<HeroPower> validEncounterPowersForHero = new ArrayList<>();
        for (HeroPower currentPower : allEncounterPowersForHero) {
            if (encounterPower1.contains(currentPower.getPowerName())) {
                currentPower.setPowerIconId(encounterIconID);
                validEncounterPowersForHero.add(currentPower);
            }
        }
        hero.setEncounterPowers(validEncounterPowersForHero);
        List<HeroPower> allDailyPowersForHero = heroClassInformationFactory.getDailyPowersAtLevel1();
        List<HeroPower> validDailyPowersForHero = new ArrayList<>();
        for (HeroPower currentPower : allDailyPowersForHero) {
            if (DailyPower1.contains(currentPower.getPowerName())) {
                currentPower.setPowerIconId(dailyIconID);
                validDailyPowersForHero.add(currentPower);
            }
        }
        hero.setDailyPowers(validDailyPowersForHero);
    }

    public List<Hero> getAllHeroes() {
        String json = jsonToString("src\\DungeonCrawl\\UserFiles\\HeroNames.JSON");
        JSONObject jsonAllHeroNamesObject = new JSONObject(json);
        JSONArray jsonArray = jsonAllHeroNamesObject.getJSONArray("heroIDs");
        List<Hero> list = new ArrayList<>();
//        ResultSet rs = pst.executeQuery();
        for (int i = 1; i < jsonArray.length(); i++) {
            Hero hero = getAHeroByID(i);
            list.add(hero);
        }
        return list;
    }

    public Hero updateHeroGold(Hero hero, int goldDifference) {
        int gold = hero.getGold();
        hero.setGold(gold - goldDifference);
        return hero;
    }

    public HeroDTO changeHeroToDTO(Hero heroToChange) {
        HeroDTO dto = new HeroDTO();
        List<String> heroEquipmentNames = new ArrayList<>();
        List<String> heroEquipment = new ArrayList<>();
        Map<String, Item> heroEquipmentMap = heroToChange.getHeroEquipment();
        heroEquipmentMap.forEach((key, value) -> {
            heroEquipmentNames.add(key);
            try {
                heroEquipment.add(value.getItemName());
            } catch (NullPointerException e) {
                heroEquipment.add("Null");
            }
        });
        dto.setHeroEquipmentNames(heroEquipmentNames);
        dto.setHeroEquipment(heroEquipment);
        dto.setHeroName(heroToChange.getHeroName());
        dto.setHeroClass(heroToChange.getHeroClass());
        dto.setHeroRace(heroToChange.getHeroRace());
        dto.setStrength(heroToChange.getStrength());
        dto.setConstitution(heroToChange.getConstitution());
        dto.setDexterity(heroToChange.getDexterity());
        dto.setIntelligence(heroToChange.getIntelligence());
        dto.setWisdom(heroToChange.getWisdom());
        dto.setCharisma(heroToChange.getCharisma());
        dto.setFortitude(heroToChange.getFortitude());
        dto.setReflex(heroToChange.getReflex());
        dto.setWill(heroToChange.getWill());
        dto.setHitPoints(heroToChange.getWill());
        dto.setGold(heroToChange.getGold());
        dto.setHeroIconId(heroToChange.getHeroIconId());
        dto.setAtWillPower1(heroToChange.getAtWillPowers().get(0).getPowerName());
        dto.setAtWillPower2(heroToChange.getAtWillPowers().get(1).getPowerName());
        dto.setEncounterPower1(heroToChange.getEncounterPowers().get(0).getPowerName());
        dto.setDailyPower1(heroToChange.getDailyPowers().get(0).getPowerName());
        dto.setAtWillPower1IconID(heroToChange.getAtWillPowers().get(0).getPowerIconId());
        dto.setAtWillPower2IconID(heroToChange.getAtWillPowers().get(1).getPowerIconId());
        dto.setEncounterPowerIconID(heroToChange.getEncounterPowers().get(0).getPowerIconId());
        dto.setDailyPowerIconID(heroToChange.getDailyPowers().get(0).getPowerIconId());
        dto.setAcrobatics(heroToChange.getAcrobatics());
        dto.setArcana(heroToChange.getArcana());
        dto.setAthletics(heroToChange.getAthletics());
        dto.setBluff(heroToChange.getBluff());
        dto.setDiplomacy(heroToChange.getDiplomacy());
        dto.setDungeoneering(heroToChange.getDungeoneering());
        dto.setEndurance(heroToChange.getEndurance());
        dto.setHeal(heroToChange.getHeal());
        dto.setHistory(heroToChange.getHistory());
        dto.setInsight(heroToChange.getInsight());
        dto.setIntimidate(heroToChange.getIntimidate());
        dto.setNature(heroToChange.getNature());
        dto.setPerception(heroToChange.getPerception());
        dto.setReligion(heroToChange.getReligion());
        dto.setStealth(heroToChange.getStealth());
        dto.setStreetwise(heroToChange.getStreetwise());
        dto.setThievery(heroToChange.getThievery());
        return dto;
    }

    public void addAHeroToDatabase(Hero heroToBeAdded, boolean shouldTheHeroNameListBeUpdated) throws IOException {
        HeroDTO dto = changeHeroToDTO(heroToBeAdded);
        addAHeroToDatabase(dto, shouldTheHeroNameListBeUpdated);
    }

    public void addAHeroToDatabase(HeroDTO heroToBeAdded, boolean shouldTheHeroNameListBeUpdated) throws IOException {
        //List<Item> itemsList = new ArrayList<>();
        //List<String> slotNamesList = new ArrayList<>();
        /*for (Map.Entry<String, Item> entry : itemsToBeUpdated.entrySet()) {
            String key = entry.getKey();
            Item value = entry.getValue();
            itemsList.add(value);
            slotNamesList.add(key);
        }*/
        JSONObject jsonObject = new JSONObject(heroToBeAdded);
        List<String> allNames = getAllHeroNames();
        allNames.add(heroToBeAdded.getHeroName());
        JSONArray allNamesArray = new JSONArray(allNames);
        String jsonString = jsonObject.toString(1);
        String allNamesString = allNamesArray.toString(1);
        String fileName = heroToBeAdded.getHeroName() + ".JSON";
        String path = "src\\DungeonCrawl\\UserFiles\\";
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path + fileName));
        //jsonString = jsonString.substring(0, jsonString.lastIndexOf("\n"));
        fileWriter.write(jsonString);
        System.out.println(jsonString);
//        appendSlotNames(slotNamesList, fileWriter);
//        appendItemNames(itemsList, fileWriter);
        fileWriter.close();

        if (shouldTheHeroNameListBeUpdated) {
            BufferedWriter allHeroNamesWriter = new BufferedWriter(new FileWriter(path + "HeroNames.JSON"));
            allHeroNamesWriter.write("{\n" +
                    "  \"heroIDs\":" + allNamesString + "\n" + "}");
            allHeroNamesWriter.close();
        }
        System.out.println("Character has successfully been added to the database");
    }

    private void appendSlotNames(List<String> itemsList, BufferedWriter fileWriter) throws IOException {
        fileWriter.write(",\n \"heroEquipmentNames\": [");
        StringBuilder equipmentString = new StringBuilder();
        equipmentString.append(" \n");
        System.out.println(equipmentString.toString());
        for (int i = 0; i < itemsList.size() - 1; i++) {
            if (itemsList.get(i) != null) {
                equipmentString.append("\"")
                        .append(itemsList.get(i))
                        .append("\",\n");
            } else {
                equipmentString.append("null,\n");
            }
            System.out.println(equipmentString.toString());
        }
        if (itemsList.get(itemsList.size() - 1) != null) {
            equipmentString.append("\"");
            equipmentString.append(itemsList.get(itemsList.size() - 1));
            equipmentString.append("\" \n  ],\n");
        } else {
            equipmentString.append("null\n],\n");
        }
        fileWriter.write(equipmentString.toString());
        System.out.println(ConsoleColors.ANSI_RED + "String Builder Result: " + ConsoleColors.ANSI_RESET);
        System.out.println(equipmentString.toString());
    }

    private void appendItemNames(List<Item> itemsList, BufferedWriter fileWriter) throws IOException {
        fileWriter.write("\"heroEquipment\": [");
        StringBuilder equipmentString = new StringBuilder();
        equipmentString.append(" \n");
        System.out.println(equipmentString.toString());
        try {
            for (int i = 0; i < itemsList.size() - 1; i++) {
                if (itemsList.get(i) != null) {
                    equipmentString.append("\"")
                            .append(itemsList.get(i).getItemName())
                            .append("\",\n");
                } else {
                    equipmentString.append("null,\n");
                }
                System.out.println(equipmentString.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Looping caused IO Exception");
        }
        try {
            if (itemsList.get(itemsList.size() - 1) != null) {
                equipmentString.append("\"");
                equipmentString.append(itemsList.get(itemsList.size() - 1).getItemName());
                equipmentString.append("\" \n  ]\n}");
            } else {
                equipmentString.append("null\n]\n}");
            }
            fileWriter.write(equipmentString.toString());
            System.out.println(ConsoleColors.ANSI_RED + "String Builder Result: " + ConsoleColors.ANSI_RESET);
            System.out.println(equipmentString.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}