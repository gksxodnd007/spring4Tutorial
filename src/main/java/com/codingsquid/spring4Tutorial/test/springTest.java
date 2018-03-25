package com.codingsquid.spring4Tutorial.test;

import com.codingsquid.spring4Tutorial.model.Mentor;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class springTest {

    @Test
    public void test() {
        ApplicationContext ctx = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/applicationContext.xml");
        GenericApplicationContext subCtx = new GenericApplicationContext(ctx);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(subCtx);
        reader.loadBeanDefinitions("file:src/main/webapp/WEB-INF/subContext.xml");
        subCtx.refresh();

        Mentor mentor = subCtx.getBean("mentor", Mentor.class);
        System.out.println(mentor.getMentee().toString());
    }

}
