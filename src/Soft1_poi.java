import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Soft1_poi {
	public static	double[][] values_initial=new double[400][200];
	//public static 	double[][] values_final=new double[4][40];
	public static double[] width=new double[200];
	public static double k=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		    
		    FileInputStream file = new FileInputStream(new File("C:\\Users\\Sushma\\Documents\\commit_data_2003.xls"));
		    //FileInputStream filec = new FileInputStream(new File("C:\\Users\\Sushma\\Documents\\update.xls"));
		    //Get the workbook instance for XLS file 
		    HSSFWorkbook workbook = new HSSFWorkbook(file);
		    HSSFWorkbook workbookc = new HSSFWorkbook();
		    //Get first sheet from the workbook
		    HSSFSheet sheet = workbook.getSheetAt(1);
		    HSSFSheet sheetc = workbookc.createSheet("sample sheet"); 
		    
	Cell cell=null;
		
			
		
		for(int j=1;j<301;j++)
		{
                  
			if(sheet.getRow(j).getCell(1).getNumericCellValue()==1111)
            {
              break;
            }     
            

		       values_initial[j][1]=sheet.getRow(j).getCell(1).getNumericCellValue();
		       k++;
                      			
		  

  	    }
		

		
		width[1]=k;
		
		
		
	
             
		
		
		for(int j=1;j<width[1]+1;j++)
		{
				
               System.out.println(" number of commits for month "+j+" are " +values_initial[j][1]);
				
		}
		for(int j=1;j<width[1]+1;j++)
		{
		
			Row row = sheetc.createRow(j);
			cell = row.createCell(0);
			cell.setCellValue(sheet.getRow(j).getCell(0).getNumericCellValue());
		
		}
		file.close();
		
		FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\Sushma\\Documents\\update.xls"));
		    workbookc.write(outFile);
		    outFile.close();
		
	}
	     catch (FileNotFoundException e) {
			    e.printStackTrace();
			} catch (IOException e) {
			    e.printStackTrace();
			}

	}

}
