    import java.io.IOException;
    import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class webParser
{


    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url)
    {
        Scanner urlScanner;

        try
        {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");

        }
        catch (IOException e)
        {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();

        urlScanner.close();
        return contents;
    }

    /*
     * Returns the number of words in a document.
     *Takes in a URL as a String.
     */
    public static String wordCount(final String url)
    {
        Scanner wordCount;
        try
        {
            wordCount = new Scanner(new URL(url).openStream(), "UTF-8");

        }
        catch (IOException e)
        {
            return "";
        }
        int count = 0;
        while(wordCount.hasNext())
        {
            if(!wordCount.next().equals(" "))
            {
                count++;
            }
        }
        wordCount.close();
        return "" + count;
    }

    /*
     * Returns the number of instances of a specific word.
     * Takes in a URL as a String and a word to check as a String.
     */
    public static String wordCountSpecific(final String url, String input)
    {
        Scanner wordCount;
        try
        {
            wordCount = new Scanner(new URL(url).openStream(), "UTF-8");

        }
        catch (IOException e)
        {
            return "";
        }
        int count = 0;
        while(wordCount.hasNext())
        {
            if(wordCount.next().toLowerCase().indexOf(input.toLowerCase()) != -1)
            {
                count++;
            }
        }
        wordCount.close();
        return "" + count;
    }

    /*
     * Lists the number of unique words in a file.
     * Takes in a URL as a String.
     */
    public static String uniqueWordCounter(final String URL)
    {
        Scanner uniqueCounter;
        try
        {
            uniqueCounter = new Scanner(new URL(URL).openStream(), "UTF-8");

        }
        catch (IOException e)
        {
            return "";
        }
       ArrayList<String> ref = new ArrayList<String>();
       while(uniqueCounter.hasNext())
       {

          String temp = uniqueCounter.next();
          if(!ref.contains(temp) && !(temp.equals(" ")))
          {
              ref.add(temp);
          }

       }
       uniqueCounter.close();
       return "" + ref.size();

    }


    public static void main(String[] args)
    {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordCount("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordCountSpecific("http://erdani.com/tdpl/hamlet.txt", "PRINCE"));
        System.out.println(uniqueWordCounter("http://erdani.com/tdpl/hamlet.txt"));
    }

}
