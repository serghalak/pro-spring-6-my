package com.apress.prospring6.four;

import com.apress.prospring6.four.impl.provider.ProviderConfig;
import com.apress.prospring6.four.impl.renderer.RendererConfig;
import com.apress.prospring6.two.decoupled.MessageProvider;
import com.apress.prospring6.two.decoupled.MessageRenderer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RendererConfig.class, ProviderConfig.class})
public class MessageRenderOneIT {

    //public static ApplicationContext ctx;

    @Autowired
    MessageRenderer messageRenderer;

    @Autowired
    MessageProvider messageProvider;


    @Test
    void testProvider() {
        assertNotNull(messageProvider);
    }


//    @BeforeAll
//    static void setUp() {
//        ctx = new AnnotationConfigApplicationContext(RendererConfig.class, ProviderConfig.class);
//    }


    @Test
    void testConfig(){
        //var ctx = new AnnotationConfigApplicationContext(RendererConfig.class, ProviderConfig.class);

//        var messageProvider = ctx.getBean(MessageProvider.class);
//        var messageRenderer = ctx.getBean(MessageRenderer.class);

        assertAll( "messageTest" ,
                () -> assertNotNull(messageRenderer),
                () -> assertNotNull(messageProvider),
                () -> assertEquals(messageProvider, messageRenderer.getMessageProvider())
        );

        messageRenderer.render();
    }

}

