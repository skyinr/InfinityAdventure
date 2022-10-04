package cx.rain.infadv.data.provider;

import cx.rain.infadv.block.ModBlocks;
import cx.rain.infadv.data.provider.base.BlockStateProviderBase;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.DeferredRegister;

public class ModBlockStateProvider extends BlockStateProviderBase {
    public ModBlockStateProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper, DeferredRegister<Block> registry) {
        super(generator, modid, existingFileHelper, registry);
    }

    @Override
    protected void registerStates() {
        skipBlocks(ModBlocks.BEER_BARREL.get(), ModBlocks.DWARF_FURNACE.get(), ModBlocks.DWARF_PILLAR_BRICKS.get(), ModBlocks.SKY_LOG.get(), ModBlocks.SKY_GRASS_BLOCK.get());

        horizontalBlock(ModBlocks.BEER_BARREL.get(), modLoc("block/beer_barrel_side"), modLoc("block/beer_barrel_front"), modLoc("block/beer_barrel_top"));
        furnaceBlock(ModBlocks.DWARF_FURNACE.get(), modLoc("block/dwarf_furnace_side"), modLoc("block/dwarf_furnace_front"), modLoc("block/dwarf_furnace_front_on"), modLoc("block/dwarf_furnace_top"));
        logBlock(ModBlocks.DWARF_PILLAR_BRICKS.get());
        logBlock(ModBlocks.SKY_LOG.get());
        grassBlock(ModBlocks.SKY_GRASS_BLOCK.get(), mcLoc("block/dirt"), modLoc("block/sky_grass_block_top"), modLoc("block/sky_grass_block"), modLoc("block/sky_grass_block"));

        // TODO by lq2007: skip UNREALIZED blocks
        skipBlocks(ModBlocks.TODO_DREAM_BED.get());
        BlockModelBuilder unrealizedModel = models().cubeAll("unrealized_block", modLoc("block/unrealized"));
        getVariantBuilder(ModBlocks.TODO_DREAM_BED.get()).forAllStates(bs -> ConfiguredModel.builder().modelFile(unrealizedModel).build());
    }
}
