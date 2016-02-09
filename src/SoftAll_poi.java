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

public class SoftAll_poi {

	public static void main(String[] args) {
		 	double[][] values_initial=new double[400][200];
		//public static 	double[][] values_final=new double[4][40];
		  double[] width=new double[200];
		  double k=0;
		// TODO Auto-generated method stub
		
		try {
		    
		    FileInputStream file = new FileInputStream(new File("C:\\Users\\Sushma\\Documents\\commit_data_2003.xls"));
		     
		    //Get the workbook instance for XLS file 
		    HSSFWorkbook workbook = new HSSFWorkbook(file);

		    //Get first sheet from the workbook
		    HSSFSheet sheet = workbook.getSheetAt(0);
		     
		    

		
		for(int i=1;i<107;i++)
		{
		for(int j=1;j<301;j++)
		{
                  
			if(sheet.getRow(j).getCell(i).getNumericCellValue()==1111)
            {
              break;
            }     
            

		       values_initial[j][i]=sheet.getRow(j).getCell(i).getNumericCellValue();
		//       System.out.print( values_initial[j][i]+" ");
		       k+=1;
                      			
		  

  	    }
		
      // System.out.println();
       width[i]=k;
      // System.out.println("k is "+k+" width is "+width[i]);
		
		
		k=0;
		}
		
		/*for(int i=1;i<107;i++)
		{
			//System.out.println(i);
			for(int j=1;j<301;j++)
			{
			System.out.println(i);
			}
	    }
          */  //FileOutputStream out = 
              //  new FileOutputStream(new File("C:\\test.xls"));
            //workbook.write(out);
            //out.close();
             
		
	/*	for(int i=1;i<107;i++)
		{
		for(int j=1;j<width[i]+1;j++)
		{
			System.out.print(i+"   "+j);
			//System.out.println("Soft  "+i);
              // System.out.print(values_initial[j][i]+"  ");
				
		}
	      System.out.println();
		}
		*/
		
		file.close();
	}
	     catch (FileNotFoundException e) {
			    e.printStackTrace();
			} catch (IOException e) {
			    e.printStackTrace();
			}

	//	System.out.println(values_initial[1][10]);
	}

}
