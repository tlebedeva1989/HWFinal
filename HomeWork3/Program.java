

import HomeWork3.base.classes.Presenter;
import HomeWork3.base.classes.checkInputData.*;
import HomeWork3.base.classes.parseData.CDataParseProcessor;
import HomeWork3.base.classes.ui.CGetData;
import HomeWork3.base.classes.workWithFile.CFileCreator;
import HomeWork3.base.classes.workWithFile.CFileWriter;
import HomeWork3.base.classes.workWithFile.CFindTheSameFileName;
import base.classes.Presenter;
import base.classes.workWithFile.CFileWriter;

import java.io.IOException;


public class Program {
    public static void main(String[] args) throws IOException {
        // Путь к папке с файлами
        String infoPathFolder = "src/HomeWork3/data/";
        Presenter presenter = new Presenter(new CGetData(),
                                            new CDataParseProcessor(),
                                            new HomeWork3.base.classes.checkInputData.CCheckDataProcessor(new HomeWork3.base.classes.checkInputData.CCheckQuantity(),
                                                                    new HomeWork3.base.classes.checkInputData.CCheckFullName(),
                                                                    new HomeWork3.base.classes.checkInputData.CCheckBirthday(),
                                                                    new HomeWork3.base.classes.checkInputData.CCheckSex()),
                                            new CFileWriter(new CFileCreator(),
                                                            new CFindTheSameFileName(),
                                                    infoPathFolder));
        presenter.run();
    }
}
