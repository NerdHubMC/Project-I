package dev.onyxstudios.projecti.registry;

import dev.onyxstudios.projecti.ProjectI;
import dev.onyxstudios.projecti.blocks.BlueCrystalBlock;
import dev.onyxstudios.projecti.blocks.CircuitStamperBlock;
import dev.onyxstudios.projecti.blocks.fluid.BaseFluidBlock;
import dev.onyxstudios.projecti.blocks.fluid.FluidMoltenBlueCrystal;
import dev.onyxstudios.projecti.items.BlueCrystalItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> blockRegistry = DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectI.MODID);
    public static final DeferredRegister<Item> itemRegistry = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectI.MODID);
    public static final DeferredRegister<Fluid> fluidRegistry = DeferredRegister.create(ForgeRegistries.FLUIDS, ProjectI.MODID);

    //Blocks
    private static Item.Properties ITEM_BLOCK_PROPS = new Item.Properties().tab(ProjectI.TAB);

    public static RegistryObject<Block> BLUE_CRYSTAL = blockRegistry.register("blue_crystal", BlueCrystalBlock::new);
    public static RegistryObject<Item> BLUE_CRYSTAL_ITEM = itemRegistry.register("blue_crystal", BlueCrystalItem::new);

    public static RegistryObject<Block> STAMPER = blockRegistry.register("circuit_stamper", CircuitStamperBlock::new);
    public static RegistryObject<Item> STAMPER_ITEM = itemRegistry.register("circuit_stamper", () -> new BlockItem(STAMPER.get(), ITEM_BLOCK_PROPS));

    //Fluids
    private static AbstractBlock.Properties HOT_FLUID_PROPS = AbstractBlock.Properties.of(Material.LAVA).randomTicks().lightLevel(value -> 100).noDrops();
    private static Item.Properties BUCKET_PROPS = new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ProjectI.TAB);

    public static FluidMoltenBlueCrystal MOLTEN_BLUE_CRYSTAL = new FluidMoltenBlueCrystal.Source();
    public static FluidMoltenBlueCrystal FLOWING_MOLTEN_BLUE_CRYSTAL = new FluidMoltenBlueCrystal.Flowing();

    public static RegistryObject<FluidMoltenBlueCrystal> MOLTEN_BLUE_CRYSTAL_REG = fluidRegistry.register("molten_blue_crystal", () -> MOLTEN_BLUE_CRYSTAL);
    public static RegistryObject<FluidMoltenBlueCrystal> FLOWING_BLUE_CRYSTAL_REG = fluidRegistry.register("flowing_molten_blue_crystal", () -> FLOWING_MOLTEN_BLUE_CRYSTAL);

    public static RegistryObject<BaseFluidBlock> MOLTEN_BLUE_CRYSTAL_BLOCK = blockRegistry.register("molten_blue_crystal", () -> new BaseFluidBlock(MOLTEN_BLUE_CRYSTAL_REG::get, HOT_FLUID_PROPS, new Vector3d(0.294, 0.4, 0.827)));
    public static RegistryObject<Item> BLUE_CRYSTAL_BUCKET = itemRegistry.register("blue_crystal_bucket", () -> new BucketItem(() -> MOLTEN_BLUE_CRYSTAL, BUCKET_PROPS));
}
