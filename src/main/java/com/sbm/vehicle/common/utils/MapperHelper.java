package com.sbm.vehicle.common.utils;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperHelper {


    @Autowired
    private DozerBeanMapper dozerBeanMapper;


    public <T> T transform(Object source, Class<T> clazz) {
        if (source == null)
            return null;
        return dozerBeanMapper.map(source, clazz);
    }

    public <T> T transform(Object source, Class<T> clazz, String mapId) {
        if (source == null)
            return null;
        return dozerBeanMapper.map(source, clazz, mapId);
    }

    public <T, U> List<U> transform(List<T> source, Class<U> destType) {

        if (source == null)
            return null;

        final List<U> dest = new ArrayList<U>();

        for (T element : source) {
            if (element == null) {
                continue;
            }
            dest.add(dozerBeanMapper.map(element, destType));
        }

        // finally remove all null values if any
        List s1 = new ArrayList();
        s1.add(null);
        dest.removeAll(s1);

        return dest;
    }

    public <T> void map(Object source, Object destination) {
        if (source == null)
            return;
        dozerBeanMapper.map(source, destination);
    }

    public <T> void partialMap(Object source, Object destination) {
        if (source == null)
            return;
        try{
            dozerBeanMapper.addMapping(
                    new BeanMappingBuilder() {
                        protected void configure() {
                            mapping(source.getClass(), destination.getClass(), TypeMappingOptions.mapNull(false));
                        }
                    });
//            TypeMappingOptions.mapNull(false), TypeMappingOptions.mapEmptyString(false)
        }catch (Exception ex) {}

        dozerBeanMapper.map(source, destination);
    }


}