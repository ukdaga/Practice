package org.ukdaga.practise;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {

	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

	public static void main (String [] args) throws IOException
	{
		int threadNumber = 1;

		System.out.println("FYI , files would be downloaded on the same path as this program and can be changed in code if needed. \n Enter Mailing list name followed by year (e.g 'abdera 2016')\n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line =br.readLine().split(" ");
		
		while(true)
		{
			if(line.length==2 && line[1].matches("^[0-9]{1,4}$"))
				break;
			else
			{
				System.out.println("Check again. Ensure that year is valid . Enter Mailing list name followed by year (e.g 'abdera 2016')\n");
				line =br.readLine().split(" ");
			}

		}


		Set<String> listLinks = getArchiveLinksFromListName("http://mail-archives.apache.org/mod_mbox",line[0]);
		for(String link : listLinks)
		{
			Set<String> yearLinksForArchiveLink = getYearLinksforArchiveLink(link,line[1]);
			for(String yearLink : yearLinksForArchiveLink )
			{
				
				Document htmlDocument;
				try {
					htmlDocument = Jsoup.connect(yearLink).userAgent(USER_AGENT).get();
					Elements pageLinks =  htmlDocument.getElementsByClass("pages").get(0).select("a[href]");
					int i=0;
					do
					{
						Downloader linkDownloader = new Downloader(yearLink+"?"+i++);
						Thread thread = new Thread (linkDownloader, String.valueOf(threadNumber++));
						thread.start();
					}
					while( i<=pageLinks.size());
					
				} 
				catch (Exception e) {
					System.out.println("Exception while downloading ");
					e.printStackTrace();
				}
			}
		}

	}

	public static Set<String> getArchiveLinksFromListName (String url, String mailingList)
	{
		Set<String> links = new HashSet<String>();
		Document htmlDocument;
		try {
			htmlDocument = Jsoup.connect(url).userAgent(USER_AGENT).get();
			Elements elements = htmlDocument.getElementsByTag("li");
			for(Element element : elements )
			{
				Elements listGroup = element.getElementsByAttributeValue("name", mailingList);
				if(listGroup.size()>0)
				{
					prepareAnchorLinks(element , links , "");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception while getting parent links for mailing list");
			e.printStackTrace();
		}

		return links;
	}

	public static Set<String>  getYearLinksforArchiveLink  (String url, String year)
	{
		Set<String> links = new HashSet<String>();
		Document htmlDocument;
		try {
			htmlDocument = Jsoup.connect(url).userAgent(USER_AGENT).get();
			Elements elements = htmlDocument.getElementsByClass("year");
			for(Element element : elements )
			{
				String yearValue = element.getElementsByTag("th").get(0).text();
				if(yearValue.contains(year))
				{
					prepareAnchorLinks(element , links , "date");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception while getting year based links for a given archive");
			e.printStackTrace();
		}

		return links;
	}


	private static void prepareAnchorLinks(Element element , Set<String> links , String appendingString) {
		Elements linksOnPage = element.select("a[href]");
		for(Element link : linksOnPage)
		{
			links.add(link.absUrl("href").substring(0,link.absUrl("href").lastIndexOf('/'))+"/"+appendingString);
		}
		for (String link  :links )
			System.out.println("Thread "+Thread.currentThread().getName()+" : "+link);
	}

}

class Downloader implements Runnable
{
	public String link;
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

	public Downloader(String link) 
	{
		this.link = link;
	}

	public void  downloadAllEmailsFromUrl (String url)
	{
		Set<String> links = new HashSet<String>();
		Document htmlDocument;
		try {
			htmlDocument = Jsoup.connect(url).userAgent(USER_AGENT).get();
			Elements downloadLinks =  htmlDocument.getElementsByClass("subject").select("a[href]");
			System.out.println("Thread "+Thread.currentThread().getName()+" : "+"Found (" + downloadLinks.size() + ") download links from "+url);
			for(Element link : downloadLinks)
			{
				links.add(link.absUrl("href"));
				String fileName = link.text();
				saveFileFromUrlWithJavaIO(/*"C:\\Users\\user\\Downloads\\"+*/fileName.replaceAll("[^\\w \\[ \\]]", "")+".xml",link.absUrl("href"));	
			}
			for (String link  :links )
				System.out.println("Thread "+Thread.currentThread().getName()+" : "+link);
		} catch (Exception e) {
			System.out.println("Exception while downloading ");
			e.printStackTrace();
		}
		//return links;
	}

	public void saveFileFromUrlWithJavaIO(String fileName, String fileUrl)
			throws MalformedURLException, IOException {
		BufferedInputStream in = null;
		FileOutputStream fout = null;
		try {
			in = new BufferedInputStream(new URL(fileUrl).openStream());
			fout = new FileOutputStream(fileName);

			byte data[] = new byte[1024];
			int count;
			while ((count = in.read(data, 0, 1024)) != -1) {
				fout.write(data, 0, count);
			}
		} finally {
			if (in != null)
				in.close();
			if (fout != null)
				fout.close();
		}
	}

	public void run ()
	{
		System.out.println(" ********* Starting thread "+Thread.currentThread().getName()+" ********  ");
		downloadAllEmailsFromUrl(link);
		System.out.println(" ********* Ending thread "+Thread.currentThread().getName()+" **********  ");
	}


}
