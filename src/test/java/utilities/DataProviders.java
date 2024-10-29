package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getLoginData() throws Exception {
        String path = System.getProperty("user.dir") + "\\testdata\\logintestdata.xlsx";
        Excelutility obj = new Excelutility(path);

        int row_size = obj.getRowCount("Sheet1");
        int col_size = obj.getCellCount("Sheet1", 1);

        String[][] loginData = new String[row_size][col_size];
        for (int row = 1; row <= row_size; row++) {
            for (int col = 0; col < col_size; col++) {
                loginData[row - 1][col] = obj.getCellData("Sheet1", row, col);
            }
        }

        return loginData;
    }

    @DataProvider(name ="Registration_Data")
    public String[][] getRegistrationData() throws Exception {
        String path = System.getProperty("user.dir") + "\\testdata\\RegistrationTestData.xlsx";
        Excelutility obj = new Excelutility(path);

        int row_size = obj.getRowCount("Sheet1");
        int col_size = obj.getCellCount("Sheet1", 1);

        String[][] registrationData = new String[row_size][col_size];
        for (int row = 1; row <= row_size; row++) {
            for (int col = 0; col < col_size; col++) {
                registrationData[row - 1][col] = obj.getCellData("Sheet1", row, col);
            }
        }

        return registrationData;
    }
}
