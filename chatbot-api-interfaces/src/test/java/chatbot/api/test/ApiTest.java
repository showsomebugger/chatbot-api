package chatbot.api.test;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get=new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        get.addHeader("cookie","abtest_env=product; zsxqsessionid=413b3480a647321ad31fc2ae626c167f; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22581211821288424%22%2C%22first_id%22%3A%2218ccadb2e64cc6-0285178732eb48-4c657b58-1638720-18ccadb2e65301f%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjY2FkYjJlNjRjYzYtMDI4NTE3ODczMmViNDgtNGM2NTdiNTgtMTYzODcyMC0xOGNjYWRiMmU2NTMwMWYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI1ODEyMTE4MjEyODg0MjQifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22581211821288424%22%7D%2C%22%24device_id%22%3A%2218ccadb2e64cc6-0285178732eb48-4c657b58-1638720-18ccadb2e65301f%22%7D; zsxq_access_token=C08CD9A3-C54E-317A-5AC1-D9912C8B58B9_6255B4F6664972EC");
        get.addHeader("Content-Type","application/json;charset=utf-8");
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res=EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException{
        CloseableHttpClient httpClient=HttpClientBuilder.create().build();
        HttpPost post=new HttpPost("https://api.zsxq.com/v2/topics/211428458245481/comments");
        post.addHeader("cookie", "abtest_env=product; zsxqsessionid=413b3480a647321ad31fc2ae626c167f; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22581211821288424%22%2C%22first_id%22%3A%2218ccadb2e64cc6-0285178732eb48-4c657b58-1638720-18ccadb2e65301f%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjY2FkYjJlNjRjYzYtMDI4NTE3ODczMmViNDgtNGM2NTdiNTgtMTYzODcyMC0xOGNjYWRiMmU2NTMwMWYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI1ODEyMTE4MjEyODg0MjQifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22581211821288424%22%7D%2C%22%24device_id%22%3A%2218ccadb2e64cc6-0285178732eb48-4c657b58-1638720-18ccadb2e65301f%22%7D; zsxq_access_token=C08CD9A3-C54E-317A-5AC1-D9912C8B58B9_6255B4F6664972EC");
        post.addHeader("Content-Type","application/json;charset=utf-8");
        String paramJson="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"auto answer\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringJson=new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringJson);
        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
            String res=EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer2() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/211428458245481/comments");
        post.addHeader("cookie", "abtest_env=product; zsxqsessionid=413b3480a647321ad31fc2ae626c167f; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22581211821288424%22%2C%22first_id%22%3A%2218ccadb2e64cc6-0285178732eb48-4c657b58-1638720-18ccadb2e65301f%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjY2FkYjJlNjRjYzYtMDI4NTE3ODczMmViNDgtNGM2NTdiNTgtMTYzODcyMC0xOGNjYWRiMmU2NTMwMWYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI1ODEyMTE4MjEyODg0MjQifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22581211821288424%22%7D%2C%22%24device_id%22%3A%2218ccadb2e64cc6-0285178732eb48-4c657b58-1638720-18ccadb2e65301f%22%7D; zsxq_access_token=C08CD9A3-C54E-317A-5AC1-D9912C8B58B9_6255B4F6664972EC");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
