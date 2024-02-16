package Excel_Datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
public static void main(String[] args) throws IOException {
		
		//FileInputStream argument
		FileInputStream file=new FileInputStream("D:\\C DATA 13-01-24\\Desktop\\KEY POINTS\\excelDataDriven.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		
		int sheets=workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("data"))
			{
			XSSFSheet sheet=workbook.getSheetAt(i);
			
			//identify test cases column by scanning the entire 1st row
			Iterator<Row> rows=sheet.iterator(); // access to all rows(sheet is a collection of rows)
			Row firstRow=rows.next();                        //access to first row 
			Iterator<Cell> cellsOfFirstRow=firstRow.cellIterator();    //access to each cell in the row(row is a collection of cells)
			int k=0;
			int column=0;
			while(cellsOfFirstRow.hasNext())
			{
				Cell cell=cellsOfFirstRow.next();
				if(cell.getStringCellValue().equalsIgnoreCase("testcase"))
				{
					column=k;
				}
				k++;
			}
			System.out.println(column);
			}
			
		}

	}


}
