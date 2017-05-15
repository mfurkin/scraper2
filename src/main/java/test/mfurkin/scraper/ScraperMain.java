/**
 * 
 */
package test.mfurkin.scraper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author mfurkin
 *
 */
public class ScraperMain {

	private static final int ARGS_MIN = 5;
	private static final String FILE_PAR = "-file";
	private static final int NAME_PARAM_TYPE_NUM = 0;
	private static final int URL_FNAME_PARAM_NUM = 1;
	private static final int WORDS_PARAM_NUM = 2;
	private static String [] urls;
	private static String [] words;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int len = args.length;
		if (len<ARGS_MIN)
			System.out.println("Incorrect parameters");
		else
			parseParams(args);			
	}

	private static void parseParams(String[] args) {
		if (args[NAME_PARAM_TYPE_NUM].equals(FILE_PAR)) {
			String fname = args[URL_FNAME_PARAM_NUM];
			File file = new File(fname);
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
				urls = br.lines().toArray(String[]::new);	
			} catch (IOException ioe) {
				System.out.println("IOException wascaught during scraper launch\n");
				ioe.printStackTrace();
			}
		} else {
			urls = new String[1];
			urls[0] = args[URL_FNAME_PARAM_NUM];
		}
		String wordsSt = args[WORDS_PARAM_NUM];
		words = wordsSt.split(",");
	}

}
