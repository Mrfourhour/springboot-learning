package com.xinyet.read_other_config_05.config;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author Administrator
 * @description //用于加载 xxx.yml配置文件内容
 * @date 2020/6/29 10:57
 */
public class PropertySourceFactory extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        if (Objects.isNull(resource)) return super.createPropertySource(name, resource);
        List<PropertySource<?>> propertySources = new YamlPropertySourceLoader().load(resource.getResource().getFilename(), resource.getResource());
        return propertySources.get(0);
    }
}
