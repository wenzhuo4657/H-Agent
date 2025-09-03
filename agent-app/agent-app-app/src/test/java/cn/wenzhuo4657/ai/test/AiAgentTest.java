package cn.wenzhuo4657.ai.test;

import com.alibaba.fastjson.JSON;
import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.vectorstore.pgvector.PgVectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AiAgentTest {

    @Autowired
    private ChatModel chatModel;

    private ChatClient chatClient;

    @Resource
    private PgVectorStore vectorStore;




    @Before
    public void init() {
        chatClient = ChatClient.builder(chatModel)
                .defaultSystem("""
                          Code Assistant（代码助手）是一个专门利用 Context7 提供最新、准确技术文档的 AI 助手。它能够访问数千个库和框架的最新文档，确保开发者始终获得最准确的 API 参考、用法示例和最佳实践。 \s
                        """)
                .defaultToolCallbacks(new SyncMcpToolCallbackProvider(stdioMcpClient()))
                .defaultAdvisors(
                        PromptChatMemoryAdvisor.builder(
                                MessageWindowChatMemory.builder()
                                        .maxMessages(100)
                                        .build()
                        ).build(),
                        SimpleLoggerAdvisor.builder().build())

                .build();
    }

    @Test
    public void test_chat_model_call() {
        Prompt prompt = Prompt.builder()
                .messages(new UserMessage(
                        """
                                spring最新版特性
                                """))
                .build();

        ChatResponse chatResponse = chatModel.call(prompt);

        log.info("测试结果(call):{}", JSON.toJSONString(chatResponse));
    }








    public McpSyncClient stdioMcpClient() {
        // 检测操作系统并使用相应的命令
        String npxCommand = System.getProperty("os.name").toLowerCase().contains("windows") ? "npx.cmd" : "npx";
        
        var stdioParams = ServerParameters.builder(npxCommand)
                .args("-y", "@upstash/context7-mcp@latest")
                .build();
    
        var mcpClient = McpClient.sync(new StdioClientTransport(stdioParams))
                .requestTimeout(Duration.ofSeconds(10)).build();
    
        var init = mcpClient.initialize();
    
        System.out.println("Code Assistant（代码助手: " + init);
    
        return mcpClient;
    }



}
