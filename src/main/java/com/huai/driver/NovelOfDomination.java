package com.huai.driver;

import com.huai.email.EMailClient;
import com.huai.httpClient.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liangyh on 2/14/2017.
 */
public class NovelOfDomination extends NovelDriver{

    private static final Set<String> oldLinks = new HashSet<String>();

    private static final String basicURL = "http://www.snwx.com/book/25/25623";

    private static final Logger logger = LoggerFactory.getLogger(NovelOfDomination.class.getName());


    public void doBusiness(){
        logger.info("---- start ----");
        HttpClient client = new HttpClient();
        try {
            logger.info("download basic html page");
            String htmlPage = client.downloadWebData(this.basicURL, "GBK");

            Set<String> currentLinks = getLinks(htmlPage);

            List<String> diffUris = getDiff(currentLinks, this.oldLinks);
            logger.info("There is "+diffUris.size()+" num different URI");
            if(diffUris.size() < 6 && !diffUris.isEmpty()){

                StringBuilder builder = new StringBuilder();

                for(String str: diffUris){
                    logger.info("download target content");
                    String data = client.downloadWebData(basicURL+"/"+str, "GBK");
                    data = extractTargetContent(data);
                    builder.append(data).append("\n\n");
                }
                logger.info("send email");
                EMailClient.sendEMail(builder.toString());
            }
            logger.info("copy current URI to the old set");
            copyLinks(currentLinks, this.oldLinks);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        logger.info("---- end ----");
    }

    public String extractTargetContent(String htmlPage){
        int index = htmlPage.indexOf("id=\"BookText\"");
        int nextDiv = htmlPage.indexOf("</div>", index);
        if(index != -1){
            return htmlPage.substring(index+13, nextDiv);
        }
        return htmlPage;
    }

    /**
     *
     * @param htmlPage
     * @return links
     */
    public Set<String> getLinks(String htmlPage){
        Set<String> result = new HashSet<String>();

        Pattern pattern = Pattern.compile("(<a\\shref=\")(\\d{7,}.html)(\"\\stitle=\"第.*</a>)");
        Matcher matcher = pattern.matcher(htmlPage);

        while(matcher.find()){
            String url = matcher.group(2);
            result.add(url);
        }
        return result;
    }
}
