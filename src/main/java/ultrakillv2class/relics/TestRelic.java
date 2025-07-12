package ultrakillv2class.relics;

import ultrakillv2class.character.v2character;

import static ultrakillv2class.ultrakillv2mod.makeID;

public class TestRelic extends BaseRelic {
    private static final String NAME = "TestRelic"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.STARTER; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.

    public TestRelic() {
        super(ID, NAME, v2character.Meta.CARD_COLOR, RARITY, SOUND);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
