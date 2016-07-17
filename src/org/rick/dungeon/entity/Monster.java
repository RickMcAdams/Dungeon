package org.rick.dungeon.entity;

import javafx.scene.image.Image;

public class Monster {
	Image image;
	String description;
	int fighterValue;

	public Monster() {
	}

	public Monster(Image image, String description, int fighterValue) {
		setImage(image);
		setDescription(description);
		setFighterValue(fighterValue);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFighterValue() {
		return fighterValue;
	}

	public void setFighterValue(int fighterValue) {
		this.fighterValue = fighterValue;
	}
}
