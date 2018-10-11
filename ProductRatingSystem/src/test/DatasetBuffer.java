package test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import controller.API;

public class DatasetBuffer {

	public static int addFile(String fileName,String datasetKind, API api) {
		int num = -1;
		try {
			File file = fileName != null ? new File( fileName ) : null;
			BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream( file ), "8859_1" ) );
			String strLine = null;

			while( ( strLine = br.readLine() ) != null ) {
				String[] content = strLine.split(",");

				String consumerID = content[0];
				String productID = content[1];
				double rNum = Double.parseDouble(content[2]);
				int timestamp = Integer.parseInt(content[3]);

				if(datasetKind.equals("consumers")) num = api.addConsumer(consumerID);
				if(datasetKind.equals("products")) num = api.addProduct(productID);
				if(datasetKind.equals("rating")) num = api.addRating(consumerID, productID, rNum, timestamp);
			}

			br.close();

		}catch(Exception ex) {System.err.println(ex.getMessage());}
		return num;
	}

	public static int getNumberOfFileLines( String file ){

		int num = 0;

		try{
			BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( new DataInputStream( new FileInputStream( file ) ) ) );
			while( bufferedReader.readLine() != null ) ++num;
			bufferedReader.close();
		}

		catch( Exception ex ){ ex.printStackTrace(); System.exit( -1 ); }

		return num;
	}

}
