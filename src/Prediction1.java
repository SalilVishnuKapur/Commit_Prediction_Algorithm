import java.util.Scanner;


public class Prediction1
{

	public static void main(String[] args) 
	{
		
     int x,c,row,colm;
     double xx,xxx,xxxx,U1_mid,U2_mid,U3_mid,U4_mid,U5_mid,U6_mid;
     double Sum=0,numbers=0;
	 System.out.println("This to perform prediction");
	 Scanner obj=new Scanner(System.in);

	 System.out.println("Enter the number of years for which you want to predict ");
	 int num =obj.nextInt();
	 
	 System.out.println("Enter the beginning year of epoch you want to predict for ");
	 int start=obj.nextInt();
	 int[] Enrollments=new int[num+start];
	 int[] Variations=new int[num+start];
	 int[] Variationsc=new int[num+start];
	 String[] FuzzVar=new String[num+start];
	 double[][] DecFuzz=new double[num+start][num+start];
	 double[] ForEnrl=new double[start+num];
	 for(int i=start;i<(start+num);i++)
	 {
		 System.out.println("Enter the  Enrollments["+i+"]");
		 Enrollments[i]=obj.nextInt();
		 
     }
	 
	 

	 for(int i=start+1;i<(start+num);i++)
	 {
		 Variations[i]=Enrollments[i]-Enrollments[i-1];
		 
     }

	 for(int i=start+1;i<(start+num);i++)
	 {
		 Variationsc[i]=Variations[i];
		 
     }
	 System.out.println("****Now we will start computation on years,erollments and variations****");
	 for(int i=start+1;i<(start+num)-1;i++)
	 {
		 if(Variationsc[i]>Variationsc[i+1])
		 {
			 
			 x=Variationsc[i+1];
			 Variationsc[i+1]=Variationsc[i];
			 Variationsc[i]=x;
			 
		 }
		 
		
		 
     }
	  
	 System.out.println("Max variation is "+Variationsc[start+num-1]);
	 for(int i=start+num-1;i>start+1;i--)
	 {
		 if(Variationsc[i-1]>Variationsc[i])
		 {
			 
			 x=Variationsc[i];
			 Variationsc[i]=Variationsc[i-1];
			 Variationsc[i-1]=x;
			 
		 }
		 
		
		 
     }
	  
	 System.out.println("Min variation is "+Variationsc[start+1]);
	 for(int i=start+1;i<start+num;i++)
	 {
		 System.out.println(Variations[i]);
	 }


	 System.out.println("User please set the lower and upper bounds of variation for easy computations");
	 System.out.println("Type the lower bound for "+Variationsc[start+1]);
	 int min=obj.nextInt();
	 System.out.println("Type the upper bound for "+Variationsc[start+num-1]);
	 int max=obj.nextInt();
	 
	 System.out.println("Enter the number of partitions you want to make of the Universe of discourse U");
	 int partitions=obj.nextInt();
	 
	 int divlenth=(max-min)/partitions;
    
	 System.out.println("We are considering following fuzzzy sets ");
		System.out.println("A1 =big decrease ");
		System.out.println("A2 =decrease ");
		System.out.println("A3 =no change ");
		System.out.println("A4 =increase ");
		System.out.println("A5 =big increase ");
		System.out.println("A6 =too big increase ");
		double[] A1={1, 0.5,0,0,0,0};
		double[] A2={0.5,1,0.5,0,0,0};
		double[] A3={0,0.5,1,0.5,0,0};
		double[] A4={0,0,0.5,1,0.5,0};
		double[] A5={0,0,0,0.5,1,0.5};
		double[] A6={0,0,0,0,0.5,1};
		
	        
		
	 
	System.out.println("Now assigning fuzzyvariables to particular variations");
	for(int i=start+1;i<start+num;i++)
	{
		
		     
		    	  
			      if((min<=Variations[i])&&(Variations[i]<=(min+divlenth)))// error of the end bounds
			      {
			     FuzzVar[i]="A1";
			     DecFuzz[i]=A1;
			     
			      }
			      else if(((min+divlenth)<=Variations[i])&&(Variations[i]<=(min+2*divlenth)))
	    		  {
	    			 FuzzVar[i]="A2";
	    			 DecFuzz[i]=A2;
	    		
	              }
			      else if(((min+2*divlenth)<=Variations[i])&&(Variations[i]<=(min+3*divlenth)))
	     		 {
	     			FuzzVar[i]="A3";
	     			DecFuzz[i]=A3;
	     			
	     		 }
	              else if(((min+3*divlenth)<=Variations[i])&&(Variations[i]<=(min+4*divlenth)))
	     		 {
	     			FuzzVar[i]="A4";
	     			DecFuzz[i]=A4;
	 
	     		 }
	              else if(((min+4*divlenth)<=Variations[i])&&(Variations[i]<=(min+5*divlenth)))
	     		 {
	     			FuzzVar[i]="A5";
	     			DecFuzz[i]=A5;
	    
	     		 }
	     		 else if(((min+5*divlenth)<=Variations[i])&&(Variations[i]<=(min+6*divlenth)))
         		 {
	     			FuzzVar[i]="A6";
	     			DecFuzz[i]=A6;
	     		
	     		 }
	     		 else if(((min+6*divlenth)<=Variations[i])&&(Variations[i]<=(min+7*divlenth)))
	     		 {
	     			FuzzVar[i]="A7";
	     			
	     		 }
	         	 
	         	
	          
	     	
	     	
   } 
		 
	U1_mid=(min+min+divlenth)/2;
	U2_mid=(min+divlenth+min+2*divlenth)/2;
	U3_mid=(min+2*divlenth+min+3*divlenth)/2;
	U4_mid=(min+3*divlenth+min+4*divlenth)/2;
    U5_mid=(min+4*divlenth+min+5*divlenth)/2;
    U6_mid=(min+5*divlenth+min+6*divlenth)/2;
	for(int i=start+1;i<start+num;i++)
	{
		System.out.println(FuzzVar[i]);

     /*   for(int o=0;o<4;o++)
        {
      	  for(int j=0;j<6;j++)
      	  {
                System.out.print(DecFuzz[o][j]);        		  
      	  }
      	  System.out.println();
        }
        */
	}
	
	
	   System.out.println("Enter a suitable window basis w");
	   int w=obj.nextInt();
	   double[] u1=new double[start+num]; // efficiency can be improved
	   double[] u2=new double[start+num];
	   double[] u3=new double[start+num];
	   double[] u4=new double[start+num];
	   double[] u5=new double[start+num];
	   double[] u6=new double[start+num];
	  // double[][] Oper=new double[w][6];

	   
	   System.out.println("Designing a great output method");
	
	   double[][] result =new double[10][10];
	   for(int j=2;j<=9;j++)
	   {
		   switch(j)
		   {   
	                         
	               case 2:
	                       for (int e=start+1+2;e<start+num;e++)
        {
       		
       	  double[][] multresult = {DecFuzz[e-2]};
          double[][] sinresult={DecFuzz[e-1]};
          
          for(int i=0;i<1;i++)
          {
        	  for(int jj=0;jj<6;jj++)
        	  {
                  System.out.print(multresult[i][j]);        		  
        	  }
        	  System.out.println();
          }
          for(int m=0;m<1;m++)
          {
               	for(int n=0;n<6;n++)
               	{
                    result[m][n]=multresult[m][n]*sinresult[0][n];
               	}
          }
             
          for(int m=0;m<6;m++)
          {
               	for(int n=0;n<0;n++)
               	{
                     if(result[n][m]>result[n+1][m])
                     {
                   	  xx=result[n][m];
                   	  result[n][m]=result[n+1][m];
                   	  result[n+1][m]=xx;
                     }
               	}
          }
               
     double[] finres ={result[0][0],result[0][1],result[0][2],result[0][3],result[0][4],result[0][5]};
             u1[e]=finres[0]; 
             u2[e]=finres[1];
             u3[e]=finres[2];
             u4[e]=finres[3];
             u5[e]=finres[4];
             u6[e]=finres[5]; 

    	    		 
    		             
        }

        for (int e=start+1+2;e<start+num;e++)
        {
        
        	System.out.println(u1[e]+" "+u2[e]+" "+u3[e]+" "+u4[e]+" "+u5[e]+" "+u6[e]);
        
        }
        
        for (int e=start+1+2;e<start+num;e++)
        {
        	if(u1[e]==0&&u2[e]==0&&u3[e]==0&&u4[e]==0&&u5[e]==0&&u6[e]==0)
        	{
        		ForEnrl[e]=Enrollments[e-1] + 0 ;
        	}
        	else
        	{
        		
                double[] comp={u1[e],u2[e],u3[e],u4[e],u5[e],u6[e]};
                
                for(int i=0;i<4;i++)
                {
                     if(comp[i]==comp[i+1]&&comp[i+1]>comp[i+2])
                     {
            	       xxx=comp[i+2];
            	       comp[i+2]=comp[i];
            	       comp[i]=xxx;
                     }
                     else if(comp[i]>comp[i+1])
                     {
            	     xxxx=comp[i];
     			     comp[i]=comp[i+1];
     			     comp[i+1]=xxxx;
     		         }
                     if(comp[4]>comp[5])
                     {
            	     xxxx=comp[4];
     			     comp[4]=comp[5];
     			     comp[5]=xxxx;
     			     }
              
                }
                
                if(u1[e]==comp[5])
                {
            	 Sum=Sum+U1_mid;
            	 numbers=numbers+1;
                }
                if(u2[e]==comp[5])
                {
            	 Sum=Sum+U2_mid;
                 numbers=numbers+1;
                }
                if(u3[e]==comp[5])
                {
            	 Sum=Sum+U3_mid;
            	 numbers=numbers+1;
                }
                if(u4[e]==comp[5])
                {
            	 Sum=Sum+U4_mid;
            	 numbers=numbers+1;
                }
                if(u5[e]==comp[5])
                {
            	 Sum=Sum+U5_mid;
            	 numbers=numbers+1;
                }
                if(u6[e]==comp[5])
               {
            	Sum=Sum+U6_mid;
            	numbers=numbers+1;
               }
               
        	}
        	Sum=Sum/numbers;
        	ForEnrl[e]=Enrollments[e-1] + Sum ;
        	Sum=0;
        	numbers=0;
        }
        for (int e=start+1+2;e<start+num;e++)
        {
        	
        System.out.println(ForEnrl[e]);
        
        }
        System.out.println("***************window size 2 ends**********************");
        break;
        case 3:
	                       
        for(int e=start+1+3;e<start+num;e++)
        {
       		
       	  double[][] multresult = {DecFuzz[e-2],DecFuzz[e-3]};
          double[][] sinresult={DecFuzz[e-1]};
          
          for(int i=0;i<2;i++)
          {
        	  for(int jj=0;jj<6;jj++)
        	  {
                  System.out.print(multresult[i][jj]);        		  
        	  }
        	  System.out.println();
          }
               for(int m=0;m<2;m++)
               {
               	for(int n=0;n<6;n++)
               	{
               
                result[m][n]=multresult[m][n]*sinresult[0][n];
               	}
               }
             
               for(int m=0;m<6;m++)
               {
               	for(int n=0;n<1;n++)
               	{
                     if(result[n][m]>result[n+1][m])
                     {
                   	  xx=result[n][m];
                   	  result[n][m]=result[n+1][m];
                   	  result[n+1][m]=xx;
                     }
               	}
               }
               
     double[] finres ={result[1][0],result[1][1],result[1][2],result[1][3],result[1][4],result[1][5]};
             u1[e]=finres[0]; 
             u2[e]=finres[1];
             u3[e]=finres[2];
             u4[e]=finres[3];
             u5[e]=finres[4];
             u6[e]=finres[5]; 

    	    		 
    		             
        }

        for (int e=start+1+3;e<start+num;e++)
        {
        
        	System.out.println(u1[e]+" "+u2[e]+" "+u3[e]+" "+u4[e]+" "+u5[e]+" "+u6[e]);
        
        }
        
        for (int e=start+1+3;e<start+num;e++)
        {
        	if(u1[e]==0&&u2[e]==0&&u3[e]==0&&u4[e]==0&&u5[e]==0&&u6[e]==0)
        	{
        		ForEnrl[e]=Enrollments[e-1] + 0 ;
        	}
        	else
        	{
             double[] comp={u1[e],u2[e],u3[e],u4[e],u5[e],u6[e]};
             for(int i=0;i<4;i++)
             {
              if(comp[i]==comp[i+1]&&comp[i+1]>comp[i+2])
              {
            	  xxx=comp[i+2];
            	  comp[i+2]=comp[i];
            	  comp[i]=xxx;
              }
              else if(comp[i]>comp[i+1])
              {
            	  
            	 xxxx=comp[i];
     			 comp[i]=comp[i+1];
     			 comp[i+1]=xxxx;
     			 
              }
              if(comp[4]>comp[5])
              {
            	  
            	 xxxx=comp[4];
     			 comp[4]=comp[5];
     			 comp[5]=xxxx;
     			 
              }
              
             }
             if(u1[e]==comp[5])
             {
            	 Sum=Sum+U1_mid;
            	 numbers=numbers+1;
             }
             if(u2[e]==comp[5])
             {
            	 Sum=Sum+U2_mid;
            	 numbers=numbers+1;
             }
             if(u3[e]==comp[5])
             {
            	 Sum=Sum+U3_mid;
            	 numbers=numbers+1;
             }
             if(u4[e]==comp[5])
             {
            	 Sum=Sum+U4_mid;
            	 numbers=numbers+1;
             }
             if(u5[e]==comp[5])
             {
            	 Sum=Sum+U5_mid;
            	 numbers=numbers+1;
             }
             if(u6[e]==comp[5])
             {
            	 Sum=Sum+U6_mid;
            	 numbers=numbers+1;
             }
               
        	}
        	Sum=Sum/numbers;
        	ForEnrl[e]=Enrollments[e-1] + Sum ;
        	Sum=0;
        	numbers=0;
        }
        for (int e=start+1+3;e<start+num;e++)
        {
        	
        System.out.println(ForEnrl[e]);
        
        }
        System.out.println("**************window size 3 ends************************");
        break;
                  case 4:
	                       for (int e=start+1+4;e<start+num;e++)
        {
       		
       	  double[][] multresult = {DecFuzz[e-2],DecFuzz[e-3],DecFuzz[e-4]};
          double[][] sinresult={DecFuzz[e-1]};
          
          for(int i=0;i<3;i++)
          {
        	  for(int jj=0;jj<6;jj++)
        	  {
                  System.out.print(multresult[i][jj]);        		  
        	  }
        	  System.out.println();
          }
               for(int m=0;m<3;m++)
               {
               	for(int n=0;n<6;n++)
               	{
               
                result[m][n]=multresult[m][n]*sinresult[0][n];
               	}
               }
             
               for(int m=0;m<6;m++)
               {
               	for(int n=0;n<2;n++)
               	{
                     if(result[n][m]>result[n+1][m])
                     {
                   	  xx=result[n][m];
                   	  result[n][m]=result[n+1][m];
                   	  result[n+1][m]=xx;
                     }
               	}
               }
               
     double[] finres ={result[2][0],result[2][1],result[2][2],result[2][3],result[2][4],result[2][5]};
             u1[e]=finres[0]; 
             u2[e]=finres[1];
             u3[e]=finres[2];
             u4[e]=finres[3];
             u5[e]=finres[4];
             u6[e]=finres[5]; 

    	    		 
    		             
        }

        for (int e=start+1+4;e<start+num;e++)
        {
        
        	System.out.println(u1[e]+" "+u2[e]+" "+u3[e]+" "+u4[e]+" "+u5[e]+" "+u6[e]);
        
        }
        
        for (int e=start+1+4;e<start+num;e++)
        {
        	if(u1[e]==0&&u2[e]==0&&u3[e]==0&&u4[e]==0&&u5[e]==0&&u6[e]==0)
        	{
        		ForEnrl[e]=Enrollments[e-1] + 0 ;
        	}
        	else
        	{
             double[] comp={u1[e],u2[e],u3[e],u4[e],u5[e],u6[e]};
             for(int i=0;i<4;i++)
             {
              if(comp[i]==comp[i+1]&&comp[i+1]>comp[i+2])
              {
            	  xxx=comp[i+2];
            	  comp[i+2]=comp[i];
            	  comp[i]=xxx;
              }
              else if(comp[i]>comp[i+1])
              {
            	  
            	 xxxx=comp[i];
     			 comp[i]=comp[i+1];
     			 comp[i+1]=xxxx;
     			 
              }
              if(comp[4]>comp[5])
              {
            	  
            	 xxxx=comp[4];
     			 comp[4]=comp[5];
     			 comp[5]=xxxx;
     			 
              }
              
             }
             if(u1[e]==comp[5])
             {
            	 Sum=Sum+U1_mid;
            	 numbers=numbers+1;
             }
             if(u2[e]==comp[5])
             {
            	 Sum=Sum+U2_mid;
            	 numbers=numbers+1;
             }
             if(u3[e]==comp[5])
             {
            	 Sum=Sum+U3_mid;
            	 numbers=numbers+1;
             }
             if(u4[e]==comp[5])
             {
            	 Sum=Sum+U4_mid;
            	 numbers=numbers+1;
             }
             if(u5[e]==comp[5])
             {
            	 Sum=Sum+U5_mid;
            	 numbers=numbers+1;
             }
             if(u6[e]==comp[5])
             {
            	 Sum=Sum+U6_mid;
            	 numbers=numbers+1;
             }
               
        	}
        	Sum=Sum/numbers;
        	ForEnrl[e]=Enrollments[e-1] + Sum ;
        	Sum=0;
        	numbers=0;
        }
        for (int e=start+1+4;e<start+num;e++)
        {
        	
        System.out.println(ForEnrl[e]);
        
        }
        System.out.println("******************window size 4 ends***************************");
        break;
         case 5:
	               
	       for (int e=start+1+5;e<start+num;e++)
        {
       		
       	  double[][] multresult = {DecFuzz[e-2],DecFuzz[e-3],DecFuzz[e-4],DecFuzz[e-5]};
          double[][] sinresult={DecFuzz[e-1]};
          
          for(int i=0;i<4;i++)
          {
        	  for(int jj=0;jj<6;jj++)
        	  {
                  System.out.print(multresult[i][jj]);        		  
        	  }
        	  System.out.println();
          }
               for(int m=0;m<4;m++)
               {
               	for(int n=0;n<6;n++)
               	{
               
                result[m][n]=multresult[m][n]*sinresult[0][n];
               	}
               }
             
               for(int m=0;m<6;m++)
               {
               	for(int n=0;n<3;n++)
               	{
                     if(result[n][m]>result[n+1][m])
                     {
                   	  xx=result[n][m];
                   	  result[n][m]=result[n+1][m];
                   	  result[n+1][m]=xx;
                     }
               	}
               }
               
     double[] finres ={result[3][0],result[3][1],result[3][2],result[3][3],result[3][4],result[3][5]};
             u1[e]=finres[0]; 
             u2[e]=finres[1];
             u3[e]=finres[2];
             u4[e]=finres[3];
             u5[e]=finres[4];
             u6[e]=finres[5]; 

    	    		 
    		             
        }

        for (int e=start+1+5;e<start+num;e++)
        {
        
        	System.out.println(u1[e]+" "+u2[e]+" "+u3[e]+" "+u4[e]+" "+u5[e]+" "+u6[e]);
        
        }
        
        for (int e=start+1+5;e<start+num;e++)
        {
        	if(u1[e]==0&&u2[e]==0&&u3[e]==0&&u4[e]==0&&u5[e]==0&&u6[e]==0)
        	{
        		ForEnrl[e]=Enrollments[e-1] + 0 ;
        	}
        	else
        	{
             double[] comp={u1[e],u2[e],u3[e],u4[e],u5[e],u6[e]};
             for(int i=0;i<4;i++)
             {
              if(comp[i]==comp[i+1]&&comp[i+1]>comp[i+2])
              {
            	  xxx=comp[i+2];
            	  comp[i+2]=comp[i];
            	  comp[i]=xxx;
              }
              else if(comp[i]>comp[i+1])
              {
            	  
            	 xxxx=comp[i];
     			 comp[i]=comp[i+1];
     			 comp[i+1]=xxxx;
     			 
              }
              if(comp[4]>comp[5])
              {
            	  
            	 xxxx=comp[4];
     			 comp[4]=comp[5];
     			 comp[5]=xxxx;
     			 
              }
              
             }
             if(u1[e]==comp[5])
             {
            	 Sum=Sum+U1_mid;
            	 numbers=numbers+1;
             }
             if(u2[e]==comp[5])
             {
            	 Sum=Sum+U2_mid;
            	 numbers=numbers+1;
             }
             if(u3[e]==comp[5])
             {
            	 Sum=Sum+U3_mid;
            	 numbers=numbers+1;
             }
             if(u4[e]==comp[5])
             {
            	 Sum=Sum+U4_mid;
            	 numbers=numbers+1;
             }
             if(u5[e]==comp[5])
             {
            	 Sum=Sum+U5_mid;
            	 numbers=numbers+1;
             }
             if(u6[e]==comp[5])
             {
            	 Sum=Sum+U6_mid;
            	 numbers=numbers+1;
             }
               
        	}
        	Sum=Sum/numbers;
        	ForEnrl[e]=Enrollments[e-1] + Sum ;
        	Sum=0;
        	numbers=0;
        }
        for (int e=start+1+5;e<start+num;e++)
        {
        	
        System.out.println(ForEnrl[e]);
        
        }		             
        System.out.println("**************window size 5 ends************************");
        break;
	               case 6:
	                       for (int e=start+1+6;e<start+num;e++)
        {
       		
       	  double[][] multresult = {DecFuzz[e-2],DecFuzz[e-3],DecFuzz[e-4],DecFuzz[e-5],DecFuzz[e-6]};
          double[][] sinresult={DecFuzz[e-1]};
          
          for(int i=0;i<5;i++)
          {
        	  for(int jj=0;jj<6;jj++)
        	  {
                  System.out.print(multresult[i][jj]);        		  
        	  }
        	  System.out.println();
          }
               for(int m=0;m<5;m++)
               {
               	for(int n=0;n<6;n++)
               	{
               
                result[m][n]=multresult[m][n]*sinresult[0][n];
               	}
               }
             
               for(int m=0;m<6;m++)
               {
               	for(int n=0;n<4;n++)
               	{
                     if(result[n][m]>result[n+1][m])
                     {
                   	  xx=result[n][m];
                   	  result[n][m]=result[n+1][m];
                   	  result[n+1][m]=xx;
                     }
               	}
               }
               
     double[] finres ={result[4][0],result[4][1],result[4][2],result[4][3],result[4][4],result[4][5]};
             u1[e]=finres[0]; 
             u2[e]=finres[1];
             u3[e]=finres[2];
             u4[e]=finres[3];
             u5[e]=finres[4];
             u6[e]=finres[5]; 

    	    		 
    		             
        }

        for (int e=start+1+6;e<start+num;e++)
        {
        
        	System.out.println(u1[e]+" "+u2[e]+" "+u3[e]+" "+u4[e]+" "+u5[e]+" "+u6[e]);
        
        }
        
        for (int e=start+1+6;e<start+num;e++)
        {
        	if(u1[e]==0&&u2[e]==0&&u3[e]==0&&u4[e]==0&&u5[e]==0&&u6[e]==0)
        	{
        		ForEnrl[e]=Enrollments[e-1] + 0 ;
        	}
        	else
        	{
             double[] comp={u1[e],u2[e],u3[e],u4[e],u5[e],u6[e]};
             for(int i=0;i<4;i++)
             {
              if(comp[i]==comp[i+1]&&comp[i+1]>comp[i+2])
              {
            	  xxx=comp[i+2];
            	  comp[i+2]=comp[i];
            	  comp[i]=xxx;
              }
              else if(comp[i]>comp[i+1])
              {
            	  
            	 xxxx=comp[i];
     			 comp[i]=comp[i+1];
     			 comp[i+1]=xxxx;
     			 
              }
              if(comp[4]>comp[5])
              {
            	  
            	 xxxx=comp[4];
     			 comp[4]=comp[5];
     			 comp[5]=xxxx;
     			 
              }
              
             }
             if(u1[e]==comp[5])
             {
            	 Sum=Sum+U1_mid;
            	 numbers=numbers+1;
             }
             if(u2[e]==comp[5])
             {
            	 Sum=Sum+U2_mid;
            	 numbers=numbers+1;
             }
             if(u3[e]==comp[5])
             {
            	 Sum=Sum+U3_mid;
            	 numbers=numbers+1;
             }
             if(u4[e]==comp[5])
             {
            	 Sum=Sum+U4_mid;
            	 numbers=numbers+1;
             }
             if(u5[e]==comp[5])
             {
            	 Sum=Sum+U5_mid;
            	 numbers=numbers+1;
             }
             if(u6[e]==comp[5])
             {
            	 Sum=Sum+U6_mid;
            	 numbers=numbers+1;
             }
               
        	}
        	Sum=Sum/numbers;
        	ForEnrl[e]=Enrollments[e-1] + Sum ;
        	Sum=0;
        	numbers=0;
        }
        for (int e=start+1+6;e<start+num;e++)
        {
        	
        System.out.println(ForEnrl[e]);
        
        }
        System.out.println("************window size 6 ends****************");
        break;
                 case 7:
                         for (int e=start+1+7;e<start+num;e++)
        {
       		
       	  double[][] multresult = {DecFuzz[e-2],DecFuzz[e-3],DecFuzz[e-4],DecFuzz[e-5],DecFuzz[e-6],DecFuzz[e-7]};
          double[][] sinresult={DecFuzz[e-1]};
          
          for(int i=0;i<6;i++)
          {
        	  for(int jj=0;jj<6;jj++)
        	  {
                  System.out.print(multresult[i][jj]);        		  
        	  }
        	  System.out.println();
          }
               for(int m=0;m<6;m++)
               {
               	for(int n=0;n<6;n++)
               	{
               
                result[m][n]=multresult[m][n]*sinresult[0][n];
               	}
               }
             
               for(int m=0;m<6;m++)
               {
               	for(int n=0;n<5;n++)
               	{
                     if(result[n][m]>result[n+1][m])
                     {
                   	  xx=result[n][m];
                   	  result[n][m]=result[n+1][m];
                   	  result[n+1][m]=xx;
                     }
               	}
               }
               
     double[] finres ={result[5][0],result[5][1],result[5][2],result[5][3],result[5][4],result[5][5]};
             u1[e]=finres[0]; 
             u2[e]=finres[1];
             u3[e]=finres[2];
             u4[e]=finres[3];
             u5[e]=finres[4];
             u6[e]=finres[5]; 

    	    		 
    		             
        }

        for (int e=start+1+7;e<start+num;e++)
        {
        
        	System.out.println(u1[e]+" "+u2[e]+" "+u3[e]+" "+u4[e]+" "+u5[e]+" "+u6[e]);
        
        }
        
        for (int e=start+1+7;e<start+num;e++)
        {
        	if(u1[e]==0&&u2[e]==0&&u3[e]==0&&u4[e]==0&&u5[e]==0&&u6[e]==0)
        	{
        		ForEnrl[e]=Enrollments[e-1] + 0 ;
        	}
        	else
        	{
             double[] comp={u1[e],u2[e],u3[e],u4[e],u5[e],u6[e]};
             for(int i=0;i<4;i++)
             {
              if(comp[i]==comp[i+1]&&comp[i+1]>comp[i+2])
              {
            	  xxx=comp[i+2];
            	  comp[i+2]=comp[i];
            	  comp[i]=xxx;
              }
              else if(comp[i]>comp[i+1])
              {
            	  
            	 xxxx=comp[i];
     			 comp[i]=comp[i+1];
     			 comp[i+1]=xxxx;
     			 
              }
              if(comp[4]>comp[5])
              {
            	  
            	 xxxx=comp[4];
     			 comp[4]=comp[5];
     			 comp[5]=xxxx;
     			 
              }
              
             }
             if(u1[e]==comp[5])
             {
            	 Sum=Sum+U1_mid;
            	 numbers=numbers+1;
             }
             if(u2[e]==comp[5])
             {
            	 Sum=Sum+U2_mid;
            	 numbers=numbers+1;
             }
             if(u3[e]==comp[5])
             {
            	 Sum=Sum+U3_mid;
            	 numbers=numbers+1;
             }
             if(u4[e]==comp[5])
             {
            	 Sum=Sum+U4_mid;
            	 numbers=numbers+1;
             }
             if(u5[e]==comp[5])
             {
            	 Sum=Sum+U5_mid;
            	 numbers=numbers+1;
             }
             if(u6[e]==comp[5])
             {
            	 Sum=Sum+U6_mid;
            	 numbers=numbers+1;
             }
               
        	}
        	Sum=Sum/numbers;
        	ForEnrl[e]=Enrollments[e-1] + Sum ;
        	Sum=0;
        	numbers=0;
        }
        for (int e=start+1+7;e<start+num;e++)
        {
        	
        System.out.println(ForEnrl[e]);
        
        }
        System.out.println("***************window size 7 ends***********************");
        break;
                  case 8:
                          for (int e=start+1+8;e<start+num;e++)
        {
       		
       	  double[][] multresult = {DecFuzz[e-2],DecFuzz[e-3],DecFuzz[e-4],DecFuzz[e-5],DecFuzz[e-6],DecFuzz[e-7],DecFuzz[e-8]};
          double[][] sinresult={DecFuzz[e-1]};
          
          for(int i=0;i<7;i++)
          {
        	  for(int jj=0;jj<6;jj++)
        	  {
                  System.out.print(multresult[i][jj]);        		  
        	  }
        	  System.out.println();
          }
               for(int m=0;m<7;m++)
               {
               	for(int n=0;n<6;n++)
               	{
               
                result[m][n]=multresult[m][n]*sinresult[0][n];
               	}
               }
             
               for(int m=0;m<6;m++)
               {
               	for(int n=0;n<6;n++)
               	{
                     if(result[n][m]>result[n+1][m])
                     {
                   	  xx=result[n][m];
                   	  result[n][m]=result[n+1][m];
                   	  result[n+1][m]=xx;
                     }
               	}
               }
               
     double[] finres ={result[6][0],result[6][1],result[6][2],result[6][3],result[6][4],result[6][5]};
             u1[e]=finres[0]; 
             u2[e]=finres[1];
             u3[e]=finres[2];
             u4[e]=finres[3];
             u5[e]=finres[4];
             u6[e]=finres[5]; 

    	    		 
    		             
        }

        for (int e=start+1+8;e<start+num;e++)
        {
        
        	System.out.println(u1[e]+" "+u2[e]+" "+u3[e]+" "+u4[e]+" "+u5[e]+" "+u6[e]);
        
        }
        
        for (int e=start+1+8;e<start+num;e++)
        {
        	if(u1[e]==0&&u2[e]==0&&u3[e]==0&&u4[e]==0&&u5[e]==0&&u6[e]==0)
        	{
        		ForEnrl[e]=Enrollments[e-1] + 0 ;
        	}
        	else
        	{
             double[] comp={u1[e],u2[e],u3[e],u4[e],u5[e],u6[e]};
             for(int i=0;i<4;i++)
             {
              if(comp[i]==comp[i+1]&&comp[i+1]>comp[i+2])
              {
            	  xxx=comp[i+2];
            	  comp[i+2]=comp[i];
            	  comp[i]=xxx;
              }
              else if(comp[i]>comp[i+1])
              {
            	  
            	 xxxx=comp[i];
     			 comp[i]=comp[i+1];
     			 comp[i+1]=xxxx;
     			 
              }
              if(comp[4]>comp[5])
              {
            	  
            	 xxxx=comp[4];
     			 comp[4]=comp[5];
     			 comp[5]=xxxx;
     			 
              }
              
             }
             if(u1[e]==comp[5])
             {
            	 Sum=Sum+U1_mid;
            	 numbers=numbers+1;
             }
             if(u2[e]==comp[5])
             {
            	 Sum=Sum+U2_mid;
            	 numbers=numbers+1;
             }
             if(u3[e]==comp[5])
             {
            	 Sum=Sum+U3_mid;
            	 numbers=numbers+1;
             }
             if(u4[e]==comp[5])
             {
            	 Sum=Sum+U4_mid;
            	 numbers=numbers+1;
             }
             if(u5[e]==comp[5])
             {
            	 Sum=Sum+U5_mid;
            	 numbers=numbers+1;
             }
             if(u6[e]==comp[5])
             {
            	 Sum=Sum+U6_mid;
            	 numbers=numbers+1;
             }
               
        	}
        	Sum=Sum/numbers;
        	ForEnrl[e]=Enrollments[e-1] + Sum ;
        	Sum=0;
        	numbers=0;
        }
        for (int e=start+1+8;e<start+num;e++)
        {
        	
        System.out.println(ForEnrl[e]);
        
        }
        System.out.println("**************window size 8 ends***************");
        break;
                  case 9:
                          for (int e=start+1+9;e<start+num;e++)
        {
       		
       	  double[][] multresult = {DecFuzz[e-2],DecFuzz[e-3],DecFuzz[e-4],DecFuzz[e-5],DecFuzz[e-6],DecFuzz[e-7],DecFuzz[e-8],DecFuzz[e-9]};
          double[][] sinresult={DecFuzz[e-1]};
          
          for(int i=0;i<8;i++)
          {
        	  for(int jj=0;jj<6;jj++)
        	  {
                  System.out.print(multresult[i][jj]);        		  
        	  }
        	  System.out.println();
          }
               for(int m=0;m<8;m++)
               {
               	for(int n=0;n<6;n++)
               	{
               
                result[m][n]=multresult[m][n]*sinresult[0][n];
               	}
               }
             
               for(int m=0;m<6;m++)
               {
               	for(int n=0;n<7;n++)
               	{
                     if(result[n][m]>result[n+1][m])
                     {
                   	  xx=result[n][m];
                   	  result[n][m]=result[n+1][m];
                   	  result[n+1][m]=xx;
                     }
               	}
               }
               
     double[] finres ={result[7][0],result[7][1],result[7][2],result[7][3],result[7][4],result[7][5]};
             u1[e]=finres[0]; 
             u2[e]=finres[1];
             u3[e]=finres[2];
             u4[e]=finres[3];
             u5[e]=finres[4];
             u6[e]=finres[5]; 

    	    		 
    		             
        }

        for (int e=start+1+9;e<start+num;e++)
        {
        
        	System.out.println(u1[e]+" "+u2[e]+" "+u3[e]+" "+u4[e]+" "+u5[e]+" "+u6[e]);
        
        }
        
        for (int e=start+1+9;e<start+num;e++)
        {
        	if(u1[e]==0&&u2[e]==0&&u3[e]==0&&u4[e]==0&&u5[e]==0&&u6[e]==0)
        	{
        		ForEnrl[e]=Enrollments[e-1] + 0 ;
        	}
        	else
        	{
             double[] comp={u1[e],u2[e],u3[e],u4[e],u5[e],u6[e]};
             for(int i=0;i<4;i++)
             {
              if(comp[i]==comp[i+1]&&comp[i+1]>comp[i+2])
              {
            	  xxx=comp[i+2];
            	  comp[i+2]=comp[i];
            	  comp[i]=xxx;
              }
              else if(comp[i]>comp[i+1])
              {
            	  
            	 xxxx=comp[i];
     			 comp[i]=comp[i+1];
     			 comp[i+1]=xxxx;
     			 
              }
              if(comp[4]>comp[5])
              {
            	  
            	 xxxx=comp[4];
     			 comp[4]=comp[5];
     			 comp[5]=xxxx;
     			 
              }
              
             }
             if(u1[e]==comp[5])
             {
            	 Sum=Sum+U1_mid;
            	 numbers=numbers+1;
             }
             if(u2[e]==comp[5])
             {
            	 Sum=Sum+U2_mid;
            	 numbers=numbers+1;
             }
             if(u3[e]==comp[5])
             {
            	 Sum=Sum+U3_mid;
            	 numbers=numbers+1;
             }
             if(u4[e]==comp[5])
             {
            	 Sum=Sum+U4_mid;
            	 numbers=numbers+1;
             }
             if(u5[e]==comp[5])
             {
            	 Sum=Sum+U5_mid;
            	 numbers=numbers+1;
             }
             if(u6[e]==comp[5])
             {
            	 Sum=Sum+U6_mid;
            	 numbers=numbers+1;
             }
               
        	}
        	Sum=Sum/numbers;
        	ForEnrl[e]=Enrollments[e-1] + Sum ;
        	Sum=0;
        	numbers=0;
        }
        for (int e=start+1+9;e<start+num;e++)
        {
        	
        System.out.println(ForEnrl[e]);
        
        }	   
        System.out.println("**************END*****************************");
        break;
	   }
	
	}
	   
	   

     }
	

	
}
	  




