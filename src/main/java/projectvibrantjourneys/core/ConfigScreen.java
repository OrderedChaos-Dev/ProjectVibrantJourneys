package projectvibrantjourneys.core;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.TranslationTextComponent;

public class ConfigScreen extends Screen {

	protected ConfigScreen() {
		super(new TranslationTextComponent(ProjectVibrantJourneys.MOD_ID + ".config.title"));
	}

}
