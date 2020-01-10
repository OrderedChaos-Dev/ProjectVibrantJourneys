package projectvibrantjourneys.core;

import java.util.Map;

import com.electronwill.nightconfig.core.UnmodifiableConfig;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ValueSpec;

public class ConfigScreen extends Screen {

	protected ConfigScreen() {
		super(new TranslationTextComponent(ProjectVibrantJourneys.MOD_ID + ".config.title"));
	}

	@Override
	protected void init() {
		this.addButton(new Button(50, this.height - 20, 200, 20, "Done", (button) -> {
			this.onClose();
		}));

		for(Map.Entry<String, Object> entry : PVJConfig.COMMON_CONFIG.valueMap().entrySet()) {
			String category = entry.getKey();
			UnmodifiableConfig settings = (UnmodifiableConfig) entry.getValue();
			
			int i = 0;
			for(Map.Entry<String, Object> values : settings.valueMap().entrySet()) {
				String name = values.getKey();
				ForgeConfigSpec.ValueSpec val = (ValueSpec) values.getValue();

			}
		}
	}
}
