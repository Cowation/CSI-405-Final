package me.derpee.creelande;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.swing.*;

import static jdk.nashorn.internal.objects.Global.println;

        /* create mode 100644 src/main/java/me/derpee/creelande/Classical_Diploma.java
        create mode 100644 src/main/resources/assets/creelande/models/item/classical_diploma.json
        create mode 100644 src/main/resources/assets/creelande/textures/item/classical_diploma.png
        create mode 100644 src/main/resources/data/creelande/recipes/classical_diploma.json */

    public class Classical_Diploma extends Item {
        // Accept registryName (creelande:registry_name)
        // Accept maxStackSize (Default: 16)
        // Accept group (Example: ItemGroup.CREATIVE)
        public Classical_Diploma(String registryName, int MaxStackSize, ItemGroup group) {
            super(new Item.Properties().maxStackSize(MaxStackSize).group(group));
            this.setRegistryName("creelande", registryName);
        }


        @Override

        //uses any world, only works when a player uses it, and either hand works.
        public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {

            // Do not run on server. (Singleplayer only)
            if (world.isRemote) return new ActionResult(ActionResultType.SUCCESS, player.getHeldItem(hand));

            // Creates PlayerInventory named inventory, and setting player.inventory to it.
            PlayerInventory inventory = player.inventory;

            //Create string of latin things to say
            String[] quotes = {"Aut viam inveniam aut faciam tibi", "Ostendes tuum et ostendam meus?", "Ars longa vita brevis", "Vultus est index animi", "Nomen est omen", "Quot homines tot sententiae: suus cuique mos", "Caelesti sumus omnes semine oriundi.", "Nam risu inepto res ineptior nulla est", "Mens sana in corpore sano", "Timendi causa est nescire", "Possunt, quia posse videntur", "Ingenio maximus, arte rudis.", "Moriamur, et in media arma ruamus", "Memento audace semper", "Stultus est sicut stultus facit", "Non torsii subligarium", "Bis dat, qui dat celeriter.", "Patientia comes est sapientiae", "Homo sum: humani nihil a me alienum puto", "Qui dormit, non peccat", "Tanta stultitia mortalium est", "Credo quia absurdum", "Vos have a valde parva caput, sed etiam magnum nasum", "Vos have a valde parva caput, sed etiam magnum nasum", "Mater tua et uxor mea"};

            //pick random quote from the array
            int randQuote = (int) (Math.random() * quotes.length);
            int rand14 = (int) (Math.random() * 8);
            // 75 percent of time it will send a random quote, other will send "Quid Quid"
            if (rand14 != 1) {
                player.sendMessage(new StringTextComponent(quotes[randQuote]));
            } else {
                player.sendMessage(new StringTextComponent("Quid Quid"));
            }
            return new ActionResult(ActionResultType.SUCCESS, player.getHeldItem(hand));
        }
    }
