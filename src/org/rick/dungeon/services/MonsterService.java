package org.rick.dungeon.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.rick.dungeon.entity.Monster;

import javafx.scene.image.Image;

public class MonsterService {
	List<Monster> levelOneMonsters = new ArrayList<Monster>();
	int levelOneMonsterCounter = 0;
	Monster currentLevelOneMonster;

	public MonsterService() {
		createLevelOneMonsters();
	}

	private void createLevelOneMonsters() {
		levelOneMonsters.add(new Monster(new Image("org/rick/dungeon/images/level1_minotaur.png"), "Minotaur", 2));
		levelOneMonsters.add(new Monster(new Image("org/rick/dungeon/images/level1_skeleton.png"), "Skeleton", 3));
		levelOneMonsters.add(new Monster(new Image("org/rick/dungeon/images/level1_dire_rat.png"), "Dire Rat", 3));
		Collections.shuffle(levelOneMonsters);

	}

	public Monster getNextLevelOneMonster() {
		Monster monster = levelOneMonsters.get(levelOneMonsterCounter);
		setCurrentLevelOneMonster(monster);
		levelOneMonsterCounter++;
		if (levelOneMonsterCounter == levelOneMonsters.size()) {
			levelOneMonsterCounter = 0;
		}
		return monster;
	}

	public Monster getCurrentLevelOneMonster() {
		return currentLevelOneMonster;
	}

	public void setCurrentLevelOneMonster(Monster currentLevelOneMonster) {
		this.currentLevelOneMonster = currentLevelOneMonster;
	}

}
