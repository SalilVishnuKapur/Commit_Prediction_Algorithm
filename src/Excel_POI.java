import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Excel_POI 
{
	static double k=0;
static	double[][] values_initial=new double[200][400];
static	double[][] values_final=new double[200][400];
static double[] width=new double[200];
	public static void main(String[] args) throws IOException 
	
	{
			
		try {
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\Sushma\\Documents\\commit_data_2003.xls"));
			HSSFWorkbook 	workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			
			//this will run for 100 times
			java.util.Iterator<Row> rowIterator = sheet.iterator();
			for(int i=0;i<107;i++)
			{
			if(i==0)
			{
			rowIterator.next();
			}
			else
			{
			 if(rowIterator.hasNext()) 
			{
			Row row = rowIterator.next();
			for(int j=0;j<256;j++)
			{
			//For each row, iterate through each columns
			 java.util.Iterator<Cell> cellIterator = row.cellIterator();
			if(j==0)
			{
			cellIterator.next();
			}
			else
			{
			 if(cellIterator.hasNext()) 
			 {

			      values_initial[i][j]=sheet.getRow(i).getCell(j).getNumericCellValue();
			      k++;
			 }
			}

			}
			width[i]=k;
			k=0;
			}
			}
		
	            //FileOutputStream out = 
	              //  new FileOutputStream(new File("C:\\test.xls"));
	            //workbook.write(out);
	            //out.close();
	             
			
			}
			for(int i=1;i<107;i++)
			{
				for(int j=1;j<width[i]+1;j++)
				{
					
                   System.out.print(values_initial[i][j]+"  ");
					
			     }
				System.out.println();
			}
			file.close();
		}
		  
			catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	
		

			
		}
	}

	
	
 
