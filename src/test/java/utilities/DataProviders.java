package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
    
    @DataProvider(name = "LoginData")
    public String[][] getData() throws Exception {
        String path = System.getProperty("user.dir")+"\\testdata\\logintestdata.xlsx";
        Excelutility obj = new Excelutility(path);
        
        // Get the number of rows and columns
        int row_size = obj.getRowCount("Sheet1");
        int col_size = obj.getCellCount("Sheet1", 1);
        
        // Initialize the data array
        String[][] logindata = new String[row_size][col_size];
        
        // Populate the data array from the Excel sheet
        for (int row = 1; row <= row_size; row++) { // Starting from 1 if there's a header
            for (int col = 0; col < col_size; col++) { // Fix: col_size should be <, not <=
                logindata[row - 1][col] = obj.getCellData("Sheet1", row, col);
            }
        }
        
        return logindata;
    }
}
