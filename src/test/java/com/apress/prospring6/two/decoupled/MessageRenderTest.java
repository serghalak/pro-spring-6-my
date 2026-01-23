package com.apress.prospring6.two.decoupled;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import com.apress.prospring6.two.decoupled.MessageProvider;
import com.apress.prospring6.two.decoupled.MessageRenderer;
import org.junit.jupiter.api.Test;


public class MessageRenderTest {

    @Test
    void testStandardOutMessageRenderer(){
        MessageProvider mockProvider =  mock(MessageProvider.class);
        when(mockProvider.getMessage()).thenReturn("test message");

        MessageRenderer messageRenderer =new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(mockProvider);

        messageRenderer.render();
        verify(mockProvider, times(1)).getMessage();
        assertEquals("test message", mockProvider.getMessage());
    }
}
