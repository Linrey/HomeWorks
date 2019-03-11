package utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.google.common.collect.Lists;

public class dp {
	//@Parameters("csvPath")
	@DataProvider(name = "dp")
	public Iterator<Message> loadUserDataFromFile(ITestContext context/*String path*/){
		//String path = "./testcsv1.csv";
		CsvParser parser = new CsvParser();
		List<String[]> csvStrings = parser.getAllRows(context.getCurrentXmlTest().getParameter("csvPath"));
		MessageBuilder mb = new MessageBuilder();
		List<Message> messages = new ArrayList<Message>();
		int i = 0;
		for(String[] s:csvStrings) {
			mb.setTheme(s[0]);
			mb.setTo(s[1]);
			mb.setContent(s[2]);
			mb.setCounter(i);
			messages.add(mb.Build());
			i++;
		}
		return messages.iterator();
	}
	@Parameters("csvPath")
	@DataProvider(name = "dpReverse")
	public Iterator<Message> loadUserDataFromFileReverse(ITestContext context){
		//String path = "./testcsv1.csv";
		CsvParser parser = new CsvParser();
		List<String[]> csvStrings = parser.getAllRows(context.getCurrentXmlTest().getParameter("csvPath"));
		MessageBuilder mb = new MessageBuilder();
		List<Message> messages = new ArrayList<Message>();
		csvStrings = Lists.reverse(csvStrings);
		int i = 0;
		for(String[] s:csvStrings) {
			mb.setTheme(s[0]);
			mb.setTo(s[1]);
			mb.setContent(s[2]);
			mb.setCounter(i);
			messages.add(mb.Build());
			i++;
		}
		return messages.iterator();
	}
//	  @DataProvider(name = "dp")
//	  public Object[][] parseLocaleData() {
//		String path = "./testcsv1.csv";
//		CsvParser parser = new CsvParser();
//		List<String[]> csvStrings = parser.getAllRows(path);
//		MessageBuilder mb = new MessageBuilder();
//		List<Message> messages = new ArrayList<Message>();
//		for(String[] s:csvStrings) {
//			mb.setTheme(s[0]);
//			mb.setTo(s[1]);
//			mb.setContent(s[2]);
//			messages.add(mb.Build());
//		}
//		Object[][] check = new Object[messages.size()][2];
//		for(int i = 0;i<messages.size();i++) {
//			check[i][] = new Object[][] {{messages.get(i)},{j}};
//		}
//		return check;
//	  }
}
