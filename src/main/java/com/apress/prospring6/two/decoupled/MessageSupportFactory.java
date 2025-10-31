package com.apress.prospring6.two.decoupled;

import java.util.Optional;
import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;
    private MessageProvider provider;
    private MessageRenderer renderer;
    private Properties props;

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    private MessageSupportFactory() {
        props = new Properties();
        try {
            props.load(this.getClass().getResourceAsStream("/msf.properties"));
            String providerClassName = props.getProperty("message.provider.class");
            String rendererClassName = props.getProperty("message.renderer.class");
            Class<?> providerClass = Class.forName(providerClassName);
            Class<?> rendererClass = Class.forName(rendererClassName);
            provider = (MessageProvider) providerClass.getDeclaredConstructor().newInstance();
            renderer = (MessageRenderer) rendererClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Optional<MessageProvider> getMessageProvider() {
        return provider == null ? Optional.empty() : Optional.of(provider);
    }

    public Optional<MessageRenderer> getMessageRenderer() {
        return renderer == null ? Optional.empty() : Optional.of(renderer);
    }
}
