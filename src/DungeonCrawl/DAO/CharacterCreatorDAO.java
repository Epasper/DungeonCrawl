package DungeonCrawl.DAO;

import DungeonCrawl.DTO.CharacterCreatorDTO;
import DungeonCrawl.HeroPowers.HeroPower;
import DungeonCrawl.HeroPowers.HeroPowerFactory;
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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class CharacterCreatorDAO {
    private PreparedStatement pst;

    public CharacterCreatorDAO() {
        //todo decryption takes place here
    }

    public Image getHeroIconByID(int id) {
        File file = new File("C:\\Users\\A753403\\IdeaProjects\\DungeonCrawl\\src\\DungeonCrawl\\GUI\\Images\\HeroPortraits\\icon" + id + ".png");
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
        String json = jsonToString("C:\\Users\\A753403\\IdeaProjects\\DungeonCrawl\\src\\DungeonCrawl\\UserFiles\\HeroNames.JSON");
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
        String json = jsonToString("C:\\Users\\A753403\\IdeaProjects\\DungeonCrawl\\src\\DungeonCrawl\\UserFiles\\HeroNames.JSON");
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("heroIDs");
        return jsonArray.getString(ID);
    }

    public Hero getAHeroByID(int ID) {
        Hero hero = new Hero();
        String heroName = getHeroNameByID(ID);
        String json = jsonToString("C:\\Users\\A753403\\IdeaProjects\\DungeonCrawl\\src\\DungeonCrawl\\UserFiles\\" + heroName + ".JSON");
        hero.setHitPoints(1000); //todo set HP properly
        hero.setCurrentHitPoints(1000);
        hero.updateTheDefensesMap();
        System.out.println("-----> Hero ID From DAO:  " + ID);
        JSONObject jsonObject = new JSONObject(json);
        hero.setCreatureImage(getHeroIconByID(jsonObject.getInt("heroIconId")));
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
        manageHeroDefenses(hero, jsonObject);
        manageHeroSkills(hero, jsonObject);
        HeroClassInformationFactory heroClassInformationFactory = new HeroClassInformationFactory(heroClass);
        manageHeroPowers(hero, heroClassInformationFactory, jsonObject);

        /*while (rs.next()) {
            a = rs.getString("hero_name");
            b = rs.getString("icon_id");
            hero.setCreatureImage(getHeroIconByID(rs.getInt("icon_id")));
            hero.setHeroIconId(rs.getInt("icon_id"));
            hero.setID(rs.getInt("idheroes"));
            hero.setHeroName(rs.getString("hero_name"));
            String heroClass = rs.getString("hero_class");
            hero.setHeroClass(heroClass);
            hero.setHeroRace(rs.getString("hero_race"));
            hero.setHeroLevel(rs.getInt("hero_level"));
            hero.setStrength(rs.getInt("strength"));
            hero.setConstitution(rs.getInt("constitution"));
            hero.setDexterity(rs.getInt("dexterity"));
            hero.setIntelligence(rs.getInt("intelligence"));
            hero.setWisdom(rs.getInt("wisdom"));
            hero.setCharisma(rs.getInt("charisma"));
            hero.setGold(rs.getInt("gold"));
            manageHeroDefenses(hero, rs);
            manageHeroSkills(hero, rs);
            HeroClassInformationFactory heroClassInformationFactory = new HeroClassInformationFactory(heroClass);
            manageHeroPowers(hero, heroClassInformationFactory, rs);
        }*/
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
        String json = jsonToString("C:\\Users\\A753403\\IdeaProjects\\DungeonCrawl\\src\\DungeonCrawl\\UserFiles\\HeroNames.JSON");
        JSONObject jsonAllHeroNamesObject = new JSONObject(json);
        JSONArray jsonArray = jsonAllHeroNamesObject.getJSONArray("heroIDs");
        List<Hero> list = new ArrayList<>();
//        ResultSet rs = pst.executeQuery();
        for (int i = 1; i < jsonArray.length(); i++) {
            Hero hero = getAHeroByID(i);
            list.add(hero);
        }
        /*while (rs.next()) {
            CharacterCreatorDTO dto = new CharacterCreatorDTO();
            dto.setHeroImage(getHeroIconByID(rs.getInt("icon_id")));
            dto.setHeroID(rs.getInt("idheroes"));
            dto.setHeroName(rs.getString("hero_name"));
            dto.setHeroClass(rs.getString("hero_class"));
            dto.setHeroRace(rs.getString("hero_race"));
            dto.setHeroLevel(rs.getInt("hero_level"));
            dto.setStrength(rs.getInt("strength"));
            dto.setConstitution(rs.getInt("constitution"));
            dto.setDexterity(rs.getInt("dexterity"));
            dto.setIntelligence(rs.getInt("intelligence"));
            dto.setWisdom(rs.getInt("wisdom"));
            dto.setCharisma(rs.getInt("charisma"));
            dto.setAc(rs.getInt("ac"));
            dto.setFortitude(rs.getInt("fortitude"));
            dto.setReflex(rs.getInt("reflex"));
            dto.setWill(rs.getInt("will"));
            dto.setHeroIconId(rs.getInt("icon_id"));
            dto.setAcrobatics(rs.getInt("sk_acrobatics"));
            dto.setArcana(rs.getInt("sk_arcana"));
            dto.setAthletics(rs.getInt("sk_athletics"));
            dto.setBluff(rs.getInt("sk_bluff"));
            dto.setDiplomacy(rs.getInt("sk_diplomacy"));
            dto.setDungeoneering(rs.getInt("sk_dungeoneering"));
            dto.setEndurance(rs.getInt("sk_endurance"));
            dto.setHeal(rs.getInt("sk_heal"));
            dto.setHistory(rs.getInt("sk_history"));
            dto.setInsight(rs.getInt("sk_insight"));
            dto.setIntimidate(rs.getInt("sk_intimidate"));
            dto.setNature(rs.getInt("sk_nature"));
            dto.setPerception(rs.getInt("sk_perception"));
            dto.setReligion(rs.getInt("sk_religion"));
            dto.setStealth(rs.getInt("sk_stealth"));
            dto.setStreetwise(rs.getInt("sk_streetwise"));
            dto.setThievery(rs.getInt("sk_thievery"));
            String allAtWillPowers = rs.getString("powers_at_will");
            dto.setAtWillPower1(allAtWillPowers.substring(0, allAtWillPowers.indexOf("_") - 1));
            dto.setAtWillPower2(allAtWillPowers.substring(allAtWillPowers.lastIndexOf("_") + 1));
            String allEncounterPowers = rs.getString("powers_encounter");
            dto.setEncounterPower1(allEncounterPowers.substring(0, allEncounterPowers.indexOf("_") - 1));
            String allDailyPowers = rs.getString("powers_daily");
            dto.setDailyPower1(allDailyPowers.substring(0, allDailyPowers.indexOf("_") - 1));
            list.add(dto);
        }*/
        return list;
    }

    public void updateHeroGold(Hero hero, int goldDifference) throws SQLException {
        String sql = "UPDATE dungeon.heroes SET " +
                "gold=? " +
                "WHERE (`idheroes`=?)";
        pst.setInt(1, hero.getGold() + goldDifference);
        pst.setInt(2, hero.getID());
        System.out.println(sql);
        pst.executeUpdate();
        System.out.println("Character's gold amount has successfully been modified");
    }
//    INSERT INTO `dungeon`.`heroes` (`idheroes`, `hero_name`, `hero_class`, `hero_race`, `hero_level`, `strength`, `constitution`, `dexterity`, `intelligence`, `wisdom`, `charisma`, `ac`, `fortitude`, `reflex`, `will`, `gold`, `icon_id`, `sk_acrobatics`, `sk_arcana`, `sk_athletics`, `sk_bluff`, `sk_diplomacy`, `sk_dungeoneering`, `sk_endurance`, `sk_heal`, `sk_history`, `sk_insight`, `sk_intimidate`, `sk_nature`, `sk_perception`, `sk_religion`, `sk_stealth`, `sk_streetwise`, `sk_thievery`, `powers_at_will`, `powers_encounter`, `powers_daily`, `power_icon_ids_at_will`, `power_icon_ids_encounter`, `power_icon_ids_daily`) VALUES ('3', 'Gwaihir', 'Fighter', 'Human', '1', '18', '18', '10', '10', '10', '10', '10', '3', '3', '0', '100', '12', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'Deft Strike___Riposte Strike', 'King\'s Castle___', 'Dazing Strike___', '1___2___', '3___', '4___');

    public void addAHeroToDatabase(CharacterCreatorDTO heroToBeAdded) throws IOException {
        JSONObject jsonObject = new JSONObject(heroToBeAdded);
        List<String> allNames = getAllHeroNames();
        allNames.add(heroToBeAdded.getHeroName());
        JSONArray allNamesArray = new JSONArray(allNames);
        String jsonString = jsonObject.toString(1);
        String allNamesString = allNamesArray.toString(1);
        String fileName = heroToBeAdded.getHeroName() + ".JSON";
        String path = "C:\\Users\\A753403\\IdeaProjects\\DungeonCrawl\\src\\DungeonCrawl\\UserFiles\\";
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path + fileName));
        fileWriter.write(jsonString);
        fileWriter.close();
        BufferedWriter allHeroNamesWriter = new BufferedWriter(new FileWriter(path + "HeroNames.JSON"));
        allHeroNamesWriter.write("{\n" +
                "  \"heroIDs\":" + allNamesString + "\n" + "}");
        allHeroNamesWriter.close();
        /*String sql = "INSERT INTO dungeon.heroes(" +
                "hero_name," +
                "hero_class," +
                "hero_race," +
                "hero_level," +
                "strength," +
                "constitution," +
                "dexterity," +
                "intelligence," +
                "wisdom," +
                "charisma," +
                "ac," +
                "fortitude," +
                "reflex," +
                "will," +
                "gold," +
                "icon_id," +
                "sk_acrobatics," +
                "sk_arcana," +
                "sk_athletics," +
                "sk_bluff," +
                "sk_diplomacy," +
                "sk_dungeoneering," +
                "sk_endurance," +
                "sk_heal," +
                "sk_history," +
                "sk_insight," +
                "sk_intimidate," +
                "sk_nature," +
                "sk_perception," +
                "sk_religion," +
                "sk_stealth," +
                "sk_streetwise," +
                "sk_thievery," +
                "powers_at_will," +
                "powers_encounter," +
                "powers_daily," +
                "power_icon_ids_at_will," +
                "power_icon_ids_encounter," +
                "power_icon_ids_daily)" +
                "VALUES" +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        pst.setString(1, heroToBeAdded.getHeroName());
        pst.setString(2, heroToBeAdded.getHeroClass());
        pst.setString(3, heroToBeAdded.getHeroRace());
        pst.setInt(4, 1);
        pst.setInt(5, heroToBeAdded.getStrength());
        pst.setInt(6, heroToBeAdded.getConstitution());
        pst.setInt(7, heroToBeAdded.getDexterity());
        pst.setInt(8, heroToBeAdded.getIntelligence());
        pst.setInt(9, heroToBeAdded.getWisdom());
        pst.setInt(10, heroToBeAdded.getCharisma());
        pst.setInt(11, heroToBeAdded.getCharisma());
        pst.setInt(12, heroToBeAdded.getFortitude());
        pst.setInt(13, heroToBeAdded.getReflex());
        pst.setInt(14, heroToBeAdded.getWill());
        pst.setInt(15, heroToBeAdded.getGold());
        pst.setInt(16, heroToBeAdded.getHeroIconId());
        pst.setInt(17, heroToBeAdded.getAcrobatics());
        pst.setInt(18, heroToBeAdded.getArcana());
        pst.setInt(19, heroToBeAdded.getAthletics());
        pst.setInt(20, heroToBeAdded.getBluff());
        pst.setInt(21, heroToBeAdded.getDiplomacy());
        pst.setInt(22, heroToBeAdded.getDungeoneering());
        pst.setInt(23, heroToBeAdded.getEndurance());
        pst.setInt(24, heroToBeAdded.getHeal());
        pst.setInt(25, heroToBeAdded.getHistory());
        pst.setInt(26, heroToBeAdded.getInsight());
        pst.setInt(27, heroToBeAdded.getIntimidate());
        pst.setInt(28, heroToBeAdded.getNature());
        pst.setInt(29, heroToBeAdded.getPerception());
        pst.setInt(30, heroToBeAdded.getReligion());
        pst.setInt(31, heroToBeAdded.getStealth());
        pst.setInt(32, heroToBeAdded.getStreetwise());
        pst.setInt(33, heroToBeAdded.getThievery());
        pst.setString(34, heroToBeAdded.getAtWillPower1() + "___" + heroToBeAdded.getAtWillPower2());
        pst.setString(35, heroToBeAdded.getEncounterPower1() + "___");
        pst.setString(36, heroToBeAdded.getDailyPower1() + "___");
        pst.setString(37, heroToBeAdded.getAtWillPower1IconID() + "___" + heroToBeAdded.getAtWillPower2IconID() + "___");
        pst.setString(38, heroToBeAdded.getEncounterPowerIconID() + "___");
        pst.setString(39, heroToBeAdded.getDailyPowerIconID() + "___");
        pst.executeUpdate();
        //todo fill this method with JSON reference
        addHeroEquipmentTable(heroToBeAdded);*/
        System.out.println("Character has successfully been added to the database");
    }

    public void addHeroEquipmentTable(CharacterCreatorDTO heroToBeAdded) throws SQLException {

    }
}