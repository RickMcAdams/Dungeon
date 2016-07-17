package org.rick.dungeon.view;

import org.rick.dungeon.entity.Monster;
import org.rick.dungeon.services.MonsterService;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class MainPane extends BorderPane {
	public MainPane() {
		// Add Toolbar
		ToolBar toolbar = new ToolBar();

		// Add Status Bar
		HBox statusbar = new HBox();
		Label statusLabel = new Label("Ready");
		statusbar.getChildren().add(statusLabel);

		// Add Content
		BorderPane appContent = new BorderPane();

		// load the image
		Image image = new Image("org/rick/dungeon/images/level1.png");

		// simple displays ImageView the image as is
		ImageView iv1 = new ImageView();
		iv1.setImage(image);

		// Initiate the monsterService
		MonsterService monsterService = new MonsterService();

		// simple displays ImageView the image as is
		ImageView monsterView = new ImageView();

		FlowPane monsterPane = new FlowPane();
		monsterPane.getChildren().add(monsterView);

		Button level1Button = new Button("", iv1);

		level1Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Monster currentMonster = monsterService.getNextLevelOneMonster();
				statusLabel.setText("Fighting a " + currentMonster.getDescription());
				monsterView.setImage(currentMonster.getImage());
				monsterView.setVisible(true);
			}
		});

		FlowPane dicePane = new FlowPane();
		Button diceButton = new Button("Roll Dice");
		Label diceRollLabel = new Label("");
		diceButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int die1;
				int die2;
				// Roll the dice by setting each of the dice to be
				// a random number between 1 and 6.
				die1 = (int) (Math.random() * 6) + 1;
				die2 = (int) (Math.random() * 6) + 1;
				int total = die1 + die2;

				diceRollLabel.setText(String.valueOf(die1) + " + " + String.valueOf(die2) + " = " + total);
				Monster currentMonster = monsterService.getCurrentLevelOneMonster();
				if (total >= currentMonster.getFighterValue()) {
					statusLabel.setText("You have defeated the " + currentMonster.getDescription() + "!");
				} else {
					statusLabel.setText(
							"You have lost to the " + currentMonster.getDescription() + ". Roll for Consequences!");
				}
			}
		});

		dicePane.getChildren().addAll(diceButton, diceRollLabel);

		appContent.setLeft(level1Button);
		appContent.setCenter(monsterPane);
		appContent.setBottom(dicePane);
		monsterView.setVisible(false);

		// Add all pieces to the pane
		this.setTop(toolbar);
		this.setCenter(appContent);
		this.setBottom(statusbar);
	}

}
