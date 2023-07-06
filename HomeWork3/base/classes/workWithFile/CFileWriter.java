package base.classes.workWithFile;

import HomeWork3.base.abstractClasses.AFileWriter;
import HomeWork3.base.classes.workWithFile.CFileCreator;
import HomeWork3.base.classes.workWithFile.CFindTheSameFileName;
import HomeWork3.base.exceptions.FileCreateException;
import HomeWork3.base.exceptions.MyFileCreateException;
import HomeWork3.base.exceptions.TheSameFileWritingException;
import base.abstractClasses.AFileWriter;

import java.io.FileWriter;
import java.io.IOException;

public class CFileWriter extends AFileWriter {
    private final String folderPath;


    public CFileWriter(CFileCreator fileCreator, CFindTheSameFileName findTheSameFileName, String folderPath) {
        super.fileCreator = fileCreator;
        super.findTheSameFileName = findTheSameFileName;
        this.folderPath = folderPath;
    }

    public CFileWriter(CFileCreator cFileCreator, CFindTheSameFileName cFindTheSameFileName, String infoPathFolder, String folderPath) {


        this.folderPath = folderPath;
    }

    @Override
    public boolean writeToFile(String[] infoToWrite) throws TheSameFileWritingException, MyFileCreateException {
        String path = this.folderPath + infoToWrite[0] + ".txt";

        if(findTheSameFileName.findTheSameFileName(infoToWrite[0], this.folderPath)){
            System.out.println("Found the same last name");
            try {
                super.fileWriter = new FileWriter(path, true);
                super.fileWriter.write(infoToWrite[1]+"\n");
                super.fileWriter.close();
                System.out.println("The data write");
            }catch (IOException e){
                throw new TheSameFileWritingException(e.getMessage());
            }
        }else {
            try {
                fileCreator.createFile(path);
                System.out.println("New file created");
            } catch (FileCreateException e) {
                throw new MyFileCreateException(e.getMessage());
            }
            try {
                super.fileWriter = new FileWriter(path, true);
                super.fileWriter.write(infoToWrite[1]+"\n");
                super.fileWriter.close();
                System.out.println("The data write");
            }catch (IOException e){
                throw new TheSameFileWritingException(e.getMessage());
            }
        }
        return true;
    }
}
