package fr.lightnew.files;

import fr.lightnew.CustomShop;

import java.io.IOException;

public class CreateFiles {
    public static String dataFolder = CustomShop.instance.getDataFolder()+"/FilesShop";
    public static void createFiles() {
        try {
            //gui
            if (!FolderGuiFile.guiFile.exists()){
                FolderGuiFile.guiFile.createNewFile();
                FolderGuiFile.send();
            }
            //blocks
            if (!FolderBlocks.folderBlock.exists()){
                FolderBlocks.folderBlock.createNewFile();
                FolderBlocks.send();
            }
            //ores
            if (!FolderOres.folderOres.exists()){
                FolderOres.folderOres.createNewFile();
                FolderOres.send();
            }
            //clay
            if (!FolderClay.folderClay.exists()){
                FolderClay.folderClay.createNewFile();
                FolderClay.send();
            }
            //dye
            if (!FolderDye.folderDye.exists()){
                FolderDye.folderDye.createNewFile();
                FolderDye.send();
            }
            //food
            if (!FolderFood.folderFood.exists()){
                FolderFood.folderFood.createNewFile();
                FolderFood.send();
            }
            //log
            if (!FolderLog.folderLog.exists()){
                FolderLog.folderLog.createNewFile();
                FolderLog.send();
            }
            //stuff
            if (!FolderStuff.folderStuff.exists()){
                FolderStuff.folderStuff.createNewFile();
                FolderStuff.send();
            }
            //sword
            if (!FolderSword.folderSword.exists()){
                FolderSword.folderSword.createNewFile();
                FolderSword.send();
            }
            //unby
            if (!FolderUnby.folderUnby.exists()){
                FolderUnby.folderUnby.createNewFile();
                FolderUnby.send();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveAllFiles() {
        try{
            FolderGuiFile.guiFileConfig.save(FolderGuiFile.guiFile);
            FolderBlocks.folderBlockConfig.save(FolderBlocks.folderBlock);
            FolderOres.folderOresConfig.save(FolderOres.folderOres);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
