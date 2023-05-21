package actionClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingTable 
{

	
		@SuppressWarnings("resource")
		public static void main(String[] args) 
		{
			String fileName = System.getProperty("user.dir"); 
			String excelpath = fileName+ "./data/Teamplayer.xlsx";
			String sheetName = "team1";
			Object[][] data;
			try {
				FileInputStream fis = new FileInputStream(excelpath);
				XSSFWorkbook workbook = new XSSFWorkbook(fis);  
				
				XSSFSheet sheet = workbook.getSheet(sheetName);
				int totalRows = sheet.getLastRowNum();  // 6
				int totalCols = sheet.getRow(0).getLastCellNum();  //4
				data = new Object[totalRows][totalCols];
				for(int i=1;i<=totalRows;i++)
				{
					for(int j=0;j<totalCols;j++)
						data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println();
				}
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("File Not found " + excelpath);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Error in opening workbook " + excelpath);
			}
			
			for(int r=0;r<data.length;r++)
			{
				for(int c=0;c<data[r].length;c++)
					System.out.print(String.format("%15s", data[r][c])) ;
				System.out.println();
			}
			

	}

}
