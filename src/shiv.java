import java.awt.Frame;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.StringReader;


public class shiv {
	
	
	public static void main(String[] args) {
		FileReader fr = null;
		try{
			File f= new File("C:\\Users\\Sushma\\ExcelTest\\statepopulation.xls");
			 fr= new FileReader(f);
			}catch(Exception E)
			{
				System.out.println("file not found");
			}
			try{
				String s;
				LineNumberReader lnr = new LineNumberReader(fr);
				while((s=lnr.readLine())!=null)
				{
					System.out.println(s+"\n");
				}
		}catch(Exception e)
			{
				System.out.println("not done");
			}
	}
}
