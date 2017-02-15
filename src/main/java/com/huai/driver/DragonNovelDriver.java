package com.huai.driver;

import com.huai.email.EMailClient;
import com.huai.httpClient.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liangyh on 2/12/2017.
 */
public class DragonNovelDriver extends NovelDriver {

    private static final Set<String> oldLinks = new HashSet<String>();

    private static final String basicURL = "http://longwangchuanshuoba.com";

    private static final Logger logger = LoggerFactory.getLogger(DragonNovelDriver.class);

    public void doBusiness(){
        logger.info("---- start ----");
        HttpClient client = new HttpClient();
        try {
            logger.info("download basic html page");
            String htmlPage = client.downloadWebData(basicURL);

            Set<String> currentLinks = getLinks(htmlPage);

            List<String> diffUris = getDiff(currentLinks, this.oldLinks);
            logger.info("There is "+diffUris.size()+" num different URI");
            if(diffUris.size() < 6 && !diffUris.isEmpty()){
                StringBuilder builder = new StringBuilder();
                for(String str: diffUris){
                    logger.info("download target content");
                    String data = client.downloadWebData(basicURL+"/"+str);
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

    @Override
    public String extractTargetContent(String htmlPage){
        int index = htmlPage.indexOf("<h1>");
        if(index != -1){
            return htmlPage.substring(index+4);
        }
        return htmlPage;
    }

    /**
     *
     * @param htmlPage
     * @return links
     */
    @Override
    public Set<String> getLinks(String htmlPage){
        Set<String> result = new HashSet<String>();

        Pattern pattern = Pattern.compile("(<a\\shref=[^\\d]*)(\\d{1,}.html)(.*</a>)");
        Matcher matcher = pattern.matcher(htmlPage);

        while(matcher.find()){
            String url = matcher.group(2);
            result.add(url);
        }
        return result;
    }
}
