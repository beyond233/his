package com.beyond233.his;

import com.beyond233.his.mapper.DepartmentMapper;
import com.beyond233.his.mapper.NewsMapper;
import com.beyond233.his.service.NewsService;
import com.beyond233.his.service.impl.NewsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-22 21:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class NewsMapperTest {
    @Resource
    NewsServiceImpl service;

    @Test
    public void test1() {
        System.out.println(service.findNewsInOneWeek(9));
    }

    @Test
    public void test2() {
        int[] ids = {5, 6};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        service.deleteNews(list);
//        service.deleteNews(ids);
    }
}
