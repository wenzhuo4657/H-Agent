package cn.wenzhuo4657.ai.test;


import com.pgvector.PGvector;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;


import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.pgvector.PgVectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenAiTest {


    @Autowired
    private ChatModel chatModel;


    @Autowired
    private PgVectorStore pgVectorStore;
    private final TokenTextSplitter tokenTextSplitter = new TokenTextSplitter();


    /**
     * 外部模型对话测试： 同步调用
     */
    @Test
    public void chatTest1() {
        String question = "请给我一个10个字符的随机密码";
        ChatResponse call = chatModel.call(
                Prompt.builder()
                        .content(question)
                        .build()
        );
        log.info("OpenAiTest.chatTest1: {}", call);
    }


    /**
     * 外部模型对话测试： 流式调用
     */
    @Test
    public void chatTest2() throws InterruptedException {
        String question = "请给我一个10个字符的随机密码";
        Flux<ChatResponse> stream = chatModel.stream(
                Prompt.builder()
                        .content(question)
                        .build()
        );
        stream.subscribe(

                chatResponse -> log.info("OpenAiTest.chatTest2: {}", chatResponse.getResult().getOutput().getText())
        );

        new CountDownLatch(1).await();// 该阻塞是为了防止异步输出丢失
    }

    /**
     * 知识库上传测试
     */
    @Test
    public void vectorStoreTest() {
        // textResource、articlePromptWordsResource
        TikaDocumentReader reader = new TikaDocumentReader("classpath:docs.txt");


        List<Document> documents = reader.get();
        List<Document> documentSplitterList = tokenTextSplitter.apply(documents);

        documentSplitterList.forEach(doc -> doc.getMetadata().put("knowledge", "article-prompt-words"));

        pgVectorStore.accept(documentSplitterList);

        log.info("上传完成");
    }




}
