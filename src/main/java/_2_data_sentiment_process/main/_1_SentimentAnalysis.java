package _2_data_sentiment_process.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _2_data_sentiment_process.sentiment.alchemyapi.SentimentAnalysisServiceImpl;
import _2_data_sentiment_process.sentiment.alchemyapi.SentimentAnalysisUtil;
import _2_data_sentiment_process.sentiment.alchemyapi.xml.TextSentimentResult;
import ci.dao.CollectionCommentsDaoImpl;
import ci.dao.CollectionPostDaoImpl;
import ci.dao.ProcessPostDaoImpl;
import ci.entity.CollectionComments;
import ci.entity.CollectionPost;
import ci.entity.Facebook;
import ci.entity.ProcessPost;
import ci.service.DataTransformServiceImpl;

public class _1_SentimentAnalysis {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SentimentAnalysisServiceImpl sentimentAnalysisService = (SentimentAnalysisServiceImpl) context
                .getBean("sentimentAnalysisService");

        CollectionPostDaoImpl collectionPostDao = (CollectionPostDaoImpl) context.getBean("collectionPostDao");
        CollectionCommentsDaoImpl collectionCommentsDao = (CollectionCommentsDaoImpl) context
                .getBean("collectionCommentsDao");

        DataTransformServiceImpl dataTransformService = (DataTransformServiceImpl) context
                .getBean("dataTransformService");

        ProcessPostDaoImpl processPostDao = (ProcessPostDaoImpl) context.getBean("processPostDao");

        for (Facebook facebook : Facebook.FACEBOOKS) {
            // get facebook page
            String facebookPage = facebook.getFacebookPage();
            
            // only process_status = 0 will be select
            List<CollectionPost> collectionPostList = collectionPostDao.selectByFacebookPageNotExecuted(facebookPage);
            for (CollectionPost collectionPost : collectionPostList) {
                ProcessPost transformPost = new ProcessPost();
                // set common
                transformPost.setCollectionPostId(collectionPost.getId());
                transformPost.setFacebookPage(collectionPost.getFacebookPage());
                transformPost.setPostId(collectionPost.getPostId());

                // set word count
                String text = collectionPost.getPostMessage();
                transformPost.setCw(dataTransformService.getWordCount(text));

                // set sentiment result
                transformPost.setSsp(sentimentAnalysisService.analyzeTextSentiment(text).getDocSentiment().getScore());

                // set sentiment for comment
                List<CollectionComments> collectionCommentsList = collectionCommentsDao.selectByPostId(collectionPost
                        .getPostId());
                for (CollectionComments collectionComments : collectionCommentsList) {
                    String commentMessage = collectionComments.getCommentMessage();
                    TextSentimentResult result = sentimentAnalysisService.analyzeTextSentiment(commentMessage);
                    Double sentimentScore = result.getDocSentiment().getScore();
                    //
                    transformPost.setCpc(transformPost.getCpc()
                            + SentimentAnalysisUtil.countPositiveSentiment(sentimentScore));
                    transformPost.setCnc(transformPost.getCnc()
                            + SentimentAnalysisUtil.countNegativeSentiment(sentimentScore));
                    transformPost.setCnlc(transformPost.getCnlc()
                            + SentimentAnalysisUtil.countNaturalSentiment(sentimentScore));

                    System.out.println("load comment: " + transformPost);
                }

                // insert into transform table
                processPostDao.insert(transformPost);

                // update process status
                collectionPostDao.updateProcessStatusToExecuted(collectionPost.getId());

                // log
                System.out.println("end post: " + transformPost);
                System.out.println();
            }
        }
        System.out.println("Finished");
    }
}
