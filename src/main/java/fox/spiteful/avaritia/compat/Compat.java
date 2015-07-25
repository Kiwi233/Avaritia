package fox.spiteful.avaritia.compat;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.Lumberjack;
import fox.spiteful.avaritia.compat.bloodmagic.Bloody;
import fox.spiteful.avaritia.compat.botania.Tsundere;
import fox.spiteful.avaritia.compat.modtweaker.Tweak;
import fox.spiteful.avaritia.compat.thaumcraft.Lucrum;
import fox.spiteful.avaritia.crafting.Grinder;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Level;

public class Compat {

    public static boolean nei = false;
    public static boolean thaumic = false;
    public static boolean sc2 = false;
    public static boolean ae2 = false;
    public static boolean exu = false;
    public static boolean ic2 = false;
    public static boolean gt = false;
    public static boolean botan = false;
    public static boolean blood = false;
    public static boolean lolDargon = false;
    public static boolean bigReactors = false;
    public static boolean ticon = false;
    public static boolean pe = false;
    public static boolean tweak = false;
    public static boolean mfr = false;
    public static boolean twilight = false;
    public static boolean natura = false;
    public static boolean magicrops = false;
    public static boolean ganyland = false;
    public static boolean pams = false;
    public static boolean am2 = false;

    public static void census(){
        nei = Loader.isModLoaded("NotEnoughItems");
        thaumic = Loader.isModLoaded("Thaumcraft");
        sc2 = Loader.isModLoaded("StevesCarts");
        ae2 = Loader.isModLoaded("appliedenergistics2");
        exu = Loader.isModLoaded("ExtraUtilities");
        ic2 = Loader.isModLoaded("IC2");
        gt = Loader.isModLoaded("gregtech");
        botan = Loader.isModLoaded("Botania");
        blood = Loader.isModLoaded("AWWayofTime");
        lolDargon = Loader.isModLoaded("DraconicEvolution");
        bigReactors = Loader.isModLoaded("BigReactors");
        ticon = Loader.isModLoaded("TConstruct");
        pe = Loader.isModLoaded("ProjectE");
        tweak = Loader.isModLoaded("MineTweaker3");
        mfr = Loader.isModLoaded("MineFactoryReloaded");
        twilight = Loader.isModLoaded("TwilightForest");
        natura = Loader.isModLoaded("Natura");
        magicrops = Loader.isModLoaded("magicalcrops");
        ganyland = Loader.isModLoaded("ganyssurface");
        pams = Loader.isModLoaded("harvestcraft");
        am2 = Loader.isModLoaded("arsmagica2");
    }

    public static void compatify(){
        if(nei){
            try
            {
                Class<?> handler = Class.forName("fox.spiteful.avaritia.compat.ExtremeShapedRecipeHandler");
                Class<?> handler2 = Class.forName("fox.spiteful.avaritia.compat.ExtremeShapelessRecipeHandler");
                Class<?> api = Class.forName("codechicken.nei.api.API");
                api.getMethod("registerRecipeHandler", Class.forName("codechicken.nei.recipe.ICraftingHandler")).invoke(null, handler.newInstance());
                api.getMethod("registerUsageHandler", Class.forName("codechicken.nei.recipe.IUsageHandler")).invoke(null, handler.newInstance());
                api.getMethod("registerRecipeHandler", Class.forName("codechicken.nei.recipe.ICraftingHandler")).invoke(null, handler2.newInstance());
                api.getMethod("registerUsageHandler", Class.forName("codechicken.nei.recipe.IUsageHandler")).invoke(null, handler2.newInstance());
            }
            catch(Throwable e)
            {
                e.printStackTrace();
            }
        }

        if(tweak){
            try
            {
                Tweak.registrate();
            }
            catch(Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia is too good for tweaking, apparently.");
                e.printStackTrace();
            }
        }

        if(thaumic){
            try
            {
                Lucrum.abracadabra();
            }
            catch(Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia accumulated too much Warp!");
                e.printStackTrace();
                thaumic = false;
            }
        }

        if(sc2){
            try {
                Block resource = getBlock("StevesCarts", "BlockMetalStorage");
                ItemStack galg = new ItemStack(resource, 1, 2);
                Grinder.catalyst.getInput().add(galg);
            }
            catch(Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia died of old age while trying to craft the Galgadorian Drill.");
                e.printStackTrace();
                sc2 = false;
            }
        }

        if(ae2){
            try {
                Item resource = getItem("appliedenergistics2", "item.ItemMultiMaterial");
                ItemStack cell = new ItemStack(resource, 1, 38);
                ItemStack singularity = new ItemStack(resource, 1, 47);
                Grinder.catalyst.getInput().add(cell);
                Grinder.catalyst.getInput().add(singularity);
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia couldn't figure out how channels work.");
                e.printStackTrace();
                ae2 = false;
            }
        }

        if(exu){
            try {
                Block bedrockium = getBlock("ExtraUtilities", "block_bedrockium");
                Block deco = getBlock("ExtraUtilities", "decorativeBlock1");
                ItemStack bed = new ItemStack(bedrockium, 1, 0);
                ItemStack unstable = new ItemStack(deco, 1, 5);
                Grinder.catalyst.getInput().add(bed);
                Grinder.catalyst.getInput().add(unstable);
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia was unable to stop Lavos.");
                e.printStackTrace();
                exu = false;
            }
        }

        if(ic2){
            try {
                if(gt){
                    try {
                        Block resource = getBlock("gregtech", "gt.meta.storage.ingot");
                        ItemStack osmir = new ItemStack(resource, 1, 8682);
                        Grinder.catalyst.getInput().add(osmir);
                    }
                    catch(Throwable e){
                        Lumberjack.log(Level.INFO, "Avaritia got sick of only getting 2 planks per log.");
                        e.printStackTrace();
                        gt = false;
                    }
                }

                if(!gt){
                    Item iridium = getItem("IC2", "itemPartIridium");
                    ItemStack plate = new ItemStack(iridium, 1, 0);
                    Grinder.catalyst.getInput().add(plate);
                }
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia blew up the macerator.");
                e.printStackTrace();
                ic2 = false;
            }
        }

        if(botan){
            try {
                Tsundere.baka();
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia is wondering where all the dayblooms went.");
                e.printStackTrace();
                botan = false;
            }
        }

        if(blood){
            try {
                Bloody.bloodlett();
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia decided to use a Fallen Kanade instead.");
                e.printStackTrace();
                blood = false;
            }
        }

        if(lolDargon){
            try {
                Block dargon = getBlock("DraconicEvolution", "draconicBlock");
                ItemStack lol = new ItemStack(dargon, 1, 0);
                Grinder.catalyst.getInput().add(lol);
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia was distracted by a giant glowing sphere.");
                e.printStackTrace();
                lolDargon = false;
            }
        }

        if(bigReactors){
            try {
                Item ingot = getItem("BigReactors", "BRIngot");
                ItemStack ludicrite = new ItemStack(ingot, 1, 8);
                Grinder.catalyst.getInput().add(ludicrite);
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia decided it just didn't need all that RF.");
                e.printStackTrace();
                bigReactors = false;
            }
        }

        if(ticon){
            try {
                Block metal = getBlock("TConstruct", "MetalBlock");
                ItemStack menomena = new ItemStack(metal, 1, 2);
                Grinder.catalyst.getInput().add(menomena);
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia fell in the smeltery.");
                e.printStackTrace();
                ticon = false;
            }
        }

        if(pe){
            try {
                Item matter = getItem("ProjectE", "item.pe_matter");
                ItemStack red = new ItemStack(matter, 1, 1);
                Grinder.catalyst.getInput().add(red);
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia got tired of abusing the blaze rod exploit.");
                e.printStackTrace();
                pe = false;
            }
        }

        if(mfr){
            try {
                Item ponk = getItem("MineFactoryReloaded", "mfr.pinkslime");
                ItemStack pank = new ItemStack(ponk, 1, 1);
                Grinder.catalyst.getInput().add(pank);
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia walked into the laser drill.");
                e.printStackTrace();
                mfr = false;
            }
        }

        if(twilight){
            try {
                Item ironwood = getItem("TwilightForest", "item.ironwoodIngot");
                ItemStack wood = new ItemStack(ironwood, 1);
                Grinder.catalyst.getInput().add(wood);
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia was killed by a hydra.");
                e.printStackTrace();
                twilight = false;
            }
        }

        if(magicrops){
            try {
                Item essence = getItem("magicalcrops", "magicalcrops_MagicEssence");
                Item meat = getItem("magicalcrops", "magicalcrops_RawMeat");
                Item crop = getItem("magicalcrops", "magicalcrops_CropProduce");
                ItemStack extreme = new ItemStack(essence, 1, 4);
                Grinder.catalyst.getInput().add(extreme);
                OreDictionary.registerOre("cropBlackberry", new ItemStack(crop, 1, 0));
                OreDictionary.registerOre("cropBlueberry", new ItemStack(crop, 1, 1));
                OreDictionary.registerOre("cropChilipepper", new ItemStack(crop, 1, 2));
                OreDictionary.registerOre("cropCucumber", new ItemStack(crop, 1, 3));
                OreDictionary.registerOre("cropGrape", new ItemStack(crop, 1, 4));
                OreDictionary.registerOre("cropRaspberry", new ItemStack(crop, 1, 5));
                OreDictionary.registerOre("cropStrawberry", new ItemStack(crop, 1, 6));
                OreDictionary.registerOre("cropCorn", new ItemStack(crop, 1, 7));
                OreDictionary.registerOre("cropTomato", new ItemStack(crop, 1, 8));
                OreDictionary.registerOre("rawMutton", new ItemStack(meat, 1, 0));
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia got bored of waiting for magical crops to grow.");
                e.printStackTrace();
                magicrops = false;
            }
        }

        if(ganyland){
            try {
                Item mutton = getItem("ganyssurface", "mutton_raw");
                OreDictionary.registerOre("rawMutton", new ItemStack(mutton, 1, 0));
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia forgot which Gany's mod it was dealing with.");
                e.printStackTrace();
                ganyland = false;
            }
        }

        if(pams){
            try {
                Item mutton = getItem("harvestcraft", "muttonrawItem");
                Item beet = getItem("harvestcraft", "beetItem");
                OreDictionary.registerOre("rawMutton", new ItemStack(mutton, 1, 0));
                OreDictionary.registerOre("cropBeetroot", new ItemStack(beet, 1, 0));
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia got overwhelmed by all the food choices. D:");
                e.printStackTrace();
                pams = false;
            }
        }

        if(natura){
            try {
                Item barley = getItem("Natura", "barleyFood");
                OreDictionary.registerOre("cropBarley", new ItemStack(barley, 1, 0));
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, "Avaritia got overwhelmed by all the food choices. D:");
                e.printStackTrace();
                natura = false;
            }
        }

        if(am2){
            try {
                Item gem = getItem("arsmagica2", "itemOre");
                Item essence = getItem("arsmagica2", "essence");

                Grinder.catalyst.getInput().add(new ItemStack(essence, 1, 10));
                Grinder.catalyst.getInput().add(new ItemStack(gem, 1, 6));
            }
            catch (Throwable e){
                Lumberjack.log(Level.INFO, e, "Avaritia got sick of the arcane guardian's healspam.");
                am2 = false;
            }
        }

    }

    public static Block getBlock(String mod, String block) throws ItemNotFoundException {
        Block target = GameRegistry.findBlock(mod, block);
        if(target == null)
            throw new ItemNotFoundException(mod, block);
        return target;
    }

    public static Item getItem(String mod, String item) throws ItemNotFoundException {
        Item target = GameRegistry.findItem(mod, item);
        if(target == null)
            throw new ItemNotFoundException(mod, item);
        return target;
    }

    public static class ItemNotFoundException extends Exception {
        public ItemNotFoundException(String mod, String item){
            super("Unable to find " + item + " in mod " + mod + "! Are you using the correct version of the mod?");
        }
    }
}
