I have used the open source library jsoup for scraping.
The attached jar for the same would be needed while compiling .

To execute this class, no command line arguments are needed.
User input will be prompted.

Download path will be the same as execution path and can be changed in code (line 154).


Design
1>Take input year and mailing list name.
2>Crawl the index site for the list name and extract all level1 archive links.
3>Go to each of the above links and extract level2 archive links (level2 means based on input year).
4>Each of the above links will open email pages arranged by date . For each of the above links extract all email download links and download all emails by creating separate download threads for each page . 
5>Each page shows a maximum of 100 emails, so each thread will download a maximum of 100 emails.
