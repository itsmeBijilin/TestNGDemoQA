package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "LoginData")
	public String[][] getData() throws Exception{
		/* Taking XL file from testData */
		String path=".\\testData\\loginQA.xlsx"; 
		
		/* Creating object for Excel utility */
		ExcelUtility xlUtil= new ExcelUtility(path);
		
		int totalRows=xlUtil.getRowCount("ValidCityPairs");
		int totalCols=xlUtil.getCellCount("ValidCityPairs", 1);
		
		/* Created for 2D array which can store */
		String loginData[][]=new String[totalRows][totalCols];
		
		for(int i=1;i<=totalRows;i++) { //read the data from xl storing in 2D array
			{
				for(int j=0;j<totalCols;j++) {
					loginData[i-1][j]=xlUtil.getCellData("ValidCityPairs", i, j); // i is rows j is col
				}
			}
		}
		return loginData;
	}
}
