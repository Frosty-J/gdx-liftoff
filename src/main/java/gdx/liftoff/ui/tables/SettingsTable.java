package gdx.liftoff.ui.tables;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import gdx.liftoff.ui.panels.PathsPanel;
import gdx.liftoff.ui.panels.SettingsPanel;

import static gdx.liftoff.Main.*;

public class SettingsTable extends LiftoffTable {
    private SettingsPanel settingsPanel;

    public SettingsTable() {
        populate();
    }

    private void populate() {
        clearChildren();
        setBackground(skin.getDrawable("black"));
        pad(20).padLeft(30).padRight(30);

        Table scrollTable = new Table();
        ScrollPane scrollPane = new ScrollPane(scrollTable, skin);
        scrollPane.setFadeScrollBars(false);
        scrollPane.setScrollingDisabled(true, false);
        add(scrollPane).grow();
        addScrollFocusListener(scrollPane);

        scrollTable.defaults().space(30);
        settingsPanel = new SettingsPanel();
        scrollTable.add(settingsPanel).grow().spaceTop(0).maxHeight(500);

        if (1+1 == 2) {
            scrollTable.row();
            PathsPanel pathsPanel = new PathsPanel();
            scrollTable.add(pathsPanel).grow().spaceTop(30);
        }

        row();
        Table table = new Table();
        add(table).bottom().growX();

        TextButton textButton = new TextButton(prop.getProperty("previous"), skin);
        table.add(textButton).uniformX().fillX();
        addHandListener(textButton);
        onChange(textButton, () -> root.previousTable());

        table.add().growX().space(5);

        textButton = new TextButton(prop.getProperty("generate"), skin);
        table.add(textButton).uniformX().fillX();
        addHandListener(textButton);
        onChange(textButton, () -> root.nextTable());
    }

    @Override
    public void captureKeyboardFocus() {
        settingsPanel.captureKeyboardFocus();
    }

    @Override
    public void finishAnimation() {

    }
}
