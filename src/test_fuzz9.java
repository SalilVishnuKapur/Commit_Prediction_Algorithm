public class test_fuzz9
{
 double get_fuz(int x1,int x2,double x3,int x4,int x5,double[][] x6,double x7)
	{
	int num=x1;
	int min=x2;
	double Variations=x3;
	int start=1;
	int divlenth=x4;
	int i=x5;
	
	String[] FuzzVar=new String[num+start+5];
	 double[][] DecFuzz=x6;
/*	 for(int io=start+1;io<start+num;io++)
     {
		   for(int j=0;j<6;j++)
     
     {
         
     	System.out.print(DecFuzz[io][j]+" ");
     }
		   System.out.println();
     }*/ //System.out.println(DecFuzz[4]);
	double[] A1={1, 0.5,0,0,0,0};
	double[] A2={0.5,1,0.5,0,0,0};
	double[] A3={0,0.5,1,0.5,0,0};
	double[] A4={0,0,0.5,1,0.5,0};
	double[] A5={0,0,0,0.5,1,0.5};
	double[] A6={0,0,0,0,0.5,1};
	
		
		     
		    	  
			      if((min<=Variations)&&(Variations<=(min+divlenth)))// error of the end bounds
			      {
			     FuzzVar[i]="A1";
			     DecFuzz[i]=A1;
			     
			      }
			      else if(((min+divlenth)<=Variations)&&(Variations<=(min+2*divlenth)))
	    		  {
		//	    	  System.out.println("ram");
	    			 FuzzVar[i]="A2";
	    			 DecFuzz[i]=A2;
	    		
	              }
			      else if(((min+2*divlenth)<=Variations)&&(Variations<=(min+3*divlenth)))
	     		 {
	     			FuzzVar[i]="A3";
	     			DecFuzz[i]=A3;
	     			
	     		 }
	              else if(((min+3*divlenth)<=Variations)&&(Variations<=(min+4*divlenth)))
	     		 {
	     			FuzzVar[i]="A4";
	     			DecFuzz[i]=A4;
	 
	     		 }
	              else if(((min+4*divlenth)<=Variations)&&(Variations<=(min+5*divlenth)))
	     		 {
	     			FuzzVar[i]="A5";
	     			DecFuzz[i]=A5;
	    
	     		 }
	     		 else if(((min+5*divlenth)<=Variations)&&(Variations<=(min+6*divlenth)))
         		 {
	     			FuzzVar[i]="A6";
	     			DecFuzz[i]=A6;
	     		
	     		 }
	     		 else if(((min+6*divlenth)<=Variations)&&(Variations<=(min+7*divlenth)))
	     		 {
	     			FuzzVar[i]="A7";
	     			
	     		 }
	         	 
	         	
	          
	     	
	 
  double xx,xxx,xxxx,U1_mid,U2_mid,U3_mid,U4_mid,U5_mid,U6_mid;
			      double[][] result =new double[10][10];
			      double Sum=0,numbers=0;
			      U1_mid=(min+min+divlenth)/2;
			  	U2_mid=(min+divlenth+min+2*divlenth)/2;
			  	U3_mid=(min+2*divlenth+min+3*divlenth)/2;
			  	U4_mid=(min+3*divlenth+min+4*divlenth)/2;
			      U5_mid=(min+4*divlenth+min+5*divlenth)/2;
			      U6_mid=(min+5*divlenth+min+6*divlenth)/2;
			  	
	  double[][] multresult = {DecFuzz[i-1],DecFuzz[i-2],DecFuzz[i-3],DecFuzz[i-4],DecFuzz[i-5],DecFuzz[i-6],DecFuzz[i-7],DecFuzz[i-8]};
   double[][] sinresult={DecFuzz[i]};
   double[] u1=new double[start+num+5]; // efficiency can be improved
   double[] u2=new double[start+num+5];
   double[] u3=new double[start+num+5];
   double[] u4=new double[start+num+5];
   double[] u5=new double[start+num+5];
   double[] u6=new double[start+num+5];
   double[] ForEnrl=new double[start+num+5]; 
   ForEnrl[i]=x7;
   for(int ix=0;ix<4;ix++)
   {
 	  for(int jj=0;jj<6;jj++)
 	  {
           System.out.print(multresult[ix][jj]);        		  
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
      u1[i+1]=finres[0]; 
      u2[i+1]=finres[1];
      u3[i+1]=finres[2];
      u4[i+1]=finres[3];
      u5[i+1]=finres[4];
      u6[i+1]=finres[5]; 

	    		 
		             
 

 
 	System.out.println(u1[i+1]+" "+u2[i+1]+" "+u3[i+1]+" "+u4[i+1]+" "+u5[i+1]+" "+u6[i+1]);
 
 
 	if(u1[i+1]==0&&u2[i+1]==0&&u3[i+1]==0&&u4[i+1]==0&&u5[i+1]==0&&u6[i+1]==0)
 	{
 		ForEnrl[i+1]=ForEnrl[i] + 0 ;
 	}
 	else
 	{
      double[] comp={u1[i+1],u2[i+1],u3[i+1],u4[i+1],u5[i+1],u6[i+1]};
      for(int ix=0;ix<4;ix++)
      {
       if(comp[ix]==comp[ix+1]&&comp[ix+1]>comp[ix+2])
       {
     	  xxx=comp[ix+2];
     	  comp[ix+2]=comp[ix];
     	  comp[ix]=xxx;
       }
       else if(comp[ix]>comp[ix+1])
       {
     	  
     	 xxxx=comp[ix];
			 comp[ix]=comp[ix+1];
			 comp[ix+1]=xxxx;
			 
       }
       if(comp[4]>comp[5])
       {
     	  
     	 xxxx=comp[4];
			 comp[4]=comp[5];
			 comp[5]=xxxx;
			 
       }
       
      }
      if(u1[i+1]==comp[5])
      {
     	 Sum=Sum+U1_mid;
     	 numbers=numbers+1;
      }
      if(u2[i+1]==comp[5])
      {
     	 Sum=Sum+U2_mid;
     	 numbers=numbers+1;
      }
      if(u3[i+1]==comp[5])
      {
     	 Sum=Sum+U3_mid;
     	 numbers=numbers+1;
      }
      if(u4[i+1]==comp[5])
      {
     	 Sum=Sum+U4_mid;
     	 numbers=numbers+1;
      }
      if(u5[i+1]==comp[5])
      {
     	 Sum=Sum+U5_mid;
     	 numbers=numbers+1;
      }
      if(u6[i+1]==comp[5])
      {
     	 Sum=Sum+U6_mid;
     	 numbers=numbers+1;
      }
        
 	}
 	Sum=Sum/numbers;
 	ForEnrl[i+1]=ForEnrl[i] + Sum ;
 

	return ForEnrl[i+1];
	}
}
