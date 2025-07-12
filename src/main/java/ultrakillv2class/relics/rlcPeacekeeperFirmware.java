package ultrakillv2class.relics;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import ultrakillv2class.character.v2character;

import static ultrakillv2class.ultrakillv2mod.makeID;

public class rlcPeacekeeperFirmware extends BaseRelic {
    private boolean triggerEffect = false, firstTurn = false;

    private static final String NAME = "rlcPeacekeeperFirmware"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.STARTER; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.

    public rlcPeacekeeperFirmware() {
        super(ID, NAME, v2character.Meta.CARD_COLOR, RARITY, SOUND);
    }

    public void onPlayerEndTurn() {
        if (EnergyPanel.totalCount == 0) {
            this.triggerEffect = false;
            this.pulse = false;
        }
    }

    public void atTurnStart() {
        beginPulse();
        this.pulse = true;
        if (this.triggerEffect && !this.firstTurn) {
            flash();
            addToBot(new RelicAboveCreatureAction((AbstractCreature) AbstractDungeon.player, this));
            addToBot(new DrawCardAction(1));
            addToBot(new GainEnergyAction(1));
        }
        this.firstTurn = false;
        this.triggerEffect = true;
    }

        @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
