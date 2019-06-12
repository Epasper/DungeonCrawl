package DungeonCrawl.GUI.Images.SkillIcons;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class SkillIcons {
    private Image skillIcon1 = new Image("DungeonCrawl/GUI/Images/SkillIcons/SkillIcon1.png");
    private Image skillIcon2 = new Image("DungeonCrawl/GUI/Images/SkillIcons/SkillIcon2.png");
    private Image skillIcon3 = new Image("DungeonCrawl/GUI/Images/SkillIcons/SkillIcon3.png");
    private Image skillIcon4 = new Image("DungeonCrawl/GUI/Images/SkillIcons/SkillIcon4.png");
    private Image skillIcon5 = new Image("DungeonCrawl/GUI/Images/SkillIcons/SkillIcon5.png");
    private Image skillIcon6 = new Image("DungeonCrawl/GUI/Images/SkillIcons/SkillIcon6.png");
    private Image skillIcon7 = new Image("DungeonCrawl/GUI/Images/SkillIcons/SkillIcon7.png");
    private Image skillIcon8 = new Image("DungeonCrawl/GUI/Images/SkillIcons/SkillIcon8.png");
    private Image skillIcon9 = new Image("DungeonCrawl/GUI/Images/SkillIcons/SkillIcon9.png");
    private List<Image> listOfSkillIcons = new ArrayList<>();

    public Image getSkillIcon1() {
        return skillIcon1;
    }

    public Image getSkillIcon2() {
        return skillIcon2;
    }

    public Image getSkillIcon3() {
        return skillIcon3;
    }

    public Image getSkillIcon4() {
        return skillIcon4;
    }

    public Image getSkillIcon5() {
        return skillIcon5;
    }

    public Image getSkillIcon6() {
        return skillIcon6;
    }

    public Image getSkillIcon7() {
        return skillIcon7;
    }

    public Image getSkillIcon8() {
        return skillIcon8;
    }

    public Image getSkillIcon9() {
        return skillIcon9;
    }

    public List<Image> getListOfSkillIcons() {
        return listOfSkillIcons;
    }

    public SkillIcons() {
        listOfSkillIcons.add(skillIcon1);
        listOfSkillIcons.add(skillIcon2);
        listOfSkillIcons.add(skillIcon3);
        listOfSkillIcons.add(skillIcon4);
        listOfSkillIcons.add(skillIcon5);
        listOfSkillIcons.add(skillIcon6);
        listOfSkillIcons.add(skillIcon7);
        listOfSkillIcons.add(skillIcon8);
        listOfSkillIcons.add(skillIcon9);
    }
}
